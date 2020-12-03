package com.example.demo2;

import com.example.demo2.entity.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.util.SnowflakeIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class Demo2ApplicationTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {
        log.info(("----- testSelect method ------"));

        User user = User.builder()
                .id(SnowflakeIdGenerator.get().nextId())
                .username("username")
                .password("1")
                .build();
        userRepository.save(user);

        System.out.println(user.toString());
    }
}
