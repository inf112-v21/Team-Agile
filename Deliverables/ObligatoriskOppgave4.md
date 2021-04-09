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
    * **Marius:** Power Down & Repair
    * **Anthony:** abstrakt -> game loop 
    * **Leif Petter:** Lage startup-meny
    * **Tore:** abstrakt-greier -> gui og flytting av spillere som dyttes
    * **Johnny:** Boostere 
    
    
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

**P**

**Akseptansekriterier:**
* 

**Arbeidsoppgaver:**
* S

***

<br/>

***

<br/>

***

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

***

## Retrospektiv

**Projektmetodikk:**

Vi

**Prosjektstruktur og gjennomførelse hittil:**

Vi

**3 forbedringspunkter:**
1. O
2. 
3. 

**Projectboard:**

[Project Board](https://trello.com/b/80a0xYw8/inf112-oblig-2)



<br/> 

**Gruppedynamikk og kommunikasjon:**



<br/> 

***