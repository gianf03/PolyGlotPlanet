use PolyGlotPlanet;

insert into Lingua values
("AZ", "azerbaigiano", 24000000, "img/stati/azerbaigian.png"),
("BE", "bielorusso", 7900000, "img/stati/bielorussia.png"),
("BG", "bulgaro", 8300000, "img/stati/bulgaria.png"),
("BS", "bosniaco", 1800000,"img/stati/bosnia.png"),
("CA", "catalano", 5300000, "img/stati/catalogna.png"),
("CS", "ceco", 10700000, "img/stati/cechia.png"),
("CY", "gallese", 500000, "img/stati/galles.png"),
("DA", "danese", 6100000, "img/stati/danimarca.png"),
("DE", "tedesco", 76600000, "img/stati/germania.png"),
("EL", "greco", 13100000, "img/stati/grecia.png"),
("EN", "inglese", 369900000, "img/stati/uk.png"),
("ES", "spagnolo", 471400000, "img/stati/spagna.png"),
("ET", "estone", 1400000, "img/stati/estonia.png"),
("EU", "basco", 500000, "img/stati/euskadi.png"),
("FI", "finlandese", 5500000, "img/stati/finlandia.png"),
("FO", "faroense", 80000, "img/stati/isole_far_oer.png"),
("FR", "francese", 79600000, "img/stati/francia.png"),
("GA", "irlandese", 1700000, "img/stati/irlanda.png"),
("HR", "croato", 5500000, "img/stati/croazia.png"),
("HU", "ungherese", 12600000, "img/stati/ungheria.png"),
("HY", "armeno", 6300000, "img/stati/armenia.png"),
("IS", "islandese", 300000, "img/stati/islanda.png"),
("IT", "italiano", 64800000, "img/stati/italia.png"),
("JA", "giapponese", 126300000, "img/stati/giappone.png"),
("KA", "georgiano", 3900000,"img/stati/georgia.png"),
("KO", "coreano", 82000000, "img/stati/corea_del_sud.png"),
("LT", "lituano", 2500000, "img/stati/lituania.png"),
("LV", "lettone", 2100000,"img/stati/lettonia.png"),
("MK", "macedone", 3500000, "img/stati/macedonia_del_nord.png"),
("NL", "olandese", 23100000, "img/stati/paesi_bassi.png"),
("NO", "norvegese", 4200000, "img/stati/norvegia.png"),
("PL", "polacco", 39700000, "img/stati/polonia.png"),
("PT", "portoghese", 232400000, "img/stati/portogallo.png"),
("RO", "rumeno", 25100000, "img/stati/romania.png"),
("RU", "russo", 153700000, "img/stati/russia.png"),
("SK", "slovacco", 5400000, "img/stati/slovacchia.png"),
("SL", "sloveno", 2600000, "img/stati/slovenia.png"),
("SQ", "albanese", 1200000, "img/stati/albania.png"),
("SR", "serbo", 6300000, "img/stati/serbia.png"),
("SV", "svedese", 9000000, "img/stati/svezia.png"),
("TR", "turco", 82200000, "img/stati/turchia.png"),
("UK", "ucraino", 27300000, "img/stati/ucraina.png"),
("ZH", "cinese", 921100000, "img/stati/cina.png"),
("AF", "afrikaans", 6800000, "img/stati/sudafrica.png"),
("HI", "hindi", 342200000, "img/stati/india.png");

insert into Categoria (nome, foto) values 
("corso", "img/categorie/corso.png"), 
("incontro", "img/categorie/incontro.png"), 
("colloquio", "img/categorie/colloquio.png");

