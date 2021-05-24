package com.hrmgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;







@Service
public class MgmtService implements MgmtImplementation {
	
	@Autowired
	MgmtRepository mgmtrepo;
	
	
	
	@Override
	public String addUser(Mgmt mgmtt) {

		try {

			if (mgmtt.getId() != null) {

				Mgmt mgmtData = mgmtrepo.getOne(mgmtt.getId());
				if (mgmtData != null) {

					
					
					System.out.println(mgmtData);
					mgmtrepo.save(mgmtData);
					return JSONUtils.getSuccessJson();

				}   
			       else {
					return JSONUtils.getFailDueToNullJson("Invalid id");
			}
			}
				else
		    {
				
			mgmtrepo.save(mgmtt);
				return JSONUtils.getSuccessJson();
			}
		} catch (Exception e) {
			return JSONUtils.getFailDueToNullJson(e.getMessage());
		}
	
		
	}
	
	@Override
	public String getAllUser(Integer pageNo, Integer pageSize, boolean isAdmin, Long id) {
		try {

			if (id != null) {
				Mgmt mgmtData = mgmtrepo.getOne(id);

				System.out.println(mgmtData);
				if (mgmtData != null) {
					
					Mgmt depData = mgmtrepo.save(mgmtData);
					return JSONUtils.getSuccessJson(depData);
				} else {
					return JSONUtils.getFailDueToNullJson("Invalid id");
				}
			} else {
				if (isAdmin) {

					Page<Mgmt> mgmtt = mgmtrepo
							.findAll(new PageRequest(pageNo,pageSize,Direction.DESC));
					return JSONUtils.getSuccessJsonForPagenation (mgmtt.getContent(),
							mgmtt.getTotalPages(), mgmtt.getTotalElements());
				} else {
					Page<Mgmt> mgmtt = mgmtrepo
							.findByIsActive(new PageRequest(pageNo, pageSize, Direction.DESC, "creationTime"), true);
					return JSONUtils.getSuccessJsonForPagenation(mgmtt.getContent(),
							mgmtt.getTotalPages(), mgmtt.getTotalElements());
				}
			}
		} catch (Exception e) {
			return JSONUtils.getFailDueToNullJson(e.getMessage());
		}

	}
	

@Override

	public String addteam(Long id, String name, boolean isActive, boolean isAdmin) {
		try {
			Mgmt mgmttt = new Mgmt();
			
			if(isAdmin== true) {
				
				mgmttt.setId(id);
				mgmttt.setName(name);
				mgmttt.setActive(isActive);
				
				
					mgmtrepo.save(mgmttt);
					return JSONUtils.getSuccessJson();
				
			}
			
			else {
				 return JSONUtils.getFailDueToNullJson("Can not add because Employee is not an admin");
			}
			
		}
			catch(Exception e){
				return JSONUtils.getFailDueToNullJson(e.getMessage());		
				}
				
			
		
	}
}


	