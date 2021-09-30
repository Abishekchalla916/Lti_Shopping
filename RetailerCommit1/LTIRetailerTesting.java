package com.example.demo.layer3.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.model.LtiRetailer;

import com.example.demo.layer3.LTIRetailerRepository;

@SpringBootTest
public class LTIRetailerTesting {
	
	@Autowired
	LTIRetailerRepository RetailerRepo;
	
	@Test
	void selectLtiRetailerByRetailerId() {
		LtiRetailer O1 = RetailerRepo.selectLtiRetailerByRetailerId(1001l);
		System.out.println("Retailer Id:"+ O1.getRetailerId());
		System.out.println("Retailer Name:"+ O1.getRetailerName());
		System.out.println("Retailer Mobile:"+ O1.getRetailerMobileNumber());
		System.out.println("Retailer Company:"+O1.getSellerComp());
		System.out.println("Retailer Brand:"+O1.getBrand());	
	}
	
	
	@Test
	void findAll() {
		List<LtiRetailer> RetailerList = RetailerRepo.selectAllLtiRetailers();
		for(LtiRetailer d: RetailerList)
		{
			System.out.println("Retailer ID: "+ d.getRetailerId());
			System.out.println("Retailer Name: "+ d.getRetailerName());
			System.out.println("Retailer Number: "+ d.getRetailerMobileNumber());
			System.out.println("Retailer Company: "+ d.getSellerComp());
			System.out.println("Retailer Brand : "+ d.getBrand());			
			System.out.println("=============");
		}
	}
	
	@Test
	void updateLtiRetailer() {

		LtiRetailer findRetailer= RetailerRepo.selectLtiRetailerByRetailerId(1001l);
		System.out.println("Retailer ID:"+findRetailer.getRetailerId());
		System.out.println("Retailer Name: "+findRetailer.getRetailerName());
		System.out.println("Retailer Number: "+findRetailer.getRetailerMobileNumber());	
		System.out.println("Retailer Company:"+findRetailer.getSellerComp());
		System.out.println("Retailer Brand :"+findRetailer.getBrand());
		System.out.println("============After Updating=========");
		findRetailer.setRetailerName("Mills");
		RetailerRepo.updateLtiRetailer(findRetailer);
		System.out.println("Retailer ID:"+findRetailer.getRetailerId());
		System.out.println("Retailer Name: "+findRetailer.getRetailerName());
		System.out.println("Retailer Number: "+findRetailer.getRetailerMobileNumber());	
		System.out.println("Retailer Company:"+findRetailer.getSellerComp());
		System.out.println("Retailer Brand :"+findRetailer.getBrand());
		
	}
	
	@Test
	void deleteLtiRetailer() {
	try {
		RetailerRepo.deleteLtiRetailer(61l);
			System.out.println("Object deleted..");
		}
	catch(Exception e) {
	System.out.println(e.getMessage());
		}
	}
	
	@Test
	void insertLtiRetailer(){
		
		LtiRetailer newRetailer = new LtiRetailer();
		
		//newRetailer.setRetailerId(1005l);
		newRetailer.setRetailerName("Harrick");
		newRetailer.setRetailerMobileNumber(9422193287l);
		newRetailer.setSellerComp("Harrick's Iphones");
		newRetailer.setBrand("Apple");
		
		RetailerRepo.insertLtiRetailer(newRetailer);
	}

}
	