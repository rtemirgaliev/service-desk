package com.sd.web.rest;

import com.sd.domain.User;
import com.sd.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Inject
    UserRepository userRepository;


    @RequestMapping(value = "/users",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public List<User> getAllUsers() throws URISyntaxException {

        return userRepository.findAll();
    }





}
