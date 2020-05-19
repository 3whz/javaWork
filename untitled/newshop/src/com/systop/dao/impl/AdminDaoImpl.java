package com.systop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.systop.dao.AdminDao;
import com.systop.dao.C3p0Utils;
import com.systop.entity.Admin;

public class AdminDaoImpl implements AdminDao {
	Connection con =null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	/**
	 *  ��¼����
	 *  ���ؿձ�ʾ��¼ʧ��
	 */
	@Override
	public Admin loginAdmin(String account, String adminpass) {
		Admin admin = null;
		String sql = "select * from admin where account = ? and adminpass = ?";
		try {

			//��ȡ�������ݿ��ַ
			con=C3p0Utils.getDataSource().getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�滻����
			pstm.setString(1, account);
			pstm.setString(2, adminpass);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			if (rs.next()) {
				admin = new Admin();
				admin.setaId(rs.getInt("a_id"));
				admin.setAccount(rs.getString("account"));
				admin.setAdminpass(rs.getString("adminpass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return admin;
	}

	/**
	 * ��ѯ���й���Ա�б�
	 * @return ����Ա����
	 */
	@Override
	public List<Admin> findAdminAll() {
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select * from admin";
		try {
			//��ȡ�������ݿ��ַ
			con=C3p0Utils.getDataSource().getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setaId(rs.getInt("a_id"));
				admin.setAccount(rs.getString("account"));
				admin.setAdminpass(rs.getString("adminpass"));
				list.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	/**
	 *   ����Ա����
	 * @param admin
	 * @return
	 */
	@Override
	public int saveAdmin(Admin admin) {
		int row = 0;
		String sql = "insert into admin (account, adminpass) values (?,?)";
		try {
			//��ȡ�������ݿ��ַ
			con=C3p0Utils.getDataSource().getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setString(1, admin.getAccount());
			pstm.setString(2, admin.getAdminpass());
			//ִ��sql���
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return row;
	}

	/**
	 *  ����Ա����
	 * @param admin
	 * @return
	 */
	@Override
	public int updateAdmin(Admin admin) {
		int row = 0;
		String sql = "update admin set account = ?,adminpass = ? where a_id = ?";
		try {
			//��ȡ�������ݿ��ַ
			con=C3p0Utils.getDataSource().getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setString(1, admin.getAccount());
			pstm.setString(2, admin.getAdminpass());
			pstm.setInt(3, admin.getaId());
			//ִ��sql���
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	/**
	 *  ����Idɾ������Ա
	 * @param id
	 * @return
	 */
	@Override
	public int deleteAdmin(int id) {
		int row = 0;
		String sql = "delete from admin where a_id = ?";
		try {
			//��ȡ�������ݿ��ַ
			con=C3p0Utils.getDataSource().getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setInt(1, id);
			//ִ��sql���
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return row;
	}

	/**
	 *  ����id��ѯ����Ա
	 * @param id
	 * @return
	 */
	@Override
	public Admin findAdminById(int id) {
		Admin admin = null;
		String sql = "select * from admin where a_id = ?";
		try {
			//��ȡ�������ݿ��ַ
			con=C3p0Utils.getDataSource().getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�滻����
			pstm.setInt(1, id);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			if (rs.next()) {
				admin = new Admin();
				admin.setaId(rs.getInt("a_id"));
				admin.setAccount(rs.getString("account"));
				admin.setAdminpass(rs.getString("adminpass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return admin;
	}

}
