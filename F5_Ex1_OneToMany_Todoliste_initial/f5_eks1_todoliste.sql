-- SQL for en-til-mange-eksemplet gjennomgått i F5 ...

DROP SCHEMA IF EXISTS f5eks1 CASCADE;
CREATE SCHEMA f5eks1;
SET search_path TO f5eks1;
    
CREATE TABLE todoliste
(
    id		SERIAL PRIMARY KEY,
    navn	VARCHAR
);

CREATE TABLE todo
(
    id      SERIAL PRIMARY KEY,
    tekst   VARCHAR,
    listeid INTEGER,
    CONSTRAINT listeFK FOREIGN KEY (listeid) REFERENCES todoliste(id)
);

