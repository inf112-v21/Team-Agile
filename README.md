# INF112 README OBLIG 1

[![Build Status](https://travis-ci.com/inf112-v21/Team-Agile.svg?branch=master)](https://travis-ci.com/inf112-v21/Team-Agile)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/718749febaf34563a55ed57f8cb05f60)](https://www.codacy.com/gh/inf112-v21/Team-Agile/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inf112-v21/Team-Agile&amp;utm_campaign=Badge_Grade)

## ROBORALLY

Roborally er et brettspill for opp til 1-8 spillere. 

Roborally sin egen Wiki er å finne her: _[RoboRally Wiki](https://www.wikiwand.com/en/RoboRally)_

Regler finnes her: _[Roborally Regler](https://www.fgbradleys.com/rules/rules4/Robo%20Rally%20-%20rules.pdf)_


### Build og versjoner

#### Build-krav: 
* Maven
* Java 15.02
* JUnit 4.11 (for testing)

#### Operativssystemer:
* MacOS
* Windows
* Linux
  
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
Spillet er så og si ferdigutviklet, men mangler noen funksjoner fra den originale RoboRally spillet. Under finner du beskrivelse på det som faktisk fungerer: 

* Start spillet ved å gjennomføre veiledningen i punktene over. 
* Velg om du vil starte ved å hoste game eller å joine. For detaljert beskrivelse av hvordan Multiplayer fungerer, se dokumentasjon for Multiplayer under. 
* Dersom du skal hoste, så må du velge hvor mange spillere som skal være med. Spillet starter ikke før alle valgte spillere har joinet. Om du eksempelvis
vil teste ut spillet alene så velger du ``HostGame`` og skriver inn tallet ``1``.

  
* Når du starter spillet så vil brettet laste. Du vil da se alle spillere, representert ved en ugle, checkpoints og andre kart-objekter. 
* Velg deg 5 kort fra kortstokken øverst i høgre hjørne. Disse kan velges ved bruk av museklikk eller piltaster, hvorav kort fra venstre->høgre er representert fra 1->5. 
* Trykk ```Lock in Cards``` når du har valgt alle kortene du ønsker å bruke i første trekk. Om du skulle velge feil så kan du trykke ```Reset deck``` for å velge på nytt. 
* Når alle spillere har valgt sine kort, så vil kortenes funksjon utføres. 
* Om du eksempelvis skulle ha behov for PowerDown så trykker du ```PowerDown``` før du velger kort. Du vil da stå over en runde for å kunne få tilbake HP, men andre spillere kan dytte deg, eller du tar damage av lasere. 


* Du vinner av å besøke alle flaggene i riktig prioritert rekkefølge (se nummereringen).
* Du taper om du går tom for liv. Du mister liv ved at HP går til 0, eller at du går i et hull. 

    
## Multiplayer
Spillet er per nå konfiguert til å kjøre på samme pc med flere instanser av spillet for hver spiller.
Før man starter må man tillate at flere instanser av Main tillates. Åpne opp Main gå i menylinjen, og naviger deg til 
run -> edit configurations -> modify options -> huke av på ``Allow multiple instances``

![](/Deliverables/Images/Multipleinstances.png "")

Kjøre multiplayer med flere instanser av Main på samme PC:
* Start en instans av Main, første instans navigere seg inn i ``HostGame`` menyen og angir i feltet hvor mange spillere som skal være med i spillet.
* Deretter starter man flere instanser av Main og trykker ``Join Game`` til man har like mange spill instanser som ble angitt i Host Game.
* Når ønsket antall instanser av Main for antall spillere er oppnådd, bruker man brukertastene oppgitt over for å spille spillet.
* Når antall spillere tilkoblet har sendt de valgte kortene sine til Server ved å trykke ``Enter`` vil Serveren utføre de valgte kortene i riktig
rekkefølge.
  
Kjøre multiplayer ved hjelp av Hamachi:

For å kunne spille flere spillere med flere PC-er , kan dette gjøres ved å benytte seg av Hamachi hvor alle kobler seg til samme nettverk gjennom hamachi

Link for oppsett av Hamachi: https://lifehacker.com/how-to-set-up-a-personal-private-vpn-with-hamachi-5902468

* Før man kjører noen instanser må du inn i mappestrukturen network -> NetworkHandler og finne variabelen ``IPAdress`` og endre IPadressen til nettverket som man er koblet til i Hamachi.
``IPAdress`` skal samsvare med ipen til nettverket man er koblet til gjennom hamachi som under.
* Deretter gjørs samme fremgangsmåte som beskrevet over for flere instanser på samme PC.
  
![](/Deliverables/Images/NetworkHandler.png "") ![](/Deliverables/Images/Hamaci.png "")




## Known bugs
**Dersom Main eller tester ikke vil kjøre:**

Om du har en mac-maskin og main / tester ikke vil kjøre gjennom IntelliJ, så kan det hende du får opp en feilmelding tilsvarende: _"Exception in thread "main" java.lang.ExceptionInInitializerError
at org.lwjgl.glfw.GLFW.glfwCreateWindow(GLFW.java:1842)
at...."._ I dette tilfellet er det en feil som må rettes opp i selve IntelliJ, og det gjøres på følgende måte:
1. Gå i menylinjen, og naviger deg til run > edit configurations > modify options > add VM options
2. Legg deretter  inn denne linjen -XstartOnFirstThread
   * MERK at denne må legges inn både under main og under testene! 
3. Apply settings og lukk dialogboksen. Du skal nå kunne starte spillet. 

**Multiplayer ikke starter korrekt:**

skjekk at lib mappen ligger i pathen til prosjektet høyre klikk på prosjekt mappen Team-Agile -> Open Module Settings -> Dependencies tab -> helt nederst av listen er det et "+" tegn.
-> Jars and Directories -> Velg ``lib`` som ligger i prosjekt mappen og apply.

** Main Menu **
Kan hende i noen tilfeller at museklikk i Main Menu er lite responsiv, som gjør at man ikke kommer seg videre inn i Host Game, prøv å dobbelt klikk evt. starte Main på nytt. Trykke seg ut og inn av spillevinduet kan også gjøre at museklikk blir mer responsiv.

**Spill Bugs**
når man spiller spillet er det et par bugs man må vite. dersom man står på en booster som er på vei ut av mappet, må man stå i samme retning som boosteren peker
for å ikke bli dyttet ut av brettet. dersom man faktisk blir dyttet ut, vil det ikke være mulig å komme seg inn på brettet igjen. 

hvis en robot står mot en vegg og en annen dytter i samme retning, vil de ende opp på samme tile. 
