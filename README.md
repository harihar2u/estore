###### Maven install and docker push
````
mvn install -DskipTests -Pdocker

docker login --username ********
2621d649-09d8-4e2a-98fb-63c4ea452dbb

docker image tag harihar2u/estore-rest:0.0.1-SNAPSHOT harihar2u/estore-rest:0.0.1-SNAPSHOT
docker image push harihar2u/estore-rest:0.0.1-SNAPSHOT
````
###### Docker command
```
docker container ls
docker system prune
docker container prune
docker image prune
docker volume prune
docker rmi $(docker images -aq)
docker rm -f $(docker ps -aq)
````
###### Application startup in docker
````
docker run -p 5432:5432  harihar2u/estore-db-postgres:0.0.1-SNAPSHOT
docker run harihar2u/estore-db-migration:0.0.1-SNAPSHOT \
-configFiles=/flyway/conf/flyway-db-estore.conf migrate

docker run -p 8082:8082 -e SPRING_PROFILES_ACTIVE=postgres harihar2u/estore-rest:0.0.1-SNAPSHOT
docker run -p 8083:8083 -e SPRING_PROFILES_ACTIVE=postgres harihar2u/estore-auth-rest:0.0.1-SNAPSHOT

http://localhost:8082/swagger-ui.html
http://localhost:8083/swagger-ui.html
````

###### Deploy application in kubernete cluster
````
kubectl run estore-db --image=harihar2u/estore-db-postgres:0.0.1-SNAPSHOT --port=5432
kubectl run estore-db-migration --image=harihar2u/estore-db-migration:0.0.1-SNAPSHOT

kubectl create deployment estore-ws --image=harihar2u/estore-rest:0.0.1-SNAPSHOT
kubectl expose deployment/estore-ws --type=NodePort --port=8082
minikube service estore-ws --url

kubectl cluster-info
curl http://<cluster-ip>:<nodePort>/

kubectl port-forward pod/estore-ws 8082:8082
http://localhost:8082/

kubectl delete all --all
````
##### minikube Ingress
````
minikube addons enable ingress
kubectl get pods -n ingress-nginx
sudo vim /etc/hosts

ingress resource need to be enabled
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