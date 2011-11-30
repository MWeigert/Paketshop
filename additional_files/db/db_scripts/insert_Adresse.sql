----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    29.11.2011
-- Zweck:   Erzeugen eines neuen Datensatzes in der Tabelle Adresse (d.h. Registrierung eine neuen Benutzers)
----------------------------------------------

INSERT INTO `paketshop`.`Adresse`
(`Id`,
`Name`,
`Vorname`,
`Strasse`,
`StrassenNr`,
`Zusatzzeile`,
`Land`,
`PLZ`,
`Ort`,
`Mobile`,
`TelefonP`,
`EMail`,
`Passwort`,
`AdressTyp`,
`created`,
`updated`)
VALUES
(
{Id: INT UNSIGNED},
{Name: VARCHAR},
{Vorname: VARCHAR},
{Strasse: VARCHAR},
{StrassenNr: VARCHAR},
{Zusatzzeile: VARCHAR},
{Land: VARCHAR},
{PLZ: VARCHAR},
{Ort: VARCHAR},
{Mobile: VARCHAR},
{TelefonP: VARCHAR},
{EMail: VARCHAR},
{Passwort: VARCHAR},
{AdressTyp: INT UNSIGNED},
{created: TIMESTAMP},
{updated: TIMESTAMP}
);