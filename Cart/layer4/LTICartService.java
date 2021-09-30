package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.model.LtiCart;
import com.example.demo.layer2.model.LtiCartPK;

@Service
public interface LTICartService {
	LtiCart selectCartByOrdIDProdID(LtiCartPK lk);
	List<LtiCart> selectCarts();
}
