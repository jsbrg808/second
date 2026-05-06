<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>포고5yn (${fn:length(pogo5ynList)})</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/list.css'/>" />
</head>
<body>
    <table>
        <colgroup>
            <col class="c-name" />
            <col class="c-data" /><col class="c-data" /><col class="c-data" />
            <col class="c-data" /><col class="c-data" /><col class="c-data" />
            <col class="c-data" /><col class="c-data" /><col class="c-data" />
        </colgroup>
        <thead>
            <tr>
                <th>name</th>
                <th class="bg-f">5f m</th><th class="bg-f">5f f</th><th class="bg-f">5f g</th>
                <th class="bg-s">5s m</th><th class="bg-s">5s f</th><th class="bg-s">5s g</th>
                <th class="bg-t">5t m</th><th class="bg-t">5t f</th><th class="bg-t">5t g</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${pogo5ynList}">
                <tr>
                    <td class="name">${row.name}</td>
                    <td class="bg-f ${row.actFM ne row.expM ? 'diff' : ''}">${row.actFM}</td>
                    <td class="bg-f ${row.actFF ne row.expF ? 'diff' : ''}">${row.actFF}</td>
                    <td class="bg-f ${row.actFG ne row.expG ? 'diff' : ''}">${row.actFG}</td>
                    <td class="bg-s ${row.actSM ne row.expM ? 'diff' : ''}">${row.actSM}</td>
                    <td class="bg-s ${row.actSF ne row.expF ? 'diff' : ''}">${row.actSF}</td>
                    <td class="bg-s ${row.actSG ne row.expG ? 'diff' : ''}">${row.actSG}</td>
                    <td class="bg-t ${row.actTM ne row.expM ? 'diff' : ''}">${row.actTM}</td>
                    <td class="bg-t ${row.actTF ne row.expF ? 'diff' : ''}">${row.actTF}</td>
                    <td class="bg-t ${row.actTG ne row.expG ? 'diff' : ''}">${row.actTG}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
