# PROSJEKTDOKUMENT INF112

#### Obligatorisk oppgave 2

## Teamet
**Gruppenavn:** Team Agile

**Deltakere:**
* Tore Bøe
* Leif Petter Sørbø
* Anthony Vu
* Johnny Tran
* Marius Skimmeland

<br/> 

## Møter
### Møtetidspunkt og møtereferater:
_Notater for hva som ble gjort og hva som er litt avklart er notert ned selve dagen møtetidspunktet skjedde._

MERK: Ingen arbeid er blitt gjort mellom møtene av noen i gruppen, såfremt det ikke er nevnt i selve møtereferatet. 
Det meste av arbeid på prosjektet skjer under de faste møtetidspunkter. 

<br/> 

**17.02.20 12:15-14:00:**
* Første møte etter oblig 1 var innlevert. Her møttes samtlige, bortsett fra Tore (han var ikke klar over at 
  vi skulle møtes).
* Gikk kort gjennom hvordan vi tenkte å omstrukturere gruppefordelingen vår gjennom neste innelevering, hvilke 
  MVP-punkter vi skulle gjennomføre også så vi gjennom selve oblig 2. I og med Tore ikke var tilstede avsluttet
  vi møtet kort etter å ha sett for oss hvilke MVP-krav vi skulle ta for oss ved neste møtetidspunkt.

<br/> 

**19.02.20 10:15-12:00**
* Alle tilstede. Fikk oppdatert Tore på hvilke avklaringer vi fikk gjort ved forrige møtetidspunkt. 
* Fikk begynt på 2 MVP krav: Spille fra flere maskiner og dele ut kort (MVP krav 6 & 7). 
* Lagte en branch for hver MVP-krav og delte oss inn i grupper. Startet her med å jobbe med MVP-kravet. 
* Brukte en del tid på å få til selve branch-delen i git og bli trygge på dette.

<br/> 

**22.02.20 12:15-14:00:**
* Alle tilstede. 
* Fortsatte med kodingen i gruppene vi har delt oss inn i. 
* Møtte på en del problemer i forbindelse med organisering av koden og selve strukturen i hvordan en skal organisere 
  kortdekket og hvordan vi skal kode inn de ulike paramterene som trengs til de ulike korttypene. 
  Brukte mesteparten av tiden her til å snakke om hvordan dette burde struktureres.
* Andre problemer var å bruke Kryonet. Fikk ikke til å laste ned gjennom maven og måtte derfor manuelt legge til 
  Kryonet i library. Dette måtte gjøres manuelt på hver datamaskin for å kunne importere metoder 
  og lignende fra kryonet.
* Men fikk endelig startet litt med kodingen men støttet stadig på problemer ettersom forståelsen slet litt, 
  siden kryonet var noe helt nytt for begge som var på denne gruppa.
  

<br/> 

**24.02.20 12:15-14:00:**
* Alle tilstede.
* Anthony hadde mellom forrige møtet og dette møtet kodet endel videre på rotasjonene på spilleren. Til dette møtet 
  så hadde Anthony fått implementert all rotasjonslogikk for spilleren. 
* Fortsatte her på MVP-kravene 6 & 7. Anthony byttet gruppe dette møtetidspunktet for å hjelpe til
  med koden til MVP-krav 6.


<br/> 

**25.02.20 12:15-14:00:**
* Alle tilstede. 
* Her gikk vi gjennom i plenum hvordan koden til kortdekket og korttypene per nå er strukturert, da vi har ikke vært 
  helt enige om hvordan vi skal gjøre dette. Snakket sammen om mulig løsninger før vi delte oss ut i grupper. 
  Denne dagen delte vi oss i litt andre grupper, for å begynne på markdown-dokumentet som skal innleveres, 
  samtidig som den gjenværende gruppen forsatte på MVP krav 7, som handlet om å dele ut kortene.
* delte oss inn i andre grupper ettersom det var spørsmål relatert til MVP-krav 6 som heller skulle tas opp med 
  gruppeleder (Jens), og dermed kunne vi få andre øyner på krav 7 og startet på markdown-doc. 
  
  
<br/> 

**26.02.20 10:15-12:00**
* Alle tilstede. 
* Implementert programCards. Lagde enum for alle korttyper.
* Begynte med libgdx sin nettverks-API istedenfor kryonet.


<br/> 

**01.03.20 12:15-14:00:**
* Alle tilstede
* Fikk oppdatert kartet og laged GUI for hvor kort initialiseres.
* Implementerte ferdig kort-klassen og begynte på deck. 
* Fortsatte med libgdx nettverks-API, sto fast med en json-fil.

<br/> 

