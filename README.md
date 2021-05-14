###### Maven install
mvn install -DskipTests -Pdocker

###### Docker run
docker run -p 8083:8083 -e server.port=8083 \
harihar2u/project-demo/estore/estore-auth-rest:0.0.1-SNAPSHOT

###### Spring boot application with persistance storage.
1. OpenApi and Swagger UI integration
2. Spring MVC, REST and Security with JWT
3. Flyway DB migration
4. Docker support

###### Open API and Swagger UI
http://localhost:8083/estore-auth/swagger-ui.html
http://localhost:8082/estore-ws/swagger-ui.html

http://localhost:8081/estore

###### Create folders to generate all files (separated for client and server)
mkdir ssl && cd ssl && mkdir client && mkdir server
###### Generate server private key and self-signed certificate in one step
openssl req -x509 -newkey rsa:4096 -keyout server/serverPrivateKey.pem -out server/server.crt -days 3650 -nodes
###### Create PKCS12 keystore containing private key and related self-sign certificate
openssl pkcs12 -export -out server/keyStore.p12 -inkey server/serverPrivateKey.pem -in server/server.crt
###### Generate server trust store from server certificate 
keytool -import -trustcacerts -alias root -file server/server.crt -keystore server/trustStore.jks

###### Generate client's private key and a certificate signing request (CSR)
openssl req -new -newkey rsa:4096 -out client/request.csr -keyout client/myPrivateKey.pem -nodes
###### Sign client's CSR with server private key and a related certificate
openssl x509 -req -days 360 -in request.csr -CA server/server.crt -CAkey server/serverPrivateKey.pem -CAcreateserial -out client/pavel.crt -sha256
###### Verify client's certificate
openssl x509 -text -noout -in client/pavel.crt
###### Create PKCS12 keystore containing client's private key and related self-sign certificate 
openssl pkcs12 -export -out client/client_pavel.p12 -inkey client/myPrivateKey.pem -in client/pavel.crt -certfile server/myCertificate.crt

