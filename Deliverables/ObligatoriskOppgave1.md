# PROSJEKTDOKUMENT INF112

#### Obligatorisk oppgave 1

## Teamet
**Gruppenavn:** Team Agile

**Deltakere:**
* Tore Bøe 
* Leif Petter Sørbø 
* Anthony Vu
* Johnny Tran
* Marius Skimmeland

## Møter
### Møtetidspunkt og møtereferater: 
_Notater for hva som ble gjort og hva som er litt avklart er notert ned selve dagen møtetidspunktet skjedde._

**30.januar 10:15-12:00:**
* Oppstart og bli kjent. Gjøre oppgaveøvelse sammen.

**1.februar: 12:15-13:00**
* Petter blir med for første gang. Introduseres for resten av gruppen. Snakker om hva oppgaven handler om og hva vi skal gjøre. 
* Ser over oppgavebeskrivelse. Snakke kort om oppgaven samt lage punkter for hva som skal se over til neste gang.
* Til neste møtetidspunkt skal alle, individuelt:
* Lese opp på prosjektmetodikk og nødvendige kapitler i boken
* Lese opp og prøve å forstå kodeskjellett
* Lese opp på game engine
* Bli tryggere på Git

**3.februar: 12:15-14:00**
* Skulle i utgangspunktet lest gjennom kodeskjelett til i dag, men siden vi ikke har fått tilgang til denne så har ingen per nå lest på denne.
* Snakker om teamets tidligere erfaringer, foredeler ut roller, snakker om prosjektmetodikk, prosess- og prosjektplan.
* Avtaler at vi til neste fredag:
* Ser på «Libgdx and Tiled Tutorial».
* Gjør seg kjent med spillmotor og kodeskjelett
* Bli kjent med git-kommandoer
* Catche «brukerhistorier» og tenke ut hvordan dette er relevant for vår oppgave

**5.februar: 10:15-12:00**
* Lagt inn brukerhistorier for MVP punkt 1-5. 
* Lagt inn akseptansekriterier og arbeidsoppgaver for hver brukerhistorie. Noe finjustering på disse gjenstår til neste time.
* Fått clonet git-repo til alle sin maskin og sjekket at Git fungerer fint hos alle.
* Forsøk å push/pull-endringer i Git-prosjektet.
* Anthony hadde i forkant av møtet kodet litt lengre i tutorial enn oss andre, så han hadde en gjennomgang av hva han hadde gjort til nå og hva ulike klasser, metoder og funksjoner gjorde. (via screensharing).
* Snakket en del mer om oppgaven i sin helhet og hvordan vi skulle få gjennomført kriteriene for å få poeng,
* Mot slutten gikk vi alle i sammen et par ekstra punkt i tutorial gjennom «code with me» på Tore sin IntelliJ.
* Til neste møtepunkt skal vi gjennomføre mer kode, oppdatere Project Board, samt prøve å ferdigstille dokumentet mer. Vi legger også opp en fast struktur for hvert møtepunkt, både tidsmessig samt innholdsmessig.

**8.februar 12:15-14:00**
* Skrevet ferdig brukerhistorie, akseptansekriterer og arbeidsoppgaver
* Laget struktur for project board
* Opprettet markdown dokument i prosjektmappen
    * Formatert dokumentet klart til innlevering     
* Fortsatte på libgdx og Tiled.
* Hadde Git problemer så en del av tiden forsvant på dette.
* Fikk vist spiller på brett ved hjelp av vektor2.
* Lagde metoden keyUp() og implementerte den for å bevege spiller på brett.
* Sørget for å fjerne spiller fra forrige posisjon.




## Møtetidspunkt og møtestruktur

**Faste møtetidspunkt:**
* Mandager 12:15 - 14:00
* Onsdager 12:15 - 14:00  
* Fredager 10:15 - 12:00

**Fast møtestruktur:**
* Gå gjennom dagens agenda
* Se på project board // se på prosjektstatus 
* Dele inn i 2 grupper som jobber med hver sitt område
* Samles mot slutten av møtet for å snakke om hvilke fremskritt en har gjort så langt og avtale neste nødvendige møtepunkt


## Teambeskrivelse og rollefordeling

### Erfaringer i teamet:  
* **Marius, Leif Petter, Johnny, Tore:** Har hatt INF100, INF101, INF102, INF122, INF115. Tore har også hatt en prosjektoppgave på HVL så har noe erfaring i tilsvarende gruppeoppgaver fra før.
* **Anthony:** Erfaring fra tidligere gruppeprosjekt i Bacheloroppgave og lignende faget INF100 i MatLab med å programmere noe Lego-greier. Programmeringserfaring tilsvarende de som er nevnt over, med noe webprogrammering i tillegg.

**Fordeling av roller:**
Vi velger deler oss inn i to grupper gjennom prosjektet, med mulig bytting etter behov. Vi vil ha kontinuerlig kommunikasjon sammen om oppgaven og er også behjelpelige med å hjelpe i hverandres grupper. Deler inn i 2-er og 3-er grupper. Gruppene er mest for at en jobber flere samtidig med samme oppgave.

### Roller

