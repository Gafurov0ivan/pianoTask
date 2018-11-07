<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Search results</title>
    <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
    <form class="form-search" method="GET" action="/result">
        <h1 class="h1-form">Search on Stack Exchange</h1>
        <div class="form-group">
            <div>
                <input type="text" class="form-control" name="inTitle" placeholder="Enter search title"
                       required="required"/>
                <input type="submit" class="button" value="Search"/>
            </div>
        </div>
    </form>
</div>
</body>

</html>