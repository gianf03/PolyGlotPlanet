drop database if exists PolyGlotPlanet;
create database PolyGlotPlanet;
use PolyGlotPlanet;

create table Lingua (
	codISOLingua char(2) primary key,
    nome varchar(50) not null,
    parlanti int not null,
    fotoStatoOrigine varchar(255)
);

create table Esperto(
	ID int auto_increment primary key,
    nome varchar(50) not null,
    cognome varchar(50) not null,
    email varchar(50) not null,
    passwordHash varchar(50) not null,
    dataNascita date not null,
    genere char(1) not null,
    valutazione int,
    fotoRiconoscitiva varchar(255) not null
);

create table Conoscenza(
	codISOLingua char(2),
    IDEsperto int,
    
    primary key(codISOLingua, IDEsperto),
    foreign key (codISOLingua) references Lingua(codISOLingua) on delete cascade on update cascade,
    foreign key (IDEsperto) references Esperto(ID) on delete cascade on update cascade
);

create table Utente(
	ID int auto_increment primary key,
    nome varchar(50) not null,
    cognome varchar(50) not null,
    dataNascita date not null,
    email varchar(50) not null,
    passwordHash varchar(50) not null,
    genere char(1) not null,
    admin boolean not null
);

create table Carrello(
	ID int auto_increment primary key,
    IDUtente int,
    
    foreign key (IDUtente) references Utente(ID) on delete cascade on update cascade
);

create table Categoria(
	ID int auto_increment primary key,
    nome varchar(50) not null,
    foto varchar(50) not null
);

create table Prodotto(
	ID int auto_increment primary key,
    prezzoBase double not null,
    scontoPercentuale double not null,
    prezzoAttuale double not null,
    IDCategoria int not null,
    codISOLingua char(2) not null,
    disponibile boolean default true,
    
	foreign key (codISOLingua) references Lingua(codISOLingua) on delete cascade on update cascade,
    foreign key (IDCategoria) references Categoria(ID) on delete cascade on update cascade
);

create table Ordine(
	ID int auto_increment primary key,
    prezzoTotale double not null,
    IDUtente int not null,
    
    foreign key (IDUtente) references Utente(id) on delete cascade on update cascade
);

create table Incontro(
	IDProdotto int not null,
    dataOra datetime not null,
    CAP varchar(20) not null,
    via varchar(50) not null,
    civico varchar(10) not null,
    prenotato boolean not null,
    IDEsperto int not null,
    avvenuto boolean not null,
    votoUtente int,
    
    foreign key (IDProdotto) references Prodotto(ID) on delete cascade on update cascade,
    foreign key (IDEsperto) references Esperto(ID) on delete cascade on update cascade
);

create table Colloquio(
	IDProdotto int not null,
    dataOra datetime not null,
    
    prenotato boolean not null,
    IDEsperto int not null,
    avvenuto boolean not null,
    votoUtente int,
    
    foreign key (IDProdotto) references Prodotto(ID) on delete cascade on update cascade,
    foreign key (IDEsperto) references Esperto(ID) on delete cascade on update cascade
);

create table Corso(
	IDProdotto int not null,
    descrizione varchar(255) not null,
    numeroUnita int not null,
    livello char(5) not null,
    
    foreign key (IDProdotto) references Prodotto(ID) on delete cascade on update cascade
);
create table Formazione(
	IDCarrello int,
    IDProdotto int,
    
    primary key(IDCarrello, IDProdotto),
    foreign key (IDCarrello) references Carrello(ID) on delete cascade on update cascade,
    foreign key (IDProdotto) references Prodotto(ID) on delete cascade on update cascade
);

create table Composizione(
	IDOrdine int,
    IDProdotto int,
    dataOra datetime not null,
    prezzoAcquisto double not null,
    
    primary key(IDOrdine, IDProdotto),
    foreign key (IDProdotto) references Prodotto(ID) on delete cascade on update cascade,
    foreign key (IDOrdine) references Ordine(ID) on delete cascade on update cascade
);



#trigger per calcolare attributo derivabile prezzoAttuale ad ogni inserimento
DELIMITER //

CREATE TRIGGER calcola_prezzo_attuale BEFORE INSERT ON Prodotto
FOR EACH ROW
BEGIN
    SET NEW.prezzoAttuale = NEW.prezzoBase - (NEW.prezzoBase / 100 * NEW.scontoPercentuale);
END//

DELIMITER ;


#trigger per aggiornare attributo derivabile prezzoAttuale in caso di modifiche a prezzoBase e/o scontoPercentuale
DELIMITER //

CREATE TRIGGER update_prezzo_attuale
BEFORE UPDATE ON Prodotto
FOR EACH ROW
BEGIN
    IF NEW.prezzoBase != OLD.prezzoBase OR NEW.scontoPercentuale != OLD.scontoPercentuale THEN
        SET NEW.prezzoAttuale = NEW.prezzoBase - (NEW.prezzoBase / 100 * NEW.scontoPercentuale);
    END IF;
END//

DELIMITER ;


DELIMITER //

CREATE PROCEDURE elimina_colloqui_non_prenotati()
BEGIN
    DELETE p
    FROM prodotto p
    INNER JOIN colloquio c ON p.ID = c.IDProdotto
    WHERE c.dataOra < NOW() AND c.prenotato = FALSE;
END //

DELIMITER ;

CREATE EVENT elimina_colloqui_evento
ON SCHEDULE
    EVERY 30 MINUTE
    STARTS '2024-07-11 10:00:01'
DO
    CALL elimina_colloqui_non_prenotati();
