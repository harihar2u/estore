ARG DOCKER_REGISTRY
ARG JAVA_BASE_IMAGE_TAG
ARG ARTIFACT_NAME
ARG FLYWAY_VERSION

FROM ${JAVA_BASE_IMAGE_TAG} as java
FROM flyway/flyway:${FLYWAY_VERSION} as flyway
FROM postgres:10.4 as postgres
ARG JAR_FILE

USER root
####################################################
########     JAVA                      #############
####################################################
COPY --from=java /opt/java/openjdk /opt/java/openjdk

####################################################
########     Flyway configuration      #############
####################################################
COPY --from=flyway /flyway /flyway

ADD ${JAR_FILE} /flyway/jars/
ADD flyway-estore.conf /flyway/conf/flyway-estore.conf
RUN chown -R root:root /flyway
RUN chmod +x /flyway/*

#########################################################
####### Postgres DB startup script ######################
#########################################################
ADD postgresql.conf /etc/postgresql/postgresql.conf
ADD 01-schemas.sql /docker-entrypoint-initdb.d/
ADD 02-run-flyway.sh /docker-entrypoint-initdb.d/
ADD setup.sh /
RUN chmod +x /setup.sh
RUN chmod +x /setup.sh /docker-entrypoint-initdb.d/*.sh
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=postgres
ENV POSTGRES_PASSWORD=postgres

USER postgres
RUN /setup.sh postgres














