package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.model.LtiOrder;

@Service
public interface LTIOrderService {
	public List<LtiOrder> selectAllOrders();
	
	public LtiOrder selectOrderByOrderId(long OId);
}

