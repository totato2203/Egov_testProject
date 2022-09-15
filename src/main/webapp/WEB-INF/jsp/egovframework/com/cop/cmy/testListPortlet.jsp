<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul>
<c:forEach var="test" items="${testList}" varStatus="status">
   	<li style="padding-top:5px">
		<form name="testForm2" method="post"  action="<c:url value='/cop/cmy/getTestDetail.do'/>" >
		<input type="hidden" name="testNo" value="<c:out value='${test.testNo}'/>"/>
		<input type="hidden" name="testTitle" value="<c:out value='${test.testTitle}'/>"/>
		<input type="submit" value="<c:out value="${test.testNo}"/>"/>
		</form>
	</li>
</c:forEach>
</ul>
