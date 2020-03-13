package com.lms.cblog.service;

import com.lms.cblog.po.Blog;
import com.lms.cblog.vo.BlogQuery;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Blog getBlog(Long id);

    Blog getAndConvert(Long id) throws NotFoundException;//查询到博客，并将博客内容从markdown格式转换为html格式，因为新增博客保存的博客内容是markdown格式的

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog) throws NotFoundException;

    void deleteBlog(Long id);
}
