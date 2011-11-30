----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    29.11.2011
-- Zweck:   Erzeugen eines neuen Datensatzes in der Tabelle MahnStatus
----------------------------------------------

INSERT INTO `paketshop`.`MahnStatus`
(`Id`,
`Text`,
`created`,
`updated`)
VALUES
(
{Id: INT UNSIGNED},
{Text: VARCHAR},
{created: TIMESTAMP},
{updated: TIMESTAMP}
);
