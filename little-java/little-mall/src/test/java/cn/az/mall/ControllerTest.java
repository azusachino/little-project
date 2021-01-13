package cn.az.mall;

import cn.az.mall.controller.PmsBrandController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

/**
 * @author az
 */
@SpringBootTest(classes = PmsBrandController.class)
public class ControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void testHomePage() {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("home"))
//                .andExpect(content().string(containsString("...")));
    }
}
