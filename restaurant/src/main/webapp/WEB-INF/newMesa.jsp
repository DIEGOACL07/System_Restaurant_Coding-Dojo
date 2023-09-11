<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>New Table</title>
    <link rel="stylesheet" href="/css/style.css" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
  </head>

  <body>
    <div class="container">
      <h1 class="mt-5">New Table</h1>
      <form:form method="POST" action="/tables/new" modelAttribute="Mesa">
        <input type="hidden" name="user" value="${user_id}" />
        <div class="form-group">
          <form:label path="guest">Guest Name:</form:label>
          <form:input type="text" class="form-control" path="guest" />
        </div>
        <div class="form-group">
          <form:label path="number">Number of Guests:</form:label>
          <form:input type="number" class="form-control" path="number" />
        </div>
        <div class="form-group">
          <form:label path="notes">Notes:</form:label>
          <form:textarea class="form-control" path="notes" />
        </div>
        <a class="btn btn btn-danger" href="/tables">Cancel</a>
        <button type="submit" class="btn btn-primary">Crear</button>
      </form:form>
      <p>
        <form:errors path="user.*" />
      </p>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </body>
</html>
