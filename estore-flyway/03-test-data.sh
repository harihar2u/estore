#!/bin/sh
export JAVA_HOME=/opt/sdk/java/jdk
export PATH=/opt/sdk/java/jdk/jre/bin:$PATH
java -cp "/home/java/dbunit/dbunit-launcher.jar:/home/java/dbunit/*" \
com.bellid.integrationtest.DbunitLauncher /home/java/dbunit/ \
org.postgresql.Driver asptsm_dev asptsm_dev \
"jdbc:postgresql://localhost:5432/postgres" asptsm_dev
