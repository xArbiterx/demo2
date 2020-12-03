package com.example.demo2;

import com.example.demo2.repository.UserRepository;
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
        userRepository.updatePasswordById(1111L, "1");

    }
}
