package cn.az.replica.mall.controller.admin;

import cn.az.replica.mall.service.IGoodsCategoryService;
import cn.az.replica.mall.service.IGoodsInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author az
 */
@Controller
@RequestMapping("admin/goods")
public class GoodsInfoController {

    @Resource
    private IGoodsInfoService goodsInfoService;

    @Resource
    private IGoodsCategoryService goodsCategoryService;

    @GetMapping
    public String index(HttpServletRequest req) {
        req.setAttribute("path", "mall_goods");
        return "admin/goods/index";
    }

    @GetMapping("/add")
    public String add(HttpServletRequest req) {

        return "admin/goods/add";
    }

}
