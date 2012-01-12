----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    08.01.2012
-- Zweck:   Auslesen der Informationen für Quittung
----------------------------------------------

SELECT
`Paket`.`Id`,
(SELECT `Adresse`.`Name`,`Adresse`.`Vorname` FROM `paketshop`.`Adresse` WHERE `Adresse`.`Id` = `Paket`.`Kunde`),
(SELECT `PaketKategorie`.`Text` FROM `paketshop`.`PaketKategorie` WHERE `PaketKategorie`.`Id` = `Paket`.`Kategorie`),
(SELECT `PaketStatus`.`Text` FROM `paketshop`.`PaketStatus` WHERE `PaketStatus`.`Id` = `Paket`.`Status`),
`Paket`.`BuHaStatus`,
`Paket`.`MahnStatus`,
`Paket`.`EingangDatum`,
(SELECT `Lager`.`Text` FROM `paketshop`.`Lager` WHERE `Lager`.`Id` = `Paket`.`LagerOrt`),
`Paket`.`created`,
`Paket`.`updated`,
`Paket`.`Abmessungen`
FROM `paketshop`.`Paket`;
WHERE `Paket`.`Id` = XXX;
