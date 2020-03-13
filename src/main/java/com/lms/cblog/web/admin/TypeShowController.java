package com.lms.cblog.web.admin;

import com.lms.cblog.po.Blog;
import com.lms.cblog.po.Type;
import com.lms.cblog.service.BlogService;
import com.lms.cblog.service.TypeService;
import com.lms.cblog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Autor Lms
 * Time 2020-3-13
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String Types(@PageableDefault(size = 50,
            sort= {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model,@PathVariable Long id){
        List<Type> types=typeService.listTypeTop(100);
        if(id==-1){
            id=types.get(0).getId();
        }
        BlogQuery blogQuery=new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types",types);
        model.addAttribute("page",blogService.listBlog(pageable,blogQuery));
        model.addAttribute("activeTypeId",id);
        return "blogType";
    }
}
