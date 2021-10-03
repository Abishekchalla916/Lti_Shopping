package com.example.demo.layer5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
import com.example.demo.layer4.LTIRetailerService;
import com.example.demo.Exception.LtiProductNotFoundException;
import com.example.demo.Exception.RetailerNotFoundExcepiton;
import com.example.demo.layer2.model.LtiProduct;
import com.example.demo.layer2.model.LtiRetailer;
@CrossOrigin
@RestController
@Service
public class LTIProductJPAController {

	@Autowired
	LTIRetailerService retailerService;
	
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
	@RequestMapping(path="/addJPAProd/{retilerID}")
	public void addProduct(@RequestBody LtiProduct prodToInsert,@PathVariable("retilerID")long retailerId) throws LtiProductNotFoundException,RetailerNotFoundExcepiton 
	{
	
		//System.out.println("addDepartment2 : " + deptToInsert.getDname()+" "+deptToInsert.getLoc());
		LtiRetailer retailer=retailerService.selectLtiRetailerByRetailerId(retailerId);
		if(retailer!=null) {
			prodService.insertProduct(prodToInsert);
			prodToInsert.setLtiRetailer(retailer);
			prodService.updateProduct(prodToInsert);
			List<LtiProduct> prodList=new ArrayList<>();
			prodList.add(prodToInsert);
			retailer.setLtiProducts(prodList);
			retailerService.updateRetailer(retailer);
			
//			List<LtiProduct> prodList=retailer.getLtiProducts();
//			prodList.add(prodToInsert);
//			retailer.setLtiProducts(prodList);
//			retailerService.updateRetailer(retailer);			
			//prodToInsert.setLtiRetailer(retailer);			
		}else {
			RetailerNotFoundExcepiton ex=new RetailerNotFoundExcepiton("Retailer dosen't exists");
			throw ex;
		}
		System.out.println("Adding Product ");
		System.out.println(prodToInsert.getProdBrand());
		//System.out.println(prodToInsert.getLtiRetailer().getRetailerId());
		System.out.println(prodToInsert.getProdName());
		System.out.println(prodToInsert.getProdPrice());
		System.out.println(prodToInsert.getStocksRemaining());
		System.out.println(prodToInsert.getProdDescription());
		prodService.insertProduct(prodToInsert);
		
	}
	
	@PostMapping
	@RequestMapping(path="/modifyJPAProdStocks/{noOfStocksToReduce}") //
	public void updateProduct(@PathVariable ("noOfStocksToReduce")int noOfStocksToReduce, @RequestBody LtiProduct prodToModify) throws LtiProductNotFoundException 
	{
		if(noOfStocksToReduce<-1) throw new RuntimeException("Invalid number to reduce stocks");
		System.out.println("Modifying....");
		if(prodToModify==null) throw new RuntimeException("Invalid product to modify");
		LtiProduct prod=prodService.selectProductByProdId(prodToModify.getProdId());
		if(prod==null) throw new LtiProductNotFoundException("Product not found ");
		prod.setStocksRemaining(prod.getStocksRemaining()-(noOfStocksToReduce==-1?prod.getStocksRemaining():noOfStocksToReduce));
		prodService.updateProduct(prod);
	}
	
	@GetMapping
	@RequestMapping(path="/deleteJPAProd/{prodId}") // localhost:8080/deleteDept/10
	public String deleteProduct(@PathVariable("prodId")  String prodId) throws LtiProductNotFoundException 
	{
		//System.out.println("deleteDepartment : "+dept.getDeptno());
		try {
			prodService.deleteProduct(Long.valueOf(prodId));
			return "Prod deleted";
		}catch(Exception e) {
						
		}
		return null;
	}
}
