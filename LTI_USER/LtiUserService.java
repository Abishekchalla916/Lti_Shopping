package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.model.LtiUser;

@Service
public interface LtiUserService {
	void insertNewUser(LtiUser dRef);
	LtiUser findUserByIdService(int userId);
	List<LtiUser> findAllUsersService();
}
