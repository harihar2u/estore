###### Maven install
````
mvn install -DskipTests -Pdocker
````

###### Docker command
```
docker container ls
docker system prune
docker container prune
docker image prune
docker volume prune
docker rmi $(docker images -a -q)
docker rm -f $(docker ps -aq)
````
#Application startup
````
docker run -p 5432:5432  harihar2u/project-demo/estore/estore-db-postgres:0.0.1-SNAPSHOT
docker run harihar2u/project-demo/estore/estore-db-migration:0.0.1-SNAPSHOT \
-configFiles=/flyway/conf/flyway-db-estore.conf migrate

docker run -p 8082:8082 -e server.port=8082 harihar2u/project-demo/estore/estore-rest:0.0.1-SNAPSHOT
docker run -p 8083:8083 -e server.port=8083 harihar2u/project-demo/estore/estore-auth-rest:0.0.1-SNAPSHOT
```
###### Open API and Swagger UI
````
http://localhost:8083/swagger-ui.html
http://localhost:8082/swagger-ui.html
````


###### Spring boot application with persistance storage.
```
1. OpenApi and Swagger UI integration
2. Spring MVC, REST and Security with JWT
3. Flyway DB migration
4. Docker support
````

###### Create folders to generate all files (separated for client and server)
```
mkdir ssl && cd ssl && mkdir client && mkdir server
openssl req -x509 -newkey rsa:4096 -keyout server/serverPrivateKey.pem -out server/server.crt -days 3650 -nodes
openssl pkcs12 -export -out server/keyStore.p12 -inkey server/serverPrivateKey.pem -in server/server.crt
keytool -import -trustcacerts -alias root -file server/server.crt -keystore server/trustStore.jks
openssl req -new -newkey rsa:4096 -out client/request.csr -keyout client/myPrivateKey.pem -nodes
openssl x509 -req -days 360 -in request.csr -CA server/server.crt -CAkey server/serverPrivateKey.pem -CAcreateserial -out client/pavel.crt -sha256
openssl x509 -text -noout -in client/pavel.crt
openssl pkcs12 -export -out client/client_pavel.p12 -inkey client/myPrivateKey.pem -in client/pavel.crt -certfile server/myCertificate.crt
```
