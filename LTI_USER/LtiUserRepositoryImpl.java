package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.example.demo.layer2.model.LtiUser;


@Repository
public class LtiUserRepositoryImpl extends BaseRepository implements LtiUserRepository {

	public LtiUserRepositoryImpl() {
		System.out.println("LtiUserRepositoryImpl().....");
	}
	
	@Transactional
	public void insertUser(LtiUser dRef) {
		super.persist(dRef);
	}

	@Transactional
	public LtiUser selectUserByUserId(long dno) {
		return super.find(LtiUser.class, dno);
	}

	@Transactional
	public List<LtiUser> selectAllUser() {
		return super.findAll("LtiUser");
	}

	@Transactional
	public void updateUser(LtiUser dRef) {
		super.merge(dRef);
	}

	@Transactional
	public void deleteUser(long dno) {
		super.remove(LtiUser.class,dno);
	}

	
}
