HSBC project.

Technologies:
1)springboot
2)hibernate
3)jsp
4)h2 memory database

JavaDocs:
Most of the classes are selfexplaioned, but I have added java docs for controllers classes as they need explanations for frontend users.

Run:
1) import pom.xml file into IDE (for example intelj)
2) upload pom dependcies
3) upload files with their directories
4) click run on ApplicationRunner.java

Usage:
Project contains two types of methods to get/update data.
1) it is by simple GUI interface which allows to add/update/delete/getAll you can access there by:
	http://localhost:8080/getAllEmployee or type localhost:8080 (it will directly move you to getAllEmployee) page
2) there is also JSON API to run requested commands examples:
	http://localhost:8080/getJsonEmployee/1
	http://localhost:8080/getJsonAllEmployee
	http://localhost:8080/deleteJsonEmployee/22
	http://localhost:8080/getJsonEmployeeByCriteria?id=1&name=wadim&surname=wojcik&salary=100&grade=55

"5. Write an engine that allows to search for users by providing any number of arguments. It should return a list of users that fulfill the given parameters."
To be honest I am not sure exacly what you have expected in this task. I have assumed that you have 5 paramters (id,name,surname,salary,grade) and you pick what paramteters are you interested in and search by them.
I write this engine by "GET" request type it allows to simple put parameter in URL (http://localhost:8080/getJsonEmployeeByCriteria?id=1&name=wadim&surname=wojcik&salary=100&grade=55) other examples:
http://localhost:8080/getJsonEmployeeByCriteria?id=1&name=wadim&surname=wojcik
http://localhost:8080/getJsonEmployeeByCriteria?id=1&name=wadim&surname=wojcik&salary=100
http://localhost:8080/getJsonEmployeeByCriteria?grade=55