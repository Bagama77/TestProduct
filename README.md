# TestProduct
Simple REST API application.

Base entity Product. Droduct properties are: 
1. Id  - number;
2. Name - string from 3 to 50 characters;
3. Price - number with 2 digits after point;
4. Date - creation or updated date

Implemented functions:
1. FindAll - returns list of products;
2. Create - saves new product into repository, returns saved product with id;
3. Update - save updated product into repository, returns updated product;
4. Delete - deletes entity from repository, returns empty string;

API:
1. Find all products - 

  curl --location --request GET 'localhost:8081/products/all'

2. Create new product - 

  curl --location --request POST 'localhost:8081/products/add' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "name": "NameProduct",
      "date": "2022-09-15T21:00:00.000+00:00",
      "price": 22.34
  }'
  
 3. Update product - 
 
  curl --location --request PUT 'localhost:8081/products/1' \
  --header 'Content-Type: application/json' \
  --data-raw '{
          "id": 1,
          "name": "Product 111 ",
          "date": "1997-06-09T21:00:00.000+00:00",
          "price": 121.34
      }'
      
 4. Delete product - 
 
  curl --location --request DELETE 'localhost:8081/products/1' \
  --data-raw ''
  
 Repository implemented in H2 in memory database. Access to database through browser with endpoint: http://localhost:8081/h2-console/
 Username: sa
 Password: password
 
 How to run application:
 1. In console: mvn spring-boot:run
 2. In IDE run main class: ProductinterviewApplication
 3. In terminal run docker container: docker run --rm --name product -p 8081:8081 9e217b98b5d2
 Docker image : https://drive.google.com/file/d/1UIJCKywcbY4C_767QZXokUiNUGFJ6Ssm/view?usp=sharing
 
