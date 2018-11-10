package com.dao;


import java.util.List;
import com.entity.RoleInfo;


/**
 * 角色信息管理的数据访问类
 * 
 * @author zhangjinyou
 * 
 */
public interface RoleDAO {

	/**
	 * 添加角色信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean add(RoleInfo info) ;

	/**
	 * 查询角色信息
	 * 
	 * @param info
	 *            角色信息
	 * @return
	 */
	public List<RoleInfo> getList(String sql, Object[] params) ;
	
	/**
	 * 修改角色信息
	 * 
	 * @param info
	 * @return
	 */
	public boolean update(RoleInfo info) ;

}
