# INF112 README OBLIG 1

## HVORDAN LASTE NED PROSJEKTET OG STARTE SPILLET
1. Laste ned Git-repo fra https://github.com/inf112-v21/Team-Agile ved å klone prosjektet til din maskin. 
2. Åpne prosjektet i en java-IDE som kan kjøre koden. 
3. Finn main under directory: Team-Agile/src/main/java/inf112.skeleton.app/Main.java
4. Kjør main. Da skal spillet startes. 

Om main ikke vil starte, se under "known bugs"



## HVORDAN SPILLE SPILLET
Spillet er ikke enda ferdigutviklet, men under finner du foreløpig dokumentasjon på hvilke funksjoner som kan utføres i spillet:

* Når du starter spillet så vil brettet laste. Du vil da se en spiller (ugle), en checkpoint (flagg) og et hull.
* Du vinner av å besøke alle flaggene i riktig prioritert rekkefølge (se nummereringen).
* Du navigerer ved å bruke piltastene: 
    * **Pil opp**: Navigerer spilleren oppover på brettet
    * **Pil ned**: Navigerer spilleren nedover på brettet
    * **Pil høyre**: Navigerer spilleren mot høyre på brettet
    * **Pil venstre**: Navigerer spilleren mot venstre på brettet


## Known bugs
**Dersom Main ikke vil kjøre:**

Om du har en mac-maskin og main ikke vil kjøre gjennom IntelliJ, så kan det hende du får opp en feilmelding tilsvarende: _"Exception in thread "main" java.lang.ExceptionInInitializerError
at org.lwjgl.glfw.GLFW.glfwCreateWindow(GLFW.java:1842)
at...."._ I dette tilfellet er det en feil som må rettes opp i selve IntelliJ, og det gjøres på følgende måte:
1. Gå i menylinjen, og naviger deg til run > edit configurations > modify options > add VM options
2. Legg deretter  inn denne linjen -XstartOnFirstThread
3. Apply settings og lukk dialogboksen. Du skal nå kunne starte spillet. 



