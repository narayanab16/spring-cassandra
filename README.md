# spring-cassandra
java + spring boot + spring data cassandra 

-  Prereqs: Java 18, IntelliJ/Eclipse, Git
-  Use docker and follow steps from **resources/cassandra_docker_cql.txt**
-  I have created **linux OSimage video with docker installed** and you can setup, any software you can run in docker
-  CassandraDBApplication - run java app, expects cassandra is running, keyspace & table created 

Create a customer REST API, I used **postman**
- HTTP method: POST
- URL : http://localhost:10000/addCustomer
- Header: Content-Type: application/json
- raw Body: {"id":"100","customername":"Narayana100","address":"address100"}

Get customer REST API (one customer):
- http://localhost:10000/getCustomerById/28

Get customer REST API(A customer with compound key data)
- http://localhost:10000/getCustomerFullDataById/28

Update customer REST API:
- http://localhost:10000/updateCustomerById/28/Narayana-testing

Delete customer REST API:
- http://localhost:10000/deleteCustomerById/28

Aggregate REST API:
- http://localhost:10000/aggregateByCustomer/Narayana
