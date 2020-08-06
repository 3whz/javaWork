package com.systop.dao;

import com.systop.entity.Record;

import java.util.List;

public interface RecordDao {
	public List<Record> liRecord(String u_name);

	public int manay(String u_name);
}
