package com.example.demo.layer5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.layer3.LtiUserRepository;
import com.example.demo.layer4.LtiUserService;
import com.example.demo.layer2.model.LtiUser;


@CrossOrigin(origins = "*", value = "*")
@RestController
public class LtiUserJPAController {

	@Autowired
	LtiUserService userService; //here it should be service calls
	
	public LtiUserJPAController() {
		System.out.println("LtiUserJPAController()....");
		
	}
	
	@RequestMapping(path="/getJPAUsers") //localhost:8086/getJPAUsers
	public List<LtiUser> getAllUsers() {
		System.out.println("getAllUsers");
		return userService.findAllUsersService();
	}
	

	@GetMapping
	@RequestMapping(path="/getJPAUser/{uno}") // localhost:8086/getJPAUser/101
	public LtiUser getUser(@PathVariable("uno") int userIdToFind) throws UserNotFoundExcepiton 
	{
		System.out.println("getUser : "+userIdToFind);
		LtiUser foundUser = null;
		foundUser = userService.findUserByIdService(userIdToFind);

	
		if(foundUser == null) {
			UserNotFoundExcepiton userIdException = new UserNotFoundExcepiton("UserId Not Found "+ userIdToFind);
			System.out.println("UserId Not Found");
			throw userIdException;
		}
		return foundUser;
	}
	
	@PostMapping
	@RequestMapping(path="/addJPAAddUser") // 
	public void addNewUser(@RequestBody LtiUser userToInsert) throws UserNotFoundExcepiton 
	{
		LtiUser newUser = new LtiUser();
		newUser.setUserName(userToInsert.getUserName());
		newUser.setEmail(userToInsert.getEmail());
		newUser.setPassword(userToInsert.getPassword());
		newUser.setMobile(userToInsert.getMobile());
		newUser.setAddress(userToInsert.getAddress());
		newUser.setCity(userToInsert.getCity());
		newUser.setState(userToInsert.getState());
		newUser.setPostalcode(userToInsert.getPostalcode());
		
		System.out.println("addNewUser :  "+newUser.getUserName()+" "+newUser.getEmail()+" "+
				newUser.getPassword()+" "+newUser.getMobile()+" "+newUser.getAddress()+" "+
				newUser.getCity()+" "+newUser.getState()+" "+newUser.getPostalcode()); 
		userService.insertNewUser(newUser);
	}
		
		/*
		//http://localhost:8080/modifyJPADept
		@PostMapping
		@RequestMapping(path="/modifyJPAUser") // 
		public void modifyUser(@RequestBody LtiUser userToModify) throws UserNotFoundExcepiton 
		{
			System.out.println("modifyUser : "+userToModify.getDeptno()+" "+userToModify.getDname()+" "+userToModify.getLoc()); 
			boolean found=false;
			userRepo.updateUser(userToModify);
			found=true;
			
			if(found) {
				System.out.println("Record modified...");
				
			} else {
				System.out.println("Not found");
				UserNotFoundExcepiton UserNotFoundEx = new DeptNotFoundExcepiton("Department Number Not Found "+deptToModify.getDeptno());
				throw UserNotFoundEx;
			}
			
		}
		
		@PostMapping
		@RequestMapping(path="/deleteJPADept") // localhost:8080/deleteDept/10
		public void deleteDepartment(@RequestBody Dept dept) throws DeptNotFoundExcepiton 
		{
			System.out.println("deleteDepartment : "+dept.getDeptno()); 
			boolean found=false;
			
			deptRepo.deleteDept(dept.getDeptno());
			found=true;
				
			
			if(found) {
				System.out.println("Dept Deleted");
			}
			else {
				System.out.println("Not found");
				DeptNotFoundExcepiton deptNotFoundEx = new DeptNotFoundExcepiton("Department Number Not Found "+dept.getDeptno());
				throw deptNotFoundEx;
			}
			
		}

	/*
	@RequestMapping(path="/getJPADept/{dno}") // localhost:8085/getJPADept/10
	public Dept getDepartment(@PathVariable("dno") int deptNumberToFind) throws DeptNotFoundExcepiton 
	{
		System.out.println("getDepartment : "+deptNumberToFind);
		Dept foundDept = null;
		foundDept = deptRepo.selectDeptByDeptNo(deptNumberToFind);

		if(foundDept == null) {
			DeptNotFoundExcepiton d = new DeptNotFoundExcepiton("Department Number Not Found "+deptNumberToFind);
		}

		return foundDept;
	}
/*	
	
	//http://localhost:8080/addDept/40/OPERATIONS/CHENNAI
	@RequestMapping(path="/addDept/{dno}/{dnm}/{dlc}") 
	public void addDepartment(@PathVariable("dno") int deptNo, @PathVariable("dnm") String dname, @PathVariable("dlc") String location) throws DeptNotFoundExcepiton 
	{
		System.out.println("addDepartment : "+deptNo+ " "+dname+" "+location);
		Dept newDept = new Dept(deptNo,dname,location);
		deptList.add(newDept);
		
	}
	
	
		@RequestMapping(path="/addDept2") // 
		public void addDepartment2(@RequestBody Dept deptToInsert) throws DeptNotFoundExcepiton 
		{
			System.out.println("addDepartment2 : "+deptToInsert.getDeptno()+" "+deptToInsert.getDname()+" "+deptToInsert.getLocation()); 
			
			deptList.add(deptToInsert);
			
		}
		
		@RequestMapping(path="/modifyDept") // 
		public void modifyDepartment(@RequestBody Dept deptToModify) throws DeptNotFoundExcepiton 
		{
			System.out.println("modifyDepartment : "+deptToModify.getDeptno()+" "+deptToModify.getDname()+" "+deptToModify.getLocation()); 
			boolean found=false;
			for(int i=0;i<deptList.size();i++) {
				
				Dept dept = deptList.get(i);
				
				if(dept.getDeptno() == deptToModify.getDeptno()) {
					deptList.set(i, deptToModify);
					
					System.out.println("Modified");
					
					found=true;
					break;
				}
			}
			
			if(found==false) {
				System.out.println("Not found");
				DeptNotFoundExcepiton deptNotFoundEx = new DeptNotFoundExcepiton("Department Number Not Found "+deptToModify.getDeptno());
				throw deptNotFoundEx;
			}
			
		}
		
		@RequestMapping(path="/deleteDept/{dno}") // localhost:8080/deleteDept/10
		public void deleteDepartment(@PathVariable("dno") int deptNoToDelete) throws DeptNotFoundExcepiton 
		{
			System.out.println("deleteDepartment : "+deptNoToDelete); 
			boolean found=false;
			
			for(int i=0;i<deptList.size();i++) {
				
				Dept dept = deptList.get(i);
				
				if(dept.getDeptno() == deptNoToDelete) {
					deptList.remove(i);
					
					System.out.println("Deleted");
					
					found=true;
					break;
				}
			}
			
			if(found==false) {
				System.out.println("Not found");
				DeptNotFoundExcepiton deptNotFoundEx = new DeptNotFoundExcepiton("Department Number Not Found "+deptNoToDelete);
				throw deptNotFoundEx;
			}
			
		}
	*/
	
		
}
