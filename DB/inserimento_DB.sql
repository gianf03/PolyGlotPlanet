use PolyGlotPlanet;

insert into Lingua values
("AZ", "azerbaigiano", 24, "img/stati/azerbaigian.png"),
("BE", "bielorusso", 7.9, "img/stati/bielorussia.png"),
("BG", "bulgaro", 8.3, "img/stati/bulgaria.png"),
("BS", "bosniaco", 1.8,"img/stati/bosnia.png"),
("CA", "catalano", 5.3, "img/stati/catalogna.png"),
("CS", "ceco", 10.7, "img/stati/cechia.png"),
("CY", "gallese", 0.5, "img/stati/galles.png"),
("DA", "danese", 6.1, "img/stati/danimarca.png"),
("DE", "tedesco", 76.6, "img/stati/germania.png"),
("EL", "greco", 13.1, "img/stati/grecia.png"),
("EN", "inglese", 369.9, "img/stati/uk.png"),
("ES", "spagnolo", 471.4, "img/stati/spagna.png"),
("ET", "estone", 1.4, "img/stati/estonia.png"),
("EU", "basco", 0.5, "img/stati/euskadi.png"),
("FI", "finlandese", 5.5, "img/stati/finlandia.png"),
("FO", "faroense", 0.08, "img/stati/isole_far_oer.png"),
("FR", "francese", 79.6, "img/stati/francia.png"),
("GA", "irlandese", 1.7, "img/stati/irlanda.png"),
("HR", "croato", 5.5, "img/stati/croazia.png"),
("HU", "ungherese", 12.6, "img/stati/ungheria.png"),
("HY", "armeno", 6.3, "img/stati/armenia.png"),
("IS", "islandese", 0.3, "img/stati/islanda.png"),
("IT", "italiano", 64.8, "img/stati/italia.png"),
("JA", "giapponese", 126.3, "img/stati/giappone.png"),
("KA", "georgiano", 3.9,"img/stati/georgia.png"),
("KO", "coreano", 82, "img/stati/corea_del_sud.png"),
("LT", "lituano", 2.5, "img/stati/lituania.png"),
("LV", "lettone", 2.1,"img/stati/lettonia.png"),
("MK", "macedone", 3.5, "img/stati/macedonia_del_nord.png"),
("NL", "olandese", 23.1, "img/stati/paesi_bassi.png"),
("NO", "norvegese", 4.2, "img/stati/norvegia.png"),
("PL", "polacco", 39.7, "img/stati/polonia.png"),
("PT", "portoghese", 232.4, "img/stati/portogallo.png"),
("RO", "rumeno", 25.1, "img/stati/romania.png"),
("RU", "russo", 153.7, "img/stati/russia.png"),
("SK", "slovacco", 5.4, "img/stati/slovacchia.png"),
("SL", "sloveno", 2.6, "img/stati/slovenia.png"),
("SQ", "albanese", 1.2, "img/stati/albania.png"),
("SR", "serbo", 6.3, "img/stati/serbia.png"),
("SV", "svedese", 9, "img/stati/svezia.png"),
("TR", "turco", 82.2, "img/stati/turchia.png"),
("UK", "ucraino", 27.3, "img/stati/ucraina.png"),
("ZH", "cinese", 921.1, "img/stati/cina.png"),
("AF", "afrikaans", 6.8, "img/stati/sudafrica.png"),
("HI", "hindi", 342.2, "img/stati/india.png");

insert into Categoria (nome, foto) values 
("corso", "img/categorie/corso.png"), 
("incontro", "img/categorie/incontro.png"), 
("colloquio", "img/categorie/colloquio.png");

insert into Utente (nome, cognome, dataNascita, email, passwordHash, genere, admin) values
("Sebastiano", "Caliendo", "2000-06-22", "sebcal2@gmail.com", SHA1("albicocca41"), "M", false),
("Giuseppe", "Falciano", "2003-06-22", "giufal1@gmail.com", SHA1("albicocca41"), "M", false),
("Gianfranco", "Vitiello", "2003-03-07", "giavit7@gmail.com", SHA1("ananas12"), "M", true);

INSERT INTO Prodotto 
	(prezzoBase, scontoPercentuale, IDCategoria, codISOLingua)
