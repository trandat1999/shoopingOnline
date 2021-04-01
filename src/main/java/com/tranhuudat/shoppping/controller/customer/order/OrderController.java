package com.tranhuudat.shoppping.controller.customer.order;

import java.util.List;

import com.tranhuudat.shoppping.model.CartItemModel;
import com.tranhuudat.shoppping.security.AccountDetails;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    
    @GetMapping()
    public String getOrder(Model model){
        if (getAuthentication() != null) {
            model.addAttribute("account", getAuthentication().getFullName());
            List<CartItemModel> listItem= getAuthentication().getCartModel().getListItem();
            model.addAttribute("cart", listItem);
        }
        return "customer/order";
    }

    public AccountDetails getAuthentication() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
            if (accountDetails != null) {
                return accountDetails;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }
}
