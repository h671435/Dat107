-- SQL for en-til-mange-eksemplet gjennomgått i timen onsdag 22. mars 2023 

DROP SCHEMA IF EXISTS forelesning3 CASCADE;
CREATE SCHEMA forelesning3;
SET search_path TO forelesning3;
    
CREATE TABLE vitnemal
(
	studnr INTEGER,
	studiestart DATE NOT NULL,
	studieslutt DATE,
	CONSTRAINT vitnemalPK PRIMARY KEY (studnr)
);

CREATE TABLE karakter
(
	karnr SERIAL,
	emnekode CHAR(6) NOT NULL,
	eksdato DATE NOT NULL,
	bokstav CHAR(1),
	studnr INTEGER NOT NULL,
	CONSTRAINT narakterPK PRIMARY KEY (karnr),
	CONSTRAINT karUnique UNIQUE (emnekode, studnr),
	CONSTRAINT vitnemalFK FOREIGN KEY (studnr) 
		REFERENCES Vitnemal(StudNr)
);

INSERT INTO
  vitnemal(studnr, studiestart, studieslutt)
VALUES
    (123456, '2021-08-15', '2024-06-15'),
    (234567, '2021-08-15', NULL), -- Er ikke ferdig ennå
    (345678, '2021-08-15', '2024-06-15');

-- NB! Databasen genererer selv primærnøkler. De skal ikke oppgis ved INSERT.    
INSERT INTO
  karakter(emnekode, eksdato, bokstav, studnr)
VALUES
    ('DAT107', '2022-05-30', 'A', 123456),
    ('DAT102', '2022-06-04', 'A', 123456),
    ('DAT107', '2022-05-30', 'B', 234567);

    
-- Finne liste av DAT107-karakterer for studenter som er
-- ferdig (har sluttdato). Forventer kun denne:
-- 		(1, DAT107, '2022-05-30', 'A', 123456)
SELECT k.* 
FROM karakter AS k 
--	JOIN vitnemal AS v ON k.studnr = v.studnr
--  evt.
NATURAL JOIN vitnemal AS v
WHERE v.studieslutt IS NOT NULL
AND k.emnekode LIKE 'DAT107';
   

    
    
    
    