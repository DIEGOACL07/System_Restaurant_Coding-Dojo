<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header">
                        Register!
                    </div>
                    <div class="card-body">
                        <form:form method="POST" action="/" modelAttribute="user">
                            <div class="form-group">
                                <form:label path="name">Name:</form:label>
                                <form:input type="text" class="form-control" path="name" />
                            </div>
                            <div class="form-group">
                                <form:label path="email">Email:</form:label>
                                <form:input type="email" class="form-control" path="email" />
                            </div>
                            <div class="form-group">
                                <form:label path="password">Password:</form:label>
                                <form:password class="form-control" path="password" />
                            </div>
                            <div class="form-group">
                                <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                                <form:password class="form-control" path="passwordConfirmation" />
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </form:form>
                        <p class="mt-3 text-center">
                            <a href="/login">login</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
