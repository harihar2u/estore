#!/bin/sh
export JAVA_HOME=/opt/java/openjdk
export PATH=/opt/java/openjdk/bin:$PATH
export PATH=/flyway:$PATH
cd /flyway

######### migrate command with configuration file
flyway -configFiles=/flyway/conf/flyway.conf migrate

######### info command
flyway -configFiles=/flyway/conf/flyway.conf  info