**Teamleder:** Johnny (holde overordnet styr på alt som må bli gjort)

**Kundekontakt:** Marius (holder kontakt med gruppeleder)

**Backend-utvikler:** Anthony (holder overordnet styr på koden helhetlig og at vi har en god kodestil)

**Product-manager:** Tore (oversikt over det endelige produktet som leveres og ser over det før innlevering)

**Designer:** Leif Petter (har kontroll på hvordan det visuelle ser ut og har ansvar for bildefiler etc.)

## Prosjektmetodikk
_(beskrive hvilken prosjektmetodikk vi har valgt, og hvorfor)_

Vi går for en metode som bruker litt Scrum og Kanban. Tenker valg av items/oppgaver blir satt i sprints, 
slik at vi alltid har en bestemt deadline for når vi skal bli ferdig med dem. 
Ellers blir det litt frittgående slik som Kanban. 
Har også bestemt oss for å ha en limited WIP (Work in progress) som skal følges ved jobbing av sprints. 
Skal prøve å starte med sprints på 1,5 uke i lengde.



### Prosess- og prosjektplan
Vi har jevnlig møter utover prosjektet hvor vi har oppfølging av arbeid i de forskjellige gruppene. Der bestemmer vi også hva som må å prioriteres og eventuelt problemer som har oppstått.

Begrensing på antall oppgaver vi tar sammen.

### Project board
**Link:** https://trello.com/b/80a0xYw8/inf112-oblig-1

## Spesifikasjon

### Brukerhistorier
_Brukerhistorier for punkt 1-5 MVP fra oppgaveteksten:_ 

**1. Vise et spillebrett**
- Jeg er en spiller som ønsker å kunne se brettet jeg spiller på, derfor trenger jeg at spillet viser brettet.


**Akseptansekriterier:**
* Brettet er synlig for en spiller som tester å spille

**Arbeidsoppgaver:**
* Gjøre brettet synlig i spillmotoren/java-koden
* Designe spillebrettet og deretter importere den inn i prosjektet
* Gjøre slik at main starter spillet først ved å vise selve brettet
* Lage koordinater til spillebrettet slik at en kan oppdatere innhold på posisjoner på brettet

<br/>  


**2. Vise brikke på spillebrett**

- Jeg er en spiller som ønsker å kunne bruke en brikke i spillet, derfor trenger jeg å kunne se brukken der den skal være på et gitt tidspunkt i spillet.

**Akseptansekriterier:**
  * En brikke er synlig

**Arbeidsoppgaver:**
* Designe brikken og deretter importere den inn i prosjektet
* Gjøre brikken synlig i spillmotoren/java-koden
* Gi brikken en startposisjon i spillet ut fra koordinater

<br/> 

**3. Flytte brikke (vha taster e.l. for testing)**

* Jeg er en spiller som ønsker å bruke brikken jeg er i spillet, derfor trenger jeg å kunne flytte brikken ved å trykke på en tast f.eks.

**Akseptansekriterier:**
* Brikken kan flyttes i alle fire retninger

**Arbeidsoppgaver:**
* Flytte brikken oppover ved bruk av tast pil opp
* Flytte brikken nedover ved bruk av tast pil ned
* Flytte brikken til venstre ved bruk av tast pil venstre
* Flytte brikken til høyre ved bruk av tast pil høyre
* Oppdatere brettet for hvert trekk
* Gi restriksjoner på hvor brikken kan og kan ikke bevege seg

<br/> 

**4. Robot besøker flagg**

* Jeg er en spiller som ønsker å kunne vinne spillet, derfor trenger jeg å kunne besøke et flagg.

**Akseptansekriterier:**
* Når spilleren besøker et flagg så må det adderes i et register av hvor mange ganger spilleren har besøkt et flagg. 
* Besøket må være unikt for flagget for hver gang. Altså om spilleren besøker det samme flagget to ganger så skal det ikke registreres to besøk ved flagg, bare ett. 

**Arbeidsoppgaver:**
* Legge til mulighet for å sjekke posisjoner som spiller besøker etterhvert. 
* Lage en liste som registrer flaggene spilleren besøker.
* Sjekke at flagget ikke ligger i listen fra før.
* Registrere flagget spiller besøker inn i listen om den oppfyller kravet. 

<br/> 

**5. Robot vinner ved å besøke flagg**

* Jeg er en spiller som ønsker å kunne vinne spillet, derfor trenger jeg å kunne besøke et flagg og få beskjed om jeg vinner spillet.

**Akseptansekriterier:**
* Registrere hvor mange flagg / checkpoints som må besøkes for av spiller skal vinne. 
* Når spilleren besøker en posisjon ved flagg, og innom alle de andre flagg-posisjonene fra før, så må spillet avsluttes og det skal gis beskjed om at spilleren har vunnet. 


**Arbeidsoppgaver:**
* Sjekke at spilleren har vært innom alle unike flagg (på antall)
* Sjekke at spilleren er den eneste som har vært innom alle unike flagg


## Produktleveranse / kode
_(hva fungerte, hva har vi ikke fått til etc. diverse notater om det ferdige produkter kan skrives inn her)_
