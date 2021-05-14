ARG DOCKER_REGISTRY
ARG JAVA_BASE_IMAGE_TAG


FROM java:8-jdk-alpine

RUN apk add --update openssl
RUN apk update && apk add bash

WORKDIR /flyway
ARG FLYWAY_VERSION=7.3.2
ARG STATIC_ARTIFACT_SOURCE=https://repo1.maven.org/maven2/org/flywaydb

RUN wget https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/${FLYWAY_VERSION}/flyway-commandline-${FLYWAY_VERSION}.tar.gz  \
  && tar -xzf flyway-commandline-${FLYWAY_VERSION}.tar.gz \
  && mv flyway-${FLYWAY_VERSION}/* . \
  && rm flyway-commandline-${FLYWAY_VERSION}.tar.gz

# ADD target/jars/* /flyway/jars/
# ADD target/drivers/* /flyway/drivers/
# #Fix for https://github.com/flyway/flyway/issues/628
# ADD target/lib/* /flyway/lib/community/
# ADD target/lib/* /flyway/lib/pro/
# ADD target/jars/* /flyway/lib/community/
# ADD target/jars/* /flyway/lib/pro/

ADD flyway.conf /flyway/conf/flyway.conf

ENV PATH="/flyway:${PATH}"

ENTRYPOINT ["flyway"]
CMD ["-?"]