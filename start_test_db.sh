#!/bin/sh

CONTAINER_NAME="strange_horizon-mariadb"
MYSQL_ROOT_PASSWORD="testdb_pass"

docker rm --force ${CONTAINER_NAME}
docker run --name ${CONTAINER_NAME} \
           --env MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} \
           --publish 3306:3306 \
           --detach \
           --rm \
           mariadb:10.5.11

docker exec --interactive \
            ${CONTAINER_NAME} \
            /bin/sh < wait_for_db.sh \
            && \
docker exec --interactive \
            ${CONTAINER_NAME} \
            sh -c "exec mysql -uroot -p${MYSQL_ROOT_PASSWORD}" < src/main/resources/db_init.sql

docker exec --interactive \
            ${CONTAINER_NAME} \
            sh -c "exec mysql -uroot -p${MYSQL_ROOT_PASSWORD}" < src/main/resources/insert_test_data.sql
