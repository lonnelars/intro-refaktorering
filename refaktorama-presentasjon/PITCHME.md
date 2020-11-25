---?image=flyt_monster_mork_bakgrunn.svg&size=120%
# Refaktorama

Note:
- Liten innrømmelse: beste godfølelsen kommer ikke av å skrive ny kode
- Men refaktorering! Det er fine dager. 
- skal introdusere en liten oppgave som går på refaktorering og redesign


---?image=https://images.pexels.com/photos/7367/startup-photo.jpg

@snap[north-west]

### @color[#27003D](Hvorfor refaktorerer vi?)
@snapend

Note:
- gjøre koden mer lesbar
- betale tilbake teknisk gjeld (fjerne snarveiene)
- tilrettelegge for ny funksjonalitet
- endret forståelse av domenet


---?image=https://images.pexels.com/photos/39900/alarm-clock-clock-time-minute-39900.jpeg&size=100%

@snap[south-west]
### Virkeligheten<br> hindrer oss
@snapend

Note:
- bilde av klokke 
- Hva slags utfordringer møter vi i praksis? 
- Tid: ofte travelt i prosjekter, vi får ikke alltid gjort de refaktoreringene
  vi ønsker. Kan være pga mye ny funksjonalitet som skal inn, eller gammelt
  system. 
- Penger
- Mer konkret: 
- manglende tester <-- endring er utrygt
- tester som sementerer implementasjon <-- endring er vanskelig
- Kodekvalitet: navngiving, lange metoder, rammeverk, ulike kodestandarder
- arkitektur: ingen klar tanke, evt feil tanke, ulike tanker blandet sammen
- de overstående tingene er jo det vi vil fikse, men det hindrer oss fra å bare
  sette igang også
- brukere: eksterne er avhengige av systemet, hindrer endring
- kode i stadig endring: vanskelig å gjøre store/inngripende endringer


---?image=https://images.pexels.com/photos/355948/pexels-photo-355948.jpeg

@snap[north]
### Strategier
@snapend

Note:
- leve med det
- gjøre minimale endringer jevnlig for å alltid gjøre verden litt
  bedre, planlegge godt slik at stegene blir små
- beholde grensesnitt, men gjøre store omskrivinger på innsiden
- kast det gamle, skriv nytt
- limited red: lag ny, duplisert funksjonalitet og erstatt etterhvert
- endre API og levere ny ikke-bak-over-kompatibelt system
- idag skal vi jobbe med et lite eksempel
- ca 50 linjer kode, drøyt 10 tester


---?image=nerdschool.jpg&size=100%

@snap[north-west]
### @color[#27003D](Nerdschool)
@snapend

Note: 
- bilde av nerdschool-event
- holdt refaktoreringsworkshops for nybegynnere i mange år gjennom nerdschool
- også brukt i internopplæring i bedrift, senest i høst i kantega
- nesten uforandret oppgavesett siden den ble laget
- finnes fryktelig mange ulike løsninger på oppgaven 
- mer erfarne lager andre type løsninger enn ferskinger
- brukt på fagdag i Bergen: enda flere løsninger og veldig interessant diskusjon
  i etterkant
- at så lite kode kan generere så mange ulike løsninger er fascinerende


---?image=https://images.pexels.com/photos/163444/sport-treadmill-tor-route-163444.jpeg

@snap[north]
### @color[#27003D](Mål)
@snapend

Note:
- se hvor ulike løsninger som kan oppstå fra avgrenset problem
- se hvordan ulike rammebetingelser gir ulike løsninger
- se hvordan ulik kontekst (feks erfaring fra tidligere) gir ulike løsninger og
  tilnærminger
- øve på refaktorering 


---?image=flyt_monster_mork_bakgrunn.svg&size=120%

# Rammebetingelser

Note:
- "alt" er lov: redesign, prisen skal være den samme
- Testgrensesnitt (API) skal beholdes, ellers står du/dere fritt til å endre
- fullstendig løsning i løpet av 2 timer (minimum effort)
- alle kan legge på tester dersom refaktoreringen krever det (vet det finnes
  noen løsninger som lager hull i testdekning)
- hva er rammen for refaktoreringen? ble spurt om forrige gang. Trenger du en
  ramme? Sett den. Men: koden er ikke særlig lesbar.  


--- 

### Oppgaven 

https://github.com/sivhollup/intro-refaktorering

Note:
- en implementasjonsklasse (Pub), og en testklasse. En metode som testes, den
  beregner pris på en drikkebestilling i baren ("interfacet")
- jobb sammen eller alene
- lever en PR på sluttresultatet
- lag en fil i tillegg til løsning: kommentar.md med følgende: 
- hvilken strategi du har valgt (min/refaktor/redesign)
- hva var det viktigste endringen du gjorde?
- hvilke designvalg har du tatt? Hvorfor?

---

### Etterarbeid

Note:
- vi har lyst til at noen av dere presenterer løsningen kort på neste faggruppe
- etterfulgt av generell diskusjon
- vi planlegger også en blogpost med eksempler fra koden som blir levert (enten
  full PR eller utdrag i selve blogposten)



