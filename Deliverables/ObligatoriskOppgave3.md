# Oblig 3

## Teamet
**Gruppenavn:** Team Agile

**Deltakere:**
* Tore Wie Bøe
* Leif Petter Sørbø
* Anthony Vu
* Johnny Tran
* Marius Skimmeland
  <br/>

***
## Møter
### Møtetidspunkt og møtereferater:
_Notater for hva som ble gjort og hva som er litt avklart er notert ned selve dagen møtetidspunktet skjedde._

MERK: Ingen arbeid er blitt gjort mellom møtene av noen i gruppen, såfremt det ikke er nevnt i selve møtereferatet.
Det meste av arbeid på prosjektet skjer under de faste møtetidspunkter.

**12.02.2021 : 12:15 - 14:00**
* Alle til stedet i starten, Marius måtte gå etter 20 min.
* Gikk gjennom hvilke krav vi ville oppnå i løpet av denne sprinten.
* Hva vi kom frem til er satt under "krav for oblig" øverst i dokumentet.
* Tore startet med å forklare Anthony og Johnny hvor langt han og Petter
  hadde komt på multiplayer, før han selv startet på et nytt krav.
* Marius hadde travelt idag og frem til tordag neste uke, så han ville ha et
  eget krav han kunne jobbe med denne tiden. Han ville jobbe med HUD og fikk dette som egen oppgave å implementere.
* Petter startet med å oppdatere project-board og marckdown-doc.


**15.03.2021 : 12:15-14:00**
* Johnny og Petter startet på design av brettet idag, og startet såvidt på implementasjon av vegger.
* Tore og Anthony jobbet videre på multiplayer.
* Marius jobber alene fortsatt og jobber med HUD.


**17.03.2021 : 12:15-14:00**
* Alle utenom Marius tilstede, han var på vei til jobb denne dagen.
  Han har også egen oppgave han jobber med så han bestemmer selv når
  det passer han i denne perioden.
* Tore og Anthony fortsetter på multiplayer.
* Petter og Johnny fortsetter på vegger på spillbrettet.

**17.03.2021 : 12:15-14:00**
* Alle tilstede, vi diskuterte litt om implementasjon av vegger,
  og fikk innspill fra kundekontakt, før vi fortsatte fra der vi slapp
  sist gang.
* Marius fikk ferdigsstilt HUD til i dag. Han ble videre med Petter og Johnny på implementasjonen av vegger og øvrig funksjoner på spillbrettet.
* Tore og Anthony har jobbet videre med multiplayer.

**22.03.2021 : 12:15-14:00**
* Denne dagen var Tore og Marius med på å jobbe på Wall-klassen ettersom Petter og Johnny hadde slitt litt dagene før med denne delen.
* Anthony jobbet seg videre ferdig med multiplayer gjennom dagen.

**24.03.2021 : 12.15-15:00**
* I forkant av denne dagen hadde Marius fått omtrent ferdigstilt Walls-klassen, så vi gikk gjennom denne sammen i starten av timen og såg på de endringene som var blitt gjort.
* Etterpå fortsatte videre Tore og Marius med Wall-klassen.
* Tore begynte også på laser-klassen.
* Johnny forstatte med å fylle ut på markdown doc.
* Petter lagde ferdig design på kartet og endret litt på øvrig design-struktur.
* Anthony startet på merging av multiplayer branch og master.


**25.03.2021 : 10:00 - 16:00**
* Johnny har i mellomtiden jobbet med Markdown doc og fått skrevet ned en del.
* Marius fikk i forkant av denne timen fullført hele walls-klassen, samt implementert branch map-design med Master.
* Marius og Anthony jobbet med merging fra klokken 10 av, hvorav noen utfordringer hadde oppståd i det en merget sammen alle branchene som var blitt jobbet på hittil.
* Etter endelig å ha merget ferdig fortsatte Anthony og Marius med fiksing av windows-size, font-sizes og småjusteringer for det visuelle i spillet. Fikk også fikset noen bugs som hadde oppstått.
* Petter ble med fra klokken 11:00 og forstatte videre der hvor Johnny slapp på markdown doc.
* Tore implementerte laser-klassen videre og jobbet med denne.
  <br/>
  
**26.03.2021 : 10:15 - **
* Fullført på Markdown doc og oppdaterert klassediagram
* Fullført laser-klasse
* Fullført tester for laser og vegger
* Fullført mindre bugs
* Refaktorert
* Slettet unødvendige kommentarer og linjer med kode / imports



