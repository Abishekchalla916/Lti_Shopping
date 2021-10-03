package com.example.demo.layer2.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the LTI_RETAILER database table.
 * 
 */
@Entity
@Table(name="LTI_RETAILER")
@NamedQuery(name="LtiRetailer.findAll", query="SELECT l FROM LtiRetailer l")
public class LtiRetailer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RETAILER_ID")
	private long retailerId;

	private String brand;

	@Column(name="RETAILER_MOBILE_NUMBER")
	private Long retailerMobileNumber;

	@Column(name="RETAILER_NAME")
	private String retailerName;

	@Column(name="SELLER_COMP")
	private String sellerComp;

	//bi-directional many-to-one association to LtiProduct
	@OneToMany(mappedBy="ltiRetailer", fetch=FetchType.EAGER)
	private List<LtiProduct> ltiProducts;

	public LtiRetailer() {
	}

	public long getRetailerId() {
		return this.retailerId;
	}

	public void setRetailerId(long retailerId) {
		this.retailerId = retailerId;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getRetailerMobileNumber() {
		return this.retailerMobileNumber;
	}

	public void setRetailerMobileNumber(Long retailerMobileNumber) {
		this.retailerMobileNumber = retailerMobileNumber;
	}

	public String getRetailerName() {
		return this.retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getSellerComp() {
		return this.sellerComp;
	}

	public void setSellerComp(String sellerComp) {
		this.sellerComp = sellerComp;
	}
	
	public List<LtiProduct> getLtiProducts() {
		return this.ltiProducts;
	}

	public void setLtiProducts(List<LtiProduct> ltiProducts) {
		this.ltiProducts = ltiProducts;
	}

	public LtiProduct addLtiProduct(LtiProduct ltiProduct) {
		getLtiProducts().add(ltiProduct);
		ltiProduct.setLtiRetailer(this);

		return ltiProduct;
	}

	public LtiProduct removeLtiProduct(LtiProduct ltiProduct) {
		getLtiProducts().remove(ltiProduct);
		ltiProduct.setLtiRetailer(null);

		return ltiProduct;
	}

}