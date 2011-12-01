----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    29.11.2011
-- Zweck:   Erzeugen eines neuen Datensatzes in der Tabelle RgZgJournal
----------------------------------------------

INSERT INTO `paketshop`.`RgZgJournal`
(`Id`,
`Paket`,
`Datum`,
`Total`,
`Status`,
`created`,
`updated`)
VALUES
(
{Id: INT UNSIGNED},
{Paket: INT UNSIGNED},
{Datum: DATE},
{Total: DECIMAL},
{Status: INT UNSIGNED},
{created: TIMESTAMP},
{updated: TIMESTAMP}
);
