## Run Spring Boot application
```
mvn spring-boot:run
```

## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```

Let’s check H2 database with url: http://localhost:8080/h2-console:

Click on Connect button, tables that we define in models package will be automatically generated in Database.



Register some users with /signup API:

admin with ROLE_ADMIN

user with ROLE_USER

```cs
curl --location 'localhost:8080/api/auth/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"user",
    "email":"user@gmail.com",
    "role": ["user"],
    "password":"12345678"
}'
```

TO LOGIN API
```cs
curl --location 'localhost:8080/api/auth/signin' \
--header 'Content-Type: application/json' \
--data '{
    "username":"user",
    "password":"12345678"
}'
```

GET ALL USERS 
```cs
curl --location --request GET 'localhost:8080/api/users' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY' \
--header 'Cookie: syc=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY; glide_user_route=glide.a831b62f21e733cb3f8809e54b566463' \
--form 'file=@"/path/to/file"'
```

GET ALL IMAGES UPLOAD BY USER 
```cs
 curl --location 'localhost:8080/api/images' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY' \
--header 'Cookie: syc=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY; glide_user_route=glide.a831b62f21e733cb3f8809e54b566463'
 ```

TO UPLOAD A NEW IMAGE 
```cs
curl --location 'localhost:8080/api/image/upload' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY' \
--header 'Cookie: syc=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY; glide_user_route=glide.a831b62f21e733cb3f8809e54b566463' \
--form 'file=@"/path/to/file"'
```

TO VIEW OR GET IMAGE BY ID 
<br>
To Get Image information we need hashcode and to get it we need to hit `api/images API` to get all hashcode associated 
with user and code any hascode 
```cs
GET : localhost:8080/api/images/<hashcode>
```
```cs
curl --location --request GET 'localhost:8080/api/images/vzOQLPP' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY' \
--header 'Cookie: syc=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY; glide_user_route=glide.a831b62f21e733cb3f8809e54b566463' \
--form 'file=@"/path/to/file"'
```


TO DELETE IMAGE
<br>
To Get Image information we need hashcode and to get it we need to hit `api/images API` to get all hashcode associated
with user and code any deletehashcode
```cs
DELETE : localhost:8080/api/images/<deletehashcode>
```

```cs
curl --location --request DELETE 'localhost:8080/api/images/vzOQLPP' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY' \
--header 'Cookie: syc=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2OTYzMjA1NTUsImV4cCI6MTY5NjQwNjk1NX0.y21dZZihAjSb0bQalTQUMwSPyPPyAu5HYdqfethVmKY; glide_user_route=glide.a831b62f21e733cb3f8809e54b566463' \
--form 'file=@"/path/to/file"'
```