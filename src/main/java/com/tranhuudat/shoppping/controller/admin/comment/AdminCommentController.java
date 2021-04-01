package com.tranhuudat.shoppping.controller.admin.comment;

import java.util.List;

import com.tranhuudat.shoppping.model.CommentModel;
import com.tranhuudat.shoppping.security.AccountDetails;
import com.tranhuudat.shoppping.service.ICommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/comment")
public class AdminCommentController {
    
    private final int pageSize= 10;

    @Autowired
    private ICommentService commentService;

    @GetMapping(value = "/list")
    public String getAll(Model model){
        return getPage(model, 1);
    }

    @GetMapping(value = "/page/{page}")
    public String getPage(Model model, @PathVariable("page") int pageNumber){
        getAuthentication(model);
        Page<CommentModel> page= commentService.findAll(pageNumber, pageSize);
        List<CommentModel> list= page.getContent();
        model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalsPage", page.getTotalPages());
		model.addAttribute("list", list);
        model.addAttribute("url", "comment");
        return "admin/comment/list";
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
