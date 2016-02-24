package com.sd.web.rest;

import com.sd.domain.Authority;
import com.sd.domain.User;
import com.sd.repository.AuthorityRepository;
import com.sd.repository.UserRepository;
import com.sd.security.AuthoritiesConstants;
import com.sd.service.UserService;
import com.sd.web.rest.dto.ManagedUserDTO;
import com.sd.web.rest.util.HeaderUtil;
import com.sd.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Inject
    private UserRepository userRepository;
    @Inject
    private UserService userService;
    @Inject
    private AuthorityRepository authorityRepository;

    /**
     * GET  /users -> get all users.
     */
    @RequestMapping(value = "/users",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<ManagedUserDTO>> getAllUsers(Pageable pageable) throws URISyntaxException {

        Page<User> page = userRepository.findAll(pageable);
        List<ManagedUserDTO> managedUserDTOs = page.getContent().stream()
                .map(user -> new ManagedUserDTO(user))
                .collect(Collectors.toList());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/users");


        return new ResponseEntity<>(managedUserDTOs, headers, HttpStatus.OK);
    }

    /**
     * PUT  /users -> Updates an existing User.
     */
    @RequestMapping(value = "/users",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
    @Transactional
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<ManagedUserDTO> updateUser(@RequestBody ManagedUserDTO managedUserDTO) throws URISyntaxException {

        log.debug("REST request to update user: {}", managedUserDTO);

        return userRepository
                .findOneById(managedUserDTO.getId())
                .map(user -> {
                    user.setLogin(managedUserDTO.getLogin());
                    user.setFirstName(managedUserDTO.getFirstName());
                    user.setLastName(managedUserDTO.getLastName());
                    user.setEmail(managedUserDTO.getEmail());
                    user.setActivated(managedUserDTO.isActivated());
                    user.setLangKey(managedUserDTO.getLangKey());
                    Set<Authority> authorities = user.getAuthorities();
                    authorities.clear();
                    managedUserDTO.getAuthorities().stream().forEach(
                            authority -> authorities.add(authorityRepository.findOne(authority))
                    );
                    return ResponseEntity.ok()
                            .headers(HeaderUtil.createEntityUpdateAlert("user", managedUserDTO.getLogin()))
                            .body(new ManagedUserDTO(userRepository.findOne(managedUserDTO.getId())));
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }



    /**
     * GET  /users/:login -> get the "login" user.
     */
    @RequestMapping(value = "users/{login}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
    public ResponseEntity<ManagedUserDTO> getUser(@PathVariable String login) {
        log.debug("REST request to get User: {}", login);
        return userService.getUserWithAuthoritiesByLogin(login)
                .map(ManagedUserDTO::new)
                .map(managedUserDTO -> new ResponseEntity<>(managedUserDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
