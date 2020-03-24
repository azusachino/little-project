package cn.az.card.merchant.controller;

import cn.az.card.merchant.constant.ErrorCode;
import cn.az.card.merchant.domain.RestResponse;
import cn.az.card.merchant.service.IMerchantService;
import cn.az.card.merchant.vo.CardTemplate;
import cn.az.card.merchant.vo.MerchantRequest;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author az
 * @date 2020/3/18
 */
@Slf4j
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Resource
    private IMerchantService merchantService;

    @PostMapping("/create")
    public RestResponse create(@RequestBody MerchantRequest request) {
        RestResponse response = RestResponse.init();
        if (Objects.isNull(request)) {
            return response.code(HttpStatus.BAD_REQUEST).message("empty request");
        }
        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        int result = merchantService.createMerchant(request);
        if (result == -1) {
            return response.code(HttpStatus.BAD_REQUEST).message("bad request");
        } else {
            return response.ok().data(result);
        }
    }

    @GetMapping("/{id}")
    public RestResponse getOne(@PathVariable("id") Integer id) {
        log.info("get one merchant info: {}", id);
        return RestResponse.init().ok().data(merchantService.getById(id));
    }

    @PostMapping("/drop")
    public RestResponse drop(@RequestBody CardTemplate template) {
        RestResponse response = RestResponse.init();
        if (Objects.isNull(template)) {
            return response.code(HttpStatus.BAD_REQUEST).message("empty template");
        }
        log.info("Drop Card Template: {}", template);

        ErrorCode errorCode = merchantService.dropCardTemplate(template);

        if (ErrorCode.SUCCESS.equals(errorCode)) {
            return response.ok();
        } else {
            return response.code(HttpStatus.INTERNAL_SERVER_ERROR).message(errorCode.getDescription());
        }
    }
}
