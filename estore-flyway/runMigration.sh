#!/usr/bin/env bash

java -cp "/home/java/dbunit/dbunit-launcher.jar:/home/java/dbunit/*" com.bellid.integrationtest.DbunitLauncher \
/home/java/dbunit/ $DRIVER $USER $PASSWORD $URL $SCHEMA
