DROP SCHEMA IF EXISTS oving1 CASCADE;
CREATE SCHEMA oving1;
SET search_path TO Oving1;

CREATE TABLE ansatt (
    brukernavn VARCHAR(4) PRIMARY KEY,
    fornavn VARCHAR(25) NOT NULL,
    etternavn VARCHAR(25) NOT NULL,
    ansettelsesdato DATE NOT NULL,
    stilling VARCHAR(45) NOT NULL,
    maanedslonn DECIMAL(10, 2) NOT NULL CHECK (maanedslonn > 0));
    
INSERT INTO ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn)
VALUES  ('stor', 'Storm', 'DenGode', '01.01.1', 'Smarting', '69420'),
        ('bjør', 'Bjørnar', 'Bjøøøøørn', '12.12.12', 'Super Stilling', '1234'),
        ('bell', 'Kristian', 'Bellting', '05.05.50', 'Polakk', '2'),
        ('rob', 'Robåt', 'Robåter', '10.10.2021', 'Idot', '53');
        
SELECT * FROM ansatt; 
 