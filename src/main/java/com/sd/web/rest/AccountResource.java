package com.sd.web.rest;

import com.sd.repository.UserRepository;
import com.sd.service.UserService;
import com.sd.web.rest.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api")
public class AccountResource {

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    @Inject
    private UserRepository userRepository;
    @Inject
    private UserService userService;


//    /**
//     * GET  /authenticate -> check if the user is authenticated, and return its login.
//     */
//    @RequestMapping(value = "/authenticate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
////    @Timed
//    public String isAuthenticated(HttpServletRequest request) {
//        log.info("REST request to check if the current user is authenticated");
//        return request.getRemoteUser();
//    }

    /**
     * GET  /account -> get the current user.
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
    public ResponseEntity<UserDTO> getAccount() {
        return Optional.ofNullable(userService.getUserWithAuthorities())
                .map(user -> new ResponseEntity<>(new UserDTO(user), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
















