package egovframework.com.cop.cmy.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cop.cmy.service.testService;
import egovframework.com.cop.cmy.service.testVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class testController {
	
	@Resource(name = "testService")
	private testService testService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	// 테스트 게시판 목록
	@RequestMapping("/cop/cmy/getTestList.do")
	public String getTestList(@ModelAttribute("searchVO") testVO vo, ModelMap model) throws Exception{
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));
		
		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());
		
		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		Map<String, Object> map = testService.getTestList(vo);
		int totCnt = Integer.parseInt((String)map.get("testCnt"));
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("testList", map.get("testList"));
		model.addAttribute("testCnt", map.get("testCnt"));
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "egovframework/com/cop/cmy/testList";
	}
	
	// 테스트 게시판 상세 페이지
	@RequestMapping("/cop/cmy/getTestDetail.do")
	public String getTestDetail(@ModelAttribute("searchVO") testVO vo, ModelMap model, HttpServletRequest request) throws Exception{
		model.addAttribute("testDetail", testService.getTestDetail(vo));
		return "egovframework/com/cop/cmy/testDetail";
	}
	
	// 테스트 게시판 등록 페이지
	@RequestMapping("/cop/cmy/insertTestForm.do")
	public String insertTestForm(@ModelAttribute("searchVO") testVO vo, ModelMap model) throws Exception{
		model.addAttribute("testRegist", new testVO());
		return "egovframework/com/cop/cmy/testRegist";
	}
	
	// 테스트 게시판 등록 처리
	@RequestMapping("/cop/cmy/insertTest.do")
	public String insertTest(@ModelAttribute("searchVO") testVO vo, ModelMap model) throws Exception{
		testService.insertTest(vo);
		return "redirect:/cop/cmy/getTestList.do";
	}
	
	// 테스트 게시판 수정  페이지
	@RequestMapping("/cop/cmy/updateTestForm.do")
	public String updateTestForm(@ModelAttribute("searchVO") testVO vo, ModelMap model) throws Exception{
		model.addAttribute("testUpdate", testService.getTestDetail(vo));
		return "egovframework/com/cop/cmy/testUpdt";
	}
	
	// 테스트 게시판 수정 처리
	@RequestMapping("/cop/cmy/updateTest.do")
	public String updateTest(@ModelAttribute("searchVO") testVO vo, ModelMap model) throws Exception{
		testService.updateTest(vo);
		return "redirect:/cop/cmy/getTestDetail.do?testNo=" + vo.getTestNo();
	}
	
	// 테스트 게시판 삭제 처리
	@RequestMapping("/cop/cmy/deleteTest.do")
	public String deleteTest(@ModelAttribute("searchVO") testVO vo, ModelMap model) throws Exception{
		testService.deleteTest(vo);
		return "redirect:/cop/cmy/getTestList.do";
	}
	
	@RequestMapping("/cop/cmy/getTestListPortlet.do")
	public String getTestListPortlet(@ModelAttribute("searchVO") testVO vo, ModelMap model) throws Exception{
		List<testVO> test = testService.getTestListPortlet(vo);
		
		model.addAttribute("testList", test);
		return "egovframework/com/cop/cmy/testListPortlet";
	}


}
