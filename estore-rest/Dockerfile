ARG DOCKER_REGISTRY
ARG JAVA_BASE_IMAGE_TAG
ARG ARTIFACT_NAME

FROM ${JAVA_BASE_IMAGE_TAG} as builder
ARG JAR_FILE

WORKDIR application
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM ${JAVA_BASE_IMAGE_TAG}
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

EXPOSE 8082
HEALTHCHECK --timeout=30s --interval=30s --retries=10 --start-period=15s \
CMD curl -m 30 -f -s http://localhost:8082/health || exit 1


