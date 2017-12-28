package cn.org.hentai.server.app;

import cn.org.hentai.server.dao.UserDAO;
import cn.org.hentai.server.model.User;
import cn.org.hentai.server.util.Configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matrixy on 2017/8/26.
 */
public class UserInterceptor extends HandlerInterceptorAdapter
{
    @Autowired
    UserDAO userDAO;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception
    {
        // 获取登陆的用户身份
        User user = (User)request.getSession().getAttribute("loginUser");
        request.setAttribute("loginUser", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception
    {
        // do nothing here...
    }
}
