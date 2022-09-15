<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<c:set var="pageTitle">테스트 게시판</c:set>
<!DOCTYPE html>
<html>
<head>
<title>${pageTitle } <spring:message code="title.update" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="testUpdate" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javascript">
/* ********************************************************
 * 초기화
 ******************************************************** */
function fn_egov_init(){
	// 첫 입력란에 포커스..
	document.getElementById("testUpdate").testTitle.focus();
}
/* ********************************************************
 * 저장처리화면
 ******************************************************** */
function fn_egov_updt_test(form, testNo){
	if (!validateTestUpdate(form)) {		 			
		return false;		
	} else {
		if(confirm("<spring:message code="common.update.msg" />")){	
			form.submit();	
		}					
	}	
}
/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_egov_inqire_commulist() {
	testUpdate.action = "<c:url value='/cop/cmy/selectCommuMasterList.do'/>";
	testUpdate.submit();	
}
</script>
</head>
<body onLoad="fn_egov_init();">

<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>

<!-- 상단타이틀 -->
<form:form commandName="testUpdate" action="${pageContext.request.contextPath}/cop/cmy/updateTest.do" method="post" onSubmit="fn_egov_updt_test(document.forms[0]); return false;">  
<div class="wTableFrm">
	<h2>${pageTitle} <spring:message code="title.update" /></h2>

	<!-- 수정폼 -->
	<table class="wTable" summary="<spring:message code="common.summary.update" arguments="${pageTitle}" />">
	<caption>${pageTitle} <spring:message code="title.update" /></caption>
	<colgroup>
		<col style="width: 20%;"><col style="width: ;">
	</colgroup>
	<tbody>
		<!-- 입력 -->
		<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
		<!-- 테스트 게시물 제목 -->
		<c:set var="title"><spring:message code="comCopCmy.testUpdate.updt.testTitle"/></c:set>
		<tr>
			<th><label for="testTitle">${title} <span class="pilsu">*</span></label></th>
			<td class="left">
			    <form:input path="testTitle" title="${title} ${inputTxt }" size="70" maxlength="70" />
   				<div><form:errors path="testTitle" cssClass="error" /></div>     
			</td>
		</tr>
		<!-- 테스트 게시물 내용 -->
		<c:set var="title"><spring:message code="comCopCmy.testUpdate.updt.testContent"/></c:set>
		<tr>
			<th><label for="testContent">${title} <span class="pilsu">*</span></label></th>
			<td class="nopd">
				<form:textarea path="testContent" title="${title} ${inputTxt}" cols="300" rows="20"/>   
				<div><form:errors path="testContent" cssClass="error" /></div>  
			</td>
		</tr>
		
	</tbody>
	</table>

	<!-- 하단 버튼 -->
	<div class="btn">
		<input type="submit" class="s_submit" value="<spring:message code="button.update" />" title="<spring:message code="button.update" /> <spring:message code="input.button" />" /><!-- 수정 -->
		<span class="btn_s"><a href="<c:url value='/cop/cmy/getTestList.do' />"  title="<spring:message code="button.list" /> <spring:message code="input.button" />"><spring:message code="button.list" /></a></span><!-- 목록 -->
	</div><div style="clear:both;"></div>
	
</div>

<input name="testNo" type="hidden" value="${testUpdate.testNo}">
</form:form>

</body>
</html>
