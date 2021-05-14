#!/bin/bash

# Create a temporary directory to store the statuses
dir=$(mktemp -d)
# Run it like sh wait-for-services.sh localhost:8000,localhost:8001
for serviceEndpoint in $(echo $WAIT_SERVICES_LIST | sed "s/,/ /g")
do
    # call wait-for-it and store the results under temp dir
    { /wait-for-it.sh $serviceEndpoint --timeout=$TIMEOUT ; echo "$?" > "$dir/$BASHPID" ; } &

done

wait;

# Get return information for each pid
if [ "$(ls -A $dir)" ];
then
  for file in "$dir"/*; do
      if [ $(<"$file") -ne 0 ]; then
        echo "Service(s) is not up, exit with non-zero"
        exit $(<"$file")
      fi
  done
fi

gradle --offline -g /home/gradle/tg_tests/.gradle_cache -i -s -Dbrowser=chromeRemoteDriver -Dtest.environment=docker_build :token-gateway:cleanTest :token-gateway:testDefaultDocker --continue --tests "$@"
