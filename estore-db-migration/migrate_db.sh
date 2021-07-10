#!/usr/bin/env bash

export $(cat .env | xargs)

# Pull the Latest Images
docker pull $DOCKER_REGISTRY/estore-postgres:$ESTORE_VERSION

# Wait for DBs to be ready
declare -A migrate_command
dblist=( "db-estore")
migrate_command["db-tkm"]='docker run --rm $DOCKER_REGISTRY/tkm/db_migration:$TKM_VERSION -url=jdbc:postgresql://db-estore:5432/postgres -configFile=conf/flyway-db-estore.conf migrate'

for dbname in "${dblist[@]}"
do
  retry_count=0
  until
    docker run -i postgres psql -h $dbname -U postgres -c "select 1" > /dev/null 2>&1;
  do
    retry_count+=1;
    if [ $retry_count -gt 15 ]
      then
        echo "One of the DB was not up, Migrations not successfully applied to all DBs"
        exit 1;
        break 2;
    fi
    sleep 2;
  done
  eval ${migrate_command[$dbname]}
done