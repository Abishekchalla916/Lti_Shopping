package com.example.demo.layer4;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.model.LtiRetailer;
import com.example.demo.layer3.LTIRetailerRepository;

@Service
public class LTIRetailerServiceImpl implements LTIRetailerService {
	// LTIRetailerRepository RetailerRepo
	
	@Autowired
	LTIRetailerRepository RetailerRepo;
	
	public LTIRetailerServiceImpl() {
		System.out.println("ServiceImpl()");
	}
	
	@Override
	public List<LtiRetailer> selectAllLtiRetailers() {
		// TODO Auto-generated method stub
		return RetailerRepo.selectAllLtiRetailers();
	}
	
	@Override
	public LtiRetailer selectLtiRetailerByRetailerId(long rid){
		// TODO Auto-generated method stub
		return RetailerRepo.selectLtiRetailerByRetailerId(rid);
	}
	
	@Override
	public void insertNewRetailer(LtiRetailer newRetailer) {
		RetailerRepo.insertLtiRetailer(newRetailer);
	}

	@Override
	public void deleteRetailer(long retailerId) {
		// TODO Auto-generated method stub
		RetailerRepo.deleteLtiRetailer(retailerId);
	}

	
	
	
	
	
	
}

