package com.example.demo.layer3;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.model.LtiCart;
import com.example.demo.layer2.model.LtiCartPK;

@Repository
public class LTICartRepositoryImpl extends BaseRepository implements LTICartRepository {

	@Transactional
	@Override
	public void insertCart(LtiCart cart) {
		super.persist(cart);

	}
	
	@Transactional
	@Override
	public LtiCart selectCartByOrdIDProdID(LtiCartPK lk) {
		// TODO Auto-generated method stub
		return super.find(LtiCart.class, lk);
		
	}
	
	@Transactional
	@Override
	public List<LtiCart> selectCarts() {
		// TODO Auto-generated method stub
		return super.findAll("LtiCart");
	}

	@Transactional
	@Override
	public void updateCart(LtiCart cart) {
		// TODO Auto-generated method stub

		super.merge(cart);
	}

	@Transactional
	@Override
	public void deleteCart(LtiCartPK lk) {
		// TODO Auto-generated method stub

		super.remove(LtiCart.class, lk);
	}

}
