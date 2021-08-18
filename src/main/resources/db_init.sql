CREATE DATABASE strange_horizon CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE strange_horizon.artists (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL, description TEXT) CHARACTER SET 'utf8';
CREATE TABLE strange_horizon.releases (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL, release_date DATE NOT NULL, description TEXT) CHARACTER SET 'utf8' ;
CREATE TABLE strange_horizon.releases_to_artists (id INT AUTO_INCREMENT PRIMARY KEY, release_id INT NOT NULL, artist_id INT NOT NULL, FOREIGN KEY (release_id) REFERENCES strange_horizon.releases (id), FOREIGN KEY (artist_id) REFERENCES strange_horizon.artists (id)) CHARACTER SET 'utf8';

GRANT SELECT ON strange_horizon.* TO 'api_read'@'localhost' IDENTIFIED BY 'api_read_pass';
GRANT SELECT ON strange_horizon.* TO 'api_read'@'%' IDENTIFIED BY 'api_read_pass';