***
## Krav for denne inneleveringen:
_Dette er målene vi har satt oss for å klare å fullføre for denne obligatoriske innleveringen:_

* multiplayer
* implementasjon av vegger
* implementasjon av laser
* implementasjon av tokens
* status bar/ noe som forteller oss hva som skjer me spiller(HUD)

<br/>

***
## Spesifikasjoner

### Brukerhistorier

**6. Spille fra flere maskiner (vise brikker for alle spillere, flytte brikker for alle spillere(Multiplayer))**
* Som spiller ønsker jeg å kunne spille mot flere spillere slik at vi kan spille mot hverandre.


**Akseptansekriterier:**
* Må kunne se andre spillere på spillbrettet
* "Connecte" med spillere gjennom en server over et LAN (Local area network)
* Må være stabilt
* Må fungere cross-platform (Mac/Windows/Linux)
* Hver spiller skal kunne ha en dialog med server slik at server reagerer på input fra spillere på andre datamaskiner.
* Spiller skal kunne bevege seg på brettet på sin skjerm og dermed også motspiller sin skjerm.


**Arbeidsoppgaver:**
* Sette opp slik at en av spillerene vil være vertskap for en server hvor alle andre spillere kobler seg til.
* spillere klarer å koble seg til.
* viser alle spiller på et og samme brett på hver datamaskin.
* bevege alle spillere på hver sin datamaskin og vise det likt på alle andre maskiner.

***

<br/>

**Implementasjon av vegger**
* Som spiller vil jeg det skal være hindinger som vegger på brettet slik at det gjør spillet mer utfordrene og at en ikke kan gå hvor en vil.


**Akseptansekriterier**
* Vegger skal vises på brettet og stoppe spiller som går mot veggen.
* dersom vegg er midt i brettet skal den stoppe spiller fra begge veier.


**Arbeidsoppgaver**
* Implimenter at spiller ikke kan gå utover kartets rammer
* Implimenter at spiller ikke kan gå forbi vegger som står foran spillerens retning, i nåværende tile og tilen foran spilleren.
* Implimenter at spiller blir stoppet dersom det er en vegg i tilen foran som er ligger i retning motsatt av det spilleren peker mot

<br/>


**Implementasjon av laser**
* Som spiller ønsker jeg at det skal være en ekstra spenning med spillet, som for.eks å miste liv / dø i spillet når en treffer en laser.


**Akseptansekriterier**
* Laser må ta liv fra spiller som er på laser tile.
* Flere lasere, jo flere liv tas.
* Når en spiller står foran en laser, så vil ikke laseret fortsette bak spilleren

**Arbeidsoppgaver**
* Implimenter at spiller mister hp ved å komme borti laser
* Implimenter at laser stopper "ruten sin" dersom det er en spiller i veien
* I ruter der det er flere laser, så skal antall liv mistet være lik antall laser

<br/>

**Implementasjon av HUD**
* Som Spiller ønsker jeg å få nødvendig info tilbake fra spillet, slik at jeg kan lage en strategi ut ifra informasjonen
* Som spiller ønsker jeg å se hvor mye liv jeg har igjen, slik at jeg vet hvor mye hp jeg har igjen til jeg dør
* Som spiller ønsker jeg å se hvor mange flagg jeg har samlet, slik at jeg vet hvor mange flagg jeg har igjen

**Akseptansekriterier**
* HUD må kunne vise fremgang i spillet, hva fremgangen gjelder og hvem det gjelder.
* så som spiller skal man få vite endringer som påvirker hvordan man spiller spillet, slik som hvor mange flagg man har,
  hvor mye liv en har, dersom man mister liv skal det oppdateres for riktig spiller og gis bedskjed om.

**Arbeidsoppgaver**
* Implementer sånn at det HUDen viser nødvendig informasjon. Powerdown, flagg, hp og vinner
* Legg informasjon på riktig posisjon så det ikke dekker eller står i veien for andre elementer i spillet
<br/> 

***
## Produktleveranse / kode

### Dokumentasjon om teknisk byggesett

Dette er å finne i README-dokumentet i selve prosjektet.

### Beskrivelse av prosjektet

Dette er å finne i README-dokumentet i selve prosjektet.
<br/>

### Kode

#### Klassediagram

