<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="css/Style_Pag2.css" var="yourStyleCSS"></spring:url>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page
	import="br.edu.ifsp.spo.lp2a4.spring.repository.PessoaRepository"%>
<%@ page import="br.edu.ifsp.spo.lp2a4.spring.model.Results"%>
<%@ page import="br.edu.ifsp.spo.lp2a4.spring.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dao" class="br.edu.ifsp.spo.lp2a4.spring.dao.PessoaDao" />
<!DOCTYPE html>
<html>
<head>
<style>
* {
    background-color: grey;
}

body {
    width: 600px;
    margin: 0 auto;
    background-color: white;
    padding: 0 20px 20px 20px;
    border: 5px solid black;
}

h3 {
	
    background-color: white;
}
</style>
<link rel="stylesheet" type="text/css" href="css/Style_Pag2.css">
<meta charset="UTF-8">
<title>Pagina Pessoa</title>
</head>
<body>


	<c:forEach var="listResultsIdPicture" items="${listResultsId.picture}" varStatus="status">
					<img src="${listResultsIdPicture.large}">
	</c:forEach>
	
	<c:forEach var="listResultsIdName" items="${listResultsId.name}" varStatus="status">
					<h3>Nome: ${listResultsIdName.first} ${listResultsIdName.last}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsId" items="${listResultsId.gender}" varStatus="status">
					<h3>Sexo: ${listResultsId}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsId" items="${listResultsId.nationality}" varStatus="status">
					<h3>Nacionalidade: ${listResultsId}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsIdDob" items="${listResultsId.dob}" varStatus="status">
					<h3>Data de Nascimento: ${listResultsIdDob.date}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsIdRegistered" items="${listResultsId.registered}" varStatus="status">
					<h3>Data de Registro: ${listResultsIdRegistered.date}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsId" items="${listResultsId.email}" varStatus="status">
					<h3>Email: ${listResultsId}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsId" items="${listResultsId.phone}" varStatus="status">
					<h3>Telefone: ${listResultsId}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsId" items="${listResultsId.cell}" varStatus="status">
					<h3>Celular: ${listResultsId}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsIdLocation" items="${listResultsId.location}" varStatus="status">
					<h3>Rua: ${listResultsIdLocation.street}</h3>
					<h3>Cidade: ${listResultsIdLocation.city}</h3>
					<h3>Estado: ${listResultsIdLocation.state}</h3>
					<h3>Regiao: ${listResultsIdLocation.region}</h3>
					<h3>Codigo Postal: ${listResultsIdLocation.postcode}</h3>
	</c:forEach>
	
	<c:forEach var="listResultsIdLocation" items="${listResultsId.location}" varStatus="status">
		<c:forEach var="listResultsIdCoordinates" items="${listResultsIdLocation.coordinates}" varStatus="status">			
					<h3>Coordenadas: <br> Latitude: ${listResultsIdCoordinates.latitude} 
					<br> Longitude: Longitude: ${listResultsIdCoordinates.longitude} </h3>
		</c:forEach>
	</c:forEach>	
</body>
</html>