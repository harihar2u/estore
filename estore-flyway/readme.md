docker run --rm flyway/flyway -url=jdbc:h2:mem:testdb -user=sa -schemas=PUBLIC info

docker run --rm \
-v /Users/hchowdhary/Documents/GitProjects/estore/estore-database/src/main/resources/db/migration/h2:/flyway/sql \
flyway/flyway -url=jdbc:h2:mem:testdb -user=sa -schemas=PUBLIC migrate
