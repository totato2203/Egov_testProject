package egovframework.com.cop.cmy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cop.cmy.service.testService;
import egovframework.com.cop.cmy.service.testVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("testService")
public class testServiceImpl extends EgovAbstractServiceImpl implements testService{

	@Resource(name="testDAO")
	public testDAO testDAO;
	
	// 테스트 게시판 목록
	@Override
	public Map<String, Object> getTestList(testVO vo) throws Exception {
		
		List<?> test = testDAO.getTestList(vo);
		int cnt = testDAO.getTestListCnt(vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("testList", test);
		map.put("testCnt", Integer.toString(cnt));
		
		return map;
	}

	// 테스트 게시판 상세
	@Override
	public testVO getTestDetail(testVO vo) throws Exception {
		testDAO.readCountup(vo);
		return testDAO.getTestDetail(vo);
	}

	// 테스트 게시판 조회수 증가
	@Override
	public void readCountup(testVO vo) throws Exception {
		testDAO.readCountup(vo);
	}

	// 테스트 게시판 등록 처리
	@Override
	public void insertTest(testVO vo) throws Exception {
		testDAO.insertTest(vo);
	}

	// 테스트 게시판 수정 처리
	@Override
	public void updateTest(testVO vo) throws Exception {
		testDAO.updateTest(vo);
	}

	// 테스트 게시판 삭제 처리
	@Override
	public void deleteTest(testVO vo) throws Exception {
		testDAO.deleteTest(vo);
	}
	
	@Override
	public List<testVO> getTestListPortlet(testVO vo) throws Exception{
		return testDAO.getTestListPortlet(vo);
	}
	
}