**03.03.20 12:15-14:30:**
* Alle tilstede
* I forkant av dette møtet har Anthony ferdig implementert visualisering av utdelingen av kort. 
* Oppsummerte hva vi har fått til nå, og hva som gjenstår å gjøres før innlevering. 
* Testet kompabilitet tvers over forskjellige operativssystemer. Gikk fint, yay! 
* Merge av playingcards-branch inn i master-branch
* Refaktorert mye kode og slettet en del unødig kode
* Fikset litt på README og justert på brukerhistorier


* Fikse til neste møtetidspunkt (fredag 09:00):
          
  Marius:
  *   deck-test
  *   fikse markdown-doc (nærmere fullføre)
  *   fikse scaling på vinduet i spillet
            
              
  Anthony:
  * Utføre PlayingCardTest
        
  Johnny:
  * Klassediagram
    
  Leif Petter:
  * Fikse playerTest
  * Ferdigstille markdown-doc sammen med Marius (lese over det som har blitt skrivet. sjekke at vi har alt vi trenger)
      
  Tore:
  * testAllFlagsTaken
  * se over Trello
      


<br/> 

**05.03.20 09:00-12:00**
* Fikset fra forrige gang:

    * Marius: har implementert og fullført DeckTest. Implementert noen tester i RobotTest. Fikset på endel refaktorering. Fyllt ut mer på prosjektdoc. Ordnet window-size og font til å matche slik at 
      programmet åpnes i riktig størrelse og med riktig formatering
         
    * Anthony: Implementert PlayingCardTest. Fiksit prioritet til kortene slik at det printes i kortets rute i selve GUI
    
    * Tore: Implementert noen tester i RobotTest og gjort setup() i RobotTest. Sett over Trello
    
    * Leif Petter: Fikset noe på prosjektdoc. 
    
    * Johnny: Laget klassediagram.
* Ferdigstilt testklasse PlayingCardTest
* Ferdigstilt README.md med oppdaterte build-comments
* Ferdigstilt prosjektdoc
* Sett over kode. Forsøkt å refaktorere noe, slette noe unødige linjer etc.
<br/>

## Teambeskrivelse og rollefordeling

**Fordeling av roller:**

Her har vi hatt god erfaring fra oblig 1 og synes rollene har vært ganske så ålreit. Bestemte oss for at vi beholder rollene slik de er, inntil videre. 

### Roller

**Teamleder:** Johnny (holde overordnet styr på alt som må bli gjort)

**Kundekontakt:** Marius (holder kontakt med gruppeleder)

**Backend-utvikler:** Anthony (holder overordnet styr på koden helhetlig og at vi har en god kodestil)

**Product-manager:** Tore (oversikt over det endelige produktet som leveres og ser over det før innlevering)

**Designer:** Leif Petter (har kontroll på hvordan det visuelle ser ut og har ansvar for bildefiler etc.)

<br/> 

### Project board

![](/Deliverables/Images/TrelloProjectBoard.png "Project Board")


**Link:** https://trello.com/b/80a0xYw8/inf112-oblig-1

<br/> 

### Møtetidspunkt og møtestruktur

**Faste møtetidspunkt:**
* Mandager 12:15 - 14:00
* Onsdager 12:15 - 14:00
* Fredager 10:15 - 12:00

Møtets varighet endres litt ut fra behov. Møtetidspunktene er i hovedsak for å kunne snakke om fremdrift og se behovene
for hva som må gjøres for å komme i mål med prosjektet, samt fortsette på koding i grupper. 

<br/> 

**Fast møtestruktur:**
* Gå gjennom dagens agenda
* Se på project board // se på prosjektstatus
* Gå inn i grupper og fortsette på hver gruppe sitt MVP-krav. 

### Oppfølging av arbeid
* Oppfølging av arbeid som er gjenstående gjøres sporadisk gjennom møtepunktene i løpet av uken, 
  samt via Project Board på Trello. 


<br/> 

## Spesifikasjon


### Brukerhistorier

_Brukerhistorier for punkt 6-8 MVP fra oppgaveteksten i oblig1:_
 

**6. Spille fra flere maskiner (vise brikker for alle spillere, flytte brikker for alle spillere)**
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

<br/> 

**7. Dele ut kort**
* Som spiller ønsker jeg å få utdelt kort fra en shufflet deck i starten av spillet, slik at jeg kan bruke kortene til å planlegge trekkene mine.
* Som spiller ønsker jeg å se hvilken prioritet og bevegelser kortene mine har, slik at de blir lettere å velge hvilke kort jeg vil ha. 


**Akseptansekriterier:**
* Spilleren får ni stk. kort hver som en kan se over
* Kortenes prioritet må kunne vise og deretter må alle spillerens sin rekkefølge for trekk prioriteres ut fra hvilken
  prioritet som ligger i kortet.


