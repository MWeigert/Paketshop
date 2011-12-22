----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    20.12.2011
-- Zweck:   Nachträglich die Kundenangaben mutieren
----------------------------------------------


UPDATE `paketshop`.`Adresse`
SET
`Id` = {Id: INT UNSIGNED},
`Name` = {Name: VARCHAR},
`Vorname` = {Vorname: VARCHAR},
`Strasse` = {Strasse: VARCHAR},
`StrassenNr` = {StrassenNr: VARCHAR},
`Zusatzzeile` = {Zusatzzeile: VARCHAR},
`Land` = {Land: VARCHAR},
`PLZ` = {PLZ: VARCHAR},
`Ort` = {Ort: VARCHAR},
`Mobile` = {Mobile: VARCHAR},
`TelefonP` = {TelefonP: VARCHAR},
`EMail` = {EMail: VARCHAR},
`Passwort` = {Passwort: VARCHAR},
`AdressTyp` = {AdressTyp: INT UNSIGNED},
`created` = {created: TIMESTAMP},
`updated` = {updated: TIMESTAMP}
WHERE <where_condition>;
