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

**09.04.2021 : 10:15 - 12:00**
* Alle møtes
* Laget nytt markdown-doc. 
* Blitt enige om hvilke krav vi ønsker å fullføre for denne innleveringen og notert ned i markdown-doc. 
* Fordelt ut oppgaver til hver av oss: 
    * **Marius:** Power Down, Rotation & Repair
    * **Anthony:** abstrakt -> game loop 
    * **Leif Petter:** Lage startup-meny
    * **Tore:** abstrakt-greier -> gui og flytting av spillere som dyttes
    * **Johnny:** Boostere 
  
**16.04.2021 : 10:15 - 12:00** 
* Alle møtte opp
* Tore og Petter hadde startet litt på GUI før dette møte, men ville ha litt info fra gruppa hvordan 
  oppsettet skulle være på koden.
* Fikk senere hjelp fra Anthony med å fortsette på koden til Menu branch, og Marius som var med på å designe
  bakgrunn til mainmenu og kanppene "start game" og "exit game"
* Fikk implementert knappene "Start Game" og "Exit Game" på menyen. slik at spillet startet og avsluttet.
* Johnny var litt syk denne dagen, men møtte fortsatt opp på discord å fortsatte med implementasjonen av Boostere

**19.04.2021 : 12:15 - 14:00**
* Denne dagen var Marius på jobb og Johnny hadde en ærend, så han kom en 45 min etter de andre. 
* Vi fikk merget inn både Menu branchen og Gameloop branchen til master. 
* Tore startet på ny branch for å implementere "Pushing" på robotene. slik at dersom de traff hverandre vil
  robot bli dyttet.
* Petter fortsatte på markdown dokumentet.
* Anthony fortsetter på main menu, for å implementere multiplayer knappen.

**20.04.2021 : 12:15 -**
* Alle var tilstede. Marius dro for å arbeide alene på powerdown, rotation og repair.
* Johnny og Athony jobbet på Boostere.
* Tore fortsatte pushing av roboter. 
* Petter fortsatte å oppdatere marcdown.doc. 

**21.04.2021 : 12:15 -**
* Alle tilstede
* Johnny og Anthony fikk gjort mye på klassediagram
* Tore og Leif Petter fikk startet på javadoc-dokumentasjon
* Marius fikk ferdigimplementert Rotation-klassen og repair-klassen. Fikk også implementert PowerDown, sammen med Anthony. 

**22.04.2021 : 12:15 -**
* Alle var tilstede.
* I forkant av dette møtet hadde Marius fått ferdigstilt tester til Repair og Rotation, samt startet på powerDown. 
  Også fått gjort litt designendringer. 
  
***
## Krav for denne inneleveringen:
_Dette er målene vi har satt oss for å klare å fullføre for denne obligatoriske innleveringen:_

* Fikse at prosjektet bygger i Travis
* Gjøre koden mer oversiktlig. Fikse abstraksjon
* Lage game-loop
* Fullføre HUD slik at denne gir informasjonen som er nødvendig gjennom selve loopen. 
* Fikse slik at spillere flytter på hverandre om de treffer på samme tile
* Implementere Power Down, Repair, Boostere
* Lage en startup-meny hvor du starter spillet fra og velger multiplayer
* Fikse tester tilhørende de nye implementasjoner fra denne obligen. 


<br/>

***
## Spesifikasjoner

### Brukerhistorier

**Implementasjon av Main Menu**
* Som bruker ønsker jeg å bli møtt med en meny som er oversiktilig, lett å forstå og som gjerne kan vise frem
  hvilket spill jeg faktisk spiller. 

**Akseptansekriterier:**
* spiller skal kunne bruke muse-klikk for at noe skal skje i main menu. 
* Som spiller vil jeg at jeg skal kunne starte spillet som single player og multiplayer
* Som spiller vil jeg kunne avsluttet spillet fra meny-en. 

**Arbeidsoppgaver:**
* Design av bagrunn og knapper på Main menu. 
* implementasjon av posisjon til 

***

<br/>

**Implementasjon av Pushing**
* Som spiller vil jeg at spille skal være "realistisk", så når jeg som spiller treffer en annen spiller, 
  vil jeg at han skal flyttes i samme retning.
* Som spiller vil jeg ikke bli hindret av andre, samtidig som jeg vil ha muligheten for å kunne sabotere litt for andre.

**Akseptansekriterier**
* Spiller skal ikke bli stoppet av andre spillere. Motspillere skal heller bli flyttet av spiller, dersom de skulle 
  kollidert.
* dersom det to spillere kolliderer men retningen til spiller som skal flyttes blir blokert av vegg, skal ingen av 
  spillerne flyttes.

