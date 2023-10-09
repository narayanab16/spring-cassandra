# spring-cassandra
java + spring boot + spring data cassandra 

-  Prereqs: Java 18, IntelliJ/Eclipse, Git
-  SpringReactiveApplication - run java app

Create a customer REST API, I used **postman**
- HTTP method: POST
- URL : http://localhost:10000/addCustomer
- Header: Content-Type: application/json
- raw Body: {"id":"100","customername":"Narayana100","address":"address100"}

Get customer REST API:
- http://localhost:10000/getCustomerById/28

Update customer REST API:
- http://localhost:10000/updateCustomerById/28/Narayana-testing

Delete customer REST API:
- http://localhost:10000/updateCustomerById/{id}


