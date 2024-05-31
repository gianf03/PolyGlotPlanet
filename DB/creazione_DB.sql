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
    fotoRiconoscitiva varchar(255)
);

create table Conoscenza(
	codISOLingua char(2),
    IDEsperto int,
    
    primary key(codISOLingua, IDEsperto),
    foreign key (codISOLingua) references Lingua(codISOLingua),
    foreign key (IDEsperto) references Esperto(ID)
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
    
    foreign key (IDUtente) references Utente(ID)
);

create table Categoria(
	ID int auto_increment primary key,
    nome varchar(50) not null
);

create table Prodotto(
	ID int auto_increment primary key,
    prezzoBase double not null,
    scontoPercentuale double not null,
    IDCategoria int not null,
    
    foreign key (IDCategoria) references Categoria(ID)
);

create table Ordine(
	ID int auto_increment primary key,
    prezzoTotale double not null,
    IDUtente int not null,
    
    foreign key (IDUtente) references Utente(id)
);

create table Incontro(
	IDProdotto int primary key,
    dataOra datetime not null,
    CAP varchar(20) not null,
    via varchar(50) not null,
    civico varchar(10) not null,
    prenotato boolean not null,
    IDEsperto int not null,
    avvenuto boolean not null,
    votoUtente int,
    
    foreign key (IDProdotto) references Prodotto(ID),
    foreign key (IDEsperto) references Esperto(ID)
);

create table Colloquio(
	IDProdotto int primary key,
    dataOra datetime not null,
    
    prenotato boolean not null,
    IDEsperto int not null,
    avvenuto boolean not null,
    votoUtente int,
    
    foreign key (IDProdotto) references Prodotto(ID),
    foreign key (IDEsperto) references Esperto(ID)
);

create table Corso(
	IDProdotto int primary key,
    descrizione varchar(255) not null,
    numeroUnita int not null,
    livello char(2) not null,
    codISOLingua char(2) not null,
    
     foreign key (IDProdotto) references Prodotto(ID),
     foreign key (codISOLingua) references Lingua(codISOLingua)
);

create table Formazione(
	IDCarrello int,
    IDProdotto int,
    
    primary key(IDCarrello, IDProdotto),
    foreign key (IDCarrello) references Carrello(ID),
    foreign key (IDProdotto) references Prodotto(ID)
);

create table Composizione(
	IDOrdine int,
    IDProdotto int,
    dataOra datetime,
    prezzoAcquisto double not null,
    
    primary key(IDOrdine, IDProdotto, dataOra),
    foreign key (IDProdotto) references Prodotto(ID),
    foreign key (IDOrdine) references Ordine(ID)
);

