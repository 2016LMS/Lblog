package com.lms.cblog.web.admin;

import com.lms.cblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Autor Lms
 * Time 2020-3-23
 */
@Controller
public class ArchiveShowController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archiveMap",blogService.arhciveBlog());
        model.addAttribute("blogCount",blogService.count());
        return "archives";
    }
}
