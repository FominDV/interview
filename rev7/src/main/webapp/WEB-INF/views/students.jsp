<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Orders</title>
</head>
<body>
<h1>Students</h1>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>AGE</td>
        <td>DELETE</td>
        <td>CHANGE</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>
                <form action="students/delete/${student.id}" method="post">
                    <button type="submit" class="btn btn-danger">delete</button>
                </form>
            </td>
            <td><a class="btn btn-warning" href="students/update/${student.id}">edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div>
    <h1>Create new student</h1>
    <form action="students" method="post">
        <div class="mb-3">
            <h4>Name</h4>
            <input type="text" name="name" minlength="2" maxlength="200">
        </div>
        <div class="mb-3">
            <h4>Age</h4>
            <input type="number" name="age" min="1" max="99">
        </div>
        <button type="submit" class="btn btn-success">Create</button>
    </form>
</div>
</body>
</html>