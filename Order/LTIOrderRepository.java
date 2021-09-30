package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.model.LtiOrder;

@Repository
public interface LTIOrderRepository {
	void insertOrder(LtiOrder ORef);
	LtiOrder selectOrderByOrdId(long OId);
	List<LtiOrder> selectAllOrders();
	void updateOrder(LtiOrder ORef);
	void deleteOrder(long OId);

}
