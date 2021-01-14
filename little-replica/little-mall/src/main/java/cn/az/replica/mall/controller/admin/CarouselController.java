package cn.az.replica.mall.controller.admin;

import cn.az.replica.mall.base.BaseController;
import cn.az.replica.mall.domain.R;
import cn.az.replica.mall.entity.Carousel;
import cn.az.replica.mall.service.ICarouselService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author az
 */
@Controller
@RequestMapping("admin/carousel")
public class CarouselController extends BaseController {

    @Resource
    private ICarouselService carouselService;

    /**
     * init method
     */
    @GetMapping
    public String index(HttpServletRequest req) {
        req.setAttribute("path", "mall_carousel");
        return "admin/carousel/index";
    }

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    public List<Carousel> list(HttpServletRequest req) {
        Page<Carousel> page = getPage(req);
        return carouselService.selectPage(page).getRecords();
    }

    /**
     * save
     */
    @ResponseBody
    @PostMapping("/save")
    public R<?> save(@RequestBody Carousel carousel) {
        if (Objects.nonNull(carousel) && carouselService.save(carousel)) {
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
    public R<?> update(@RequestBody Carousel carousel) {
        if (carouselService.updateById(carousel)) {
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
        return R.success(carouselService.getById(id));
    }

    /**
     * 删除
     */
    @ResponseBody
    @PostMapping("/delete")
    public R<?> delete(@RequestBody List<Integer> ids) {
        if (carouselService.removeByIds(ids)) {
            return R.success();
        } else {
            return R.fail();
        }
    }

}