![](/Deliverables/Images/ClassDiagramRoboRally2.png "Class Diagram")

**Hva vi ikke har fått til av kode:**
***

* Noe av koden kan ansees som litt uoversiktlig. Vi har litt gjenstående når det gjelder abstraksjon og refaktorering av selve koden. Dette vil være et mål i neste innlevering. 
* Spillet vårt går foreløpig ikke i en loop, som sjekker conditions sporadisk, så derfor har vi midlertidlig lagt til en funksjon hvor du gjøre tastetrykk
  "c" inne i spillet, da den vil sjekke conditions for den ruten du er i. Med neste innlevering så ønsker vi å implementere ferdig game-loop som sporadisk sjekker
  Tile brukeren står i, og gir informasjon om hva den aktuelle Tilen gjør.
* Vi har enda ikke tatt høyde for at spillerene flytter hverandre når de treffer på samme tile. Dette implementeter vi inn i neste innleveringen.  
* HUD er ikke ferdig implementert enda, da det mangler litt mer spill-logikk for at denne skal bli fullstendig.
  Mangler også fullstendig game-loop for at HUD-informasjonen skal kunne vises for hver condition som skjer (tatt flagg, mistet hp, power down etc).
  Men foreløpig resultat for HUD, og hvordan den er tenkt til å brukes, kan sees i bilde under:

![](/Deliverables/Images/HUD.png "HUD")

### Manuelle tester

**Multiplayer test med flere instanser på samme PC**
Vi hadde problemer med å hente modulene fra pom.xml filen derfor må du skjekke at lib mappen ligger i pathen til prosjektet høyre klikk på prosjekt mappen Team-Agile -> Open Module Settings -> Dependencies tab -> helt nederst av listen er det et "+" tegn.
-> Jars and Directories -> Velg ``lib`` som ligger i prosjekt mappen og apply.

Før man starter må man tillate at flere instanser av Main tillates. Åpne opp Main gå i menylinjen, og naviger deg til
run -> edit configurations -> modify options -> huke av på ``Allow multiple instances``

(les Known Bugs i ``Readme.md`` om feil oppstår ved gjennomføring av test)

Kjøre multiplayer med 2 instanser av Main på samme PC:

* Start en instans av Main, første instans av Main vil være hosten av serveren. Og skrive i terminalen til denne instansen ``no``.
* Deretter i Main skjekk at ``host`` variabel er satt til ``false`` og kjør flere instanser av Main for å koble nye instansen til hosten.
  For hver nye Main instanser som blir kjørt må det i første Main instansen som er Host skrive ``no`` visst du skal koble til flere instanser ellers ``yes`` for å starte og få tilgang til brukertaster(les i Multiplayer i readme.md for mer detaljert stegvis oppstart av Multiplayer)
* Start en ny Main instans til, og i første Main instansen som ble kjørt skriv ``yes``
* Nå skal 2 seperate spillvinduer være oppe , hvor hver av de har egne brukertaster og styrer hver sin robot.
* Gjennomfør noen av robot styringene ved hjelp av piltastene. Spilleren som flytter på seg flytter seg på samme måte i begge spillvinduene.
* Velg 5 kort med tastetrykkene fra 1-9 og trykk ``ENTER`` for å sende de valgte kortene til Server. Gjørs på begge spillvinduer individuelt.
* Når valgte kort er sendt fra begge spillvinduer, utføres kortene i sekvens for alle spillvinduene.
* Etter alle kortene er utført vil begge spillvinduer få nye kort og, stegene over kan gjøres på nytt.

<br/>

***
## Teambeskrivelse og rollefordeling
### Roller

**Fordeling av roller:**

Vi har ikke forandret noe på rollene fra første oblig, men rollene er ikke så fastsatt. Alle er med å bidrar sånn at arbeidet blir gjort.



**Teamleder:** Johnny (holde overordnet styr på alt som må bli gjort)

**Kundekontakt:** Marius (holder kontakt med gruppeleder)

**Backend-utvikler:** Anthony (holder overordnet styr på koden helhetlig og at vi har en god kodestil)

**Product-manager:** Tore (oversikt over det endelige produktet som leveres og ser over det før innlevering)

**Designer:** Leif Petter (har kontroll på hvordan det visuelle ser ut og har ansvar for bildefiler etc.)

<br>

## Retrospektiv

**Projektmetodikk:**

