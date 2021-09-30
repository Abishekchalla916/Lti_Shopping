package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.model.LtiCart;
import com.example.demo.layer2.model.LtiCartPK;
import com.example.demo.layer3.LTICartRepository;



@SpringBootTest
public class CartCRUDTest {

	@Autowired
	LTICartRepository lr;
	LtiCart lc = new LtiCart();
	@Test
	public void selectSingleCart() {
		
		LtiCartPK lk = new LtiCartPK(2001,1500);
		
		
		
		lc = (LtiCart) lr.selectCartByOrdIDProdID(lk);
		System.out.println(lc.getId().getOrdId());
		System.out.println(lc.getId().getProdId());
		System.out.println(lc.getProdPrice());
		System.out.println(lc.getQty());
		System.out.println(lc.getProdTotal());
	}
	@Test 
	public void insertSingleCart() {
		LtiCart lc = new LtiCart();
		LtiCartPK lk = new LtiCartPK(2001,1503);
		lc.setId(lk);
		lc.setProdPrice(1000.0);
		lc.setQty(2);
		lc.setProdTotal(2*1000.0);
		lr.insertCart(lc);
	}
	@Test
	public void selectAllCarts() {
		
		List<LtiCart> cl = lr.selectCarts();
		for(LtiCart a : cl) {
			System.out.println(a.getLtiOrder().getOrdId());
		System.out.println(a.getLtiProduct().getProdId());
			System.out.println(a.getProdPrice());
			System.out.println(a.getQty());
			System.out.println(a.getProdTotal());
			System.out.println("--------------");
		}
	}
	@Test
	public void deleteCart() {
	LtiCartPK lk = new LtiCartPK(2001,1503);
	
	lr.deleteCart(lk);
	System.out.println("deleted");
	}
	}

