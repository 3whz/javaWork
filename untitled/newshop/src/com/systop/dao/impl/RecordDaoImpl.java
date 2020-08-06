package com.systop.dao.impl;

import com.sun.prism.impl.Disposer;
import com.systop.dao.AdminDao;
import com.systop.dao.C3p0Utils;
import com.systop.dao.RecordDao;
import com.systop.entity.Admin;
import com.systop.entity.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecordDaoImpl implements RecordDao {
	Connection con =null;
	PreparedStatement pstm=null;
	ResultSet rs=null;


	@Override
	public List<Record> liRecord(String u_name) {
		List<Record> list = new ArrayList<Record>();
		Record Record = null;
		String sql = "select * from record where u_name = ?";
		try {

			con=C3p0Utils.getDataSource().getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, u_name);
			rs = pstm.executeQuery();
			if (rs.next()) {
				Record = new Record();
				Record.setTime(rs.getString("time"));
				Record.setP_name(rs.getString("p_name"));
				Record.setU_name(rs.getString("u_name"));
				Record.setP_many(rs.getInt("p_many"));
				Record.setR_id(rs.getInt("r_id"));
				list.add(Record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int manay(String u_name) {
		int smany=0;
		String sql = "select p_many from record where u_name = ?";
		try {
			con=C3p0Utils.getDataSource().getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, u_name);
			rs = pstm.executeQuery();
			if (rs.next()) {
				smany=smany+rs.getInt("p_many");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smany;
	}
}
