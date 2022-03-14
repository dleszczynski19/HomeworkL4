# Lekcja nr 4

## Założenia:
####Spis jsonów:
- car.json -> zawiera dane dla 15 aut
- country.json -> zawiera nazwy oraz symbole 5 państw
- dimension.json -> zawiera wyskość, szerokość oraz pojemność bagażnika dla 10 wymiarów
- procuder.json -> zawiera markę oraz model 10 pojazdów


####W car.json istnieją 6 auta marki BMW
- 4 z tych aut posiadają automatyczną skrzynię biegów
- 4 z tych aut posiadają pojemność bagażnika większą niż 300
- 2 z tych aut spełniają oba powyższe warunki

####Odpowiedzią powinny być dwa auta marki BMW model M2 oraz M3 dostępne kolejno w:
- France - F, Germany - G, Spain - S
- Belgium - B, Spain - S, Germany - G

## Treść Polecenia:

Zadanie domowe:
1. Napisz klasę Car. Jest to klasa główna, agregująca inne klasy, która posiada następujące elementy:
- pole producent, typu Producent: String model, String Type
- pole isAutomaticGear, typu boolean
- pole market, typu Market: String name, List<Country> countries, (każdy Market ma listę co najmniej 3 krajów w których chce sprzedawać auta)
- pole segment, typu String. Możliwe wartości: standard, medium, premium
- ArrayList dimensions, typu Dimension: int high, int width, int trankCapacity

2. Dodatkowe klasy:
   Producent: String model, String type (np: Toyota Corolla)
   Dimension: int high(cm), int width (cm), int trankCapacity (litr) (przykład: 75, 145, 240)
   Market: String name, List<Country> countries (Przykład: name = business, cargo, transport, taxi, bus)
   Country: String countryName, char countrySign (przykład - Polska - P, Niemcy - D, Chiny - C, Holandia - N, Korea - K)


3. Stwórz z klasie uruchomieniowej następującą liczbę obiektów:
    
    - Country - 5
    - Market - 5
    - Dimension - 10
    - Producent - 10
    
    Klasa głowna - Car - będzie posiadała 15 obiektów. 
    

4. Utwórz metodę w klasie Car, która przeszuka wszystkie obiekty i wypisze na konsoli kraj - countryName, oraz oznaczenie kraju - countrySign (w formacie: Poland - P) 
gdzie producentem jest BMW, z automatyczną skrzynią biegów oraz pojemnością bagażnika - trankCapacity większą niż 300 litrów.