# INF112 README OBLIG 1

### Build og versjoner
* Maven
* Java 15.02
* JUnit 4.11
* [![Build Status](https://travis-ci.com/inf112-v21/Team-Agile.svg?branch=master)](https://travis-ci.com/inf112-v21/Team-Agile)
  
## HVORDAN LASTE NED PROSJEKTET OG STARTE SPILLET
1. Laste ned Git-repo fra: https://github.com/inf112-v21/Team-Agile ved å klone prosjektet til din maskin. 
2. Åpne prosjektet i en java-IDE som kan kjøre koden. 
3. Finn main under directory: Team-Agile/src/main/java/inf112.skeleton.app/Main.java
4. Kjør main. Da skal spillet startes. 

Om main ikke vil starte, se under "known bugs" 

ta med java-versjon
setup for linux/mac i form av terminalkommandoer

enda mer grunnleggende for en person som ikke kan git eller vet hva en IDE er


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



