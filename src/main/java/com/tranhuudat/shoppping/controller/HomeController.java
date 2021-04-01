package com.tranhuudat.shoppping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranhuudat.shoppping.model.AccountModel;
import com.tranhuudat.shoppping.model.ItemModel;
import com.tranhuudat.shoppping.service.IAccountService;
import com.tranhuudat.shoppping.service.IItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private IItemService itemService;

    @Autowired
    private IAccountService accountService;

    @GetMapping(value = "image/{id}")
    public void getImage(@PathVariable("id") long id, HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {
        ItemModel item = itemService.getItemById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getPicture());
        response.getOutputStream().close();
    }

    @GetMapping("login")
    private String loginView(HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        request.getSession().setAttribute("url_prior", referrer);
        return "login";
    }

    @GetMapping("signup")
    private String signupView(Model model) {
        model.addAttribute("account", new AccountModel());
        return "signup";
    }

    @PostMapping("signup")
    private String signup(@ModelAttribute("account") AccountModel accountModel, Model model) {
        if (accountService.save(accountModel)) {
            return "redirect:/login";
        } else {
            model.addAttribute("err", "account is exists");
            return signupView(model);
        }
    }
}
