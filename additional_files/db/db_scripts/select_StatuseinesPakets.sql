----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    29.11.2011
-- Zweck:   Anzeige eines Status eines bestimmten Pakets
--          Zunächst wird nur der Status-Text (z.B. "eingetroffen") angezeigt.
--          Je nach GUI können die anderen Attribute wieder einkommentiert werden
----------------------------------------------

SELECT
-- `PaketStatus`.`Id`,
`PaketStatus`.`Text`
-- `PaketStatus`.`created`,
-- `PaketStatus`.`updated`
FROM `paketshop`.`PaketStatus`
 WHERE `PaketStatus`.`Id` IN (SELECT `Paket`.`Status` FROM `paketshop`.`Paket` WHERE `Paket`.`Id` = ???);