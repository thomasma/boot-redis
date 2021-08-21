### Spring Boot and Redis
Code sample to write an object to redis and then read it back using RESTful API. All built using Spring Boot, Redis for Spring Data and Spring MVC exposed RESTful API

To run this
```
brew install redis
redis-server
mvn spring-boot:run
```


Write Blog object to Redis using cURL
```
curl --location --request POST 'http://localhost:8080/blog' \
--header 'Accept-Language: application/json' \
--header 'Accept-Encoding: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id" : 1,
    "title" : "my first blog",
    "content" : "this is an amazing first blog here"
}'
```
Read Blog object to Redis using cURL
```
curl --location --request GET 'http://localhost:8080/blog/1'
```