**Arbeidsoppgaver:**
* Må lage et deck på 84 kort hvor en har sortert ut alle de ulike kortene med ulik prioritet.
    * backup: 6 kort (430 - 480)
    * u-turn: 6 kort (10 - 60)
  * rotate right: 18 kort (80-420, intervall 20)
  * rotate left: 18 kort (70-410, intervall 20)
  * move 1: 18 kort (490 - 650, intervall 10)
  * move 2: 12 kort (670 - 780, intervall 10)
  * move 3: 6 kort (790 - 840, intervall 10)
* Prioritet skal gis for hvert kort i bunken, i intervallene som er gitt over.
* Må starte spillet med å dele ut kort til alle spillerene. Må randomnize deck og deretter dele ut 9. stk kort til hver spiller
* Hvert kort må inneholde parameter for bevegelser som igjen kan hentes opp når spiller bruker kort.
* Må visualisere kortene som blir delt ut på brettet

<br/>


  **8. Velge 5 kort**
* Som spiller ønsker jeg, ut fra kortene jeg har fått utdelt, velge ut fem kort slik at jeg kan bruke de som trekk i spillet


**Akseptansekriterier:**
* Må kunne velge kortene ved eksempelvis bruke tastatur
* Må kunne se hvilke kort som er valgt på et eget område på brettet


**Arbeidsoppgaver:**
* Lage plass i brettet til å se hvilke kort en har valgt
* Gjøre det mulig for spiller å velge kortene vha tastatatur

<br/>

  **9. Bevege robot ut fra valgte kort** 
* Som spiller ønsker jeg å kunne bruke kortene jeg har valgt ut slik at roboten kan flytte
  seg etter hva kortene representerer av trekk.
* Som spiller ønsker jeg at de spillerene med høyest prioritet på kortet sitt, for hvert trekk, de 
  skal også få gjøre trekket sitt først.


**Akseptansekriterier:**
* Spillet må prioritere den spilleren som har høyest prioritet og utføre hva utføre det kortet 
  til den spilleren sier først, deretter de andre i prioriteringen. 
* Etter å ha fått vite hva kortet sier, skal spillet utføre det på brette visuelt. 
* Det som skjer på brette må være det samme som kortet sier. 
  
**Arbeidsoppgaver:**
* Robot må endre trekk etter hvert kort som blir brukt. 
* Må legge inn hensyn til prioritet, vha en form for PriorityQueue, slik at roboten 
  som har høyest prioritet får bevege seg først.
* Når første robot er ferdig med sitt trekk skal spillet forsette å følge PriorityQueue-en, 
  helt til alle spillere har gjort sitt trekk. 
  
  <br/>

## Produktleveranse / kode

### Dokumentasjon om teknisk byggesett

  Dette er å finne i README-dokumentet i selve prosjektet. 

### Beskrivelse av prosjektet 

  Dette er å finne i README-dokumentet i selve prosjektet.
<br/>

### Kode

#### Klassediagram

![](/Deliverables/Images/ClassDiagramRoboRally.png "Class Diagram")

  **Hva vi ikke har fått til av kode:** 

Multiplayer:

Tore og Petter har forsøkt en del på å implementere multiplayer men har støtt på en del problemer. Først valgte de
å forsøke med en Kryonet implementasjon, som viste seg å være litt for omfattende og kanskje litt for lavnivå for jobben.
De valgte derfor å forsøke med libgdx sin nettverks-API. Det har vist seg å være litt tidkrevende å komme ordentlig i
gang ved å lese tutorialet, da særlig å få importert en korrekt json-fil for å vise et vindu hvor det implementeres
nettverks-funksjonalitet. Forhåpentligvis vil ting gå en del fortere når disse tingene er løst.

Det som er gjort hittil av Multiplayer er å finne under egen libgdxmultiplayer-branch i prosjektet, og det som ble
gjort før det ligger i branchen som heter multiplayer.

Antall flagg funnet: 

Vi har enda ikke fått implementert ferdig logikken for muligheten for flere flagg i spillet, slik at spillet tar hensyn til flaggens
rekkefølge og deretter avslutter spillet når alle flaggene er funnet. Antar å gjennomføre dette innen neste oblig. Per nå fungerer det med ett flagg bare. 

<br/>

## Retrospektiv

### Retrospektiv hittil
Etter å ha jobbet med prosjektet og nå nærmer oss deadline, så merkes det at kode-delen er ganske mye større enn forventet og
at vi fort startet med å prioriterer å komme fortere i gang med kodingen istedet for å bruke tid på møter.
Noe vi har merket som en positiv endring er inndelingen av grupper over lengre tid. Siden vi kommer fortere i gang med kode-delen,
enn hvis vi hver gang skal prøve å dele inn oppgaver og grupper. Nå derimot vet vi hvilken gruppe som skal jobbe med
hva og de har selv kontroll på arbeidsoppgaver innad i gruppen. Noe vi ser på som en positiv forandring.

