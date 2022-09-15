<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%pageContext.setAttribute("crlf", "\r\n"); %>
<c:set var="pageTitle">테스트 게시판</c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle} <spring:message code="title.detail" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<script type="text/javascript">
/* ********************************************************
 * 삭제처리
 ******************************************************** */
 function fn_egov_delete_test(testNo){
	if(confirm("<spring:message code="common.delete.msg" />")){	
		// Delete하기 위한 키값을 셋팅
		document.testForm.testNo.value = testNo;	
		document.testForm.action = "<c:url value='/cop/cmy/deleteTest.do'/>";
		document.testForm.submit();	
	}	
}	
</script>
</head>
<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<form name="testForm" action="<c:url value='/cop/cmy/updateTestForm.do'/>" method="post">
<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>${pageTitle} <spring:message code="title.detail" /></h2>

	<!-- 상세조회 -->
	<table class="wTable" summary="<spring:message code="common.summary.inqire" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.detail" /></caption>
	<colgroup>
		<col style="width: ;">
		<col style="width: ;">
		<col style="width: ;">
		<col style="width: ;">
		<col style="width: ;">
		<col style="width: ;">
	</colgroup>
	<tbody>
		<tr>
			<th><spring:message code="comCopCmy.testDetail.detail.testTitle" /></th>
			<td colspan="3" class="left"><c:out value="${testDetail.testTitle}"/></td>
			<th><spring:message code="comCopCmy.testDetail.detail.testWriter" /></th>
			<td colspan="2" class="left"><c:out value="${testDetail.testWriter}"/></td>
		</tr>
		<tr>
			<th><spring:message code="comCopCmy.testDetail.detail.testRdate" /></th>
			<td class="left"><c:out value="${testDetail.testRdate}"/></td>
			<th><spring:message code="comCopCmy.testDetail.detail.testUdate" /></th>
			<td class="left"><c:out value="${testDetail.testUdate}"/></td>
			<th><spring:message code="comCopCmy.testDetail.detail.hits" /></th>
			<td class="left"><c:out value="${testDetail.hits}"/></td>
		</tr>
		<tr>
			<th><spring:message code="comCopCmy.testDetail.detail.testContent" /></th>
			<td colspan="5" class="cnt">
				<c:out value="${fn:replace(testDetail.testContent , crlf , '<br/>')}" escapeXml="false" />
			</td>
		</tr>
		
	</tbody>
	</table>
	<!-- 하단 버튼 -->
	<div class="btn">
		<input type="submit" class="s_submit" value="<spring:message code="button.update" />" title="<spring:message code="title.update" /> <spring:message code="input.button" />" />
		<input type="button" class="s_submit" value="삭제" onclick="fn_egov_delete_test(${testDetail.testNo})" />
		<span class="btn_s"><a href="<c:url value='/cop/cmy/getTestList.do' />"  title="<spring:message code="title.list" /> <spring:message code="input.button" />"><spring:message code="button.list" /></a></span>
	</div><div style="clear:both;"></div>
	
</div>

<input name="testNo" type="hidden" value="<c:out value="${testDetail.testNo}" />">
<input name="cmd" type="hidden" value="">
</form>

</body>
</html>
