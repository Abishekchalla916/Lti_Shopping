package com.example.demo.layer3.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.layer2.model.LtiUser;
import com.example.demo.layer3.LtiUserRepository;
import com.example.demo.layer3.LtiUserRepositoryImpl;

@SpringBootTest
//@ContextConfiguration
public class LtiUserTesting {
	
	@Autowired
	LtiUserRepository userRepo;
	
	@Test
	void addNewUserTest() {
		LtiUser newUser = new LtiUser();
		//newUser.setUserId(106);
		newUser.setUserName("Meave");
		newUser.setEmail("meave@gmail.com");
		newUser.setMobile(9657458965L);
		newUser.setPassword("NAH3HA");
		newUser.setAddress("No. 8 Bazaar Lane , Mylapore");
		newUser.setCity("Chennai");
		newUser.setState("Tamil Nadu");
		newUser.setPostalcode(600004);
		userRepo.insertUser(newUser);
	}
	
	@Test
	void getUserTest() {
		LtiUser findUser= userRepo.selectUserByUserId(101l);
		System.out.println("User Id: "+findUser.getUserId());
		System.out.println("User Name: "+findUser.getUserName());
		System.out.println("User Email: "+findUser.getEmail());	
		System.out.println("User Mobile: "+findUser.getMobile());
		System.out.println("User Addres: "+findUser.getAddress());
		System.out.println("User City: "+findUser.getCity());
		System.out.println("User State: "+findUser.getState());
		System.out.println("User Postalcode: "+findUser.getPostalcode());
		
	}
	
	@Test
	void getAllUserTest() {
		List<LtiUser> userList = userRepo.selectAllUser();
		for(LtiUser d: userList)
		{
			System.out.println("User Id: "+ d.getUserId());
			System.out.println("User Name: "+d.getUserName());
			System.out.println("User Email: "+d.getEmail());	
			System.out.println("User Mobile: "+d.getMobile());
			System.out.println("User Addres: "+d.getAddress());
			System.out.println("User City: "+d.getCity());
			System.out.println("User State: "+d.getState());
			System.out.println("User Postalcode: "+d.getPostalcode());
			System.out.println("-------------------------------------------------");
		}
	}
	
	@Test
	void updateUserTest() {
		LtiUser updUser=new LtiUser();
		updUser.setUserId(103);
		updUser.setUserName("Adam");
		updUser.setEmail("adam@gmail.com");
		updUser.setMobile(9566442152L);
		updUser.setPassword("YAG34A");
		updUser.setAddress("36 Greams Rd");
		updUser.setCity("Chennai");
		updUser.setState("Tamil Nadu");
		updUser.setPostalcode(600006);
		
		userRepo.updateUser(updUser);
		
		System.out.println("Data Updated");	
	}

	@Test
	void deleteUserTest() {
		try {
			userRepo.deleteUser(26);
			System.out.println("Object deleted..");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
