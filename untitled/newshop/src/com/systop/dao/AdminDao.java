package com.systop.dao;

import java.util.List;

import com.systop.entity.Admin;

public interface AdminDao {
	/**
	 *   ��¼����
	 * @param account
	 * @param adminpass
	 * @return
	 */
	public Admin loginAdmin(String account, String adminpass);

	/**
	 * ��ѯ���й���Ա�б�
	 * @return ����Ա����
	 */
	public List<Admin> findAdminAll();
	
	/**
	 *   ����Ա����
	 * @param admin
	 * @return
	 */
	public int saveAdmin(Admin admin);
	
	/**
	 *  ����id��ѯ����Ա
	 * @param id
	 * @return
	 */
	public Admin findAdminById(int id);
	
	/**
	 *  ����Ա����
	 * @param admin
	 * @return
	 */
	public int updateAdmin(Admin admin);
	
	/**
	 *  ����Idɾ������Ա
	 * @param id
	 * @return
	 */
	public int deleteAdmin(int id);
}
