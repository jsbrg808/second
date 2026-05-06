<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>포고5de2 (${fn:length(pogo5de2List)})</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/list.css'/>" />
</head>
<body>
    <table>
        <colgroup>
            <col class="c-name" />
            <col class="c-data-15" /><col class="c-data-15" />
            <col class="c-data-15" /><col class="c-data-15" />
            <col class="c-data-15" /><col class="c-data-15" />
        </colgroup>
        <thead>
            <tr>
                <th>name</th>
                <th class="bg-f">5f dup</th>
                <th class="bg-f">5f evo</th>
                <th class="bg-s">5s dup</th>
                <th class="bg-s">5s evo</th>
                <th class="bg-t">5t dup</th>
                <th class="bg-t">5t evo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${pogo5de2List}">
                <tr>
                    <td class="name">${row.name}</td>
                    <td class="bg-f">${row.pogo5fDup}</td>
                    <td class="bg-f">${row.pogo5fEvo}</td>
                    <td class="bg-s">${row.pogo5sDup}</td>
                    <td class="bg-s">${row.pogo5sEvo}</td>
                    <td class="bg-t">${row.pogo5tDup}</td>
                    <td class="bg-t">${row.pogo5tEvo}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
