ARG DOCKER_REGISTRY
ARG JAVA_BASE_IMAGE_TAG
ARG ARTIFACT_NAME

FROM ${JAVA_BASE_IMAGE_TAG}
# ADD target/${ARTIFACT_NAME}.jar /opt/app/java/app.jar
ADD target/estore-auth-rest-0.0.1-SNAPSHOT.jar /opt/app/java/app.jar

EXPOSE 8083
WORKDIR /opt/app/java
CMD "java" "-jar" "app.jar"

HEALTHCHECK --timeout=30s --interval=30s --retries=10 --start-period=15s \
CMD curl -m 30 -f -s http://localhost:8083/health || exit 1


