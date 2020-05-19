package com.systop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.systop.dao.UserDao;

import com.systop.dao.C3p0Utils;
import com.systop.entity.Admin;
import com.systop.entity.User;

public class UserDaoImpl implements UserDao {
	
	Connection con =null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	@Override
	public List<User> finduserAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		try {
			//��ȡ�������ݿ��ַ
			con=C3p0Utils.getDataSource().getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			while (rs.next()) {
				User User = new User();
				User.setU_id(rs.getInt("u_id"));
				User.setU_name(rs.getString("u_name"));
				User.setU_phone(rs.getString("u_phone"));
				User.setBirthday(rs.getString("birthday"));
				User.setU_sex(rs.getString("u_sex"));
				User.setU_mail(rs.getString("u_mail"));
				User.setU_address(rs.getString("u_address"));
				User.setU_heart(rs.getDouble("u_heart"));
				User.setType(rs.getInt("type"));//0:��ͨ�û���1����Ա
				User.setU_status(rs.getInt("u_status"));//�û�״̬��0�����ã�1������
				list.add(User);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	@Override
	public int saveUser(User User) {
		// TODO �Զ����ɵķ������
		return 0;
	}
	@Override
	public User findUserById(int id) {
		// TODO �Զ����ɵķ������
		User user = null;
		String sql = "update admin set account = ?,adminpass = ? where a_id = ?";
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
				user = new User();
				user.setU_id(rs.getInt("u_id"));
				user.setU_name(rs.getString("u_name"));
				user.setU_phone(rs.getString("u_phone"));
				user.setBirthday(rs.getString("birthday"));
				user.setU_sex(rs.getString("u_sex"));
				user.setU_mail(rs.getString("u_mail"));
				user.setU_address(rs.getString("u_address"));
				user.setType(rs.getInt("type"));//0:��ͨ�û���1����Ա
				user.setU_status(rs.getInt("u_status"));//�û�״̬��0�����ã�1������
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return user;
	}
	@Override
	public int updownUserById(int u_id ,int u_status) {
		int row = 0;
		String sql = "update user set u_status = ? where u_id = ?";
		try {
			//��ȡ�������ݿ��ַ
			con=C3p0Utils.getDataSource().getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setInt(1, u_status);
			pstm.setInt(2, u_id);
			//ִ��sql���
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
					

}
