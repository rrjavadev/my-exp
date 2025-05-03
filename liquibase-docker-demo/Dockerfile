# This Dockerfile is provided for reference only
# The project uses Google Jib for containerisation
# To build the image, use: mvn compile jib:dockerBuild

FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Create a volume for external changelog files
VOLUME /app/external-changelog

# Set default environment variables
ENV DB_URL=jdbc:postgresql://localhost:5432/mydb
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=password
ENV DB_SCHEMA=public
ENV CHANGELOG_FILE=db/changelog/db.changelog-master.xml

# Create a script to run Liquibase
COPY <<EOF /app/run-liquibase.sh
#!/bin/bash
# Update liquibase.properties with environment variables
cat > /app/src/main/resources/liquibase.properties <<EOL
driver=org.postgresql.Driver
url=${DB_URL}
username=${DB_USERNAME}
password=${DB_PASSWORD}
defaultSchemaName=${DB_SCHEMA}
EOL

# Run Liquibase update
mvn liquibase:update -Dliquibase.changeLogFile=${CHANGELOG_FILE}
EOF

RUN chmod +x /app/run-liquibase.sh

ENTRYPOINT ["/app/run-liquibase.sh"] 