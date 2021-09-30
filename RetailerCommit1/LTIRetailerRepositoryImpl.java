package com.example.demo.layer3;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.model.LtiRetailer;


@Repository
public class LTIRetailerRepositoryImpl extends BaseRepository implements LTIRetailerRepository {
	
	public LTIRetailerRepositoryImpl() {
		System.out.println("LTIRetailerRepositoryImpl().....");
	}
	
	@Transactional
	public void insertLtiRetailer(LtiRetailer dRef) {
		super.persist(dRef);
	}
	
	/*
	@Transactional
	public LtiRetailer selectLtiRetailerByRetailerNo(long dno) {
		return super.find(LtiRetailer.class, dno);
	}
	*/
	
	@Transactional
	public List<LtiRetailer> selectAllLtiRetailers() {
		return super.findAll("LtiRetailer");
	}
	
	
	@Transactional
	public void updateLtiRetailer(LtiRetailer dRef) {
		super.merge(dRef);
	}
	

	@Transactional
	public void deleteLtiRetailer(long dno) {
		super.remove(LtiRetailer.class,dno);
	}

	@Override
	public LtiRetailer selectLtiRetailerByRetailerId(long dno) {
		// TODO Auto-generated method stub
		return super.find(LtiRetailer.class, dno);
	}

}
