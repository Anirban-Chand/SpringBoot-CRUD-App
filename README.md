# SpringBoot-CRUD-App

A simplistic Spring backend application that demonstrates how CRUD APIs works

###Spring Boot CRUD application with branches for different tasks###

##Running the application
./mvnw clean spring-boot:run

or

mvn clean spring-boot:run

##Create a jar file from the project

mvn clean package

##Run from jar file, default profile

java -jar target/springboottesting-0.0.1-SNAPSHOT.jar

##Run from jar file, dev profile

java -jar target/springboottesting-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

##Add new record

curl -X POST localhost:3000/plants/ -H 'Content-type:application/json' -d  \
'{"id": 1, "genus": "Nolina", "subfamily": "Nolinoideae", "distribution": "S America" }' \
&& echo

##Listing all records

curl -v localhost:3000/plants && echo

##List particular record

curl -X GET localhost:3000/plants/1 && echo

##Update

curl -X PUT localhost:3000/plants/1 -H 'Content-type:application/json' -d  \
'{"id": 1, "genus": "Nolina", "subfamily": "Nolinoideae", "distribution": "South America" }' \
 && echo

##Delete a record

curl -X DELETE localhost:3000/plants/1


