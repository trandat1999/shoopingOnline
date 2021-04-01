package com.tranhuudat.shoppping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;


@Entity
@Table(name = "account")
@Data
public class AccountModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(unique = true, name = "email")
    @Email(message = "invalid email")
    private String email;

    @Column(unique = true, name = "phone_number")
    private String phoneNumber;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne(targetEntity = RoleModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleModel role;

    @OneToOne(targetEntity = CartModel.class)
    @JoinColumn(name = "cart_id")
    private CartModel cartModel;

}
