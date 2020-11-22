# TestProduct
Spring-boot application. 
There is a variable(counter) that can be shared by all the clients, the initial value of the counter is 50.

There is an ENDPOINT that receives two request parameters, the first one increases the number of producer threads. The second parameter increases the number of consumer threads.

         The response is HTTP 201 Created success status.

In MySQL, persists the request's information received by the app to the database.

The producer threads will increase the value of the counter while the consumer threads will decrease it. 

Printing in the console the current value of the counter when it changes and print which producer/consumer is responsible for the change.

The threads are running in parallel and continue until the counter reaches 0 or 100. Persist in the database the timestamp when the counter reaches 0 or 100.

g. Create another ENDPOINT that will receive one parameter, the parameter will change the current value of the counter.

	The response will be HTTP 200 Ok success status.

API:

1. Set counter to some particular value:

  curl --location --request GET 'localhost:8081/counts/change/50'

2. Change the number of producer/consumer threads

curl --location --request GET 'localhost:8081/counts/50/40'

where 50 are producers and 40 - consumers


Application uses MySql Server to persist some data (every request to change producers/consumers, every request to set counter when counter becomes 0 or 100)

 How to run application:
 1. In console: mvn spring-boot:run
 2. In IDE run main class: ProductinterviewApplication
 3. In terminal run docker container: docker run --rm --name counter -p 8081:8081 8b4000cf63e3
 
 Docker image : https://hub.docker.com/repository/docker/bagama/consumer_producer_threads
 
 Docker image link on Docker hub: docker pull bagama/consumer_producer_threads:latest
 