**Arbeidsoppgaver:**


<br/>

**Implementasjon av GameLoop** 
* Som bruker ønsker jeg at spillet skal gå av seg selv. 
* Ønsker at spillet skal holde styr på runder og faser i spillet.


**Akseptansekriterier**
* Som Spiller vil jeg at trekkene til spillerne går i rekkefølge, og at spillere går en etter en. 
* Som Spiller vil jeg at spillet selv skal holde styr på hvor mange kort jeg skal kunne velge mellom, og at for hver 
  runde så får jeg nye valg muligheter.

**Arbeidsoppgaver:**
* Gameloop skal kalles på når antall registers mottat av serveren er lik antall tilkoblinger til spillet. f.eks. 2 spillere , da kalles gameloop så fort serveren mottar 
register fra hver av spillerene.
* Gameloop utfører alle Phasene i hver runde i riktig rekkefølge.

<br/>

**Implementasjon av Boostere/rullebaner** 
* Som spiller ønsker jeg at det skal være mulighet for å komme fortere fremover eller andre muligheter for bevegelse 
  utenom egne steg. 


**Akseptansekriterier**
* Spiller må kunne beve seg i samme retningen som pilene på booseteren viser.
* Spiller skal flyttes 1 eller 2 tiles etter hvilken type booster, etter runden er ferdig.

**Arbeidsoppgaver:**

<br/>

**Implementasjon av Repair**
* Som spiller ønsker jeg å ha muligheten til å kunne få tilbake liv i spillet ved å gå på repair-tiles

**Akseptansekriterier**
* Som spiller vil jeg kunne få tilbake liv når jeg går på de ulike repair-tiles. 
* Når jeg går på en tile med to repair-verktøy så skal jeg kunne få to healthpoints. 
* Når jeg går på en tile med ett repair-verktøy så skal jeg kunne få ett healthpoints.

**Arbeidsoppgaver:**
* Lage en egen klasse for repair
* Lage en egen layer i map for repair
* Registere alle repair-tiles i en liste, slik at en kan iterere over de
* Lage en check som sjekker for hver gang spilleren står på en repair tile, og i så tilfelle så skal spilleren få hp
* Sjekke at spilleren ikke kan få mer enn 9 hp. F.eks om spilleren havner på en dobbel-repair når en har 8 hp --> så skal en bare ende opp med 9 hp maks. 

<br/>

**Implementasjon av Rotation**
* Som spiller ønsker jeg å rotere når jeg lander på en rute med rotering. 

**Akseptansekriterier**
* Som spiller vil jeg rotere til venstre eller høgre når jeg havner på en av de to rotation-flisene. 
* En skal bare rotere en gang (+90 eller -90, avhengig av retning.)

**Arbeidsoppgaver:**
* Lage en egen klasse for rotation
* Lage en egen layer i map for rotation
* Registere alle rotation-tiles i en liste, slik at en kan iterere over de
* Lage en check som sjekker for hver gang spilleren står på en rotation tile, og i så tilfelle så skal spilleren roteres mot retningen tilen representerer

<br/>


**Implementasjon av PowerDown**
* Som spiller ønsker jeg at det skal finnes en PowerDown mulighet, slik at jeg ikke beveger og dermed hopper over min tur.

**Akseptansekriterier** 
* Som spiller ønsker jeg at en PowerDown skal være mulig.
* En PowerDown skal kun gjøre slik at spiller ikke beveger seg av kortene. 
* Dersom spiller står i laser eller på Booster så vil spiller miste liv eller bli beveget i retning av Booster.
* For at spiller mister trekkene sine skal spiller få noe tilbake. x-antall hp.
* Alle spillerene må både kunne se seg selv og andre som gjør PowerDown

**Arbeidsoppgaver:**
* Legge inn en knapp hvor en kan trykke på powerDown i starten av hver runde
* Implementere inn PowerDown for alle spillere, også slik at de ser sine motsandere som har PowerDown
* Påse at PowerDown beholder samme tile-lokasjon ved neste runde

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

* P
![](/Deliverables/Images/HUD.png "HUD")

### Manuelle tester

**Multiplayer test med flere instanser på samme PC**
Vi hadde problemer med å hente modulene fra pom.xml filen derfor må du skjekke at lib mappen ligger i pathen til prosjektet høyre klikk på prosjekt mappen Team-Agile -> Open Module Settings -> Dependencies tab -> helt nederst av listen er det et "+" tegn.
-> Jars and Directories -> Velg ``lib`` som ligger i prosjekt mappen og apply. Har funnet ut i etterkant at vi får problemer om vi laster ned kryonet modulene gjennom pom.xml filen ettersom kryonet versjonen gjennom maven er en annen versjon enn det vi har brukt når vi implementerte multiplayer, dermed må vi benytte oss 
av den manuelle måten for å laste modulene for at ting skal funke.

