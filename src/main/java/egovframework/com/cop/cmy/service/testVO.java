package egovframework.com.cop.cmy.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class testVO implements Serializable{
	
	// 테스트 게시판 번호
	private int testNo;
	
	// 테스트 게시판 제목
	private String testTitle;
	
	// 테스트 게시판 작성자
	private String testWriter;
	
	// 테스트 게시판 작성일
	private String testRdate;
	
	// 테스트 게시판 수정일
	private String testUdate;
	
	// 테스트 게시판 조회수
	private int hits;
	
	// 테스트 게시판 내용
	private String testContent;
	
	
	// 테스트 게시판 검색어
	private String searchWrd;
	
	// 테스트 게시판 검색 종류
	private String searchType;
	
	// 테스트 게시판 검색 종류 - 제목+내용
	private String testTitleContent;
	
	
	/** 정렬순서(DESC,ASC) */
    private long sortOrdr = 0L;

    /** 검색사용여부 */
    private String searchUseYn = "";

    /** 현재페이지 */
    private int pageIndex = 1;

    /** 페이지갯수 */
    private int pageUnit = 10;

    /** 페이지사이즈 */
    private int pageSize = 10;

    /** 첫페이지 인덱스 */
    private int firstIndex = 1;

    /** 마지막페이지 인덱스 */
    private int lastIndex = 1;

    /** 페이지당 레코드 개수 */
    private int recordCountPerPage = 10;

    /** 레코드 번호 */
    private int rowNo = 0;

    /** 등록구분 코드명 */
    private String registSeCodeNm = "";

    /** 최초 등록자명 */
    private String frstRegisterNm = "";

    /** 게시판 아이드 */
    private String bbsId = "";

    /** 게시판 이름 */
    private String bbsNm = "";
    
    /** 제공 URL */
    private String provdUrl = "";

	
	public testVO() {}

	public testVO(int testNo, String testTitle, String testWriter, String testRdate, String testUdate, int hits,
			String testContent, int pageIndex) {
		super();
		this.testNo = testNo;
		this.testTitle = testTitle;
		this.testWriter = testWriter;
		this.testRdate = testRdate;
		this.testUdate = testUdate;
		this.hits = hits;
		this.testContent = testContent;
		this.pageIndex = pageIndex;
	}

	public testVO(int testNo, String testTitle, String testWriter, String testRdate, String testUdate, int hits,
			String testContent, String searchWrd, String searchType, String testTitleContent, long sortOrdr,
			String searchUseYn, int pageIndex, int pageUnit, int pageSize, int firstIndex, int lastIndex,
			int recordCountPerPage, int rowNo, String registSeCodeNm, String frstRegisterNm, String bbsId, String bbsNm,
			String provdUrl) {
		super();
		this.testNo = testNo;
		this.testTitle = testTitle;
		this.testWriter = testWriter;
		this.testRdate = testRdate;
		this.testUdate = testUdate;
		this.hits = hits;
		this.testContent = testContent;
		this.searchWrd = searchWrd;
		this.searchType = searchType;
		this.testTitleContent = testTitleContent;
		this.sortOrdr = sortOrdr;
		this.searchUseYn = searchUseYn;
		this.pageIndex = pageIndex;
		this.pageUnit = pageUnit;
		this.pageSize = pageSize;
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
		this.recordCountPerPage = recordCountPerPage;
		this.rowNo = rowNo;
		this.registSeCodeNm = registSeCodeNm;
		this.frstRegisterNm = frstRegisterNm;
		this.bbsId = bbsId;
		this.bbsNm = bbsNm;
		this.provdUrl = provdUrl;
	}

	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getTestWriter() {
		return testWriter;
	}

	public void setTestWriter(String testWriter) {
		this.testWriter = testWriter;
	}

	public String getTestRdate() {
		return testRdate;
	}

	public void setTestRdate(String testRdate) {
		this.testRdate = testRdate;
	}
	public String getTestUdate() {
		return testUdate;
	}

	public void setTestUdate(String testUdate) {
		this.testUdate = testUdate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getTestContent() {
		return testContent;
	}

	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}

	public String getSearchWrd() {
		return searchWrd;
	}

	public void setSearchWrd(String searchWrd) {
		this.searchWrd = searchWrd;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getTestTitleContent() {
		return testTitleContent;
	}

	public void setTestTitleContent(String testTitleContent) {
		this.testTitleContent = testTitleContent;
	}

	public long getSortOrdr() {
		return sortOrdr;
	}

	public void setSortOrdr(long sortOrdr) {
		this.sortOrdr = sortOrdr;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getRegistSeCodeNm() {
		return registSeCodeNm;
	}

	public void setRegistSeCodeNm(String registSeCodeNm) {
		this.registSeCodeNm = registSeCodeNm;
	}

	public String getFrstRegisterNm() {
		return frstRegisterNm;
	}

	public void setFrstRegisterNm(String frstRegisterNm) {
		this.frstRegisterNm = frstRegisterNm;
	}

	public String getBbsId() {
		return bbsId;
	}

	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}

	public String getBbsNm() {
		return bbsNm;
	}

	public void setBbsNm(String bbsNm) {
		this.bbsNm = bbsNm;
	}

	public String getProvdUrl() {
		return provdUrl;
	}

	public void setProvdUrl(String provdUrl) {
		this.provdUrl = provdUrl;
	}

	
}
