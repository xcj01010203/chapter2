package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 页面跳转控制器
 */
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 跳转到带有菜单的页面
     * @param pagePath  页面路径
     * @param request
     * @return
     */
    @RequestMapping("/forward/menu/{pagePath}")
    public ModelAndView forwardToMenuPage(@PathVariable String pagePath,
                                          HttpServletRequest request) {
        ModelAndView mv = new ModelAndView(pagePath);
        mv.addAllObjects(this.getParams(request));
        return mv;
    }

    /**
     * 跳转到不带有菜单的页面
     * @param pagePath 页面路径
     * @param request
     * @return
     */
    @RequestMapping("/forward/nomenu/{pagePath}")
    public ModelAndView forwardToNoMenuPage(@PathVariable String pagePath,
                                          HttpServletRequest request) {
        ModelAndView mv = new ModelAndView(pagePath);
        mv.addAllObjects(this.getParams(request));
        return mv;
    }

    /**
     * 获取请求参数
     * @param request
     * @return
     */
    protected Map<String, Object> getParams(HttpServletRequest request)
    {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        Enumeration<String> nameEnumeration = request.getParameterNames();
        if (nameEnumeration != null)
        {
            while (nameEnumeration.hasMoreElements())
            {
                String key = nameEnumeration.nextElement();
                paraMap.put(key, request.getParameter(key));
            }
        }
        return paraMap;
    }
}
