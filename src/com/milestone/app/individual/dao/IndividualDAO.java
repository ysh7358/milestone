package com.milestone.app.individual.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.milestone.app.individual.vo.IndividualDTO;
import com.milestone.app.individual.vo.IndividualVO;
import com.milestone.mybatis.config.MyBatisConfig;

public class IndividualDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	SqlSession sqlSession;

	public IndividualDAO() { // sqlSessionFactoory를 생성해줘야한다.
		sqlSession = sqlSessionFactory.openSession(true);
	}

	public int checkId(String individualMemberId) {
		return sqlSession.selectOne("IndividualMember.checkId", individualMemberId);
	}

	public int checkNickName(String nickName) {
		return sqlSession.selectOne("IndividualMember.checkNickName", nickName);
	}

	public int checkPhoneNumber(String individualMemberPhoneNumber) {
		return sqlSession.selectOne("IndividualMember.checkPhoneNumber", individualMemberPhoneNumber);
	}

	public void join(IndividualVO individualVO) {
		sqlSession.insert("IndividualMember.join", individualVO);
	}

	public int login(IndividualVO individualVO) {
		return sqlSession.selectOne("IndividualMember.login", individualVO);
	}

	public String findId(IndividualVO individualVO) {
		return sqlSession.selectOne("IndividualMember.findId", individualVO);
	}

	public int findPw(IndividualVO individualVO) {
		return sqlSession.selectOne("IndividualMember.findPw", individualVO);
	}

	public void updatePw(IndividualVO individualVO) {
		sqlSession.update("IndividualMember.updatePw", individualVO);
	}

	// 전체랭킹
	public List<IndividualDTO> selectRanking() {
		return sqlSession.selectList("IndividualMember.selectRanking");
	}

	// My랭킹
	public IndividualDTO selectByIndividualMemberNumber(int individualMemberNumber) {
		return sqlSession.selectOne("IndividualMember.selectByIndividualMemberNumber", individualMemberNumber);
	}
	
	public IndividualVO userOneInfo(int individualMemberNumber) {
		return sqlSession.selectOne("IndividualMember.userOneInfo",individualMemberNumber);
	}

}
