----------------------------------------------
-- Fallstudie "Paketshop"
-- Kurs:    Methoden der Programmierung
-- Author:  Miro Ljubicic
-- Version: 0.1
-- Date:    29.11.2011
-- Zweck:   Nachträglich die Paketabmessungen eingeben
----------------------------------------------

UPDATE `paketshop`.`Paket`
SET
`Abmessungen` = {Abmessungen: INT UNSIGNED}
WHERE `Id` = ???