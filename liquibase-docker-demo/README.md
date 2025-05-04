# Liquibase Docker Demo Project

A database migration tool using Liquibase and PostgreSQL, packaged in a Docker container using Google Jib.

## Prerequisites

- Java 21
- Maven 3.9+
- Docker
- PostgreSQL database

## Project Structure

```
liquibase-docker-demo/
├── src/
│   └── main/
│       └── resources/
│           ├── db/
│           │   └── changelog/
│           │       ├── db.changelog-master.xml
│           │       └── changes/
│           │           └── 001-create-sample-table.xml
│           └── liquibase.properties
├── pom.xml
└── README.md
```

## Database Schema

The project creates a sample table with the following structure:

- `sample_table`
  - Column `a`: VARCHAR(255), not null
  - Column `b`: INTEGER, not null

## Building the Project

1. Navigate to the project directory:
   ```bash
   cd liquibase-docker-demo
   ```

2. Build the project using Maven:
   ```bash
   mvn clean package
   ```

## Running Locally with Maven

You can run Liquibase migrations directly using Maven with properties:

```bash
mvn liquibase:update \
  -Ddb.url="jdbc:postgresql://localhost:5432/mydb" \
  -Ddb.username="postgres" \
  -Ddb.password="password" \
  -Ddb.schema="public"
```

To use a different changelog file:

```bash
mvn liquibase:update \
  -Dliquibase.url=jdbc:postgresql://localhost:5432/postgres \
  -Dliquibase.username=postgres \
  -Dliquibase.password=mysecretpassword \
  -Dliquibase.searchPath=src/main/resources \
  -Dliquibase.changeLogFile=db/changelog/db.changelog-master.xml 
  ```

## Building and Running with Docker

The project uses Google Jib for containerisation. To build and run the container:

1. Build the Docker image:
   ```bash
   mvn compile jib:dockerBuild
   ```

2. Run the container with environment variables:
   ```bash
   docker run -it \
     -e DB_URL="jdbc:postgresql://your-db-host:5432/your-database" \
     -e DB_USERNAME="your-username" \
     -e DB_PASSWORD="your-password" \
     -e DB_SCHEMA="your-schema" \
     -e CHANGELOG_FILE="db/changelog/db.changelog-master.xml" \
     liquibase-docker-demo:1.0-SNAPSHOT
   ```

### Properties and Environment Variables

The following properties/environment variables are required:

1. `db.url` / `DB_URL`: JDBC connection URL for your PostgreSQL database
   - Format: `jdbc:postgresql://host:port/database`
   - Example: `jdbc:postgresql://localhost:5432/mydb`

2. `db.username` / `DB_USERNAME`: Database username
   - Example: `postgres`

3. `db.password` / `DB_PASSWORD`: Database password
   - Example: `your-secure-password`

4. `db.schema` / `DB_SCHEMA`: Target schema name
   - Example: `public`

5. `liquibase.changeLogFile` / `CHANGELOG_FILE`: Path to the Liquibase changelog file
   - Default: `db/changelog/db.changelog-master.xml`

### Example Usage

```bash
# Using default changelog file from resources
docker run -it \
  -e DB_URL="jdbc:postgresql://localhost:5432/mydb" \
  -e DB_USERNAME="postgres" \
  -e DB_PASSWORD="password" \
  -e DB_SCHEMA="public" \
  -e CHANGELOG_FILE="db/changelog/db.changelog-master.xml" \
  liquibase-docker-demo:1.0-SNAPSHOT

# Using external changelog file (mounted as volume)
docker run -it \
  -v /path/to/your/changelog:/app/changelog \
  -e DB_URL="jdbc:postgresql://localhost:5432/mydb" \
  -e DB_USERNAME="postgres" \
  -e DB_PASSWORD="password" \
  -e DB_SCHEMA="public" \
  -e CHANGELOG_FILE="changelog/db.changelog-master.xml" \
  liquibase-docker-demo:1.0-SNAPSHOT
```

## Features

- Java 21 support using Eclipse Temurin JDK
- Liquibase 4.25.0 for database migrations
- PostgreSQL 42.7.1 driver
- Docker containerisation using Google Jib
- Schema isolation
- Secure credential handling through Maven properties and environment variables
- External changelog file support
- Maven-based execution

## Security Notes

- Database credentials are passed via Maven properties or environment variables
- No hardcoded credentials in the code
- Properties can be managed securely in your deployment environment
- Schema isolation for better security
- Changelog files can be mounted as volumes for external management

## Troubleshooting

If you encounter any issues:

1. Verify your database connection details
2. Ensure the PostgreSQL server is running and accessible
3. Check that the specified schema exists
4. Verify that the user has necessary permissions
5. Confirm the changelog file path is correct and accessible
6. Check Maven and Docker logs for detailed error messages
7. Ensure all required properties/environment variables are set
8. Verify that the properties/environment variables are being passed correctly
9. Check that the Maven resource filtering is working correctly

## License

This project is open-source and available under the MIT License. 