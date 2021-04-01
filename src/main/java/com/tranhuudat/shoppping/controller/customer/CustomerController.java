package com.tranhuudat.shoppping.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tranhuudat.shoppping.model.ItemModel;
import com.tranhuudat.shoppping.security.AccountDetails;
import com.tranhuudat.shoppping.service.ICategoryService;
import com.tranhuudat.shoppping.service.IItemService;

@Controller
@RequestMapping("/home")
public class CustomerController {
	@Autowired
	private IItemService itemService;

	@Autowired
	private ICategoryService categoryService;
	
    @GetMapping
    public String homePage(Model model) {
    	return findPage(1,model);
    }
    
    @GetMapping("/page/{page}") 
    public String findPage(@PathVariable("page") int page, Model model) {
    	int pageSize=6;
    	Page<ItemModel> page1= itemService.findPage(page, pageSize);
    	List<ItemModel> listItem= page1.getContent();
		model.addAttribute("listcate", categoryService.findAll());
    	model.addAttribute("currentPage", page);
    	model.addAttribute("totalsPage", page1.getTotalPages());
    	model.addAttribute("listItem", listItem);
    	try {
    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		AccountDetails accountDetails= (AccountDetails) auth.getPrincipal();
            if (accountDetails != null) {
                model.addAttribute("account", accountDetails.getFullName());
            }
            return "customer/home";
		} catch (Exception e) {
			return "customer/home";
		}
    }
    
    @GetMapping("/item/{name}")
    public String itemDescription(Model model, @PathVariable("name") String name) {
    	model.addAttribute("item", itemService.findByName(name));
		model.addAttribute("listcate", categoryService.findAll());
    	try {
    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		AccountDetails accountDetails= (AccountDetails) auth.getPrincipal();
            if (accountDetails != null) {
                model.addAttribute("account", accountDetails.getFullName());
            }
            return "customer/item";
		} catch (Exception e) {
			return "customer/item";
		}
    	
    }

}
