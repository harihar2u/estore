#DB migration script
````
docker run harihar2u/project-demo/estore/estore-db-migration:0.0.1-SNAPSHOT \
-configFiles=/flyway/conf/flyway-db-estore.conf migrate

docker run harihar2u/project-demo/estore/estore-db-migration:0.0.1-SNAPSHOT \
-url=jdbc:postgresql://host.docker.internal:5432/postgres \
-locations=db/migration/postgresql \
-user=postgres \
-password=postgres \
-placeholders.ESTORE_SCHEMA=estore_dev \
migrate

````
