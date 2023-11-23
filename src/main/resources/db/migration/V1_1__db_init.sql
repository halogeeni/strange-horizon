CREATE TABLE artists (id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL, description TEXT, UNIQUE(name));
CREATE TABLE releases (id SERIAL PRIMARY KEY, catalog_number VARCHAR(255) NOT NULL, name VARCHAR(100) NOT NULL, release_date DATE NOT NULL, description TEXT, UNIQUE(catalog_number));
CREATE TABLE releases_to_artists (id SERIAL PRIMARY KEY, release_id INTEGER NOT NULL REFERENCES releases(id), artist_id INTEGER NOT NULL REFERENCES artists(id));
