----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    29.11.2011
-- Zweck:   Erzeugen eines neuen Datensatzes in der Tabelle Paket (d.h. Erfassen eines neuen Pakets)
----------------------------------------------

INSERT INTO `paketshop`.`Paket`
(`Id`,
`Kunde`,
`Kategorie`,
`Status`,
`BuHaStatus`,
`MahnStatus`,
`EingangDatum`,
`LagerOrt`,
`created`,
`updated`)
VALUES
(
{Id: INT UNSIGNED},
{Kunde: INT UNSIGNED},
{Kategorie: INT UNSIGNED},
{Status: INT UNSIGNED},
{BuHaStatus: VARCHAR},
{MahnStatus: INT UNSIGNED},
{EingangDatum: DATE},
{LagerOrt: INT UNSIGNED},
{created: TIMESTAMP},
{updated: TIMESTAMP}
);
