package com.tranhuudat.shoppping.controller.admin;

import java.util.List;

import com.tranhuudat.shoppping.model.CategoryModel;
import com.tranhuudat.shoppping.model.ItemModel;
import com.tranhuudat.shoppping.security.AccountDetails;
import com.tranhuudat.shoppping.service.ICategoryService;
import com.tranhuudat.shoppping.service.IItemService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private IItemService itemService;

	@Autowired
	private ICategoryService categoryService;

	@GetMapping(value = "/home")
	private String homeAdminPage(Model model) {
		getAuthentication(model);
		return "admin/home";
	}

	@GetMapping(value = "/item/page/{page}")
	public String getItem(Model model, @PathVariable(value = "page") int page) {
		getAuthentication(model);
		int pageSize = 8;
		Page<ItemModel> page1 = itemService.findPage(page, pageSize);
		List<ItemModel> listItem = page1.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalsPage", page1.getTotalPages());
		model.addAttribute("listItem", listItem);
		model.addAttribute("url", "item");
		return "admin/item/listitem";
	}

	@GetMapping(value = "/item/listitem")
	public String getListItem(Model model) {
		return getItem(model, 1);
	}

	@GetMapping(value = "/item/add")
	public String addItem(Model model) {
		getAuthentication(model);
		model.addAttribute("item", new ItemModel());
		model.addAttribute("listCategory", categoryService.findAll());
		return "admin/item/additem";

	}

	@PostMapping(value = "/item/add")
	public String postItem(Model model, @ModelAttribute("item") ItemModel itemModel,
			@RequestParam("category") long idCate, @RequestParam("file") MultipartFile file) {
		CategoryModel cate = categoryService.findById(idCate);
		itemModel.setCategoryModel(cate);
		try {
			itemModel.setPicture(file.getBytes());
			if(itemService.saveItem(itemModel)){
				return "redirect:/admin/item/listitem";
			}else{
				return addItem(model);
			}
		} catch (Exception e) {
			model.addAttribute("err", "err");
			return addItem(model);
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
