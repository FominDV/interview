<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Orders</title>
    </head>
</head>
<body>
<h1>Update Student</h1>
<form action="/rev/students/update/${student.id}" method="post">
    <h4>ID: ${student.id}</h4>
    <div class="mb-3">
        <h4>Name</h4>
        <input type="text" name="name" minlength="2" maxlength="200" value="${student.name}">
    </div>
    <div class="mb-3">
        <h4>Age</h4>
        <input type="number" name="age" min="1" max="99" value="${student.age}">
    </div>
    <button type="submit" class="btn btn-success">Update</button>
</form>
<h4><a class="btn btn-warning" href="/rev/students">To Main</a></h4>
</body>
</html>
