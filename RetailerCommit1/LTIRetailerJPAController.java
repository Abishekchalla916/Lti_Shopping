package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.layer2.model.LtiRetailer;
import com.example.demo.layer3.LTIRetailerRepository;
import com.example.demo.layer4.LTIRetailerService;

@CrossOrigin
@RestController
public class LTIRetailerJPAController {

	@Autowired
	LTIRetailerService RetailerService;
	
	/*
	@Autowired
	LTIRetailerRepository RetailerRepo;
	*/

	public LTIRetailerJPAController() {
		System.out.println("LTIRetailerJPAController()....");
	}
	

	@GetMapping
	@RequestMapping(path="/getAllRetailers") //localhost:8086/getAllRetailers
	public List<LtiRetailer> getAllRetailers() {
		System.out.println("getAllRetailers");
		return RetailerService.selectAllLtiRetailers();
	}
	
	
	@GetMapping
	@RequestMapping(path="/getRetailer/{dno}") // localhost:8086/getRetailer/1001
	public LtiRetailer getRetailer(@PathVariable("dno") long RetailerIdToFind) throws RetailerNotFoundExcepiton 
	{
		System.out.println("getRetailer : "+RetailerIdToFind);
		LtiRetailer foundRetailer = null;
		foundRetailer = RetailerService.selectLtiRetailerByRetailerId(RetailerIdToFind);
	
		if(foundRetailer == null) {
		//	RetailerNotFoundExcepiton d = new RetailerNotFoundExcepiton("Retailer Id Not Found "+RetailerIdToFind);
			RetailerNotFoundExcepiton d = new RetailerNotFoundExcepiton("Retailer Id Not Found "+RetailerIdToFind);
		}

		return foundRetailer;
	}
}