Vi justert endel på hvordan vi jobber fra den første obligatoriske innleveringen, men mye av det har holdt seg det samme.
Vi bruker fortsatt en blanding mellom Scrum og Kanban.
Vi kunne ha vært bedre å oppdatere projectboard oftere, men for det meste er vi flinke til skrive og flytte oppgaver på Trello projectboard.
I forhold til de tidligere innleveringene så har arbeidsoppgavene blitt mindre og mer konkrete. Dette har medført til at vi har økt begrensning av oppgaver som kan være i "work-in-progress".
Samtidig som mange av oppgavene også overlapper hverandre.

**Prosjektstruktur og gjennomførelse hittil:**

Vil si at vi er veldig fornøyd på det vi har klart frem til nå. Det er selvfølgelig ting vi kanskje burde ha forandret eller gjort bedre, men frem til nå har dette fungert.
Det vi kunne ha forbedret oss på er produktivitet.
Vi har for det meste delt oss inn i mindre grupper (som oftest parprogrammering), og fordelt arbeidsoppgavene.
Det vi kunne ha prøvd på, og som har vært diskutert i teamet, er å jobbe litt mer alene for økt produktivitet og kjappere fremgang.
Vi har fram til nå nesten alltid jobbet i grupper og har merket at av og til kan det ta litt tid før vi får startet.
Vi jobber med oppgaven mandag, onsdag og fredag der vi møter hverandre. Som oftest har vi 2 timer på oss, hvor mye av tiden
bruker vi å oppdatere hverandre hvordan det går med de forskjellige gruppene, planlegge hva vi skal gjøre og om noen trenger hjelp.
Dette er veldig tidkrevende, og ikke god utnyttelse av tid - som også fører til at vi må jobbe flere timer sammenhengende mot slutten av innleveringsfristen.

**3 forbedringspunkter:**
1. Organsering av arbeid er noe vi kan vær mer individuelt og effektivt på. Vi har nesten kun parprogrammert, men ser nå at det er mye vi kunne ha gjort alene for å være mer effektiv.
2. Selvom vi har ganske flinke med å kommunisere med hverandre, så kunne vi ha vært bedre når vi jobber individuelt. Dette er noe vi prøver å bli flinkere på.
3. Det som har fortsatt henger igjen helt fra alle innlevering er bedre planlegging. Denne har vi klart å planlegge litt lengre i forveien, men merker fortsatt det er mye som samler seg mot slutten av innleveringen.
   Dette kan vi bli enda bedre på og dele opp oppgavene jevnlig utover sprint perioden.


**Projectboard:**

![](/Deliverables/Images/TrelloProjectBoard2.png "Project Board")

Det vi har fokusert og prioritert på i denne innlevering er det siste MVP-kravet som var multiplayer.
Utenom denne så har vi priroritert å få på plass øvrig spilllogikk, som vegger & lasere. Det har også vært viktig å få på plass
den største grunnmuren av logikk, før vi i neste innleveringen kan fokusere på selve spill-loopen som skal gå gjennom hele spillet.

<br/> 

**Gruppedynamikk og kommunikasjon:**

Gruppedynamikken vår har vært utrolig bra og der har vi vært veldig heldig. Å jobbe med hverandre har aldri vært vanskelig og alle blir hørt.
Det skal sies at 4 av 5 i gruppen kjente hverandre fra før som har gjort det mye enklere. Vi har også laget en facebook chat hvor mye planlegger
oppdatere hverandre. Her planlegger vi møter, sier ifra om vi har tenkt å jobbe med oppgaven alene eller om vi lurer på noe angående koden.
Når vi bruker discord så har vi det ofte at det er en som styre møte sånn at vi ikke snakker over hverandre og får diskutert ting mer strukturert.
Frem til nå har vi nesten kun parprogrammert og har brukt Code With Me.

Når vi er ferdig med oppgaven vår, så bruker vi ofte en liten del av møte for å gå gjennom det som har blitt gjort. 
Her stiller vi ofte spørsmål om det er noe vi ikke forstår og kommer med forslag om endringer. 


Merk også at vi bruker Code With me flittig. Dette medfører i stor variasjon i commits blant teammedlemmene. 
En annen faktor til dette er også at de som skriver mye innhold på markdown dokumentet får også større status i "contributions" på Github, selv om
de ikke nødvendigvis har stått for majoriteten av arbeidet. 

<br/> 