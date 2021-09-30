package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.layer2.model.LtiUser;


@Repository
public interface LtiUserRepository { //DAO is known as Repository framework
	void insertUser(LtiUser dRef);
	LtiUser selectUserByUserId(long dno);
	List<LtiUser> selectAllUser();
	void updateUser(LtiUser dRef);
	void deleteUser(long dno);
}
