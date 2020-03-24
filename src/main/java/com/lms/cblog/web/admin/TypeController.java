package com.lms.cblog.web.admin;

import com.lms.cblog.po.Type;
import com.lms.cblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


/**
 * Autor Lms
 * Time 2019/9/20/020
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")       //查询，每页显示五条数据，  通过主键ID排序， 降序排序
    public String types(@PageableDefault(size=5,sort={"id"},direction = Sort.Direction.DESC) Pageable pageable,Model model){

        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")     //接受新增分类点击请求
    public String input(Model model){

        model.addAttribute("type",new Type());
        return "admin/addType";
    }

    @GetMapping("/types/{id}/input")    //编辑分类,修改分类名称，先查询出分类信息在跳转到新增分类页面进行编辑
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/addType";
    }

    @PostMapping("/types")  //新增分类
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes){  //@Valid用于后端校验

        Type type1=typeService.getTypeByName(type.getName());
        if (type1!=null){
            result.rejectValue("name","nameError","不能添加重复的分类");
        }

        if (result.hasErrors()){
            return "admin/addType";
        }

        Type t= typeService.saveType(type);
       if (t==null){
            attributes.addFlashAttribute("message","新增失败");
       }else{
            attributes.addFlashAttribute("message","新增成功");
       }
       return "redirect:/admin/types";  //返回到/types映射的方法中查询，再返回页面 (默认使用get请求？)
    }


    @PostMapping("/types/{id}")  //修改分类
    public String editPost(@Valid Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes){  //@Valid用于后端校验

        Type type1=typeService.getTypeByName(type.getName());
        if (type1!=null){
            result.rejectValue("name","nameError","不能添加重复的分类");
        }

        if (result.hasErrors()){
            return "admin/addType";
        }

        Type t= typeService.updateType(id,type);
        if (t==null){
            attributes.addFlashAttribute("message","修改失败");
        }else{
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/types";  //返回到/types映射的方法中查询，再返回页面 (默认使用get请求？)
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }

    /**
      *以下是单体应用改造时，新增的提供给服务消费者的service层使用的方法
     **/

    //新增一个分类
    @PostMapping("/type")
    public Type saveType(Type type){
        return typeService.saveType(type);
    }
    //根据id查询一个分类
    @GetMapping("/type")
    public Type getTypeById(Long id){
        return typeService.getType(id);
    }

    //根据name查询一个分类
    @GetMapping("/type")
    @ResponseBody
    public Type getTypeByName(String name){
        return typeService.getTypeByName(name);
    }

    //根据分页信息查询一页的数据
    @PostMapping("/types")
    @ResponseBody
    public Page<Type> listTypes(Pageable pageable){
        return typeService.listType(pageable);
    }

    //修改分类信息
    @PutMapping("/type")
    public Type updateType(Long id,Type type){
        return typeService.updateType(id,type);
    }

    //删除一条记录
    public void deleteType(Long id){
        typeService.deleteType(id);
    }

    //查询所有的分类
    @GetMapping("/types")
    public List<Type>listAll(){
        return typeService.listType();
    }

    //从阅读量由高到低查询分类
    @GetMapping("/typesTop")
    @ResponseBody
    public List<Type> listTypeTop(Integer size){
        return typeService.listTypeTop(size);
    }




}
