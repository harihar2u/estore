ARG DOCKER_REGISTRY
FROM postgres:10.4
ADD postgresql.conf /etc/postgresql/postgresql.conf
ADD schemas.sql /docker-entrypoint-initdb.d/
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=postgres
ENV POSTGRES_PASSWORD=postgres