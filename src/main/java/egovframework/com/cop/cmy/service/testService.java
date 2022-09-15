package egovframework.com.cop.cmy.service;

import java.util.List;
import java.util.Map;

public interface testService {
	
	// 테스트 게시판 목록
	public Map<String, Object> getTestList(testVO vo) throws Exception;
	
	// 테스트 게시판 상세 정보
	public testVO getTestDetail(testVO vo) throws Exception;
	
	// 테스트 게시판 조회수 처리
	public void readCountup(testVO vo) throws Exception;
	
	// 테스트 게시판 등록 처리
	public void insertTest(testVO vo) throws Exception;
	
	// 테스트 게시판 수정 처리
	public void updateTest(testVO vo) throws Exception;
	
	// 테스트 게시판 삭제 처리
	public void deleteTest(testVO vo) throws Exception;
	
	public List<testVO> getTestListPortlet(testVO vo) throws Exception;
	
}
