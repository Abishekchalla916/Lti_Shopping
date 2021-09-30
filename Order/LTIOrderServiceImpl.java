package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.model.LtiOrder;
import com.example.demo.layer3.LTIOrderRepository;


@Service
public class LTIOrderServiceImpl implements LTIOrderService {
	
	@Autowired
	LTIOrderRepository OrderRepo;
	public LTIOrderServiceImpl() {
		System.out.println("LTIOrderService().......");
	}

	@Override
	public List<LtiOrder> selectAllOrders() {
		// TODO Auto-generated method stub
		return OrderRepo.selectAllOrders();
	}

	@Override
	public LtiOrder selectOrderByOrderId(long OId) {
		// TODO Auto-generated method stub
		return OrderRepo.selectOrderByOrdId(OId);
	}
	
	
}