Noe negativt med gruppeindelingen vil være at det å hjelpe hverandre på tvers av gruppene har vert noe utfordende. Selv om det er godt å få et helt blankt
synspunkt på kode av og til, så har vi heller fått konsekvensen av at der er for mye tid å sette seg inn for en enkelte person, bare for å hjelpe med en liten
eller en veldig spesifikk del av koden. eksempel når vi har sittet å jobbet med multiplayer, men kommer ikke fremover på tutorial.

Vi har også bemerket oss at noen deler av oppgaven er vi ikke spesielt flinke, slik som å holde trello oppdatert og refaktorering av koden.
Når det kommer til trello har vi en tendens til å hive inn oppgave eller deler av hva vi har klart inn etter at vi har klart dem. Dette er
vi fullt klar over er feil rekkefølge, men noe vi da må bli bedre på er å gjerne dele opp gaven skikkelig eller mer spesifikk (utenom MVP-kravene).

Vi har også ikke vært så flinke med å planlegge strukturen av koden i forkant. Dette har kanskje ført til dårligere objektorientert kode, samt et større behov for 
kontinuerlig refaktorering. 

<br/>

**Gjennomførelsen av oppgaven**

For denne innleveringen har det vært noe vanskeligere å komme i mål. Det har vært mye komplekse oppgaver som har måttet
være utført i de siste MVP-kravene eksempelvis med logikken bak ulike korttyper, men spesielt med tanke på Multiplayer.
Vi har nok undervurdert arbeidet med å implementere Multiplayer, og det har gjort til at vi ikke har fått komt i mål med dette MVP-kravet.
Lureste hadde trolig vært å få flere til å jobbe med Multiplayer, i håp om større måloppnåelse.

Likevel er vi fornøyde med GUI hittill og kan allerede se tydelige resultater med fremgang i spillets utvikling.


Forbedringspunkter fra retrospektiv:
1. Jobbe mer aktivt med selve kode-biten. Ved forrige innlevering brukte vi alt for mye tid på kode siste dagen og
   var i overkant stresset de siste timene før inneleveringsfrist. 
   
2. Ha selve refaktorering i tankene kontinurlig i kodingen, samt også planlegge selve strukturen i koden bedre i forkant. 

3. Bruke Trello mer aktivt, gjerne i forbindelse med møtene

4. Jobbe mer på egenhånd / i inndelte grupper. Dette vil spare oss for mye tid i kodingen.

<br/> 

### Kommunikasjon
Kommunikasjon har fortsatt henholdsvis via Discord, og litt Facebook. Eneste vi oppdaget gjennom første møtetidspunkt var at vi har ingen måte å få kontakt med Tore på
uten at han er pålogget på Discord. Derfor har vi nå opprettet en facebook-chat hvor vi enklere kan nå hverandre og kommunisere kjappere.

På generell basis så fungerer kommunikasjonen i gruppen bra. Gruppedynamikken er god og alle er flinke til å dele meninger, komme med forslag etc.
Vi jobber godt sammen som team og er alle enige om måloppnåelsen med innleveringen.

Før øvrig deling og oppbevaring av filer gjelder samme som ble beskrive i oblig1:
Gruppen har valgt å bruke Trello project board som en felles delingsarena for både Project Board, men vi har også laget
en egen tavle som heter "Ressurser". Her deles de nødvendige filer, informasjonsskriv og eventuelle bilder som gruppen
trenger enkelt tilgang til for å innhente nødvendig informasjon for utførelsen av oppgaven. Øvrig deling har skjedd via
egen intern Discord-chat, samt også brukt Github for
opplasting av kodebase og assets-filer.

Vi opplever at dette fungerer svært godt. 

<br/> 

### Prosjektmetodikk
Vi har fortsatt med en type Scrum og Kanban metodikk. Vi har fortsatt hatt deadlines, men nå har vi bare bestemt oss for
at deadlines skal være innleveringsdato, ettersom det ikke er mye ekstra tid å dele arbeidsoppgaver mer inn i tidligere deadlines.
Vi beholder WIP limit til antall av MVP-er utdelt fra obligen. Noe vi har endret er en litt mer konsekvent gruppeinndeling.
Vi beholder samme grupper over en hel sprint. Altså gjennom en hel obligatorisk innlevering.
Planen var i utgangspunktet å skifte på gruppene halvveis, men fant fort ut at det var for mye å sette seg inn i
dersom gruppene skulle skiftes på og arbeidsoppgaver/ kode måtte forklares og forstås.
Gruppen ble dermed enig om å holde på gruppene gjennom hele sprinten.
Noe vi merker er at det er mye koding som skal gjøres mellom hver deadline, så oppdeling av MVP
sees som unødvendig, ettersom det tar tid å dele dem mer opp, samt det er lettere å skille arbeid dersom en gruppe
får et MVP-krav og den andre får det andre.

<br/> 

