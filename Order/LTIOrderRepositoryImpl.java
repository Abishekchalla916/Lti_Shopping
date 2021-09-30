package com.example.demo.layer3;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.model.LtiOrder;

@Repository
public class LTIOrderRepositoryImpl extends BaseRepository implements LTIOrderRepository {
	
	public LTIOrderRepositoryImpl() {
		System.out.println("LTIOrderRespository() working");
	}
	
	@Transactional
	@Override
	public void insertOrder(LtiOrder ORef) {
		// TODO Auto-generated method stub
		super.persist(ORef);
	}
	
	@Transactional
	@Override
	public LtiOrder selectOrderByOrdId(long OId) {
		// TODO Auto-generated method stub
		return super.find(LtiOrder.class, OId);
	}
	
	@Transactional
	@Override
	public List<LtiOrder> selectAllOrders() {
		// TODO Auto-generated method stub
		return super.findAll("LtiOrder");
	}
	
	@Transactional
	@Override
	public void updateOrder(LtiOrder ORef) {
		// TODO Auto-generated method stub
		super.merge(ORef);

	}
	
	@Transactional
	@Override
	public void deleteOrder(long OId) {
		// TODO Auto-generated method stub
		super.remove(LtiOrder.class,OId);

	}

}
