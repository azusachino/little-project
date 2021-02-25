package cn.az.project.shop.admin;

import cn.az.project.shop.core.utils.ShaUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopAdminApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testSha() {
        System.out.println(ShaUtil.sha256("123"));
    }
}
