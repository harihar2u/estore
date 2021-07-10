ARG DOCKER_REGISTRY
ARG JAVA_BASE_IMAGE_TAG
ARG ARTIFACT_NAME
ARG FLYWAY_VERSION


FROM ${JAVA_BASE_IMAGE_TAG} as java
FROM flyway/flyway:${FLYWAY_VERSION}

####################################################
######## Add flyway configuration      #############
####################################################
ARG JAR_FILE
USER root
COPY --from=java /opt/java/openjdk/ /opt/java/openjdk/

ADD flyway-db-estore.conf /flyway/conf/flyway-db-estore.conf
ADD target/flyway/* /flyway/jars/
RUN chown -R root:root /flyway
RUN chmod +x /flyway/*

####################################################
#### execute migration command          ############
####################################################
ENV JAVA_HOME="/opt/java/openjdk"
ENV PATH="/opt/java/openjdk/bin:$PATH"
ENV PATH="/flyway:${PATH}"

ENTRYPOINT ["flyway"]
CMD ["-?"]

####################################################
#### execute migration extended command ############
####################################################
#COPY entrypoint.sh /entrypoint.sh
#COPY runMigration.sh /runMigration.sh
#
#RUN chown -R root:root /entrypoint.sh
#RUN chown -R root:root /runMigration.sh
#RUN chmod +x /entrypoint.sh
#RUN chmod +x /runMigration.sh
#
#ENTRYPOINT ["/entrypoint.sh"]
#CMD [""]