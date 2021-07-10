#!/usr/bin/env bash

export JAVA_HOME=/opt/java/openjdk
export PATH=/opt/java/openjdk/bin:$PATH
export PATH=/flyway:$PATH

# migrate command
flyway -configFiles=/flyway/conf/flyway-db-estore.conf migrate
