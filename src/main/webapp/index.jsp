<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    /**
									 * @Class Name : egovSampleList.jsp
									 * @Description : Sample List 화면
									 * @Modification Information
									 *
									 *   수정일         수정자                   수정내용
									 *  -------    --------    ---------------------------
									 *  2009.02.01            최초 생성
									 *
									 * author 실행환경 개발팀
									 * since 2009.02.01
									 *
									 * Copyright (C) 2009 by MOPAS  All right reserved.
									 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Second</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>" />
<script type="text/javaScript" language="javascript" defer="defer">
<!--
    /* 목록 화면 function */
    function fn_egov_goList(id, sub) {
        if (id == "Coin") {
            document.listForm.action = "<c:url value='/selectCoinList.do'/>";
        } else if (id == "Pogo5f") {
            document.listForm.action = "<c:url value='/selectPogo5fList.do'/>";
        } else if (id == "Pogo5s") {
            document.listForm.action = "<c:url value='/selectPogo5sList.do'/>";
        } else if (id == "Pogo5t") {
            document.listForm.action = "<c:url value='/selectPogo5tList.do'/>";
        } else if (id == "Pogo5pc2") {
            window.location.href = "<c:url value='/downloadPogo5pc2.do'/>";
            return;
        } else if (id == "Pogo5de2") {
            window.location.href = "<c:url value='/selectPogo5de2List.do'/>";
            return;
        } else if (id == "Pogo5yn") {
            window.location.href = "<c:url value='/selectPogo5ynList.do'/>";
            return;
        }
        document.listForm.submit();
    }
//-->
</script>
</head>
<body style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
    <form:form commandName="searchVO" name="listForm" id="listForm" method="post">
        <div id="content_pop">
            <div id="title">
                <ul>
                    <li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt="" /> 메뉴</li>
                </ul>
            </div>
            <div id="table">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
                    <caption style="visibility: hidden">카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블</caption>
                    <colgroup>
                        <col width="33%" />
                        <col width="33%" />
                        <col width="33%" />
                    </colgroup>
                    <tr>
                        <td align="left" class="listtd"><a href="javascript:fn_egov_goList('Coin')">동전</a></td>
                        <td class="listtd"></td>
                        <td class="listtd"></td>
                    </tr>
                    <tr>
                        <td align="left" class="listtd"><a href="javascript:fn_egov_goList('Pogo5f')">포고5f</a></td>
                        <td align="left" class="listtd"><a href="javascript:fn_egov_goList('Pogo5s')">포고5s</a></td>
                        <td align="left" class="listtd"><a href="javascript:fn_egov_goList('Pogo5t')">포고5t</a></td>
                    </tr>
                    <tr>
                        <td align="left" class="listtd"><a href="javascript:fn_egov_goList('Pogo5pc2')">포고5pc2</a></td>
                        <td align="left" class="listtd"><a href="javascript:fn_egov_goList('Pogo5de2')">포고5de2</a></td>
                        <td align="left" class="listtd"><a href="javascript:fn_egov_goList('Pogo5yn')">포고5yn</a></td>
                    </tr>
                </table>
            </div>
        </div>
    </form:form>
</body>
</html>
