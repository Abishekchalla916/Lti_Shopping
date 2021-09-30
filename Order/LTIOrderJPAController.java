package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.model.LtiOrder;
import com.example.demo.layer3.LTIOrderRepository;
import com.example.demo.layer4.LTIOrderService;

@CrossOrigin(origins = "*", value = "*")
@RestController
public class LTIOrderJPAController {
	
	

	@Autowired
	LTIOrderService OrderService;

	public LTIOrderJPAController() {
		System.out.println("LTIOrderJPAController()....");
	}

	@GetMapping
	@RequestMapping(path = "/getAllOrders") // localhost:8086/getAllOrders
	public List<LtiOrder> getAllOrders() {
		System.out.println("getAllDepartments");
		return OrderService.selectAllOrders();
	}

	@GetMapping
	@RequestMapping(path = "/getOrder/{OId}") // localhost:8086/getOrder/2001
	public LtiOrder getOrder(@PathVariable("OId") long orderIdToFind) throws OrderNotFoundException {
		System.out.println("getOrder : " + orderIdToFind);
		LtiOrder foundOrder = null;
		foundOrder = OrderService.selectOrderByOrderId(orderIdToFind);

		if (foundOrder == null) {
			OrderNotFoundException d = new OrderNotFoundException("Order Id Not Found " + orderIdToFind);
			System.out.println("OrderNotFoundException");
			throw d;
		}

		return foundOrder;
	}
}
