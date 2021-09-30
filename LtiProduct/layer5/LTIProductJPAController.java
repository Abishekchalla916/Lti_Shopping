package com.example.demo.layer5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.layer3.LTIProductRepository;
import com.example.demo.layer4.LTIProductService;
import com.example.demo.layer2.model.LtiProduct;
@CrossOrigin
@RestController
public class LTIProductJPAController {

	
	@Autowired
	LTIProductService prodService; //here it should be service calls
	
	public LTIProductJPAController() {
		System.out.println("DeptJPAController()....");
		
	}
	@GetMapping
	@RequestMapping(path="/getJPAProds") //localhost:8085/getJPADepts
	public List<LtiProduct> getAllProducts() {
		System.out.println("getAllProducts");
		return prodService.selectAllProducts();
	}
	
	@GetMapping
	@RequestMapping(path="/getJPAProd/{prodId}") // localhost:8085/getJPADept/10
	public LtiProduct getProduct(@PathVariable("prodId") long prodId) throws LtiProductNotFoundException 
	{
		System.out.println("getDepartment : "+prodId);
		LtiProduct foundDept = null;
		foundDept = prodService.selectProductByProdId(prodId);

		if(foundDept == null) {
			System.out.println("Not exists");
			LtiProductNotFoundException prodExep = new LtiProductNotFoundException("Product id Not Found "+prodId);
			throw prodExep;
		}
		return foundDept;
	}
	
	@PostMapping
	@RequestMapping(path="/addJPAProd") // 
	public void addDepartment2(@RequestBody LtiProduct deptToInsert) throws LtiProductNotFoundException 
	{
		//System.out.println("addDepartment2 : " + deptToInsert.getDname()+" "+deptToInsert.getLoc()); 
		System.out.println("Adding department");
		prodService.insertProduct(deptToInsert);
		//deptRepo.insertDept(deptToInsert);
		
	}
	
	@PostMapping
	@RequestMapping(path="/modifyJPAProd") // 
	public void modifyDepartment(@RequestBody LtiProduct prodToModify) throws LtiProductNotFoundException 
	{
		//System.out.println("modifyDepartment : "+deptToModify.getDeptno()+" "+deptToModify.getDname()+" "+deptToModify.getLoc()); 
		System.out.println("Modifying....");
		boolean found=false;
		prodService.updateProduct(prodToModify);
	}
	@PostMapping
	@RequestMapping(path="/deleteJPAProd") // localhost:8080/deleteDept/10
	public void deleteDepartment(@RequestBody LtiProduct prod) throws LtiProductNotFoundException 
	{
		//System.out.println("deleteDepartment : "+dept.getDeptno());
		try {
			prodService.deleteProduct(1525);
		}catch(Exception e) {
						
		}
	}
		
}
