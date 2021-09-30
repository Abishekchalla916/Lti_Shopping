package com.example.demo.layer3;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.model.LtiProduct;


@Repository
public class LTIProductRepositoryImpl extends BaseRepository implements LTIProductRepository {

	public LTIProductRepositoryImpl() {
		System.out.println("Product RepositoryImpl().....");
	}
	
	@Transactional
	public void insertProduct(LtiProduct Ref) {
		super.persist(Ref);
		
	}

	@Transactional
	public LtiProduct selectProductByProdId(long PId) {
		return super.find(LtiProduct.class, PId);
	}

	@Transactional
	public List<LtiProduct> selectAllProducts() {
		return super.findAll("LtiProduct");
	}

	@Transactional
	public void updateProduct(LtiProduct Ref) {
		super.merge(Ref);
	}

	@Transactional
	public void deleteProduct(long PId) {
		super.remove(LtiProduct.class,PId);
	}

}
