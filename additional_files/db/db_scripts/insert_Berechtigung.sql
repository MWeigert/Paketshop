----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Michael Ott
-- Version: 0.1
-- Date:    20.12.2011
-- Zweck:   Erzeugen eines neuen Datensatzes in der Tabelle Berechtigung
----------------------------------------------

INSERT INTO `paketshop`.`Berechtigung`
(`Id`,
`Gruppe`,
`Tabelle`,
`Feld`,
`Action`,
`created`,
`updated`)
VALUES
(
{Id: INT UNSIGNED},
{Gruppe: INT UNSIGNED},
{Tabelle: VARCHAR},
{Feld: VARCHAR},
{Action: VARCHAR},
{created: TIMESTAMP},
{updated: TIMESTAMP}
);
