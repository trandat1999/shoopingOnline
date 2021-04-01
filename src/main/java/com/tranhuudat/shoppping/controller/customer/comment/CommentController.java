package com.tranhuudat.shoppping.controller.customer.comment;

import com.tranhuudat.shoppping.model.AccountModel;
import com.tranhuudat.shoppping.model.CommentModel;
import com.tranhuudat.shoppping.model.ItemModel;
import com.tranhuudat.shoppping.security.AccountDetails;
import com.tranhuudat.shoppping.service.IAccountService;
import com.tranhuudat.shoppping.service.ICommentService;
import com.tranhuudat.shoppping.service.IItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/comment/post")
public class CommentController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IItemService itemService;

    @PostMapping(value = "/{id}")
    public String postComment(Model model, @PathVariable(value = "id") long id,
            @RequestParam("comment") String comment) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            try {
                ItemModel item = itemService.findById(id);
                AccountModel account = accountService.findByUsername(getAuthentication().getUsername());
                CommentModel commentModel = new CommentModel();
                commentModel.setDetails(comment);
                commentModel.setItemModel(item);
                commentModel.setAccountModel(account);
                commentService.add(commentModel);
                return "redirect:/home/item/" + item.getName();
            } catch (Exception e) {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }
    }

    public AccountDetails getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
        if (accountDetails != null) {
            return accountDetails;
        } else {
            return null;
        }
    }
}