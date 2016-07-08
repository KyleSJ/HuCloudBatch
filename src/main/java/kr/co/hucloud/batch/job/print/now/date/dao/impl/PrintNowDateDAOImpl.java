package kr.co.hucloud.batch.job.print.now.date.dao.impl;

import kr.co.hucloud.batch.job.print.now.date.dao.PrintNowDateDAO;
import kr.co.hucloud.batch.tool.UserSqlSessionDaoSupport;

import org.springframework.stereotype.Repository;

@Repository("printNowDateDAOImpl")
public class PrintNowDateDAOImpl extends UserSqlSessionDaoSupport implements PrintNowDateDAO {

	@Override
	public String getNowDate() {
		//return getSqlSession().selectOne("printNowDateDAO.getSystemDate");
		return "!!!";
	}
	
}
