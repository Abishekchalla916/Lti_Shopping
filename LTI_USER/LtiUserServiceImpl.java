package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.model.LtiUser;
import com.example.demo.layer3.LtiUserRepository;

@Service
public class LtiUserServiceImpl implements LtiUserService {
	
	@Autowired
	LtiUserRepository userRepo;
	
	public LtiUserServiceImpl() {
		System.out.println("LtiUserServiceImpl() is running....");
	}
	
	public LtiUser findUserByIdService(int userId) {
		System.out.println("findUserByIdService() code is running...");
		return userRepo.selectUserByUserId(userId);
	}

	public List<LtiUser> findAllUsersService() {
		System.out.println("findAllUsersService() code is running...");
		return userRepo.selectAllUser();
	}

	public void insertNewUser(LtiUser dRef) {
		System.out.println("insertNewUser() code is running...");
		
		
	}

}
