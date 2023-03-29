-- Mange-til-mange-eksempel forelesning F5

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS f5eks3a CASCADE;
CREATE SCHEMA f5eks3a;
SET search_path TO f5eks3a;

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
  CONSTRAINT deltagelsePK PRIMARY KEY (ansattid,prosjektid),
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
  prosjektdeltagelse(ansattid, prosjektid)
VALUES
  (1, 1),
  (2, 1),
  (2, 2),
  (3, 1),
  (3, 2),
  (4, 1);

  