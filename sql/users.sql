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
, username              VARCHAR(100)     NOT NULL     UNIQUE
--, domain                VARCHAR(100)    NOT NULL
, access                VARCHAR(10)     NOT NULL      DEFAULT 'read' CHECK(access IN ('read','classify','admin'))
, name                  VARCHAR(100)
);

INSERT INTO users (username, access, name) VALUES ('dmheggo@uio.no','admin','Dan Michael Heggø');
INSERT INTO users (username, access, name) VALUES ('ewinge@uio.no','admin','Erik Winge');

--Alter table users alter column access set default 'read';
