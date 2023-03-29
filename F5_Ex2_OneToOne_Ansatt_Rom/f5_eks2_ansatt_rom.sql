-- SQL for en-til-en-eksemplet gjennomgått i F5

-- Muligheter:
-- 		Uten koblingstabell, FK på en av sidene.
-- 		Koblingstabell for en-til-en-forhold er mulig, men gjør ting mer komplisert.
-- 		Slå sammen tabellene?

-- Hvis vi velger FK i Ansatt = RomNr vil ansatte uten kontor ha NULL for denne.
-- Hvis vi velger FK i Rom = AnsNr vil rom uten ansatt ha NULL for denne.
-- Velger å legge FK i Ansatt


DROP SCHEMA IF EXISTS f4eks2 CASCADE;
CREATE SCHEMA f4eks2;
SET search_path TO f4eks2;
    
CREATE TABLE rom
(
    romnr       CHAR(4) PRIMARY KEY,
    kvm         FLOAT
);

CREATE TABLE ansatt
(
    ansattnr    SERIAL PRIMARY KEY,
    fornavn     CHAR(20),
    etternavn   CHAR(20),
    kontor      CHAR(4),
    CONSTRAINT kontorFK FOREIGN KEY (kontor) REFERENCES rom(romnr)
);

INSERT INTO
  rom(romnr, kvm)
VALUES
    ('E425', 10.5),
    ('F118', 120.4),
    ('E404', 12.3);

INSERT INTO
  ansatt(fornavn, etternavn, kontor)
VALUES
    ('Atle', 'Atlesen', 'E425'),
    ('Carsten', 'Carstensen', NULL), -- Carsten har ikke kontor
    ('Lars', 'Larsen', 'E404');
    
