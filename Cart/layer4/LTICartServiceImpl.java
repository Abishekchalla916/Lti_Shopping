package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.model.LtiCart;
import com.example.demo.layer2.model.LtiCartPK;
import com.example.demo.layer3.LTICartRepository;

@Service
public class LTICartServiceImpl implements LTICartService {
@Autowired
LTICartRepository lr;
	@Override
	public LtiCart selectCartByOrdIDProdID(LtiCartPK lk) {
		// TODO Auto-generated method stub
		return lr.selectCartByOrdIDProdID(lk);
	}

	@Override
	public List<LtiCart> selectCarts() {
		// TODO Auto-generated method stub
		return lr.selectCarts();
	}

	

}
