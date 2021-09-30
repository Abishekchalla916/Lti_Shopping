package com.example.demo.layer3.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.model.LtiOrder;
import com.example.demo.layer3.LTIOrderRepository;

@SpringBootTest
public class LTIOrderRepositoryTest {
	
	@Autowired
	LTIOrderRepository OrdRepo;
	
	@Test
	void selectOrderByOrdId() {
		LtiOrder O1 = OrdRepo.selectOrderByOrdId(2001l);
		System.out.println("Order Id:"+ O1.getOrdId());
		System.out.println("Order Date:"+ O1.getOrderDate());
		System.out.println("User Id:"+ O1.getLtiUser().getUserId());
		System.out.println("Delivery Status:"+O1.getDeliverySts());
		System.out.println("Total Order Price:"+ O1.getTotalOrderPrice());
		System.out.println("Mode Of Payment:"+ O1.getModeOfPayment());
	}
	
	@Test
	void selectAllOrders() {
		List<LtiOrder> Ords = OrdRepo.selectAllOrders();
		for(LtiOrder x: Ords) {
			System.out.println("Order Id:"+x.getOrdId());
			System.out.println("Order Date:"+ x.getOrderDate());
			System.out.println("User Id:"+ x.getLtiUser().getUserId());
			System.out.println("Delivery Status:"+x.getDeliverySts());
			System.out.println("Total Order Price:"+ x.getTotalOrderPrice());
			System.out.println("Mode Of Payment:"+ x.getModeOfPayment());
			System.out.println("...................");
		}
		}
	
	@Test
	void deleteOrder() {
		try {
			OrdRepo.deleteOrder(2001l);
			System.out.println("Order Deleted");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void updateOrderTest() {
		LtiOrder findOrd= OrdRepo.selectOrderByOrdId(2001l);
		System.out.println("Order Id:"+findOrd.getOrdId());
		System.out.println("Order Date:"+ findOrd.getOrderDate());
		System.out.println("User Id:"+ findOrd.getLtiUser().getUserId());
		System.out.println("Delivery Status:"+findOrd.getDeliverySts());
		System.out.println("Total Order Price:"+ findOrd.getTotalOrderPrice());
		System.out.println("Mode Of Payment:"+findOrd.getModeOfPayment());
		findOrd.setOrdId(2011l);
		OrdRepo.updateOrder(findOrd);
		System.out.println("Order Id:"+findOrd.getOrdId());
		System.out.println("Order Date:"+ findOrd.getOrderDate());
		System.out.println("User Id:"+ findOrd.getLtiUser().getUserId());
		System.out.println("Delivery Status:"+findOrd.getDeliverySts());
		System.out.println("Total Order Price:"+ findOrd.getTotalOrderPrice());
		System.out.println("Mode Of Payment:"+findOrd.getModeOfPayment());
	}
	
	//@SuppressWarnings("deprecation")
	@Test
	void insertOrder() {
		//Date d = new Date();
		LtiOrder newOrd = new LtiOrder();
		//newOrd.setOrdId(2006l);
		newOrd.setOrderDate(new java.util.Date());
		newOrd.setDeliverySts("D");
		newOrd.setTotalOrderPrice(50000d);
		newOrd.setModeOfPayment("UPI");
		
		OrdRepo.insertOrder(newOrd);
	}
}
