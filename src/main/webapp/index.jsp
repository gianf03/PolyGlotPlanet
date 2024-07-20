<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <link type="text/css" href="css/index.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@ include file="WEB-INF/jsp/header.jsp"%>
    <div id="containerOfAll">

        <%
            if(request.getParameter("ordine") != null && request.getParameter("ordine").equals("effettuato")) {%>
                <script>alert("Ordine effettuato!")</script>
        <%} else if (request.getQueryString() != null && request.getQueryString().equals("error=25")) {%>
                <script>alert("Accesso negato!")</script>
        <%}%>


        <p id="selezionaMod">Benvenuto su PolyGlotPlanet!<br><br>Seleziona una modalità di apprendimento</p>

        <div id="containerCategorie">
            <c:forEach items="${categorie}" var="categoria" >
                <section>
                    <img class="categoria" src="${categoria.immagine}">
                    <a class="categoria" href="sceltaLingua.jsp?categoria=${categoria.nome}">
                        <div id="divLinkCat">
                            ${categoria.nome}
                        </div>
                    </a>
                </section>
            </c:forEach>
        </div>

        <div id="divDescrizione">
            <div class="divTextImg" id="divBenvenuto">
                <div class="divText">
                    Benvenuti su PolyGlotPlanet, il tuo universo dedicato all'apprendimento delle lingue!
                    La nostra missione è rendere l'apprendimento linguistico un'esperienza accessibile, divertente
                    e soprattutto efficace. Siamo qui per accompagnarti passo dopo passo nel tuo viaggio
                    verso la padronanza di nuove lingue, offrendo strumenti e risorse di alta qualità per
                    diventare un vero poliglotta.
                </div>
                <div class="divImg">
                    <img alt="cartello benvenuto" src="img/welcome.png">
                </div>
            </div>
            <div class="divTextImg">
                <div class="divText">
                    <p class="parDesc">I nostri fondatori: Gianf & Sebax</p><br>
                    PolyGlotPlanet nasce dalla passione e dalla visione di Gianf e Sebax, appassionati
                    linguisti con oltre 20 anni di esperienza nell'insegnamento delle lingue. Hanno
                    iniziato il loro percorso linguistico all'università, dove hanno studiato lingue e letterature straniere.
                    Dopo la laurea, hanno viaggiato e lavorato in vari paesi, acquisendo una profonda comprensione
                    delle sfide e delle gioie dell'apprendimento linguistico. La loro esperienza internazionale
                    e il desiderio di condividere il potere della comunicazione interculturale li hanno ispirati
                    a creare PolyGlotPlanet.
                </div>
                <div class="divImg">
                    <img alt="fondatore stilizzato" src="img/fondatore.png">
                </div>
            </div>
            <div class="divTextImg">
                <div class="divText">
                    <p class="parDesc">Il Nostro Approccio Innovativo</p><br>
                    PolyGlotPlanet si distingue per il suo approccio unico e interattivo all'apprendimento delle lingue.
                    I nostri corsi sono stati progettati per essere coinvolgenti e dinamici, utilizzando una combinazione
                    di tecnologia avanzata, contenuti multimediali e attività pratiche che stimolano la conversazione reale.
                    Che tu voglia imparare l'inglese, lo spagnolo, il francese, il tedesco o una delle altre lingue
                    disponibili, troverai programmi adatti a ogni livello, dai principianti agli avanzati.
                    Le nostre lezioni sono strutturate per favorire un apprendimento naturale, simulando situazioni
                    di vita reale e promuovendo l'interazione attiva.
                </div>
                <div class="divImg">
                    <img alt="idea innovativa stilizzata" src="img/innovazione.png">
                </div>
            </div>
            <div class="divTextImg">
                <div class="divText" id="divServizi">
                    <p class="parDesc">I Nostri Servizi</p><br>
                    Lezioni Online Personalizzate: Offriamo lezioni individuali, tenute da insegnanti
                    madrelingua qualificati, che si adattano alle tue esigenze e ai tuoi obiettivi di apprendimento.
                    Le lezioni possono essere prenotate in base alla tua disponibilità, rendendo l'apprendimento
                    flessibile e conveniente.<br><br>

                    <b>Accesso 24/7:</b> La nostra piattaforma online è disponibile in qualsiasi momento, permettendoti
                    di studiare quando e dove vuoi, senza limitazioni. Puoi accedere ai materiali didattici, esercitarti
                    con i test interattivi e partecipare alle lezioni in diretta ovunque ti trovi.<br><br>

                    <b>Materiali Didattici Innovativi:</b> Offriamo una vasta gamma di risorse, tra cui video interattivi,
                    esercizi di grammatica e vocabolario, giochi educativi e attività di ascolto. Questi strumenti
                    sono progettati per rendere l'apprendimento stimolante e vario, aiutandoti a migliorare rapidamente
                    le tue competenze linguistiche.
                </div>
            </div>
            <div class="divTextImg">
                <div class="divText">
                    <p class="parDesc">Perché Scegliere PolyGlotPlanet?</p><br>
                    PolyGlotPlanet non è solo una scuola di lingue, ma una comunità che ti sostiene e ti ispira lungo
                    il tuo percorso di apprendimento. Crediamo che imparare una nuova lingua debba essere un'avventura
                    entusiasmante, e ci impegniamo a rendere ogni lezione interessante e motivante. Con il nostro supporto
                    continuo, feedback personalizzato e un ambiente di apprendimento stimolante, riuscirai a raggiungere
                    i tuoi obiettivi linguistici in modo efficace e piacevole.

                    Inizia oggi la tua avventura con PolyGlotPlanet e scopri il piacere di imparare nuove lingue!
                </div>
                <div class="divImg">
                    <img alt="perchè stilizzato" src="img/perché.png">
                </div>
            </div>
        </div>
    </div>
<%@ include file="WEB-INF/jsp/footer.jsp"%>
    <script src="JavaScript/cambiaAltezza.js"></script>
</body>
</html>
