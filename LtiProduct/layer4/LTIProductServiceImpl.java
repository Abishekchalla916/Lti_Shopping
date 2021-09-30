package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.model.LtiProduct;
import com.example.demo.layer3.LTIProductRepository;

@Service
public class LTIProductServiceImpl implements LTIProductService{

	@Autowired
	LTIProductRepository prodRepo;
		
	public LTIProductServiceImpl() {
		super();
		System.out.println("In prod service Impl()...");
	}

	@Override
	public LtiProduct selectProductByProdId(long prodId) {
		return prodRepo.selectProductByProdId(prodId);
	}

	@Override
	public List<LtiProduct> selectAllProducts() {
		return prodRepo.selectAllProducts();
	}

	@Override
	public void updateProduct(LtiProduct prodToModify) {
		prodRepo.updateProduct(prodToModify);
		
	}

	@Override
	public void deleteProduct(long i) {
				
	}

	@Override
	public void insertProduct(LtiProduct deptToInsert) {
		// TODO Auto-generated method stub
		
	}

}
