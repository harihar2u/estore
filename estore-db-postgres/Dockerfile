ARG DOCKER_REGISTRY
ARG JAVA_BASE_IMAGE_TAG
ARG ARTIFACT_NAME
ARG FLYWAY_VERSION

FROM flyway/flyway:${FLYWAY_VERSION} as flyway
FROM ${JAVA_BASE_IMAGE_TAG} as java
FROM postgres:10.4 as base

###########################################################################
########    Copy Flyway/java and Migration script             #############
###########################################################################
ARG JAR_FILE
COPY --from=flyway /flyway/ /flyway/
ADD flyway.conf /flyway/conf/flyway.conf
ADD target/flyway/* /flyway/jars/
RUN chown -R root:root /flyway
RUN chmod +x /flyway/*

#Copy Java
COPY --from=java /opt/java/openjdk/ /opt/java/openjdk/

#Flyway migration script
#search.path configutaion for postgre
ADD postgresql.conf /etc/postgresql/postgresql.conf
ADD 01-schemas.sql /docker-entrypoint-initdb.d/
ADD 02-run-flyway.sh /docker-entrypoint-initdb.d/
ADD setup.sh /
RUN chmod +x /setup.sh
RUN chmod +x /setup.sh /docker-entrypoint-initdb.d/*.sh
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_SCHEMA=postgres
USER postgres
RUN /setup.sh postgres

##############################################################
###### final Postgres DB startup script ######################
##############################################################
USER root
FROM postgres:10.4
COPY docker-healthcheck.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-healthcheck.sh
HEALTHCHECK --interval=15s CMD ["docker-healthcheck.sh"]

COPY --from=base /var/lib/postgresql/data/ /var/lib/postgresql/data/
VOLUME /var/lib/postgresql/data/

