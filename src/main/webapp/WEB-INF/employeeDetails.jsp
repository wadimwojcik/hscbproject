
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>

table {

}
th {
  background: limegreen;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>
<form:form method="post" modelAttribute="employee" action="${pageContext.request.contextPath}/addEmployee">
<table>
		<tr>
			<th colspan="2">Add Employee</th>
		</tr>
		<tr>
	<form:hidden path="id" />
          <td><form:label path="employeeName">Employee Name:</form:label></td>
          <td><form:input path="employeeName" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
			    <td><form:label path="employeeSurname">Employee Surname:</form:label></td>
          <td><form:input path="employeeSurname" size="30" maxlength="30"></form:input></td>
		</tr>
	<tr>
		<td><form:label path="employeeGrade">Employee Grade:</form:label></td>
		<td><form:input path="employeeGrade" size="30" maxlength="30"></form:input></td>
	</tr>
	<tr>
		<td><form:label path="employeeSalary">Employee Salary:</form:label></td>
		<td><form:input path="employeeSalary" size="30" maxlength="30"></form:input></td>
	</tr>
		<tr>
			<td colspan="2"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Employee List</h3>
<c:if test="${!empty listOfEmployee}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Employee Name</th>
		<th width="120">Employee Surname</th>
		<th width="120">Employee Grade</th>
		<th width="120">Employee Salary</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfEmployee}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.employeeName}</td>
			<td>${employee.employeeSurname}</td>
			<td>${employee.employeeGrade}</td>
			<td>${employee.employeeSalary}</td>
			<td><a href="<c:url value='/updateEmployee/${employee.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteEmployee/${employee.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
