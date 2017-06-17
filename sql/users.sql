--DROP TABLE IF EXISTS group_memberships ;
--DROP TABLE IF EXISTS groups ;
--DROP TABLE IF EXISTS mappings ;
--DROP TABLE IF EXISTS external_vocabularies ;
--DROP TABLE IF EXISTS terms;
--DROP TABLE IF EXISTS strings;
--DROP TABLE IF EXISTS relationships;
--DROP TABLE IF EXISTS concepts;
--DROP TABLE IF EXISTS vocabularies;
--DROP TABLE IF EXISTS languages;
--DROP TABLE IF EXISTS users;

CREATE TABLE users
( user_id               SERIAL          PRIMARY KEY
, created               TIMESTAMP(0)    NOT NULL      DEFAULT CURRENT_TIMESTAMP
, created_by            INT                           REFERENCES users(user_id)
, username              VARCHAR(100)     NOT NULL
--, domain                VARCHAR(100)    NOT NULL
, name                  VARCHAR(100)
, UNIQUE(username, domain)
);

INSERT INTO users (username, name) VALUES ('dmheggo@uio.no',' Dan Michael Heggø');
INSERT INTO users (username, name) VALUES ('ewinge@uio.no','Erik Winge');
