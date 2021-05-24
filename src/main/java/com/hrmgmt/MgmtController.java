package com.hrmgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class MgmtController {
	

	@Autowired
	MgmtService mgmtService;
	
	@PostMapping(value ="/api/v1/add/update/department")
	public ResponseEntity<String> addUser(@ModelAttribute Mgmt mgmtt) throws Exception {
		return new ResponseEntity<String>(mgmtService.addUser(mgmtt), HttpStatus.CREATED);
	}
	@GetMapping(value ="/api/v1/all/department/or/by/id")
	public ResponseEntity<String> getAllDept(@RequestParam(required=true) Integer pageNo,@RequestParam(required=true) Integer pageSize,@RequestParam boolean isAdmin,@RequestParam(required=false) Long id) throws Exception {
		return new ResponseEntity<String>(mgmtService.getAllUser(pageNo, pageSize,isAdmin,id), HttpStatus.OK);
	}
	
	@PostMapping(value ="/api/v1/add/team/")
	public ResponseEntity<String> addteam(@RequestParam Long id,@RequestParam String name,@RequestParam boolean isActive,@RequestParam boolean isAdmin) throws Exception {
		return new ResponseEntity<String>(mgmtService.addteam(id,name,isActive,isAdmin), HttpStatus.OK);

}
}