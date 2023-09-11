<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <div class="container">
        <h1 class="mt-5">Welcome,
            <c:out value="${user.name}" />
        </h1>
        <h1>Your Tables:</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Guest Name</th>
                    <th># Guest</th>
                    <th>Arrived at</th>
                    <th class="action">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${Mesa}" var="mesa">
                    <tr>
                        <td><c:out value="${mesa.guest}" /></td>
                        <td><c:out value="${mesa.number}" /></td>
                        <td><c:out value="${mesa.createdAt}" /></td>
                        <td>
                            <div class="d-flex flex-column flex-md-row align-items-start align-items-md-center">
                                <form action="/${mesa.id}/delete" method="post" class="mb-2 mb-md-0 mr-md-2">
                                    <input type="hidden" name="_method" value="delete">
                                    <button type="submit" class="btn btn-danger">Finished</button>
                                </form>
                                <a href="/tables/${mesa.id}/edit" class="btn btn-primary mr-md-2">Edit</a>
                                <form action="/${mesa.id}/give" method="post">
                                    <button type="submit" class="btn btn-warning">Give Up Table</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <a class="btn btn btn-danger" href="/logout">Logout</a>
        <a class="btn btn btn-primary" href="/tables">See Other Tables</a>
        <a class="btn btn-success" href="/home/tables/new">+ New Table</a>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
