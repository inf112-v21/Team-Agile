# INF112 README OBLIG 1

[![Build Status](https://travis-ci.com/inf112-v21/Team-Agile.svg?branch=master)](https://travis-ci.com/inf112-v21/Team-Agile)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/718749febaf34563a55ed57f8cb05f60)](https://www.codacy.com/gh/inf112-v21/Team-Agile/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inf112-v21/Team-Agile&amp;utm_campaign=Badge_Grade)

### Build og versjoner
* Maven
* Java 15.02
* JUnit 4.11
  
## HVORDAN LASTE NED PROSJEKTET OG STARTE SPILLET

### MAC // LINUX // WINDOWS

**Dersom du vil kjøre spillet fra en Java-IDE:**
1. Laste ned Git-repo fra: https://github.com/inf112-v21/Team-Agile under den grønne knappen "Code" og "Download ZIP"
2. Åpne prosjektet i din IDE. Eksempelvis anbefaler vi IntelliJ. 
3. Finn main under directory: Team-Agile/src/main/java/inf112.skeleton.app/Main.java
4. Kjør main. Da skal spillet startes.

Om main ikke vil starte i din egen IDE, se under "known bugs"


<br/>

**Om du ikke har IDE fra før:**
1. Sjekk at du har riktig Java versjon ved å skrive
        ``java -version``
   Du kan alltids laste ned nyeste Java versjon på Java sine egne sider.
   
2. Laste ned Git-repo fra: https://github.com/inf112-v21/Team-Agile under den grønne knappen "Code" og "Download ZIP"
   

3. Pakk ut ZIP-filen i en mappe lokalt på din maskin

   
4. Åpne Terminal/CMD og naviger deg inn til lokasjenen du lagret mappen i. Eksempelvis dersom filen befinner ser i Downloads: 
    Bruk kommandoen:
      
    **MacOS/Linux:** ``cd Downloads/Team-Agile``

    **Windows:** ``cd "Downloads/Team-Agile"``

   
5. Fullfør maven build kommandoer:

    ``mvn clean install``
   <br/>

    ``mvn compile``
   <br/>
   ``mvn exec:java -Dexec.mainClass=inf112.skeleton.app.Main``
   <br/>

Dersom ingen av mvn-kommandoene i steg 5 fungerer så må du først installere Maven. Dette kan gjøres på følgende måte: 

**MacOS:** 
1. Installer _[HomeBrew](https://docs.brew.sh/Installation)_, en package manager til MacOS
2. Kommandoen ``brew install maven`` vil installere maven. 

**Windows:**
1. Installer ZIP-filen ``apache-maven-3.6.3-bin.zip` `` Fra _[Maven](https://maven.apache.org/download.cgi)_
2. Høyreklikk på ZIP-filen og velg _Extract all_. 
3. Deretter må du søke på _environment variables_ i søkefeltet lokalt på pc-en din.
4. Lag variabel i _User variable_ med navn _Maven_Home_ og med verdi 
   ``C:\Users\"Username"\Downloads\apache-maven-3.6.3-bin\apache-maven-3.6.3`` ,
   legg til hva brukeren din heter der det står _Username_.
5. I _system variables_ skal vi legge til samme lenke i _Path_ som du skal ha fra før av.
   Her klikker du på _Path_, velger _Edit_, deretter _New_ og legger til samme lenke bare med 
   ``\bin`` på slutten. Vil se slik ut: 
   ``C:\Users\47915\Downloads\apache-maven-3.6.3-bin\apache-maven-3.6.3\bin``
6. Til slutt kan du åpne terminal og skrive inn kommandoen ``mvn -version`` for å sjekke at det har blitt
   installert riktig.
   
**Linux/Ubuntu**

1. ``sudo apt update``
<br/>

2. ``sudo apt install maven``
<br/>

3. ``mvn -version`` (for å sjekke at du har riktig versjon)
<br/>
   

## HVORDAN SPILLE SPILLET
Spillet er ikke enda ferdigutviklet, men under finner du foreløpig dokumentasjon på hvilke funksjoner som kan utføres i spillet:

For å starte å spillet kjøres 1 instans av GameServer først også 1 instans av Main, deretter for å starte å kunne gjøre bevegelser
skrive ``yes`` og enter i terminalen til GameServer som spillet kjøres på. Hvordan spille flere spillere sammen beskrives under i Multiplayer

* Når du starter spillet så vil brettet laste. Du vil da se en spiller (ugle), en checkpoint (flagg) og et hull.
* Du vinner av å besøke alle flaggene i riktig prioritert rekkefølge (se nummereringen).
* Du navigerer ved å bruke piltastene: 
    * **Pil opp**: Flytter roboten 1 steg framover i retningen den står i.
    * **Pil ned**: Flytter roboten 1 steg bakover i forhold til retningen den står i.
    * **Pil høyre**: Roterer roboten til høyre.
    * **Pil venstre**: Roterer roboten til venstre.
    * **R**: Roter roboten 180 grader (UTURN).
    * **C**: Plukke opp ``flag`` eller ta ``skade`` når roboten befinner seg i en av de rutene. 
* Velge ut kort ved tastetrykk 1-9, kortene er indeksert fra 1-5 de øverste, deretter 6-9 på raden under.
    * Tastetrykk flytter valgte kort til Register-feltet (kortene spilleren velger).
* Angre valgte kort: 
    * **A** Resetter hele Register-feltet (valgte kort) og alle kortene flyttes tilbake til og kan deretter velges på nytt.
* Utføre valgte kort som ligger i Register-feltet: 
    * **SPACEBAR** Utfører kortet som ligger først fra venstre.
    * **ENTER** Sender de valgte kortene til Server.
    
## Multiplayer
Spillet er per nå konfiguert til å kjøre på samme pc med flere instanser av spillet for hver spiller.
Før man starter må man tillate at flere instanser av Main tillates. Åpne opp Main gå i menylinjen, og naviger deg til 
run -> edit configurations -> modify options -> huke av på ``Allow multiple instances``

![](/Deliverables/Images/Multipleinstances.png "")

Kjøre multiplayer med flere instanser av Main på samme PC:

* Kjører 1 instans av GameServer for å starte server. 
* Kjører deretter så mange instanser av Main for antall spillere man ønsker å ha i spillet. For hver instans av Main som startes, 
må tilkoblingen aksepteres i GameServer Terminalen ved å skrive ``yes``
* Når ønsket antall instanser av Main for antall spillere er oppnådd, bruker man brukertastene oppgitt over for å spille spillet.
* Når antall spillere tilkoblet har sendt de valgte kortene sine til Server ved å trykke ``Enter`` vil Serveren utføre de valgte kortene i riktig
rekkefølge.
  
Kjøre multiplayer ved hjelp av Hamachi:

For å kunne spille flere spillere med flere PC-er , kan dette gjøres ved å benytte seg av Hamachi hvor alle kobler seg til samme nettverk gjennom hamachi

Link for oppsett av Hamachi: https://lifehacker.com/how-to-set-up-a-personal-private-vpn-with-hamachi-5902468

* Før man kobler til gjennom hamachi må man navigere seg i prosjektmappen network -> NetworkHandler og finne variabelen ``IPAdress`` og endre til IPadressen til nettverket som man er koblet til i Hamachi.

![](/Deliverables/Images/NetworkHandler.png "") ![](/Deliverables/Images/Hamachi.png "")

* Gjør samme fremgangsmåte som over på samme PC, men hver spiller starter Main selv på sin PC etter at en av spillerene har startet å Hoste GameServer.





## Known bugs
**Dersom Main eller tester ikke vil kjøre:**

Om du har en mac-maskin og main / tester ikke vil kjøre gjennom IntelliJ, så kan det hende du får opp en feilmelding tilsvarende: _"Exception in thread "main" java.lang.ExceptionInInitializerError
at org.lwjgl.glfw.GLFW.glfwCreateWindow(GLFW.java:1842)
at...."._ I dette tilfellet er det en feil som må rettes opp i selve IntelliJ, og det gjøres på følgende måte:
1. Gå i menylinjen, og naviger deg til run > edit configurations > modify options > add VM options
2. Legg deretter  inn denne linjen -XstartOnFirstThread
   * MERK at denne må legges inn både under main og under testene! 
3. Apply settings og lukk dialogboksen. Du skal nå kunne starte spillet. 

**Multiplayer ikke starter korrekt**

Om man prøver å koble til Main instanser til GameServer for fort, kan føre til at Server/Client kræsjer.
Vent etter hver oppstart av instans til at programmet får loadet og startet skikkelig eller prøv igjen.