VALUES
	(9, 5, 1, 'AZ'),
    (10, 10, 1, 'BE'),
    (11, 15, 1, 'BG'),
    (12, 20, 1, 'BS'),
    (13, 25, 1, 'CA'),
    (14, 30, 1, 'CS'),
    (15, 35, 1, 'CY'),
    (16, 40, 1, 'DA'),
    (17, 45, 1, 'DE'),
    (18, 50, 1, 'EL'),
    (19, 5, 1, 'EN'),
    (20, 10, 1, 'ES'),
    (21, 15, 1, 'ET'),
    (22, 20, 1, 'EU'),
    (23, 25, 1, 'FI'),
    (24, 30, 1, 'FO'),
    (25, 35, 1, 'FR'),
    (26, 40, 1, 'GA'),
    (27, 45, 1, 'HR'),
    (28, 50, 1, 'HU'),
    (29, 5, 1, 'HY'),
    (30, 10, 1, 'IS'),
    (29, 15, 1, 'IT'),
    (28, 20, 1, 'JA'),
    (27, 25, 1, 'KA'),
    (26, 30, 1, 'KO'),
    (25, 35, 1, 'LT'),
    (24, 40, 1, 'LV'),
    (23, 45, 1, 'MK'),
    (22, 50, 1, 'NL'),
    (21, 5, 1, 'NO'),
    (20, 10, 1, 'PL'),
    (19, 15, 1, 'PT'),
    (18, 20, 1, 'RO'),
    (17, 25, 1, 'RU'),
    (16, 30, 1, 'SK'),
    (15, 35, 1, 'SL'),
    (14, 40, 1, 'SQ'),
    (13, 45, 1, 'SR'),
    (12, 50, 1, 'SV'),
    (11, 5, 1, 'TR'),
    (10, 10, 1, 'UK'),
    (9, 15, 1, 'ZH'),
    (8, 20, 1, 'AF'),
    (7, 25, 1, 'HI'),
    (31, 5, 1, 'AZ'),
    (32, 10, 1, 'BE'),
    (33, 15, 1, 'BG'),
    (34, 20, 1, 'BS'),
    (35, 25, 1, 'CA'),
    (36, 30, 1, 'CS'),
    (37, 35, 1, 'CY'),
    (38, 40, 1, 'DA'),
    (39, 45, 1, 'DE'),
    (40, 50, 1, 'EL'),
    (41, 5, 1, 'EN'),
    (42, 10, 1, 'ES'),
    (43, 15, 1, 'ET'),
    (44, 20, 1, 'EU'),
    (45, 25, 1, 'FI'),
    (46, 30, 1, 'FO'),
    (47, 35, 1, 'FR'),
    (48, 40, 1, 'GA'),
    (49, 45, 1, 'HR'),
    (50, 50, 1, 'HU'),
    (51, 5, 1, 'HY'),
    (52, 10, 1, 'IS'),
    (53, 15, 1, 'IT'),
    (54, 20, 1, 'JA'),
    (55, 25, 1, 'KA'),
    (56, 30, 1, 'KO'),
    (57, 35, 1, 'LT'),
    (58, 40, 1, 'LV'),
    (59, 45, 1, 'MK'),
    (31, 50, 1, 'NL'),
    (32, 5, 1, 'NO'),
    (33, 10, 1, 'PL'),
    (34, 15, 1, 'PT'),
    (35, 20, 1, 'RO'),
    (36, 25, 1, 'RU'),
    (37, 30, 1, 'SK'),
    (38, 35, 1, 'SL'),
    (39, 40, 1, 'SQ'),
    (40, 45, 1, 'SR'),
    (41, 50, 1, 'SV'),
    (42, 5, 1, 'TR'),
    (43, 10, 1, 'UK'),
    (44, 15, 1, 'ZH'),
    (45, 20, 1, 'AF'),
    (46, 25, 1, 'HI'),
    (60, 0, 1, 'AZ'),
    (61, 5, 1, 'BE'),
    (62, 10, 1, 'BG'),
    (63, 15, 1, 'BS'),
    (64, 20, 1, 'CA'),
    (65, 25, 1, 'CS'),
    (66, 30, 1, 'CY'),
    (67, 35, 1, 'DA'),
    (68, 40, 1, 'DE'),
    (69, 0, 1, 'EL'),
    (70, 5, 1, 'EN'),
    (71, 10, 1, 'ES'),
    (72, 15, 1, 'ET'),
    (73, 20, 1, 'EU'),
    (74, 25, 1, 'FI'),
    (75, 30, 1, 'FO'),
    (76, 35, 1, 'FR'),
    (77, 40, 1, 'GA'),
    (78, 0, 1, 'HR'),
    (79, 5, 1, 'HU'),
    (80, 10, 1, 'HY'),
    (81, 15, 1, 'IS'),
    (82, 20, 1, 'IT'),
    (83, 25, 1, 'JA'),
    (84, 30, 1, 'KA'),
    (85, 35, 1, 'KO'),
    (86, 40, 1, 'LT'),
    (87, 0, 1, 'LV'),
    (88, 5, 1, 'MK'),
    (89, 10, 1, 'NL'),
    (90, 15, 1, 'NO'),
    (61, 20, 1, 'PL'),
    (62, 25, 1, 'PT'),
    (63, 30, 1, 'RO'),
    (64, 35, 1, 'RU'),
    (65, 40, 1, 'SK'),
    (66, 0, 1, 'SL'),
    (67, 5, 1, 'SQ'),
    (68, 10, 1, 'SR'),
    (69, 15, 1, 'SV'),
    (70, 20, 1, 'TR'),
    (71, 25, 1, 'UK'),
    (72, 30, 1, 'ZH'),
    (73, 35, 1, 'AF'),
    (74, 40, 1, 'HI'),
	(4.99, 0, 2, "EN"),
    (16, 5, 2, "ES"),
    (6.50, 0, 2, "ET"),
    (23.99, 10, 2, "EU"),
    (7, 0, 2, "FI"),
    (6.99, 0, 2, "FO"),
    (9.99, 10, 2, "FR"),
    (14.99, 20, 2, "GA"),
    (8, 10, 2, "HR"),
	(9, 0, 2, "HU"),
	(5.99, 0, 3, "HY"),
    (18, 30, 3, "IS"), 
    (8.50, 0, 3, "IT"), 
    (13.99, 15, 3, "JA"), 
    (10, 20, 3, "KA"),
    (8.99, 0, 3, "KO"),
    (16.99, 50, 3, "LT"),
    (4.99, 20, 3, "LV"),
    (18, 35, 3, "MK"),
    (20, 15, 3, "NL");
    
    
