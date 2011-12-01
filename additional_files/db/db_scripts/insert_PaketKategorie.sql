----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    29.11.2011
-- Zweck:   Erzeugen eines neuen Datensatzes in der Tabelle PaketKategorie
----------------------------------------------

INSERT INTO `paketshop`.`PaketKategorie`
(`Id`,
`Text`,
`Preis`,
`GueltigAb`,
`created`,
`updated`)
VALUES
(
{Id: INT UNSIGNED},
{Text: VARCHAR},
{Preis: DECIMAL},
{GueltigAb: DATE},
{created: TIMESTAMP},
{updated: TIMESTAMP}
);



