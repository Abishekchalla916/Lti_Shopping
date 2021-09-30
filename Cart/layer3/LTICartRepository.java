package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.model.LtiCart;
import com.example.demo.layer2.model.LtiCartPK;

@Repository
public interface LTICartRepository {
void insertCart(LtiCart cart);
LtiCart selectCartByOrdIDProdID(LtiCartPK lk);
List<LtiCart> selectCarts();
void updateCart(LtiCart cart);
void deleteCart(LtiCartPK lk);
}