Før man starter må man tillate at flere instanser av Main tillates. Åpne opp Main gå i menylinjen, og naviger deg til
run -> edit configurations -> modify options -> huke av på ``Allow multiple instances``

(les Known Bugs i ``Readme.md`` om feil oppstår ved gjennomføring av test)

Kjøre multiplayer med 2 instanser av Main på samme PC:

* Start en instans av Main, en Main menu screen vil komme opp, hvor man får valgene mellom Join Game/Host Game/Exit Game. Første instans velger man Host Game og i tastefeltet skriver inn 2 for å teste med 2 roboter, deretter ``continue`` og hele spillet vil vises.
* Start en ny instans til av Main, på denne instans velger du Join Game og instansene kobles til den forrige instansen som hostet game.
* Nå skal 2 seperate spillvinduer være oppe og spillet startes, hvor hver av de har egne brukertaster og styrer hver sin robot.
* Gjennomfør noen av robot styringene ved hjelp av piltastene. Spilleren som flytter på seg flytter seg på samme måte i begge spillvinduene.
* Velg 1-5 kort med tastetrykkene fra 1-9 eller ved museklikk på kortene, og trykk ``ENTER``/``Lock Cards`` knappen for å sende de valgte kortene til Server. Gjørs på begge spillvinduer individuelt.
* Når valgte kort er sendt fra begge spillvinduer, utføres kortene i sekvens for alle spillvinduene.
* Serveren utfører gameloopen og en hel runde av spillet utføres.
* Etter alle kortene er utført vil begge spillvinduer få nye kort og, stegene over kan gjøres på nytt.


Teste PowerDown på spiller.
* start spillet, gjerne går slik at spiller mister hp.
* deretter gå tilbake til posisjon hvor spiller ikke mister hp, trykk powerdown, eller knappen ``p``.
* forventes da at du skal få 9 hp, som er maks hp. men skal ikke kunne bevege deg før neste runde.
* dersom du tar powerdown og står i et felt med laser.
* skal du får 9 hp i starten og miste 1 hp for hver fase i hver runde.
* så du kan forvente å ha 4 hp igjen etter en full runde med en spiller som har brukt powerdown som også
  blir truffet av laser.
  
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

***

## Retrospektiv

**Projektmetodikk:**

Prosjektmetodikken har holdt seg ganske konsekvent gjennom alle obligene. Har gjerne mindre definerte grupper enn før. 
Vi deler mer opp etter hvilke oppgaver som krever flere personer.
Så vi beholder fortsatt illusjonen av en sprint mellom innleveringsdatoene og prøver å holde en WIP limit slik at vi 
starter kun på oppgaver når vi er ferdig med en annen. 
Denne gangen hadde vi ingen krav som overskredet sprinten så dermed fikk vi beholdt scrum delen av metodikken vi ville 
prøve å utføre. 
Så vi beholder en konsekvent metodikk med Kanban og litt Scrum. 

**Prosjektstruktur og gjennomførelse hittil:**

Selve strukturen ved å jobbe sammen på bestemte tidspunkt har sine positive og negative sider. Siden ikke alle er like 
sterke på kodedelen, er det lettere for de å spørre og komme videre med krav de har fått. Men noen ganger er det også gjerne
mye diskusjon om småting som løser seg selv dersom man bare starter. 
Men det er også mulighet for å jobbe alene dersom man ønsker det. 

**3 forbedringspunkter:**
1. Starte på obligen tidligere(hvertfall på denne obligen). 
2. 
3. 

**Projectboard:**

[Project Board](https://trello.com/b/80a0xYw8/inf112-oblig-2)



<br/> 

**Gruppedynamikk og kommunikasjon:**
Alle i gruppen er nok meget fornøyd med dynamikken og kommunikasjonen mellom hverandre. Vi er flinke til å spør om hjelp
dersom noen sliter, vi er gode på å finne nytt arbeid dersom vi ser noe mangler eller ender opp med å bli ferdig med 
et krav vi har satt oss. Og dersom noen ikke finner noe så spør vi om noen andre trenger hjelp med noe. De som er litt
sterkere å kode tar å hjelper litt ekstra dem som kanskje sliter litt mer, men alle er med på kodingen. Dersom noe 
ikke er forstått av oppgaver, eller dersom en implementasjon henger sammen med noe annet så er det aldri et problem 
at vi forklarer hva som er blitt gjort slik at det blir enklest mulig for alle parter å samarbeide/forstå andres kode. 


<br/> 

***