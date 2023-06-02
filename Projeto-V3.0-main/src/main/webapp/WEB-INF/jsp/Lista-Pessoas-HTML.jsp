<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="css/Style.css" var="yourStyleCSS"></spring:url>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="br.edu.ifsp.spo.lp2a4.spring.repository.PessoaRepository"%>
<%@ page import="br.edu.ifsp.spo.lp2a4.spring.model.Results"%>
<%@ page import="br.edu.ifsp.spo.lp2a4.spring.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dao" class="br.edu.ifsp.spo.lp2a4.spring.dao.PessoaDao" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${yourStyleCSS}">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="Header">
	<c:import url="Header.jsp" />
	</div>
	<div class="container">
		<div class="container-size">
			<div class="left-box">
				<div class="filters">
					<p>
						<strong>Filtrar por usuário:</strong>
					</p>

					<div class="inputs">
						<input class="radio" type="radio" name="Especial" checked></input>
						<label for="Especial">Especial</label>
					</div>

					<div class="inputs">
						<input class="radio" type="radio" name="Normal"></input> <label
							for="Normal">Normal</label>
					</div>

					<div class="inputs">
						<input class="radio" type="radio" name="Trabalhoso"></input> <label
							for="Trabalhoso">Trabalhoso</label>
					</div>

				</div>
				<div class="filters">
					<p>
						<strong>Filtrar por Região:</strong>
					</p>

					<div class="inputs">
						<input class="radio" type="radio" name="norte" checked></input> <label
							for="norte">Norte</label>
					</div>

					<div class="inputs">
						<input class="radio" type="radio" name="nordeste"></input> <label
							for="nordeste">Nordeste</label>
					</div>

					<div class="inputs">
						<input class="radio" type="radio" name="centro-oeste"></input> <label
							for="centro-oeste">Centro-Oeste</label>
					</div>

					<div class="inputs">
						<input class="radio" type="radio" name="sudeste"></input> <label
							for="sudeste">Sudeste</label>
					</div>

					<div class="inputs">
						<input class="radio" type="radio" name="sul"></input> <label
							for="sul">Sul</label>
					</div>
				</div>
			</div>
			<div class="right-box">
				<!-- Repete tudo -->
				<c:forEach var="listpicture" items="${listpicture}" varStatus="status">
					<div class="card">
					<a href="results/${listResults[status.index].id}"><img src="${listpicture.large}"></a>
					<h3>${listname[status.index].first} ${listname[status.index].last}</h3>
					<h3>${listlocation[status.index].street}</h3>
					<h3>${listlocation[status.index].city} , ${listlocation[status.index].state}</h3>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>