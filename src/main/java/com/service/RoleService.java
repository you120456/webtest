package com.service;


import java.util.List;
import com.entity.RoleInfo;


/**
 * 角色管理的业务逻辑接口
 * 
 * @author zhangjinyou
 * 
 */
public interface RoleService {

	
	/**
	 * 添加角色信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean add(RoleInfo info) ;

	/**
	 * 修改角色信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean update(RoleInfo info);

	/**
	 * 删除角色信息 假删除
	 * 
	 * @param info
	 * @return
	 */
	public boolean delete(RoleInfo info) ;
	/**
	 * 查询角色信息
	 * 
	 * @param info
	 *            查询条件
	 * @return
	 */
	public List<RoleInfo> getList(RoleInfo info) ;

	public RoleInfo getRole(Integer roleId) ;

}
