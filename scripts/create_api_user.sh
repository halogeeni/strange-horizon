#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER api_read WITH PASSWORD 'api_read_pass';
	GRANT pg_read_all_data TO api_read;
EOSQL
