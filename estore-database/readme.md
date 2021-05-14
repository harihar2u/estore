docker run harihar2u/project-demo/estore/estore-database:0.0.1-SNAPSHOT  \
-url=jdbc:h2:mem:testdb -user=sa -schemas=empty info     

docker run harihar2u/project-demo/estore/estore-database:0.0.1-SNAPSHOT  \
-url=jdbc:h2:mem:testdb -user=sa -schemas=empty migrate  

###### flyway postgres info
docker run harihar2u/project-demo/estore/estore-database:0.0.1-SNAPSHOT  \
 -url=jdbc:postgresql://0.0.0.0:32080/postgres \
 -user=postgres -password=postgres -schemas=postgres info   

###### flyway docker
docker run --rm flyway/flyway \
 -url=jdbc:postgresql://db-estore:32080/postgres \
 -user=postgres -password=postgres -schemas=postgres info 
                                