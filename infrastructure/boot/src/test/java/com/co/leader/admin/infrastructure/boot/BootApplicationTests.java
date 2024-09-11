package com.co.scm.inventory.infrastructure.boot;

import com.co.leader.admin.infrastructure.boot.BootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = BootApplication.class)
@ActiveProfiles("test")
class BootApplicationTests {

    @Test
    void contextLoads() {
    }

}
