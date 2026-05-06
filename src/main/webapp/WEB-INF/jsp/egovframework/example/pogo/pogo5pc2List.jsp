<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>pc2 (${fn:length(pogo5pc2List)})</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>" />
<style>
    table { border-collapse: collapse; width: 100%; }
    th, td { border: 1px solid #ccc; padding: 4px 8px; white-space: pre; }
    th { background-color: #f0f0f0; }
</style>
</head>
<body style="text-align: center; margin: 0 auto; padding-top: 20px;">
    <table>
        <thead>
            <tr>
                <th>name</th>
                <th>5f pow</th>
                <th>5f cat</th>
                <th>5s pow</th>
                <th>5s cat</th>
                <th>5t pow</th>
                <th>5t cat</th>
                <th>max</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${pogo5pc2List}">
                <tr>
                    <td>${row.name}</td>
                    <td>${row.pogo5fPow}</td>
                    <td>${row.pogo5fCat}</td>
                    <td>${row.pogo5sPow}</td>
                    <td>${row.pogo5sCat}</td>
                    <td>${row.pogo5tPow}</td>
                    <td>${row.pogo5tCat}</td>
                    <td>${row.pogoMax}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
