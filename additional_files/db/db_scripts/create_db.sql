----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Michael Ott
-- Version: 0.1
-- Date:    25.11.2011
-- Zweck:   Erzeugen des Datenbank-Grundgerüsts
----------------------------------------------

CREATE TABLE AdressTyp(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Text varchar(15) NOT NULL DEFAULT 'Neuer Eintrag',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;

INSERT INTO AdressTyp
	(Text) 
VALUES 
	('Kunde'),
	('User'),
	('Superuser'),
	('Developper');


CREATE TABLE Adresse(
	Id int(7) unsigned NOT NULL auto_increment PRIMARY KEY,
	Name varchar(40) NOT NULL DEFAULT '',
	Vorname varchar(40) NOT NULL DEFAULT '',
	Strasse varchar(40) NOT NULL DEFAULT '',
	StrassenNr varchar(5) NULL,
	Zusatzzeile varchar(40) NULL,
	Land varchar(3) NOT NULL DEFAULT 'CHE',
	PLZ varchar(6) NOT NULL DEFAULT '',
	Ort varchar(40) NOT NULL DEFAULT '',
	Mobile varchar(16) NULL,
	TelefonP varchar(16) NULL,
	EMail varchar(50) NOT NULL DEFAULT '',
	Passwort varchar(16) NOT NULL DEFAULT '',
	AdressTyp int(2) unsigned NOT NULL DEFAULT '1',
	FOREIGN KEY (AdressTyp) REFERENCES AdressTyp(Id),
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;


CREATE TABLE PaketKategorie(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Text varchar(15) NOT NULL DEFAULT '',
	Preis decimal(5,2) NOT NULL DEFAULT '0.00',
	GueltigAb date NOT NULL DEFAULT '0000-00-00',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;

INSERT INTO PaketKategorie 
	(Text, Preis, GueltigAb) 
VALUES 
	('Klein', 4.50, '2011-01-01'),
	('Klein', 5.00, '2011-05-01'),
	('Standard', 7.00, '2011-01-01'),
	('Standard', 7.50, '2011-06-01'),
	('Gross', 12.00, '2011-01-01'),
	('Gross', 13.00, '2011-08-01');


CREATE TABLE PaketStatus(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Text varchar(30) NOT NULL DEFAULT 'Neuer Eintrag',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)

ENGINE = INNODB;

INSERT INTO PaketStatus
	(Text) 
VALUES 
	('Unauffindbar'),
	('Eingetroffen'),
	('Eingetroffen / Informiert'),
	('Abgeholt'),
	('Retourniert');

	
CREATE TABLE MahnStatus(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Text varchar(15) NOT NULL DEFAULT 'Neuer Eintrag',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;

INSERT INTO MahnStatus
	(Text) 
VALUES 
	('keine Mahnung'),
	('1. Mahnung'),
	('2. Mahnung'),
	('3. Mahnung'),
	('Inkasso');


CREATE TABLE Lager(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Text varchar(15) NOT NULL DEFAULT 'Neuer Eintrag',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;

INSERT INTO Lager
	(Text) 
VALUES 
	('Lager 1'),
	('Lager 2');


CREATE TABLE Paket(
	Id int(7) unsigned NOT NULL auto_increment PRIMARY KEY,
	Kunde int(7) unsigned NOT NULL DEFAULT '0',
	FOREIGN KEY (Kunde) REFERENCES Adresse(Id),
	Kategorie int(2) unsigned NOT NULL DEFAULT '0',
	FOREIGN KEY (Kategorie) REFERENCES PaketKategorie(Id),
	Status int(2) unsigned NOT NULL DEFAULT '2',
	FOREIGN KEY (Status) REFERENCES PaketStatus(Id),
	BuHaStatus varchar(15) NOT NULL DEFAULT '',
	MahnStatus int(2) unsigned NOT NULL DEFAULT '2',
	FOREIGN KEY (MahnStatus) REFERENCES MahnStatus(Id),
	EingangDatum date NOT NULL DEFAULT '0000-00-00',
	LagerOrt int(2) unsigned NOT NULL DEFAULT '1',
	FOREIGN KEY (LagerOrt) REFERENCES Lager(Id),
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;


CREATE TABLE RgZgStatus(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Text varchar(15) NOT NULL DEFAULT 'Neuer Eintrag',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;

INSERT INTO RgZgStatus
	(Text) 
VALUES 
	('Rg Aktiv'),
	('Rg Storno'),
	('Zg Aktiv'),
	('Zg Storno');


CREATE TABLE RgZgJournal(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Paket int(7) unsigned NOT NULL DEFAULT '0',
	FOREIGN KEY (Paket) REFERENCES Paket(Id),
	Datum date NOT NULL DEFAULT '0000-00-00',
	Total decimal(5,2) NOT NULL DEFAULT '0.00',
	Status int(2) unsigned NOT NULL DEFAULT '1',
	FOREIGN KEY (Status) REFERENCES RgZgStatus(Id),
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)
ENGINE = INNODB;