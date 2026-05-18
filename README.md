Zadanie_grupowe - Spring Boot App Cloud Deployment

1. Nazwa zespołu
Grupa-Dziewczyny

2. Skład zespołu, podział obowiązków i współpraca
W celu realizacji projektu zespół założył jeden wspólny, grupowy repozytorium, z którego korzystały jednocześnie trzy osoby. Podział zadań w zespole wyglądał następująco:
* Yuliia Nahorna (Indeks: 75565) – Odpowiedzialna za bezpośrednie pisanie kodu źródłowego aplikacji oraz przygotowanie materiału wideo (prezentacji projektu).
* Marta Makarova (Indeks: 75723 ) – Odpowiedzialna za wsparcie merytoryczne przy kodowaniu, konfigurację środowisk chmurowych oraz przeprowadzenie udanych wdrożeń na platformach produkcyjnych. Jako jedyna pomyślnie skonfigurowała i zweryfikowała działanie wszystkich platform chmurowych.
* Polina Kolesnikova (Indeks: 77020) – Odpowiedzialna za kontrolę jakości kodu oraz przygotowanie pełnej dokumentacji technicznej projektu (w tym pliku README).

3. Krótki opis aplikacji
Mikroaplikacja backendowa typu Cloud-Ready stworzona w architekturze REST API przy użyciu frameworka Spring Boot oraz Java 17. Zarządzanie zależnościami w projekcie odbywa się za pomocą narzędzia Apache Maven. Głównym zadaniem aplikacji jest zwracanie ustrukturyzowanych danych identyfikacyjnych zespołu w formacie JSON.

4. Endpoint do sprawdzenia
* Ścieżka (URI): /hello
* Metoda HTTP: GET
* Zwracane dane: Aplikacja w ciele odpowiedzi przekazuje komunikat o poprawnym działaniu, nazwę zespołu, numery indeksów oraz imiona i nazwiska wszystkich członkiń projektu.

5. Instrukcja uruchomienia lokalnego
Uruchomienie aplikacji w środowisku lokalnym wymaga sklonowania wspólnego repozytorium Git z platformy GitHub, a następnie zbudowania projektu i uruchomienia go za pomocą narzędzia Maven. Aplikacja domyślnie uruchamia się na porcie 8080, a punkt końcowy staje się dostępny po wpisaniu w przeglądarce lokalnego adresu serwera z odpowiednią ścieżką zasobu.

6. Publiczne URL-e do wdrożeń 
Aplikacja została pomyślnie zsynchronizowana z grupowym repozytorium GitHub i wdrożona w chmurze pod następującymi adresami:
* Platforma Railway: https://zadanie-grupowe-production.up.railway.app/hello
* Platforma Azure App Service: https://zadaniegrupowe-b0hshccbbyb9h7an.polandcentral-01.azurewebsites.net/hello

7. Lista sprawdzonych platform
W ramach projektu zespół podjął próby wdrożenia oraz przetestował szeroką gamę platform hostingowych. Pełna lista sprawdzonych serwisów obejmuje:
1. Railway (Wdrożenie udane)
2. Azure App Service (Wdrożenie udane)
3. Render (Wdrożenie nieudane)
4. Inne platformy alternatywne (Wdrożenie nieudane)

8. Opis tego, co się udało
* Wspólna praca nad kodem: Kod aplikacji został pomyślnie napisany, zintegrowany i przetestowany w środowisku lokalnym przy użyciu jednego wspólnego repozytorium.
* Elastyczne zarządzanie portami: W konfiguracji zastosowano dynamiczny zapis parametryzujący port. Pozwoliło to na stabilne działanie aplikacji zarówno lokalnie (na domyślnym porcie), jak i w środowiskach chmurowych, które wstrzykują port automatycznie.
* Skuteczny deployment: Dzięki zaangażowaniu Marty Makarovej aplikacja została pomyślnie uruchomiona na platformach Railway oraz Azure i jest w pełni dostępna publicznie.

9. Opis problemów technicznych i tego, co się nie udało

Podczas procesu konfiguracji i wdrażania na poszczególne platformy, zespół napotkał szereg kluczowych problemów technicznych:

