package com.hrmgmt;

public interface MgmtImplementation {

	//public String addDept(Mgmt mgmtt);

	public String addUser(Mgmt mgmtt);

	public String getAllUser(Integer pageNo, Integer pageSize, boolean isAdmin, Long id);

	public String addteam(Long id, String name, boolean isActive, boolean isAdmin);

	

	

}
