package com.tranhuudat.shoppping.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.tranhuudat.shoppping.model.CartModel;

import java.util.Collection;

public class AccountDetails extends User {

    /**
     * 
     */
    private static final long serialVersionUID = -4403804947552589055L;

    public AccountDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AccountDetails(String username, String password, boolean enabled, boolean accountNonExpired,
    boolean credentialsNonExpired, boolean accountNonLocked,
    Collection<? extends GrantedAuthority> authorities){
        super(username, password, enabled, true, true, true, authorities);
    }

    
    private String fullName;
    private CartModel cartModel;

    public CartModel getCartModel() {
        return cartModel;
    }

    public void setCartModel(CartModel cartModel) {
        this.cartModel = cartModel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
