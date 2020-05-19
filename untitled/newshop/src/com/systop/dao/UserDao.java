package com.systop.dao;

import java.util.List;

import com.systop.entity.User;

public interface UserDao {
	
	
	/**
	 * 
	 * @return 
	 */
	public List<User> finduserAll();
	
	/**
	 *  
	 * @param admin
	 * @return
	 */
	public int saveUser(User User);
	/**
	 * ͨ��id����
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
	/**
	 * ͨ��id �ͻ�ȡ��״ֵ̬�޸�
	 * @param aid,String u_status
	 * @return
	 */
	public int updownUserById(int u_id, int u_status);
}
