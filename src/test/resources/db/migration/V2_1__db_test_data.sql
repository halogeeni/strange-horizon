/* Insert test data into database. File named with V2-prefix, to ensure this migration is run last */

INSERT INTO artists (name, description) VALUES ('You Can''t Keep Me Down', 'Dark Ojamo Hardcore');
INSERT INTO artists (name, description) VALUES (N'Vässykät', 'Melodic Punk Rock');
INSERT INTO artists (name, description) VALUES ('Vile Fate', 'TKU-LOHJA 4 LIFE!');
INSERT INTO artists (name, description) VALUES ('Born To Cry', 'Doom Hardcore');

INSERT INTO releases (release_date, catalog_number, name, description) VALUES ('2014-05-05', 'SHZ001 / PSR016', 'Cold Dark Mind', 'Heavy Tormenting Hardcore');
INSERT INTO releases (release_date, catalog_number, name, description) VALUES ('2015-05-05', 'SHZ002', 'On yksin', 'Debut of great punk band');
INSERT INTO releases (release_date, catalog_number, name, description) VALUES ('2016-06-01', 'SHZ003', 'Demonstration Of Maleficium', 'Never to wake...');
INSERT INTO releases (release_date, catalog_number, name, description) VALUES ('2016-05-05', 'SHZ004', 'On pahoillaan', N'Vässykät re-invents itself!');
INSERT INTO releases (release_date, catalog_number, name, description) VALUES ('2018-05-05', 'SHZ005', 's/t', 'In the vein of Life Of Agony');

INSERT INTO releases_to_artists (artist_id, release_id)
VALUES ((SELECT id FROM artists WHERE name = 'You Can''t Keep Me Down'),
        (SELECT id FROM releases WHERE name = 'Cold Dark Mind'));

INSERT INTO releases_to_artists (artist_id, release_id)
VALUES ((SELECT id FROM artists WHERE name = N'Vässykät'),
        (SELECT id FROM releases WHERE name = 'On yksin'));

INSERT INTO releases_to_artists (artist_id, release_id)
VALUES ((SELECT id FROM artists WHERE name = N'Vässykät'),
        (SELECT id FROM releases WHERE name = 'On pahoillaan'));

INSERT INTO releases_to_artists (artist_id, release_id)
VALUES ((SELECT id FROM artists WHERE name = 'Vile Fate'),
        (SELECT id FROM releases WHERE name = 'Demonstration Of Maleficium'));

INSERT INTO releases_to_artists (artist_id, release_id)
VALUES ((SELECT id FROM artists WHERE name = 'Born To Cry'),
        (SELECT id FROM releases WHERE name = 's/t'));
