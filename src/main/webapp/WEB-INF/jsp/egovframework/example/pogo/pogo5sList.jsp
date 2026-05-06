<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>포고5s (${fn:length(pogo5List)})</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>" />
<script type="text/javaScript" language="javascript" defer="defer">
<!--
    function fn_egov_append() {
        document.listForm.action = "<c:url value='/appendPogo5s.do'/>";
        document.listForm.submit();
    }

    function fn_egov_update() {
        document.listForm.action = "<c:url value='/updatePogo5s.do'/>";
        document.listForm.submit();
    }
    
    function fn_egov_delete(seq) {
        document.listForm.seq.value = seq;
        
        document.listForm.action = "<c:url value='/deletePogo5s.do'/>";
        document.listForm.submit();
    }
    
    function fn_egov_insert(seq) {
        document.listForm.seq.value = seq;
        document.listForm.default_.value = document.getElementById("default_" + seq).value;
        document.listForm.for_.value = document.getElementById("for_" + seq).value;
        document.listForm.alp.value = document.getElementById("alp" + seq).value;
        
        document.listForm.action = "<c:url value='/insertPogo5s.do'/>";
        document.listForm.submit();
    }
    
    function fn_egov_srch() {
        document.listForm.action = "<c:url value='/selectPogo5sList.do'/>";
        document.listForm.submit();
    }

    function fn_egov_select(seq, default_, for_, alp) {
        document.listForm.seq.value = seq;
        document.listForm.default_.value = default_;
        document.listForm.for_.value = for_;
        document.listForm.alp.value = alp;
        
        document.listForm.default_.focus();
    }
//-->
</script>
</head>
<body style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
    <form:form commandName="searchVO" name="listForm" method="post">
        <table width="100%" border="1px" cellpadding="0" cellspacing="0" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
            <colgroup>
                <col width="16.6%" />
                <col width="16.6%" />
                <col width="16.6%" />
                <col width="16.6%" />
                <col width="16.6%" />
                <col width="16.6%" />
            </colgroup>

            <tr>
                <td><input type="text" id="srchNm" name="srchNm" value="${srchNm}" style="width: 100px;" onkeydown="if(event.keyCode==13){fn_egov_srch();}" /><br /> <br /> <a onclick="fn_egov_srch();">확인</a></td>
                <td><input type="hidden" name="seq" /> <input type="text" name="default_" style="width: 110px;" /> / <input type="text" name="for_" style="width: 20px;" /> / <input type="text"
                    name="alp" style="width: 20px;"
                /><br /> <br /> <a onclick="fn_egov_append();">추가</a> / <a onclick="fn_egov_update();">변경</a></td>
            </tr>

            <tr>
                <c:forEach var="pogo5" items="${pogo5List}" varStatus="status">

                    <td valign="bottom" id="seq${pogo5.seq}" onclick="fn_egov_select(${pogo5.seq}, '${pogo5.default_}', '${pogo5.for_}', '${pogo5.alp}');"><c:choose>
                            <c:when test="${empty pogo5.imgSrc}">
                                <span style="width: 128px; height: 128px; display: inline-flex; align-items: center; justify-content: center; color: #999; font-size: 12px;">대체 ${pogo5.imgAlt}</span>
                            </c:when>
                            <c:otherwise>
                                <img src="${pogo5.imgSrc}" style="width: 128px; height: 128px;" alt="${pogo5.imgAlt}" />
                            </c:otherwise>
                        </c:choose><br /> <input type="text" value="${pogo5.default_}" style="width: 110px;" disabled /> / <input type="text" value="${pogo5.for_}" style="width: 20px;" disabled /> / <input
                        type="text" value="${pogo5.alp}" style="width: 20px;" disabled
                    /><br /> <br /> <a onclick="fn_egov_delete(${pogo5.seq});">삭제</a></td>
                    <td valign="bottom"><input type="text" id="default_${pogo5.seq}" style="width: 110px;" /> / <input type="text" id="for_${pogo5.seq}" style="width: 20px;" /> / <input
                        type="text" id="alp${pogo5.seq}" style="width: 20px;"
                    /><br /> <br /> <a onclick="fn_egov_insert(${pogo5.seq});">삽입</a></td>

                    <c:if test="${status.count % 3 == 0}">
            </tr>
            <tr>
                </c:if>

                </c:forEach>
            </tr>

        </table>

    </form:form>
</body>
</html>
