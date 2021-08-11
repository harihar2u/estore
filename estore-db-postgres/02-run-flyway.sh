#!/bin/sh
export JAVA_HOME=/opt/java/openjdk
export PATH=/opt/java/openjdk/bin:$PATH
export PATH=/flyway:$PATH

######### migrate command with configuration file
/flyway/flyway -configFiles=/flyway/conf/flyway.conf -connectRetries=5 -lockRetryCount=5  migrate

######### info command
/flyway/flyway -configFiles=/flyway/conf/flyway.conf  info
