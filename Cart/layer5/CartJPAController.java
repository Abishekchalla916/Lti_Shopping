package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CartNotFoundException;
import com.example.demo.layer2.model.LtiCart;
import com.example.demo.layer2.model.LtiCartPK;
import com.example.demo.layer3.LTICartRepository;
import com.example.demo.layer4.LTICartService;

@CrossOrigin
@RestController
public class CartJPAController {
	@Autowired
	LTICartService ls;

	@GetMapping
	@RequestMapping(path = "/getJPACart/{oid}/{pid}")
	public LtiCart getSingleLtiCart(@PathVariable("oid") long ordIdtoFind, @PathVariable("pid") long prodIdToFind) throws CartNotFoundException {
		LtiCartPK lk = new LtiCartPK(ordIdtoFind, prodIdToFind);
		LtiCart lc = new LtiCart();
		lc=null;
		lc= ls.selectCartByOrdIDProdID(lk);
	    if(lc==null) {
	    	CartNotFoundException ce = new CartNotFoundException("Cart not found "+"Order Id: "+lk.getOrdId()+" Product Id: "+lk.getProdId());
	    throw ce;
	    }
	    return lc;

	}

	@GetMapping
	@RequestMapping(path = "/getJPACarts")
	public List<LtiCart> getLtiCarts() {
		return ls.selectCarts();

	}
}
