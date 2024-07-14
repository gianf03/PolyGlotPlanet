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
("Gianfranco", "Vitiello", "2003-03-07", "giavit7@gmail.com", SHA1("ananas12"), "M", true);

INSERT INTO Prodotto (prezzoBase, scontoPercentuale, IDCategoria, codISOLingua) VALUES
	(30.5, 2.5, 1, "PT"),
    (60.75, 15, 1, "PT"),
    (50, 30, 1, "PT"),
    (70, 5, 1, "ZH"),
    (5, 0, 1, "SV");
    
INSERT INTO Corso (IDProdotto, descrizione, numeroUnita, livello, disponibile) VALUES
	(1, "Impara il portoghese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 11, "A1-A2", true),
	(2, "Il corso di portoghese intermedio perfeziona le competenze linguistiche con focus su conversazione, grammatica avanzata e cultura lusofona.
    Ideale per chi vuole migliorare la fluidità e la comprensione scritta/orale.", 15, "B1-B2", true),
    (3, "Corso avanzato di portoghese: perfeziona la tua fluency, comprensione e abilità comunicative.
    Approfondisci la grammatica, il vocabolario e la cultura lusofona attraverso conversazioni e letture complesse.", 25, "C1-C2", true),
    (4, "Impara il cinese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 11, "A1-A2", true),
    (5, "Impara lo svedese dalle basi! Questo corso ti introduce alla grammatica, vocabolario e pronuncia essenziale. 
    Perfetto per principianti, migliorerai le tue abilità di conversazione e comprensione.", 11, "A1-A2", true);
	