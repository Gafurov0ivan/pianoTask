<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Stack Exchange search</title>
    <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
</head>

<body>
<div class="container" align="center">

    <h1 class="h1-form">Results</h1>

    <table class="resultTable">
        <tr>
            <th>Date Of Question</th>
            <th>Title</th>
            <th>Username</th>
        </tr>
        <c:forEach var="searchResult" items="${searchResponse.getQuestions()}">
            <tr
                    <c:if test="${searchResult.isAlreadyAnswered()}">bgcolor="#C0D890"</c:if>
                    <c:if test="${!searchResult.isAlreadyAnswered()}">bgcolor="#F09C82"</c:if>
            >
                <td align="center"><fmt:formatDate value="${searchResult.dateOfQuestion}"
                                                   pattern="dd.MM.yyyy HH:mm:ss"/></td>
                <td>
                    <a href="<c:out value="${searchResult.link}"/>">
                        <c:out value="${searchResult.title}"/>
                    </a>
                </td>
                <td align="center"><c:out value="${searchResult.username}"/></td>
            </tr>
        </c:forEach>
    </table>

    <h1/>

    <button class="button-hidden">
        <a class="button-navigate" href="<spring:url value="/search"/>">Back to search</a>
    </button>

    <c:if test="${searchResponse.getCurrentPage() > 1}">
        <button class="button-hidden">
            <form id="form-previous-page" method="GET" action="/result">
                <input type="hidden" name="page" value="${searchResponse.getCurrentPage() - 1}"/>
                <input type="hidden" name="inTitle" value="${searchResponse.getInTitle()}"/>
                <input type="submit" class="button-navigate" value="Previous page"/>
            </form>
        </button>
    </c:if>

    <c:if test="${searchResponse.getHasMore()}">
        <button class="button-hidden">
            <form id="form-next-page" method="GET" action="/result">
                <input type="hidden" name="page" value="${searchResponse.getCurrentPage() + 1}"/>
                <input type="hidden" name="inTitle" value="${searchResponse.getInTitle()}"/>
                <input type="submit" class="button-navigate" value="Next page"/>
            </form>
        </button>
    </c:if>

</div>
</body>
</html>