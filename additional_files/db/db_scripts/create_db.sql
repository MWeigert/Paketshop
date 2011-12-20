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
	EMail varchar(50) UNIQUE NOT NULL DEFAULT '',
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


CREATE TABLE Berechtigung(
	Id int(2) unsigned NOT NULL auto_increment PRIMARY KEY,
	Gruppe int(7) unsigned NOT NULL DEFAULT '0',
	FOREIGN KEY (Gruppe) REFERENCES AdressTyp(Id),
	Tabelle varchar(15) NOT NULL DEFAULT '',
	Feld varchar(15) NULL DEFAULT '',
	Aktion varchar(15) NULL DEFAULT '',
	Art varchar(2) NOT NULL DEFAULT '',
	created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated timestamp NOT NULL DEFAULT '0000-00-00'
)

ENGINE = INNODB;

INSERT INTO Berechtigung 
	(Gruppe, Tabelle, Feld, Aktion, Art, created) 
VALUES 
	(1, 'Adresse', 'ID','', 'R', '2011-12-20'),
	(1, 'Adresse', 'Name','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'Vorname','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'Strasse','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'StrasseNr','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'Zusatzzeile','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'Land','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'PLZ','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'Ort','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'Mobile','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'TelefonP','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'EMail','', 'RW', '2011-12-20'),
	(1, 'Adresse', 'Passwort','', 'RW', '2011-12-20'),


	(2, 'Adresse', 'ID','', 'R', '2011-12-20'),
	(2, 'Adresse', 'Name','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'Vorname','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'Strasse','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'StrasseNr','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'Zusatzzeile','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'Land','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'PLZ','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'Ort','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'Mobile','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'TelefonP','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'EMail','', 'RW', '2011-12-20'),
	(2, 'Adresse', 'Passwort','', 'RW', '2011-12-20'),
	
	(2, 'Paket', 'ID','', 'R', '2011-12-20'),
	(2, 'Paket', 'Kunde','', 'RW', '2011-12-20'),
	(2, 'Paket', 'Kategorie','', 'RW', '2011-12-20'),
	(2, 'Paket', 'Status','', 'RW', '2011-12-20'),
	(2, 'Paket', 'Mahnstatus','', 'RW', '2011-12-20'),
	(2, 'Paket', 'EingangDatum','', 'RW', '2011-12-20'),
	(2, 'Paket', 'LagerOrt','', 'RW', '2011-12-20'),
	(2, 'Paket', '','Erfassen', '', '2011-12-20'),
	
	
	(3, 'Adresse', 'ID','', 'R', '2011-12-20'),
	(3, 'Adresse', 'Name','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'Vorname','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'Strasse','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'StrasseNr','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'Zusatzzeile','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'Land','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'PLZ','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'Ort','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'Mobile','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'TelefonP','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'EMail','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'Passwort','', 'RW', '2011-12-20'),
	(3, 'Adresse', 'Typ','', 'RW', '2011-12-20'),
	(3, 'Adresse', '','Erfassen', '', '2011-12-20'),
	(3, 'Adresse', '','Speichern', '', '2011-12-20'),	
	
	(3, 'Paket', 'ID','', 'R', '2011-12-20'),
	(3, 'Paket', 'Kunde','', 'RW', '2011-12-20'),
	(3, 'Paket', 'Kategorie','', 'RW', '2011-12-20'),
	(3, 'Paket', 'Status','', 'RW', '2011-12-20'),
	(3, 'Paket', 'Mahnstatus','', 'RW', '2011-12-20'),
	(3, 'Paket', 'EingangDatum','', 'RW', '2011-12-20'),
	(3, 'Paket', 'LagerOrt','', 'RW', '2011-12-20'),
	(3, 'Paket', '','Erfassen', '', '2011-12-20'),
	(3, 'Paket', '','Speichern', '', '2011-12-20'),
	(3, 'Paket', '','Loeschen', '', '2011-12-20'),
	
	(3, 'PaketKategorie', 'ID','', 'R', '2011-12-20'),
	(3, 'PaketKategorie', 'Text','', 'RW', '2011-12-20'),
	(3, 'PaketKategorie', 'Preis','', 'RW', '2011-12-20'),
	(3, 'PaketKategorie', 'GueltigAb','', 'RW', '2011-12-20'),
	(3, 'PaketKategorie', '','Erfassen', '', '2011-12-20'),
	(3, 'PaketKategorie', '','Speichern', '', '2011-12-20'),
	
	(3, 'Lager', 'ID','', 'R', '2011-12-20'),
	(3, 'Lager', 'Text','', 'RW', '2011-12-20'),
	(3, 'Lager', '','Erfassen', 'RW', '2011-12-20'),
	(3, 'Lager', '','Speichern', 'RW', '2011-12-20'),
	
	(3, 'Berechtigung', 'ID','', 'R', '2011-12-20'),
	(3, 'Berechtigung', 'Gruppe','', 'RW', '2011-12-20'),
	(3, 'Berechtigung', 'Tabelle','', 'RW', '2011-12-20'),
	(3, 'Berechtigung', 'Feld','', 'RW', '2011-12-20'),
	(3, 'Berechtigung', 'Aktion','', 'RW', '2011-12-20'),
	(3, 'Berechtigung', 'Art','', 'RW', '2011-12-20'),
	(3, 'Berechtigung', '','Erfassen', '', '2011-12-20'),
	(3, 'Berechtigung', '','Speichern', '', '2011-12-20'),
	(3, 'Berechtigung', '','Loeschen', '', '2011-12-20');