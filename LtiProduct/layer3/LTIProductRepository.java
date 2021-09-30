package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.model.LtiProduct;

@Repository
public interface LTIProductRepository { //DAO is known as Repository framework
	void insertProduct(LtiProduct dRef);
	LtiProduct selectProductByProdId(long PId);
	List<LtiProduct> selectAllProducts();
	void updateProduct(LtiProduct dRef);
	void deleteProduct(long PId);
}
