package com.example.demo.layer3;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.layer2.model.LtiRetailer;


@Repository
public interface LTIRetailerRepository { 
	
	void insertLtiRetailer(LtiRetailer dRef);
	
	LtiRetailer selectLtiRetailerByRetailerId(long dno);
	
	List<LtiRetailer> selectAllLtiRetailers();
	
	void updateLtiRetailer(LtiRetailer dRef);
	
	void deleteLtiRetailer(long dno);
}