INSERT INTO Corso
	(IDProdotto, descrizione, numeroUnita, livello)
VALUES
	(1, "Impara l'azerbaigiano dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (2, "Impara il bielorusso dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (3, "Impara il bulgaro dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (4, "Impara il bosniaco dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (5, "Impara il catalano dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (6, "Impara il ceco dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (7, "Impara il gallese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (8, "Impara il danese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (9, "Impara il tedesco dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (10, "Impara il greco dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (11, "Impara l'inglese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (12, "Impara lo spagnolo dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (13, "Impara l'estone dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (14, "Impara il basco dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (15, "Impara il finlandese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (16, "Impara il faroense dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (17, "Impara il francese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (18, "Impara l'irlandese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (19, "Impara il croato dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (20, "Impara l'ungherese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (21, "Impara l'armeno dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (22, "Impara l'islandese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (23, "Impara l'italiano dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (24, "Impara il giapponese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (25, "Impara il georgiano dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (26, "Impara il coreano dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (27, "Impara il lituano dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (28, "Impara il lettone dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (29, "Impara il macedone dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (30, "Impara l'olandese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (31, "Impara il norvegese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (32, "Impara il polacco dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (33, "Impara il portoghese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (34, "Impara il rumeno dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (35, "Impara il russo dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (36, "Impara lo slovacco dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (37, "Impara lo sloveno dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (38, "Impara l'albanese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (39, "Impara il serbo dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (40, "Impara lo svedese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (41, "Impara il turco dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (42, "Impara l'ucraino dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 7, "A1-A2"),
    (43, "Impara il cinese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 6, "A1-A2"),
    (44, "Impara l'afrikaans dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 4, "A1-A2"),
    (45, "Impara l'hindi dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 5, "A1-A2"),
    (46, "Il corso di azerbaigiano intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(47, "Il corso di bielorusso intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(48, "Il corso di bulgaro intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(49, "Il corso di bosniaco intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(50, "Il corso di catalano intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(51, "Il corso di ceco intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(52, "Il corso di gallese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(53, "Il corso di danese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(54, "Il corso di tedesco intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(55, "Il corso di greco intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(56, "Il corso di inglese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(57, "Il corso di spagnolo intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(58, "Il corso di estone intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(59, "Il corso di basco intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(60, "Il corso di finlandese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(61, "Il corso di faroese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(62, "Il corso di francese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(63, "Il corso di irlandese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(64, "Il corso di croato intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(65, "Il corso di ungherese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(66, "Il corso di armeno intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(67, "Il corso di islandese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(68, "Il corso di italiano intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(69, "Il corso di giapponese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(70, "Il corso di georgiano intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(71, "Il corso di coreano intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(72, "Il corso di lituano intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(73, "Il corso di lettone intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(74, "Il corso di macedone intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(75, "Il corso di olandese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(76, "Il corso di norvegese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(77, "Il corso di polacco intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
    (78, "Il corso di portoghese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
    (79, "Il corso di rumeno intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
    (80, "Il corso di russo intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
    (81, "Il corso di slovacco intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
    (82, "Il corso di sloveno intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
    (83, "Il corso di albanese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
    (84, "Il corso di serbo intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
    (85, "Il corso di svedese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
    (86, "Il corso di turco intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
    (87, "Il corso di ucraino intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
    (88, "Il corso di cinese intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
    (89, "Il corso di afrikaans intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
    (90, "Il corso di hindi intermedio perfeziona le competenze linguistiche con focus su conversazione, 
    grammatica avanzata e cultura lusofona. Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(91, "Corso avanzato di azerbaigiano: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(92, "Corso avanzato di bielorusso: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(93, "Corso avanzato di bulgaro: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(94, "Corso avanzato di bosniaco: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(95, "Corso avanzato di catalano: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(96, "Corso avanzato di ceco: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(97, "Corso avanzato di gallese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(98, "Corso avanzato di danese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(99, "Corso avanzato di tedesco: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(100, "Corso avanzato di greco: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(101, "Corso avanzato di inglese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(102, "Corso avanzato di spagnolo: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(103, "Corso avanzato di estone: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(104, "Corso avanzato di basco: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(105, "Corso avanzato di finlandese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(106, "Corso avanzato di faroese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(107, "Corso avanzato di francese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(108, "Corso avanzato di irlandese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(109, "Corso avanzato di croato: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(110, "Corso avanzato di ungherese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(111, "Corso avanzato di armeno: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(112, "Corso avanzato di islandese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(113, "Corso avanzato di italiano: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(114, "Corso avanzato di giapponese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(115, "Corso avanzato di georgiano: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(116, "Corso avanzato di coreano: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(117, "Corso avanzato di lituano: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(118, "Corso avanzato di lettone: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(119, "Corso avanzato di macedone: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(120, "Corso avanzato di olandese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(121, "Corso avanzato di norvegese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(122, "Corso avanzato di polacco: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(123, "Corso avanzato di portoghese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(124, "Corso avanzato di rumeno: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(125, "Corso avanzato di russo: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(126, "Corso avanzato di slovacco: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(127, "Corso avanzato di sloveno: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(128, "Corso avanzato di albanese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(129, "Corso avanzato di serbo: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(130, "Corso avanzato di svedese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(131, "Corso avanzato di turco: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(132, "Corso avanzato di ucraino: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(133, "Corso avanzato di cinese: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(134, "Corso avanzato di afrikaans: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(135, "Corso avanzato di hindi: perfeziona la tua fluency, comprensione e abilità comunicative.
		Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 16, "C1-C2");

    
INSERT INTO Esperto
	(nome, cognome, email, passwordHash, dataNascita, genere, fotoRiconoscitiva)
VALUES
	("Robert", "Smith", "robsmi@gmail.com", SHA1("robert1985"), "1985-03-17", "M", "img/esperti/1.jpg"),
    ("Carla", "Bianchi", "carbia@gmail.com", SHA1("carla1992"), "1992-06-25", "F", "img/esperti/2.jpg"),
    ("Claire", "Dupont", "cladup@gmail.com", SHA1("claire1978"), "1978-11-08","F", "img/esperti/3.jpg"),
    ("Hans", "Muller", "hanmul@gmail.com", SHA1("hans2000"), "2000-02-14", "M", "img/esperti/4.jpg"),
    ("Ana", "García", "anagar@gmail.com", SHA1("garcia1965"), "1965-09-30", "F", "img/esperti/5.jpg"),
    ("Jan", "de Vries", "jandev@gmail.com", SHA1("devries1988"), "1988-07-12", "M", "img/esperti/6.jpg"),
    ("Anna", "Johansson", "annjoh@gmail.com", SHA1("anna1995"), "1995-10-22", "F", "img/esperti/7.jpg"),
    ("João", "Silva", "joasil@gmail.com", SHA1("joao1973"), "1973-04-05", "M", "img/esperti/8.jpg"),
    ("Anna", "Novak", "annnov@gmail.com", SHA1("anna2003"), "2003-12-01", "F", "img/esperti/9.jpg");
    

INSERT INTO Conoscenza
	(codISOLingua, IDEsperto)
VALUES
	("EN", 1),
    ("AZ", 1),
    ("BE", 1),
    ("BG", 1),
    ("BS", 1),
    ("IT", 2),
    ("CA", 2),
    ("CS", 2),
    ("CY", 2),
    ("DA", 2),
    ("FR", 3),
    ("EL", 3),
    ("ET", 3),
    ("EU", 3),
    ("FI", 3),
    ("DE", 4),
    ("FO", 4),
    ("GA", 4),
    ("HR", 4),
    ("HU", 4),
    ("ES", 5),
    ("HY", 5),
    ("IS", 5),
    ("JA", 5),
    ("KA", 5),
    ("NL", 6),
    ("KO", 6),
    ("LT", 6),
    ("LV", 6),
    ("MK", 6),
    ("SV", 7),
    ("NO", 7),
    ("RO", 7),
    ("RU", 7),
    ("SK", 7),
    ("PT", 8),
    ("SL", 8),
    ("SQ", 8),
    ("SR", 8),
    ("TR", 8),
    ("PL", 9),
    ("UK", 9),
    ("ZH", 9),
    ("AF", 9),
    ("HI", 9);
       
INSERT INTO Colloquio
	(IDProdotto, dataOra, IDEsperto)
VALUES
	(136, '2024-07-21 16:30:00', 1),
    (137, '2024-07-22 17:30:00', 5),
    (138, '2024-07-23 14::00', 3),
    (139, '2024-08-10 11:30:00', 3),
    (140, '2024-08-11 9:45:00', 3),
    (141, '2024-08-12 8:30:00', 4),
    (142, '2024-09-15 18:30:00', 3),
    (143, '2024-09-20 13:30:00', 4),
    (144, '2024-09-25 8:45:00', 4),
    (145, '2024-10-10 14:30:00', 4);
    
INSERT INTO Incontro 
	(IDProdotto, dataOra, CAP, via, civico, IDEsperto)
VALUES
	(146, '2024-07-21 16:30:00', "0010", "Baghramyan Avenue, Yerevan", "10", 5),
    (147, '2024-07-21 16:30:00', "101", "Skólavörðustígur, Reykjavík", "12", 5),
    (148, '2024-07-21 16:30:00', "20121", "Via Montenapoleone, Milano", "12", 2),
    (149, '2024-07-21 16:30:00', "100-0001", "Tokyo Prefecture, Chiyoda Ward, Chiyoda", "1-1", 5),
    (150, '2024-07-21 16:30:00', "0108", "Shota Rustaveli Avenue, Tbilisi", "22", 5),
    (151, '2024-07-21 16:30:00', "04524", "Eulji-ro 12-gil, Jung-gu, Seoul", "15", 6),
    (152, '2024-07-21 16:30:00', "01103", "Gedimino prospektas, Vilnus", "16", 6),
    (153, '2024-07-21 16:30:00', "LV-1010", "Brīvības iela, Rīga", "55", 6),
    (154, '2024-07-21 16:30:00', "51000", "Via Ilindenska, Skopje", "45", 6),
    (155, '2024-07-21 16:30:00', "1012 AB", "Damstraat, Amsterdam", "5", 6);
	