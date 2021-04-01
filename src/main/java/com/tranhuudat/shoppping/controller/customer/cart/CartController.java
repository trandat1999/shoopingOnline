package com.tranhuudat.shoppping.controller.customer.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tranhuudat.shoppping.model.CartItemModel;
import com.tranhuudat.shoppping.model.ItemModel;
import com.tranhuudat.shoppping.security.AccountDetails;
import com.tranhuudat.shoppping.service.ICartService;
import com.tranhuudat.shoppping.service.IItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @Autowired
    private IItemService itemService;


    @GetMapping()
    public String getCartView(Model model) {
        if (getAuthentication() != null) {
            model.addAttribute("account", getAuthentication().getFullName());
            List<CartItemModel> listItem= getAuthentication().getCartModel().getListItem();
            model.addAttribute("cart", listItem);
        }
        return "customer/cart";
    }

    @GetMapping(value = "/addtocart/{id}")
    public String addToCart(Model model, @PathVariable("id") long id, HttpServletRequest request) {
        if (getAuthentication() != null) {
            ItemModel item = itemService.findById(id);
            List<CartItemModel> listItem = cartService.findById(getAuthentication().getCartModel().getId()).getListItem();
            boolean tmp = false;
            for (CartItemModel cartitem : listItem) {
                if (cartitem.getItemModel().getId() == id) {
                    cartitem.setQuantity(cartitem.getQuantity() + 1);
                    tmp = true;
                    break;
                }
            }
            if (tmp == false) {
                CartItemModel cartitem = new CartItemModel();
                cartitem.setCartModel(getAuthentication().getCartModel());
                cartitem.setQuantity(1);
                cartitem.setItemModel(item);
                listItem.add(cartitem);
            }
            getAuthentication().getCartModel().setListItem(listItem);
            cartService.update(getAuthentication().getCartModel());
            return "redirect:/cart";
        } else {

            return "redirect:/login";
        }

    }

    @GetMapping(value = "/delete/{id}")
    public String deleteCartItem(Model model, @PathVariable(value = "id") long id){
        List<CartItemModel> listcartitem= getAuthentication().getCartModel().getListItem();
        for(CartItemModel cartItemModel:listcartitem){
            if(cartItemModel.getId()==id){
                if(cartItemModel.getQuantity()==1){
                    listcartitem.remove(cartItemModel);
                    break;
                }else{
                    cartItemModel.setQuantity(cartItemModel.getQuantity()-1);
                    break;
                }
            }
        }
        getAuthentication().getCartModel().setListItem(listcartitem);
        cartService.update(getAuthentication().getCartModel());
        return "redirect:/cart";
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
