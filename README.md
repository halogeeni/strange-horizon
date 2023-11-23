# strange-horizon-api
[![GitHub](https://img.shields.io/github/license/halogeeni/strange-horizon-api)](https://github.com/halogeeni/strange-horizon-api/blob/master/LICENSE.md)

API for Strange Horizon record label. Work in progress.

This is also an experiment to work with new Java goodies:
* Java 17
* Spring Boot 2.7
* JUnit 5

## Tests
Run unit & integration tests via Maven with `mvn clean test`

## Docker
Both database and API containers can be started via:
```
docker-compose up
```
API container is configured to wait for DB to be healthy before launch.
Otherwise, Spring Boot would fail initialization on startup.

Running only DB container is also possible:
```
docker-compose up db
```
API can then be run locally against the DB container for development purposes.

Dummy test data can be populated to DB container for development purposes:
```sh
docker-compose exec -T db psql --username postgres --dbname=strange_horizon < src/test/resources/db/migration/V2_1__db_test_data.sql
```
