-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = f2person
        -- Tabell(er) = person 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS f2person CASCADE;

CREATE SCHEMA f2person;
SET search_path TO f2person;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE IF EXISTS person CASCADE;

CREATE TABLE person
(
    id integer PRIMARY KEY,
    navn VARCHAR(30) NOT NULL
);

INSERT INTO
  person(id, navn)
VALUES
    (1001, 'Per Viskeler'),
    (1002, 'Atle Patle'),
    (1003, 'Donald Duck');

