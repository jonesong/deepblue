<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="localization/messages_en" />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="COMMON_TITLE" /></title>
	<link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/img/jsp-icon.png' />" rel="icon"></link>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<html>
<body>
<header>
    <nav>
        <img id="logo" src="<c:url value='/static/img/logo_deepblue.png' />" alt="LOGO">
        <ul id="menu">     
        </ul>
    </nav>
</header>