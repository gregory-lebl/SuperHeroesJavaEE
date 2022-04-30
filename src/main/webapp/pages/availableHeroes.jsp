<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Les héros disponibles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">Les héros disponible dans un rayon de 50 Km autour de la ville de l'incident</h1>
<div class="container mt-5">
    <j:forEach items="${availableHeros}" var="hero">
        <div class="card" style="max-width: max-content;">
            <img class="card-img-top" style="max-width: 300px;" src="https://c7.alamy.com/compfr/r84g2r/caractere-avatar-super-heros-design-illustration-vectorielle-r84g2r.jpg" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">${hero.name}</h5>
                <a href="tel:${hero.phoneNumber}" class="btn btn-primary">Contacter ce héro !</a>
            </div>
        </div>
    </j:forEach>
</div>
</body>
</html>