*Wdrożenie i weryfikacja platform:Pomimo prób samodzielnego uruchomienia aplikacji przez każdą z członkiń zespołu na indywidualnych kontach, proces ten kończył się niepowodzeniem ze względu na liczne błędy autoryzacji oraz różnice w konfiguracji środowiskowej.
*Główny problem z repozytorium (Git / GitHub): Początkowo repozytorium zostało utworzone bezpośrednio przez interfejs webowy GitHub. Taki sposób uniemożliwiał prawidłową synchronizację, budowanie i edycję projektu z poziomu lokalnych środowisk programistycznych. Rozwiązaniem było pobranie narzędzia Git lokalnie na komputery, prawidłowa inicjalizacja repozytorium przez terminal (właściwa ścieżka tworzenia) i ponowne poprawne podłączenie lokalnego projektu do zdalnego repozytorium GitHub.

*Problemy z wdrożeniem na Azure App Service: Azure początkowo nie potrafił prawidłowo zinterpretować, przetworzyć i odczytać struktury plików repozytorium, przez co aplikacja zgłaszała błąd startu. Problem został rozwiązany dopiero po poprawnym zreorganizowaniu struktury plików oraz przesłaniu kodu przez terminal za pomocą poprawnie skonfigurowanego narzędzia Git. Po tym zabiegu Azure automatycznie i bezbłędnie uruchomił aplikację.

*Problem z widocznością na platformie Railway: Na samym początku platforma Railway nie wykrywała właściwego repozytorium grupowego na koncie GitHub, co uniemożliwiało integrację. Rozwiązaniem była ponowna autoryzacja i ręczne skonfigurowanie uprawnień dostępu w celu ustanowienia stabilnego kontaktu między Railway a GitHubem.

*Błąd typu „Page Not Found” (Błąd 404): Zarówno Azure, jak i Railway poprawnie uruchamiały witryny, jednak wejście na adresy główne generowało błąd 404. Wynikało to z faktu, że automatycznie generowane przez chmury linki nie zawierały na końcu wymaganego punktu końcowego (endpointu). Ponieważ w kodzie jedyna ścieżka została zmapowana jako /hello, rozwiązaniem problemu było ręczne dopisywanie frazy /hello na końcu adresu URL w przeglądarce.

*Problemy z platformą Render: Wdrożenie na tej platformie zakończyło się niepowodzeniem, ponieważ system Render nie wykrywał środowiska Java. Platforma narzucała automatyczny wybór środowiska Node.js i nawet po próbach ręcznego wskazania ścieżki do Javy poprzez konfigurację zmiennych środowiskowych JAVA_HOME oraz PATH, aplikacja nie wystartowała.

*Ogólne problemy z innymi platformami alternatywnymi:
Próby uruchomienia aplikacji na pozostałych platformach chmurowych z rynku zakończyły się niepowodzeniem z trzech głównych powodów:
  1. Problemy z wypakowywaniem i przetwarzaniem paczek bezpośrednio z repozytorium GitHub.
  2. Wymóg wprowadzenia danych karty płatniczej i przejścia na wersje w pełni płatne (brak darmowych pakietów startowych).
  3. Konflikty konfiguracji sieciowej – niektóre platformy bezwzględnie wymagały zmiany portu wewnątrz kodu aplikacji na ich własny, sztywny port. Zastosowanie takiego rozwiązania zablokowałoby jednak poprawne działanie aplikacji na pozostałych, równolegle testowanych platformach.

10. Krótkie wnioski
* Najłatwiejsza platforma: Railway – po przyznaniu odpowiednich uprawnień do repozytorium GitHub, proces automatycznego budowania (CI/CD) przebiegał bezproblemowo. Platforma bardzo dobrze radzi sobie z plikami wykonywalnymi generowanymi przez Mavena, a logi systemowe są przejrzyste.
* Najtrudniejsza platforma: Azure App Service – wymagała rygorystycznego podejścia do struktury katalogów i odpowiedniego zarządzania projektem przez terminal. Sam proces wdrożenia był długotrwały i podatny na błędy komunikacji z repozytorium, co wymusiło kilkukrotną rekonfigurację połączenia Git.