insert into Utente (nome, cognome, dataNascita, email, passwordHash, genere, admin) values
("Sebastiano", "Caliendo", "2000-06-22", "sebcal2@gmail.com", SHA1("albicocca41"), "M", false),
("Giuseppe", "Falciano", "2003-06-22", "giufal1@gmail.com", SHA1("albicocca41"), "M", false),
("Stanislao", "Pakosz", "1991-02-24", "stapak@gmail.com", SHA1("albicocca41"), "M", false),
("Vladimir", "Dugin", "1992-10-26", "vladug@gmail.com", SHA1("albicocca41"), "M", false),
("Boris", "Johnson", "1993-06-25", "borjoh@gmail.com", SHA1("albicocca41"), "M", false),
("Donald", "Trump", "1994-12-04", "dontru@gmail.com", SHA1("albicocca41"), "M", false),
("Giorgia", "Califano", "1995-04-29", "giocal@gmail.com", SHA1("albicocca41"), "F", false),
("Drusilla", "Pepe", "1996-02-24", "drupep@gmail.com", SHA1("albicocca41"), "F", false),
("Maria", "Rosato", "1997-01-06", "marros@gmail.com", SHA1("albicocca41"), "F", false),
("Ugo", "Ugonotto", "1996-01-20", "ugougo@gmail.com", SHA1("albicocca41"), "M", false),
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
	(4.99, 0, 3, "EN"),
    (16, 5, 3, "ES"),
    (6.50, 0, 3, "ET"),
    (23.99, 10, 3, "EU"),
    (7, 0, 3, "FI"),
    (6.99, 0, 3, "FO"),
    (9.99, 10, 3, "FR"),
    (14.99, 20, 3, "GA"),
    (8, 10, 3, "HR"),
	(9, 0, 3, "HU"),
    (14, 5, 3, 'EN'),
    (8, 17, 3, 'FR'),
    (20, 30, 3, 'DE'),
    (6, 45, 3, 'IT'),
    (15, 9, 3, 'ES'),
    (23, 25, 3, 'PT'),
    (4, 10, 3, 'NL'),
    (19, 32, 3, 'DA'),
    (22, 21, 3, 'FI'),
    (5, 13, 3, 'SV'),
    (16, 2, 3, 'NO'),
    (11, 27, 3, 'EL'),
    (7, 49, 3, 'PL'),
    (14, 3, 3, 'CS'),
    (18, 15, 3, 'SK'),
    (21, 8, 3, 'HU'),
    (9, 22, 3, 'RO'),
    (24, 31, 3, 'BG'),
    (6, 11, 3, 'HR'),
    (17, 18, 3, 'LT'),
    (12, 4, 3, 'LV'),
    (20, 35, 3, 'ET'),
    (8, 7, 3, 'SL'),
    (19, 24, 3, 'GA'),
    (5, 40, 3, 'IT'),
    (16, 29, 3, 'CY'),
    (22, 6, 3, 'IS'),
    (10, 50, 3, 'MK'),
    (7, 12, 3, 'SR'),
    (15, 19, 3, 'TR'),
	(10, 23, 2, 'IT'),
    (18, 47, 2, 'PL'),
    (12, 35, 2, 'ES'),
    (25, 19, 2, 'FR'),
    (7, 42, 2, 'DE'),
    (22, 4, 2, 'PT'),
    (11, 28, 2, 'NL'),
    (6, 49, 2, 'SV'),
    (14, 15, 2, 'DA'),
    (9, 36, 2, 'FI'),
    (19, 1, 2, 'NO'),
    (21, 33, 2, 'HU'),
    (8, 21, 2, 'RO'),
    (17, 30, 2, 'CS'),
    (15, 44, 2, 'SK'),
    (23, 8, 2, 'LT'),
    (13, 39, 2, 'LV'),
    (5, 27, 2, 'ET'),
    (16, 50, 2, 'BG'),
    (20, 2, 2, 'IT'),
    (24, 41, 2, 'HR'),
    (7, 18, 2, 'SL'),
    (9, 32, 2, 'MK'),
    (13, 7, 2, 'CY'),
    (18, 29, 2, 'IS'),
    (12, 46, 2, 'TR'),
    (25, 14, 2, 'SR'),
    (10, 38, 2, 'BG'),
    (6, 25, 2, 'FI'),
    (22, 11, 2, 'PL'),
    (14, 43, 2, 'DE'),
    (21, 5, 2, 'NL'),
    (17, 34, 2, 'FR'),
    (8, 22, 2, 'IT'),
    (23, 9, 2, 'ES'),
    (5, 45, 2, 'PT'),
    (19, 3, 2, 'SV'),
    (11, 37, 2, 'DA'),
    (16, 17, 2, 'NO'),
    (11, 10, 2, 'ZH');
    
    
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
    (46, "Il corso di azerbaigiano intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(47, "Il corso di bielorusso intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(48, "Il corso di bulgaro intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(49, "Il corso di bosniaco intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(50, "Il corso di catalano intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(51, "Il corso di ceco intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(52, "Il corso di gallese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(53, "Il corso di danese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(54, "Il corso di tedesco intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(55, "Il corso di greco intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(56, "Il corso di inglese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(57, "Il corso di spagnolo intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(58, "Il corso di estone intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(59, "Il corso di basco intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(60, "Il corso di finlandese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(61, "Il corso di faroese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(62, "Il corso di francese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(63, "Il corso di irlandese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(64, "Il corso di croato intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(65, "Il corso di ungherese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(66, "Il corso di armeno intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(67, "Il corso di islandese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(68, "Il corso di italiano intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(69, "Il corso di giapponese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(70, "Il corso di georgiano intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(71, "Il corso di coreano intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(72, "Il corso di lituano intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(73, "Il corso di lettone intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(74, "Il corso di macedone intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(75, "Il corso di olandese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(76, "Il corso di norvegese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(77, "Il corso di polacco intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(78, "Il corso di portoghese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(79, "Il corso di rumeno intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(80, "Il corso di russo intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(81, "Il corso di serbo intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 11, "B1-B2"),
	(82, "Il corso di slovacco intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(83, "Il corso di sloveno intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(84, "Il corso di svedese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 10, "B1-B2"),
	(85, "Il corso di turco intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(86, "Il corso di ucraino intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(87, "Il corso di ungherese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 8, "B1-B2"),
	(88, "Il corso di vietnamita intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
    (89, "Il corso di afrikaans intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
    (90, "Il corso di hindi intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura. 
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 9, "B1-B2"),
	(91, "Corso avanzato di azerbaigiano: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(92, "Corso avanzato di bielorusso: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(93, "Corso avanzato di bulgaro: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(94, "Corso avanzato di bosniaco: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(95, "Corso avanzato di catalano: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(96, "Corso avanzato di ceco: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(97, "Corso avanzato di gallese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(98, "Corso avanzato di danese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(99, "Corso avanzato di tedesco: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(100, "Corso avanzato di greco: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(101, "Corso avanzato di inglese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(102, "Corso avanzato di spagnolo: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(103, "Corso avanzato di estone: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(104, "Corso avanzato di basco: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(105, "Corso avanzato di finlandese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(106, "Corso avanzato di faroese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(107, "Corso avanzato di francese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(108, "Corso avanzato di irlandese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(109, "Corso avanzato di croato: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(110, "Corso avanzato di ungherese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(111, "Corso avanzato di armeno: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(112, "Corso avanzato di islandese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(113, "Corso avanzato di italiano: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(114, "Corso avanzato di giapponese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(115, "Corso avanzato di georgiano: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(116, "Corso avanzato di coreano: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(117, "Corso avanzato di lituano: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(118, "Corso avanzato di lettone: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(119, "Corso avanzato di macedone: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(120, "Corso avanzato di olandese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(121, "Corso avanzato di norvegese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(122, "Corso avanzato di polacco: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(123, "Corso avanzato di portoghese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(124, "Corso avanzato di rumeno: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(125, "Corso avanzato di russo: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(126, "Corso avanzato di slovacco: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(127, "Corso avanzato di sloveno: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(128, "Corso avanzato di albanese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(129, "Corso avanzato di serbo: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(130, "Corso avanzato di svedese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2"),
	(131, "Corso avanzato di turco: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 12, "C1-C2"),
	(132, "Corso avanzato di ucraino: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 13, "C1-C2"),
	(133, "Corso avanzato di cinese: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 14, "C1-C2"),
	(134, "Corso avanzato di afrikaans: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 15, "C1-C2"),
	(135, "Corso avanzato di hindi: perfeziona la tua fluency, comprensione e abilità comunicative. Approfondisci la grammatica, 
    il vocabolario e la cultura attraverso conversazioni e letture complesse.", 16, "C1-C2");

    
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
	('EN', 7),
    ('AZ', 5),
    ('BE', 8),
    ('BG', 6),
    ('BS', 2),
    ('IT', 3),
    ('CA', 1),
    ('CS', 4),
    ('CY', 9),
    ('DA', 8),
    ('FR', 2),
    ('EL', 3),
    ('ET', 6),
    ('EU', 4),
    ('FI', 1),
    ('DE', 9),
    ('FO', 3),
    ('GA', 7),
    ('HR', 5),
    ('HU', 8),
    ('ES', 6),
    ('HY', 4),
    ('IS', 9),
    ('JA', 1),
    ('KA', 2),
    ('NL', 3),
    ('KO', 7),
    ('LT', 5),
    ('LV', 8),
    ('MK', 6),
    ('SV', 9),
    ('NO', 1),
    ('RO', 4),
    ('RU', 7),
    ('SK', 2),
    ('PT', 8),
    ('SL', 9),
    ('SQ', 1),
    ('SR', 6),
    ('TR', 3),
    ('PL', 5),
    ('UK', 2),
    ('ZH', 4),
    ('AF', 9),
    ('HI', 6);
       
INSERT INTO Colloquio
	(IDProdotto, dataOra, IDEsperto)
VALUES
	(136, '2024-07-28 16:30:00', 7),
    (137, '2024-07-29 17:30:00', 6),
    (138, '2024-07-30 14:00:00', 6),
    (139, '2024-08-10 11:30:00', 4),
    (140, '2024-08-11 9:45:00', 1),
    (141, '2024-08-12 8:30:00', 3),
    (142, '2024-09-15 18:30:00', 2),
    (143, '2024-09-20 13:30:00', 7),
    (144, '2024-09-25 8:45:00', 5),
    (145, '2024-10-10 14:30:00', 8),
	(146, '2024-08-02 10:15:00', 7),
    (147, '2024-08-11 14:45:00', 2),
    (148, '2024-09-04 09:30:00', 9),
    (149, '2024-09-15 16:20:00', 3), 
    (150, '2024-09-27 12:00:00', 6),
    (151, '2024-10-03 11:10:00', 8),
    (152, '2024-10-12 17:35:00', 3),
    (153, '2024-10-22 08:45:00', 8),
    (154, '2024-11-02 18:55:00', 1), 
    (155, '2024-11-14 15:30:00', 9),
    (156, '2024-11-20 13:10:00', 1),
    (157, '2024-11-30 10:50:00', 3),
    (158, '2024-08-05 14:30:00', 5),
    (159, '2024-08-18 11:20:00', 4), 
    (160, '2024-09-06 09:45:00', 2),
    (161, '2024-09-19 16:10:00', 8),
    (162, '2024-09-25 08:30:00', 4),
    (163, '2024-10-07 18:20:00', 6),
    (164, '2024-10-14 17:00:00', 5), 
    (165, '2024-10-30 12:45:00', 5),
    (166, '2024-11-05 08:10:00', 8),
    (167, '2024-11-18 14:00:00', 6),
    (168, '2024-11-23 09:40:00', 9),
    (169, '2024-08-14 10:20:00', 7), 
    (170, '2024-08-28 18:50:00', 3),
    (171, '2024-09-10 12:30:00', 9),
    (172, '2024-09-21 14:40:00', 9),
    (173, '2024-10-01 11:50:00', 6),
    (174, '2024-10-19 15:15:00', 6), 
    (175, '2024-11-09 17:25:00', 3);

    

INSERT INTO Incontro 
	(IDProdotto, dataOra, CAP, via, civico, IDEsperto)
VALUES
	(176, '2024-09-15 09:45:00', '00100', 'Via delle Rose', '12', 3),
    (177, '2024-10-05 14:15:00', '20121', 'Via dei Girasoli', '45', 5),
    (178, '2024-08-22 10:00:00', '80121', 'Corso delle Stelle', '67', 6),
    (179, '2024-11-07 11:30:00', '10121', 'Via del Sole', '89', 2),
    (180, '2024-08-28 16:45:00', '50100', 'Via dei Limoni', '34', 9),
    (181, '2024-08-12 08:15:00', '00187', 'Viale dei Giardini', '23', 8),
    (182, '2024-09-18 12:00:00', '37100', 'Via delle Orchidee', '58', 3),
    (183, '2024-11-23 18:30:00', '50122', 'Piazza dei Miracoli', '55', 9),
    (184, '2024-08-31 09:30:00', '40100', 'Via dei Cedri', '45', 8),
    (185, '2024-10-12 13:15:00', '34100', 'Via del Mare', '77', 1),
    (186, '2024-11-01 17:00:00', '34101', 'Via dei Pini', '78', 1),
    (187, '2024-08-18 10:45:00', '34102', 'Via del Faro', '79', 8),
    (188, '2024-09-27 08:30:00', '34103', 'Via del Vento', '80', 4),
    (189, '2024-10-02 09:00:00', '34104', 'Via della Luna', '81', 4),
    (190, '2024-08-15 10:30:00', '34105', 'Via delle Stelle', '82', 2),
    (191, '2024-09-04 11:00:00', '34106', 'Via del Cielo', '83', 5),
    (192, '2024-10-10 12:30:00', '34107', 'Via della Speranza', '84', 8),
    (193, '2024-08-21 13:00:00', '34108', 'Via del Tramonto', '85', 6),
    (194, '2024-11-12 14:30:00', '34109', "Via dell'alba", '86', 6),
    (195, '2024-10-28 15:00:00', '34110', 'Via della Sera', '87', 3),
    (196, '2024-09-16 16:30:00', '34111', 'Via della Notte', '88', 5),
    (197, '2024-08-26 17:00:00', '34112', 'Via delle Ombre', '89', 9),
    (198, '2024-10-15 18:30:00', '34113', 'Via del Crepuscolo', '90', 6),
    (199, '2024-11-06 08:30:00', '34114', 'Via del Mattino', '91', 9),
    (200, '2024-09-23 09:00:00', '34115', 'Via del Giorno', '92', 9),
    (201, '2024-11-22 10:30:00', '34116', 'Via del Pomeriggio', '93', 3),
    (202, '2024-09-11 11:00:00', '34117', 'Via del Vespro', '94', 6),
    (203, '2024-08-19 12:30:00', '34118', 'Via della Mattina', '95', 6),
    (204, '2024-09-30 13:00:00', '34119', 'Via dei Fiori', '96', 1),
    (205, '2024-10-25 14:30:00', '34120', 'Via delle Rose', '97', 5),
    (206, '2024-08-21 15:00:00', '34121', 'Via dei Gelsi', '98', 9),
    (207, '2024-09-13 16:30:00', '34122', 'Via delle Mimose', '99', 3),
    (208, '2024-10-14 17:00:00', '34123', 'Via degli Ulivi', '100', 2),
    (209, '2024-08-25 18:30:00', '34124', 'Via dei Cipressi', '101', 3),
    (210, '2024-10-05 08:30:00', '34125', 'Via delle Betulle', '102', 6),
    (211, '2024-09-10 09:00:00', '34126', 'Via dei Tigli', '103', 8),
    (212, '2024-11-30 10:30:00', '34127', 'Via delle Querce', '104', 9),
    (213, '2024-10-03 11:00:00', '34128', 'Via degli Abeti', '105', 8),
    (214, '2024-09-06 12:30:00', '34129', 'Via dei Lecci', '106', 1),
    (215, '2024-11-15 13:00:00', '34130', 'Via dei Noci', '107', 4);

insert into Ordine (IDUtente, dataOra) values (1, '2024-07-10 14:30:00');

insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 1, p.ID, p.prezzoAttuale from Prodotto p where id=1;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 1, p.ID, p.prezzoAttuale from Prodotto p where id=110;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 1, p.ID, p.prezzoAttuale from Prodotto p where id=176;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 1, p.ID, p.prezzoAttuale from Prodotto p where id=136;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 1, p.ID, p.prezzoAttuale from Prodotto p where id=200;

insert into Ordine (IDUtente, dataOra) values (1, '2024-07-11 12:35:00');

insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 2, p.ID, p.prezzoAttuale from Prodotto p where id=2;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 2, p.ID, p.prezzoAttuale from Prodotto p where id=211;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 2, p.ID, p.prezzoAttuale from Prodotto p where id=144;

insert into Ordine (IDUtente, dataOra) values (1, '2024-07-12 21:30:57');

insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 3, p.ID, p.prezzoAttuale from Prodotto p where id=133;


insert into Ordine (IDUtente, dataOra) values (2, '2024-07-13 00:30:52');

insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 4, p.ID, p.prezzoAttuale from Prodotto p where id=4;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 4, p.ID, p.prezzoAttuale from Prodotto p where id=114;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 4, p.ID, p.prezzoAttuale from Prodotto p where id=180;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 4, p.ID, p.prezzoAttuale from Prodotto p where id=140;
insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 4, p.ID, p.prezzoAttuale from Prodotto p where id=204;	
    
    
insert into Ordine (IDUtente, dataOra) values (2, '2024-07-14 03:30:52');

insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 5, p.ID, p.prezzoAttuale from Prodotto p where id=207;


insert into Ordine (IDUtente, dataOra) values (3, '2024-07-15 03:30:52');

insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 6, p.ID, p.prezzoAttuale from Prodotto p where id=206;

insert into Ordine (IDUtente, dataOra) values (1, '2024-07-15 03:30:52');

insert into Composizione (IDOrdine, IDProdotto, prezzoAcquisto)
select 7, p.ID, p.prezzoAttuale from Prodotto p where id=213;


