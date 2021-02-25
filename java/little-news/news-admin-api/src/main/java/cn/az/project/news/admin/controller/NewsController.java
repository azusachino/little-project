package cn.az.project.news.admin.controller;

import cn.az.project.news.core.domain.RestResponse;
import cn.az.project.news.db.entity.Comment;
import cn.az.project.news.db.entity.News;
import cn.az.project.news.db.service.ICommentService;
import cn.az.project.news.db.service.INewsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Liz
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Resource
    private ICommentService commentService;

    @Resource
    private INewsService newsService;

    @GetMapping
    public RestResponse list(@RequestParam News param) {
        return RestResponse.init().ok().message("enjoy your news").data(newsService.list(new QueryWrapper<>()));
    }

    @GetMapping("/{id}")
    public RestResponse detail(@PathVariable String id) {
        News news = newsService.getById(id);
        RestResponse response = RestResponse.init();
        return news == null
                ? response.code(HttpStatus.BAD_REQUEST).message("no news here")
                : response.ok().message("enjoy your news").data(news);
    }

    @PostMapping
    public RestResponse save(@RequestParam News entity) {
        RestResponse response = RestResponse.init();
        if (newsService.save(entity)) {
            return response.ok().message("save success");
        } else {
            return response.code(HttpStatus.BAD_REQUEST).message("save failed");
        }
    }

    @PutMapping
    public RestResponse update(@RequestParam News entity) {
        RestResponse response = RestResponse.init();
        if (newsService.saveOrUpdate(entity)) {
            return response.ok().message("update success");
        } else {
            return response.code(HttpStatus.BAD_REQUEST).message("update failed");
        }
    }

    @DeleteMapping("/{id}")
    public RestResponse delete(@PathVariable String id) {
        if (newsService.removeById(id)) {
            return RestResponse.init().ok().message("delete success");
        } else {
            return RestResponse.init().code(HttpStatus.BAD_REQUEST).message("delete failed");
        }
    }

    @PostMapping("/{id}/comment")
    public RestResponse comment(@PathVariable Long id, @RequestParam Comment entity) {
        RestResponse response = RestResponse.init();
        entity.setNewsId(id);
        if (commentService.save(entity)) {
            return response.ok().message("save success");
        } else {
            return response.code(HttpStatus.BAD_REQUEST).message("save failed");
        }
    }
}
