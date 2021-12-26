package com.myconpany;


import com.myconpany.user.User;
import com.myconpany.user.UserRepository;
import net.minidev.json.JSONUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo ;
    @Test
    public void testAddNew(){
        User user = new User();

        user.setEmail("alex.stevenson@gmail.com");
        user.setPassword("alex123456");
        user.setFirstName("Alex");
        user.setLastName("Stenvenson");

        User savedUser = repo.save(user);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Integer unserId = 1;
        Optional<User> optionalUser = repo.findById(unserId);
        User user = optionalUser.get();
        user.setPassword("Hello2021");
        repo.save(user);

        User updatedUser = repo.findById(unserId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("Hello2021");
    }

    @Test
        public void testGet() {
        Integer userId = 2;
        Optional<User> optionalUser = repo.findById(userId);
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId = 1;
        repo.deleteById(userId);
    }
}
