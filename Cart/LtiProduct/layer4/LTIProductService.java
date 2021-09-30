package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.model.LtiProduct;

@Service
public interface LTIProductService {
	public LtiProduct selectProductByProdId(long prodId);
	
	public List<LtiProduct> selectAllProducts();

	public void updateProduct(LtiProduct prodToModify);

	public void deleteProduct(long i);

	public void insertProduct(LtiProduct deptToInsert);

}
