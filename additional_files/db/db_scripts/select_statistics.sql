----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    08.01.2012
-- Zweck:   Auslesen der Paketinformationen für Statistik
----------------------------------------------

SELECT
`Paket`.`Id`,
`Paket`.`Kunde`,
`Paket`.`Kategorie`,
`Paket`.`Status`,
`Paket`.`BuHaStatus`,
`Paket`.`MahnStatus`,
`Paket`.`EingangDatum`,
`Paket`.`LagerOrt`,
`Paket`.`created`,
`Paket`.`updated`,
`Paket`.`Abmessungen`
FROM `paketshop`.`Paket`
WHERE `Paket`.`Id` = XXX;
