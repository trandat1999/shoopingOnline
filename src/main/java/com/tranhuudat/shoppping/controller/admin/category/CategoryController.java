package com.tranhuudat.shoppping.controller.admin.category;

import java.util.List;

import com.tranhuudat.shoppping.model.CategoryModel;
import com.tranhuudat.shoppping.security.AccountDetails;
import com.tranhuudat.shoppping.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    private final int pageSize= 10;

    @GetMapping(value = "/list")
    public String getAllCategory(Model model){
        return getPage(model, 1);
    }

    @GetMapping(value = "/page/{page}")
    public String getPage(Model model, @PathVariable("page") int pageNumber){
        getAuthentication(model);
        Page<CategoryModel> page= categoryService.findAll(pageNumber, pageSize);
        List<CategoryModel> list= page.getContent();
        model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalsPage", page.getTotalPages());
		model.addAttribute("listCate", list);
        model.addAttribute("url", "category");
        return "admin/category/listcategory";
    }

    @GetMapping(value = "/add")
    public String getAdd(Model model){
        getAuthentication(model);
        model.addAttribute("cate", new CategoryModel());
        return "admin/category/create";
    }

    @PostMapping(value="/add")
    public String postAdd(Model model, @ModelAttribute("cate") CategoryModel cate ){
        getAuthentication(model);
        if(categoryService.add(cate)==null){
            model.addAttribute("err", "category has exist");
            return getAdd(model);
        }else{
            return "redirect:/admin/category/list";
        }
    }

    private void getAuthentication(Model model) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
			model.addAttribute("account", accountDetails);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
