<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="pageTitle">테스트 게시판</c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle}<spring:message code="title.list" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<script type="text/javascript">
// 초기화
function fn_egov_init(){
	// 첫 입력란에 포커스..
	document.testForm.searchType.focus();
}
// 페이징 처리 함수
function fn_egov_select_linkPage(pageNo){
	document.testForm.pageIndex.value = pageNo;
	document.testForm.action = "<c:url value='/cop/cmy/getTestList.do'/>";
   	document.testForm.submit();
}
// 조회 처리 함수
function fn_egov_search_test(){
	document.testForm.pageIndex.value = 1;
	document.testForm.submit();
}
// 상세회면 처리 함수
function fn_egov_inquire_testdetail(testNo) {
	// 사이트 키값(siteId) 셋팅.
	document.testForm.testNo.value = testNo;
  	document.testForm.action = "<c:url value='/cop/cmy/getTestDetail.do'/>";
  	document.testForm.submit();
}
</script>
</head>
<body onload="fn_egov_init()">
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>


<form name="testForm" action="<c:url value='/cop/cmy/getTestList.do'/>" method="post" onSubmit="fn_egov_search_test(); return false;">
<div class="board">
		<h1>${pageTitle} <spring:message code="title.list" /></h1>
		<div class="search_box" title="<spring:message code="common.searchCondition.msg"/>">
			<ul>
				<li>
					<select name="searchType" title="<spring:message code="title.searchCondition" /> <spring:message code="input.cSelect" />">
						<option value="testTitle" <c:out value="${searchVO.searchType == 'testTitle'?'selected':''}"/>>제목</option>
						<option value="testWriter" <c:out value="${searchVO.searchType == 'testWriter'?'selected':''}"/>>작성자</option>
						<option value="testContent" <c:out value="${searchVO.searchType == 'testContent'?'selected':''}"/>>내용</option>
						<option value="testTitleContent" <c:out value="${searchVO.searchType == 'testTitleContent'?'selected':''}"/>>제목+내용</option>
					</select>
				</li>
				<li>
					<input class="s_input" name="searchWrd" type="text"  size="35" title="<spring:message code="title.search" /> <spring:message code="input.input" />" value="<c:out value='${searchVO.searchWrd}'/>"  maxlength="155" >
					<input type="submit" class="s_btn" value="<spring:message code="button.inquire" />" title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" /><!-- 조회 -->
					<span class="btn_b"><a href="<c:url value='/cop/cmy/insertTestForm.do' />"  title="<spring:message code="button.create" /> <spring:message code="input.button" />"><spring:message code="button.create" /></a></span><!-- 등록 -->
				</li>
			</ul>
		</div>
	
	<!-- 목록영역 -->
	<table class="board_list" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
	<caption>${pageTitle}<spring:message code="title.list" /></caption>
	<colgroup>
		<col style="width: 9%;">
		<col style="width: 40%;">
		<col style="width: 13%;">
		<col style="width: 18%;">
		<col style="width: 13%;">
	</colgroup>
	<thead>
	<tr>
		<th>번호</th>
		<th class="board_th_link">제목</th>
		<th>등록자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	</thead>
	<tbody class="ov">
	<c:if test="${fn:length(testList) == 0}">
	<tr>
		<td colspan="5"><spring:message code="common.nodata.msg" /></td>
	</tr>
	</c:if>
	<c:forEach items="${testList}" var="test" varStatus="status">
	<tr>
		<td><c:out value="${(searchVO.pageIndex-1) * searchVO.pageSize + status.count}"/></td>
		<td class="left"><a href="<c:url value='/cop/cmy/getTestDetail.do'/>?testNo=${test.testNo}" onClick="fn_egov_inquire_testdetail('<c:out value="${test.testNo}"/>');return false;"><c:out value='${fn:substring(test.testTitle, 0, 40)}'/></a></td>
		<td><c:out value='${test.testWriter}'/></td>
		<td><c:out value='${test.testRdate}'/></td>
		<td><c:out value='${test.hits}'/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	<!-- paging navigation -->
	<div class="pagination">
		<ul>
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_linkPage"/>
		</ul>
	</div>
</div><!-- end div board -->

<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>">
</form>

</body>
</html>