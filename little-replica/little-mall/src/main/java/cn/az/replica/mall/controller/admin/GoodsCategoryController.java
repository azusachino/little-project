package cn.az.replica.mall.controller.admin;

import cn.az.replica.mall.base.BaseController;
import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.domain.R;
import cn.az.replica.mall.entity.GoodsCategory;
import cn.az.replica.mall.service.IGoodsCategoryService;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author az
 */
@Controller
@RequestMapping("admin/category")
public class GoodsCategoryController extends BaseController {

    @Resource
    private IGoodsCategoryService goodsCategoryService;

    @GetMapping
    public String index(GoodsCategory goodsCategory, String backParentId, HttpServletRequest req) {
        req.setAttribute("path", "mall_category");
        req.setAttribute("categoryLevel", goodsCategory.getCategoryId());
        req.setAttribute("parentId", goodsCategory.getParentId());
        req.setAttribute("backParentId", backParentId);
        return "admin/category/index";
    }

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    public List<GoodsCategory> list(HttpServletRequest request) {
        Page<GoodsCategory> page = getPage(request);
        return goodsCategoryService.selectPage(page).getRecords();
    }

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping(value = "/listForSelect")
    public R<?> listForSelect(@RequestParam("categoryId") Long categoryId) {
        GoodsCategory category = goodsCategoryService.getById(categoryId);
        // 既不是一级分类也不是二级分类则为不返回数据
        if (Objects.isNull(category) || category.getCategoryLevel() == Constants.CATEGORY_LEVEL_THREE) {
            return R.fail("参数异常！", null);
        }
        int categoryLevel = category.getCategoryLevel();
        Map<String, Object> categoryResult = new HashMap<>(2);
        if (categoryLevel == Constants.CATEGORY_LEVEL_ONE) {
            //如果是一级分类则返回当前一级分类下的所有二级分类，以及二级分类列表中第一条数据下的所有三级分类列表
            //查询一级分类列表中第一个实体的所有二级分类
            List<GoodsCategory> secondLevelCategories = goodsCategoryService.list(Wrappers.<GoodsCategory>query()
                    .eq("category_level", Constants.CATEGORY_LEVEL_TWO).eq("parent_id", categoryId));
            if (CollectionUtils.isNotEmpty(secondLevelCategories)) {
                //查询二级分类列表中第一个实体的所有三级分类
                List<GoodsCategory> thirdLevelCategories = goodsCategoryService.list(Wrappers.<GoodsCategory>query()
                        .eq("category_level", Constants.CATEGORY_LEVEL_THREE)
                        .eq("parent_id", secondLevelCategories.get(0).getCategoryId()));
                categoryResult.put("secondLevelCategories", secondLevelCategories);
                categoryResult.put("thirdLevelCategories", thirdLevelCategories);
            }
        } else if (categoryLevel == Constants.CATEGORY_LEVEL_TWO) {
            //如果是二级分类则返回当前分类下的所有三级分类列表
            List<GoodsCategory> thirdLevelCategories = goodsCategoryService.list(Wrappers.<GoodsCategory>query()
                    .eq("category_level", Constants.CATEGORY_LEVEL_THREE).eq("parent_id", categoryId));
            categoryResult.put("thirdLevelCategories", thirdLevelCategories);
        }
        return R.success(categoryResult);
    }

    /**
     * save
     */
    @ResponseBody
    @PostMapping("/save")
    public R<?> save(@RequestBody GoodsCategory goodsCategory) {
        if (goodsCategoryService.save(goodsCategory)) {
            return R.success();
        } else {
            return R.fail();
        }
    }

    /**
     * update
     */
    @ResponseBody
    @PostMapping("/update")
    public R<?> update(@RequestBody GoodsCategory goodsCategory) {
        if (goodsCategoryService.updateById(goodsCategory)) {
            return R.success();
        } else {
            return R.fail();
        }
    }

    /**
     * 详情
     */
    @ResponseBody
    @GetMapping("/info/{id}")
    public R<?> info(@PathVariable("id") Integer id) {
        return R.success(goodsCategoryService.getById(id));
    }

    /**
     * 删除
     */
    @ResponseBody
    @PostMapping("/delete")
    public R<?> delete(@RequestBody List<Long> ids) {
        List<Long> list = new ArrayList<>(ids);
        for (Long id : ids) {
            List<GoodsCategory> categories = goodsCategoryService.list(Wrappers.<GoodsCategory>query()
                    .select("category_id").eq("parent_id", id));
            if (CollectionUtils.isNotEmpty(categories)) {
                categories.stream()
                        .map(GoodsCategory::getCategoryId)
                        .forEach(i -> {
                            List<GoodsCategory> parentCategories = goodsCategoryService.list(Wrappers.<GoodsCategory>query()
                                    .select("category_id").eq("parent_id", i));
                            parentCategories.stream().map(GoodsCategory::getCategoryId).forEach(list::add);
                        });
            }
        }
        goodsCategoryService.removeByIds(list);
        return R.success();
    }

}
