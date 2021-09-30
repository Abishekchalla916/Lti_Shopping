package com.example.demo.layer4;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.model.LtiRetailer;

@Service
public interface LTIRetailerService {
	
	public List<LtiRetailer> selectAllLtiRetailers();
	
	public LtiRetailer selectLtiRetailerByRetailerId(long rid);
}
