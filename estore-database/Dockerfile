ARG DOCKER_REGISTRY
ARG JAVA_BASE_IMAGE_TAG
ARG ARTIFACT_NAME
ARG FLYWAY_VERSION=7.3.2

FROM java:8-jdk-alpine

WORKDIR /flyway
RUN apk add --update openssl
RUN apk update && apk add bash
ARG STATIC_ARTIFACT_SOURCE=https://repo1.maven.org/maven2/org/flywaydb

RUN wget https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/7.3.2/flyway-commandline-7.3.2.tar.gz  \
  && tar -xzf flyway-commandline-7.3.2.tar.gz \
  && mv flyway-7.3.2/* . \
  && rm flyway-commandline-7.3.2.tar.gz

ADD flyway.conf /flyway/conf/flyway.conf


# FROM postgres:10.4
# ADD postgresql.conf /etc/postgresql/postgresql.conf
# ADD 01-schemas.sql /docker-entrypoint-initdb.d/
# ADD 02-run-flyway.sh /docker-entrypoint-initdb.d/
# ADD setup.sh /
# RUN chmod +x /setup.sh
# RUN chmod +x /setup.sh /docker-entrypoint-initdb.d/*.sh
# ENV POSTGRES_USER=postgres
# ENV POSTGRES_DB=postgres
# ENV POSTGRES_PASSWORD=postgres
#
# USER postgres
# RUN /setup.sh postgres














