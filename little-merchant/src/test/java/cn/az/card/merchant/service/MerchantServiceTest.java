package cn.az.card.merchant.service;

import cn.az.card.merchant.vo.MerchantRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Test Merchant Service
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see IMerchantService
 * @since 2020-03-18
 */
@SpringBootTest
public class MerchantServiceTest {

    @Resource
    private IMerchantService merchantService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateMerchant() {
        MerchantRequest request = new MerchantRequest();
        request.setName("water");
        request.setLogoUrl("http://www.baidu.com");
        request.setBusinessLicenseUrl("http://www.baidu.com");
        request.setAddress("AnHui");
        request.setPhone("15802673998");

        System.out.println(merchantService.createMerchant(request));
    }

}
