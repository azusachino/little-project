package cn.az.replica.mall.base;

import cn.az.replica.mall.constant.Constants;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * BaseController
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see BaseController
 * @since 2020-03-24
 */
public abstract class BaseController {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpSession session;

    @Resource
    protected ServletContext application;

    protected <T> Page<T> getPage(HttpServletRequest request) {
        String pageSizeStr = request.getParameter(Constants.PAGE_SIZE);
        long pageSize = Long.parseLong(StringUtils.isNotEmpty(pageSizeStr) ? pageSizeStr : "10");
        return getPage(request, pageSize);
    }

    protected <T> Page<T> getPage(HttpServletRequest request, long pageSize) {
        String pageNumberStr = request.getParameter(Constants.PAGE_NUMBER);
        long pageNumber = Long.parseLong(StringUtils.isNotEmpty(pageNumberStr) ? pageNumberStr : "1");
        String sortName = request.getParameter("sortName");
        String sortOrder = request.getParameter("sortOrder");
        Page<T> tPage = new Page<>(pageNumber, pageSize);
        if (StringUtils.isNotEmpty(sortName)) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn(sortName.replaceAll("[A-Z]", "_$0").toLowerCase());
            if (Constants.ORDER_DESC.equals(sortOrder)) {
                orderItem.setAsc(false);
            }
            tPage.addOrder(orderItem);
        }
        return tPage;
    }

    protected String redirectTo(String url) {
        return "redirect:" + url;
    }
}
