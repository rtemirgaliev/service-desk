package com.sd.repository;

import com.sd.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/business-config.xml")
public class UserRepoTest {

//    @Inject
//    UserRepository userRepository;
//
//    User user = new User();

//    @Before
//    @Transactional
//    @Rollback
//    public void setup() {
//        user.setFirstName("Rinat1");
//        user.setLastName("Temirgaliev1");
//        user.setEmail("rtemirgaliev1@gmail.com");
//        user.setLogin("rtemirgaliev1");
//        user.setPasswordHash("1234567890");
//        userRepository.save(user);
//    }

//    @After
//    @Transactional
//    @Rollback
//    public void clean() {
//        userRepository.delete(user);
//    }
//
//
//    @Test
//    @Transactional
//    public void testFind() {
//
//        Optional<User> userList = userRepository.findOneByLogin("rtemirgaliev1");
//
//        Assert.assertTrue(userList.isPresent());
//        Assert.assertEquals("Rinat1", userList.get().getFirstName());
//        Assert.assertEquals("Temirgaliev1", userList.get().getLastName());
//        Assert.assertEquals("rtemirgaliev1@gmail.com", userList.get().getEmail());
//        Assert.assertEquals("rtemirgaliev1", userList.get().getLogin());
//
//    }

}
