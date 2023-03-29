-- Mange-til-en-til-mange-eksempel forelesning F5

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS f5eks3b CASCADE;
CREATE SCHEMA f5eks3b;
SET search_path TO f5eks3b;

CREATE TABLE ansatt
(
  id         SERIAL PRIMARY KEY,
  fornavn    VARCHAR(30),
  etternavn  VARCHAR(30)
);

CREATE TABLE prosjekt
(
  id        SERIAL PRIMARY KEY,
  navn      VARCHAR(30)
);

-- Mange-til-mange må løses med en koblingstabell, slik:
CREATE TABLE prosjektdeltagelse
(
  ansattid INTEGER,
  prosjektid INTEGER,
  timer INTEGER,
  CONSTRAINT deltagelsePK PRIMARY KEY (ansattid, prosjektid),
  CONSTRAINT ansattFK FOREIGN KEY (ansattid) REFERENCES ansatt(id),
  CONSTRAINT prosjektFK FOREIGN KEY (prosjektid) REFERENCES prosjekt(id)  
);

INSERT INTO
  ansatt(fornavn, etternavn)
VALUES
  ('Arne', 'Arnesen'),
  ('Brit', 'Britsen'),
  ('Carl', 'Carlsen'),
  ('Donald', 'Duck');

INSERT INTO
  prosjekt(navn)
VALUES
  ('Trivselsprosjektet'),
  ('Synergiprosjektet'),
  ('Utviklingsprosjektet');

INSERT INTO
  prosjektdeltagelse(ansattid, prosjektid, timer)
VALUES
  (1, 1, 0),
  (2, 1, 0),
  (2, 2, 0),
  (3, 1, 0),
  (3, 2, 0),
  (4, 1, 0);

   