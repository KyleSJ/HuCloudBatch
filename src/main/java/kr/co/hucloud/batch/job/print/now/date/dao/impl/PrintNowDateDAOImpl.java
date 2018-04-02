package kr.co.hucloud.batch.job.print.now.date.dao.impl;

import kr.co.hucloud.batch.job.print.now.date.dao.PrintNowDateDAO;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class PrintNowDateDAOImpl extends SqlSessionDaoSupport implements PrintNowDateDAO {

	@Override
	public String getNowDate() {
		return "!!!";
	}
	
}
