package com.lms.cblog.web;
/*
 *Autor Lms
 *Time 2019/8/25/025 12:13
 */

import com.lms.cblog.service.BlogService;
import com.lms.cblog.service.TagService;
import com.lms.cblog.service.TypeService;
import com.lms.cblog.vo.BlogQuery;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @RequestMapping("/")
    public String index(@PageableDefault(size = 8,
            sort= {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blog, Model model){

        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(8));
        return "index";   //“/admin”就是controller的映射，“admin/login”就是admin文件夹下的login.html动态页面
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model) throws NotFoundException {
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "blogDetail";
    }
}
