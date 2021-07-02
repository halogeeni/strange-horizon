#!/bin/sh
MYSQL_USER="root"
MYSQL_PASSWORD="testdb_pass"
counter=1
maxcounter=45

while ! mysql --protocol TCP -u "${MYSQL_USER}" -p"${MYSQL_PASSWORD}" -e "SHOW DATABASES;" > /dev/null 2>&1; do
    sleep 1
    counter=$((counter + 1))
    if [ "$counter" -gt $maxcounter ]; then
        >&2 echo "We have been waiting for MariaDB too long already; failing."
        exit 1
    fi;
done
