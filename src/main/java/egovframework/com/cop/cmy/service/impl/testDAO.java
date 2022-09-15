package egovframework.com.cop.cmy.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.cop.cmy.service.testVO;

@Repository("testDAO")
public class testDAO extends EgovComAbstractDAO{

	// 테스트 게시판 목록
	public List<?> getTestList(testVO vo) {
		return list("testMapper.getTestList", vo);
	}
	
	public int getTestListCnt(testVO vo) {
		return (Integer)selectOne("testMapper.getTestListCnt", vo);
	}
	
	// 테스트 게시판 상세
	public testVO getTestDetail(testVO vo) {
		return (testVO) selectOne("testMapper.getTestDetail", vo);
	}
	
	// 테스트 게시판 조회수 증가
	public void readCountup(testVO vo) {
		update("testMapper.readCountup", vo);
	}
	
	// 테스트 게시판 등록 처리
	public void insertTest(testVO vo) {
		insert("testMapper.insertTest", vo);
	}
	
	// 테스트 게시판 수정 처리
	public void updateTest(testVO vo) {
		update("testMapper.updateTest", vo);
	}
	
	// 테스트 게시판 삭제 처리
	public void deleteTest(testVO vo) {
		delete("testMapper.deleteTest", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<testVO> getTestListPortlet(testVO vo) throws Exception{
		return (List<testVO>) list("testMapper.getTestListPortlet", vo);
	}

}
