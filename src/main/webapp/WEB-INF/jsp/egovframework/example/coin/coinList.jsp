<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>동전</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/list.css'/>" />
<script type="text/javaScript" language="javascript" defer="defer">
<!--
    /* 글 메뉴 화면 function */
    function fn_egov_selectMenu() {
        document.listForm.action = "<c:url value='/index.jsp'/>";
        document.listForm.submit();
    }
//-->
</script>
</head>

<body>
    <form:form commandName="searchVO" name="listForm" method="post">
        <!-- 		<input type="hidden" name="grp2No" /> -->
        <!-- 		<input type="hidden" name="cntrNo" /> -->
        <!-- 		<input type="hidden" name="coinNo" /> -->
        <div id="content_pop">
            <!-- List -->
            <div id="table">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
<colgroup>
                        <col width="20%" />
                        <col width="40%" />
                        <col width="40%" />
                    </colgroup>
                    <c:set var="cntrsTot" value="0" />
                    <c:set var="coinsTot" value="0" />
                    <c:set var="coinYearsTot" value="0" />
                    <c:forEach var="grp2Code" items="${grp2CodeList}">
                        <tr>
                            <th align="center" colspan="3"><c:out value="${grp2Code.codeName}" /></th>
                        </tr>
                        <c:set var="cntrs" value="0" />
                        <c:set var="coins" value="0" />
                        <c:set var="coinYears" value="0" />
                        <c:set var="cntrNo" value="" />
                        <c:forEach var="coin" items="${coinList}">
                            <c:if test="${coin.grp2No == grp2Code.codeNo}">
                                <tr>
                                    <c:if test="${coin.cntrNo != cntrNo}">
                                        <td align="left" class="listtd" rowspan="${coin.cntrCnt}"><c:out value="${coin.cntrName}" /></td>
                                        <c:set var="cntrsTot" value="${cntrsTot + 1}" />
                                        <c:set var="cntrs" value="${cntrs + 1}" />
                                        <c:set var="cntrNo" value="${coin.cntrNo}" />
                                    </c:if>
                                    <td align="left" class="listtd"><c:out value="${coin.coinName}" />&nbsp; <c:if test="${!empty coin.coinEtc}">
                                            <br />
                                            <em><c:out value="${coin.coinEtc}" />&nbsp;</em>
                                        </c:if></td>
                                    <td class="listtd">
                                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                            <colgroup>
                                                <col width="25%" />
                                                <col width="25%" />
                                                <col width="25%" />
                                                <col width="25%" />
                                            </colgroup>
                                            <tr>
                                                <c:set var="strings" value="${fn:split(coin.coinYears, '|')}" />
                                                <c:set var="string2s" value="${fn:split(coin.coinYear2s, '|')}" />
                                                <c:forEach var="string" items="${strings}" varStatus="status">
                                                    <td align="center"><c:out value="${string}" />&nbsp; <c:if test="${!empty string2s[status.index]}">
                                                            <br />
                                                            <em><c:out value="${string2s[status.index]}" />&nbsp;</em>
                                                        </c:if></td>
                                                    <c:choose>
                                                        <c:when test="${!status.last && status.count % 4 == 0}">
                                            </tr>
                                            <tr>
                                                </c:when>
                                                <c:when test="${status.last && status.count % 4 == 1}">
                                                    <td align="center">&nbsp;</td>
                                                    <td align="center">&nbsp;</td>
                                                    <td align="center">&nbsp;</td>
                                                </c:when>
                                                <c:when test="${status.last && status.count % 4 == 2}">
                                                    <td align="center">&nbsp;</td>
                                                    <td align="center">&nbsp;</td>
                                                </c:when>
                                                <c:when test="${status.last && status.count % 4 == 3}">
                                                    <td align="center">&nbsp;</td>
                                                </c:when>
                                                </c:choose>
                                                <c:set var="coinYearsTot" value="${coinYearsTot + 1}" />
                                                <c:set var="coinYears" value="${coinYears + 1}" />
                                                </c:forEach>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <c:if test="${!empty coin.coinNo}">
                                    <c:set var="coinsTot" value="${coinsTot + 1}" />
                                    <c:set var="coins" value="${coins + 1}" />
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <td align="center" class="listtd"><c:out value="${cntrs}" />&nbsp;</td>
                            <td align="center" class="listtd"><c:out value="${coins}" />&nbsp;</td>
                            <td align="center" class="listtd"><c:out value="${coinYears}" />&nbsp;</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th align="center" colspan="3">총</th>
                    </tr>
                    <tr>
                        <td align="center" class="listtd"><c:out value="${cntrsTot}" />&nbsp;</td>
                        <td align="center" class="listtd"><c:out value="${coinsTot}" />&nbsp;</td>
                        <td align="center" class="listtd"><c:out value="${coinYearsTot}" />&nbsp;</td>
                    </tr>
                </table>
            </div>
            <!-- /List -->
            <!-- 	<div id="paging"> -->
            <%-- 		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" /> --%>
            <%-- 		<form:hidden path="pageIndex" /> --%>
            <!-- 	</div> -->
            <div id="sysbtn">
                <ul>
                    <li><span class="btn_blue_l"> <a href="javascript:fn_egov_selectMenu();">메뉴</a> <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
                            class="btn-arrow" alt=""
                        />
                    </span></li>
                </ul>
            </div>
        </div>
    </form:form>
</body>
</html>
