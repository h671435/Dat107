-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = f2todo
        -- Tabell(er) = todo 

-- FARE !!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS f2todo CASCADE;
CREATE SCHEMA f2todo;
SET search_path TO f2todo;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE IF EXISTS todo CASCADE;

CREATE TABLE todo
(
    id INTEGER PRIMARY KEY,
    tekst VARCHAR NOT NULL
);

INSERT INTO
  todo(id, tekst)
VALUES
    (1, 'Handle mat'),
    (2, 'Vaske opp'),
    (3, 'Ta ut bosset');

SELECT * FROM todo;
    