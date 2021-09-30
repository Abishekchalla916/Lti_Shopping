package com.example.demo.layer3.test;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.demo.layer2.model.LtiProduct;
import com.example.demo.layer2.model.LtiRetailer;
import com.example.demo.layer3.LTIProductRepository;
import com.example.demo.layer3.LTIProductRepositoryImpl;

@SpringBootTest
public class LtiProductTest {
	
	@Autowired
	LTIProductRepository prodRepo;

	@Test
	void addNewProductTest() {
		//ApplicationContext ctx = new
		//ClassPathXmlApplicationContext("SpringConfig.xml");
		//deptRepo = (LTIProductRepository) ctx.getBean("ProductRepo");
		this.prodRepo=new LTIProductRepositoryImpl();
		LtiProduct newProd = new LtiProduct();
		newProd.setProdId(1511);
		newProd.setProdBrand("Apple");
		newProd.setLtiRetailer(null);
		newProd.setProdName("13 pro");
		newProd.setProdPrice(90000.0);
		newProd.setStocksRemaining(999);
		newProd.setProdDescription("Good mobile juz buy it");
		prodRepo.insertProduct(newProd);
	}

	@Test
	public void selectAll() {
		//ApplicationContext ctx = new
		//		ClassPathXmlApplicationContext("SpringConfig.xml");
		//deptRepo = (DeptRepository) ctx.getBean("deptRepo");
		List<LtiProduct> list = prodRepo.selectAllProducts();
		for(LtiProduct prod:list) {
			System.out.println(prod.getProdId());
			System.out.println(prod.getProdName());
			System.out.println(prod.getProdBrand());
			System.out.println(prod.getProdDescription());
			System.out.println(prod.getProdPrice());
			System.out.println(prod.getStocksRemaining());
			System.out.println("----------");
		}
	}
	
	@Test
	public void select() {
		//ApplicationContext ctx = new
		//		ClassPathXmlApplicationContext("SpringConfig.xml");
		//deptRepo = (DeptRepository) ctx.getBean("deptRepo");
		LtiProduct prod = prodRepo.selectProductByProdId(1500l);
		System.out.println(prod.getProdId());
		System.out.println(prod.getProdName());
		System.out.println(prod.getProdBrand());
		System.out.println(prod.getProdDescription());
		System.out.println(prod.getProdPrice());
		System.out.println(prod.getStocksRemaining());
		System.out.println("----------");
	}
	
	@Test
	public void update() {
		LtiProduct newProd = new LtiProduct();
		newProd.setProdId(1511);
		newProd.setProdBrand("Apple");
		newProd.setLtiRetailer(null);
		newProd.setProdName("13 pro");
		newProd.setProdPrice(90000.0);
		newProd.setStocksRemaining(999);
		newProd.setProdDescription("Good mobile juz buy it");
		prodRepo.updateProduct(newProd);
		System.out.println("Updated Department Row");
		System.out.println("====================");
		System.out.println(newProd.getProdId());
		System.out.println(newProd.getProdName());
		System.out.println(newProd.getProdBrand());
		System.out.println(newProd.getProdDescription());
		System.out.println(newProd.getProdPrice());
		System.out.println(newProd.getStocksRemaining());
		System.out.println("----------");
		System.out.println("====================");
	}
	
	@Test
	void deleteProdTest() {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConfig.xml");
		//deptRepo = (DeptRepository) ctx.getBean("deptRepo");
		LtiProduct prod = prodRepo.selectProductByProdId(10l);
		if(prod!=null) {
			prodRepo.deleteProduct((int)prod.getProdId());
			System.out.println("Deleted");
			
		}else {
			System.out.println("Prod with that id dosen't exists");
		}
//			
//		try {
//			deptRepo.deleteProduct(55);
//			System.out.println("Object deleted");
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		Dept delDept = deptRepo.selectDeptByDeptNo(55);
//		boolean flag=deptRepo.deleteDept(delDept);	
//		if(flag) {
//			System.out.println("Deleted Department Row");
//			System.out.println("====================");
//			System.out.println(delDept.getDeptno());
//			System.out.println(delDept.getDname());
//			System.out.println(delDept.getLoc());
//			System.out.println("====================");
//		}
		
	}
}