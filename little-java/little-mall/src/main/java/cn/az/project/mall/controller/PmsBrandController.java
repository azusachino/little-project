package cn.az.project.mall.controller;

import cn.az.project.mall.api.CommonResult;
import cn.az.project.mall.entity.PmsBrand;
import cn.az.project.mall.service.impl.PmsBrandServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author AzusaChino
 * @version 2019-12-12
 */
@Slf4j
@RestController
@RequestMapping("/brand")
@Api(tags = "PmsBrandController")
public class PmsBrandController {

    @Autowired
    private PmsBrandServiceImpl pmsBrandService;

    @ApiOperation("获取所有品牌列表")
    @GetMapping("listAll")
    public CommonResult<?> getBrandList() {
        return CommonResult.success(pmsBrandService.list());
    }

    @ApiOperation("添加品牌")
    @PostMapping
    public CommonResult<?> createBrand(PmsBrand pmsBrand) {
        if (pmsBrandService.save(pmsBrand)) {
            log.debug("create brand success: {}", pmsBrand);
            return CommonResult.success(pmsBrand);
        } else {
            log.debug("create brand failed: {}", pmsBrand);
            return CommonResult.failed("operation failed");
        }
    }

    @ApiOperation("更新指定id品牌信息")
    @PutMapping(value = "/update/{id}")
    public CommonResult<?> updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        boolean success = pmsBrandService.saveOrUpdate(pmsBrandDto);
        if (success) {
            log.debug("updateBrand success:{}", pmsBrandDto);
            return CommonResult.success(pmsBrandDto);
        } else {
            log.debug("updateBrand failed:{}", pmsBrandDto);
            return CommonResult.failed("操作失败");
        }

    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult<?> deleteBrand(@PathVariable("id") Long id) {
        if (pmsBrandService.removeById(id)) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<?> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = pmsBrandService.page(new Page<>(pageNum, pageSize)).getRecords();
        return CommonResult.success(brandList);
    }

    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<?> brand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getById(id));
    }
}
