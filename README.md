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
      
    **MacOS/Linux:** ``cd Downloads/eam-Agile``

    **Windows:** ``cd "Downloads/Team-Agile"``

   
5. Fullfør maven build kommandoer:

    ``mvn clean install``
   <br/>

    ``mvn compile``
   <br/>
   ``mvn exec:java -Dexec.mainClass=inf112.skeleton.app``
   <br/>

Dersom ingen av mvn-kommandoene i steg 5 fungerer så må du først installere Maven. Dette kan gjøres på følgende måte: 

**MacOS:** 
1. Installer _[HomeBrew](https://docs.brew.sh/Installation)_, en package manager til MacOS
2. Kommandoen ``brew install maven`` vil installere maven. 

**Windows:**


## HVORDAN SPILLE SPILLET
Spillet er ikke enda ferdigutviklet, men under finner du foreløpig dokumentasjon på hvilke funksjoner som kan utføres i spillet:

* Når du starter spillet så vil brettet laste. Du vil da se en spiller (ugle), en checkpoint (flagg) og et hull.
* Du vinner av å besøke alle flaggene i riktig prioritert rekkefølge (se nummereringen).
* Du navigerer ved å bruke piltastene: 
    * **Pil opp**: Flytter roboten 1 steg framover i retningen den står i.
    * **Pil ned**: Flytter roboten 1 steg bakover i forhold til retningen den står i.
    * **Pil høyre**: Roterer roboten til høyre.
    * **Pil venstre**: Roterer roboten til venstre.
    * **R**: Roter roboten 180 grader (UTURN).
* Velge ut kort ved tastetrykk 1-9, kortene er indeksert fra 1-5 de øverste, deretter 6-9 på raden under.
    * Tastetrykk flytter valgte kort til Register-feltet (kortene spilleren velger).
* Angre valgte kort: 
    * **A** Resetter hele Register-feltet (valgte kort) og alle kortene flyttes tilbake til og kan deretter velges på nytt.
* Utføre valgte kort som ligger i Register-feltet: 
    * **SPACEBAR** Utfører kortet som ligger først fra venstre.

## Known bugs
**Dersom Main eller tester ikke vil kjøre:**

Om du har en mac-maskin og main / tester ikke vil kjøre gjennom IntelliJ, så kan det hende du får opp en feilmelding tilsvarende: _"Exception in thread "main" java.lang.ExceptionInInitializerError
at org.lwjgl.glfw.GLFW.glfwCreateWindow(GLFW.java:1842)
at...."._ I dette tilfellet er det en feil som må rettes opp i selve IntelliJ, og det gjøres på følgende måte:
1. Gå i menylinjen, og naviger deg til run > edit configurations > modify options > add VM options
2. Legg deretter  inn denne linjen -XstartOnFirstThread
   * MERK at denne må legges inn både under main og under testene! 
3. Apply settings og lukk dialogboksen. Du skal nå kunne starte spillet. 



