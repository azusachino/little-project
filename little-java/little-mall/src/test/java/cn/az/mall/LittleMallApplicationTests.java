package cn.az.mall;

import cn.az.mall.entity.PmsBrand;
import cn.az.mall.service.IPmsBrandService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class LittleMallApplicationTests {

    @Resource
    private IPmsBrandService pmsBrandService;

    @Test
    public void contextLoads() {
        pmsBrandService.page(new Page<>(1, 5),
            Wrappers.<PmsBrand>lambdaQuery().orderByAsc(PmsBrand::getId))
            .getRecords().forEach(System.out::println);
        pmsBrandService.listMaps().forEach(System.out::println);
    }

}
