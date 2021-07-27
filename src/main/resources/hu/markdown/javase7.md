
# Java SE 7

## Alap fajlmuveletek

Java-ban rengeteg eszkoz all rendelkezesunkra fajlok kezelesehez es
szamos modon hasznalhatjuk ezeket, de ebben a feladatsorban ket eszkozre
fogunk koncentralni ket kulonbozo esetre, illetve mindket eszkozt
hasonlo eljarassal fogjuk alkalmazni. Eloszor a `FileInputStream`
osztalyt fogjuk hasznalni, aminek segitsegevel egy fajlt byte-onkent
kezelhetunk.

## Falj olvasas (byte-okkent)

A kovetkezo peldaban peldanyositunk egy `FileInputStream` objektumot
eloszor, ami `FileNotFoundException`-t dob. Ezt kotelezoen lekezeljuk
egy `try-catch` blokk segitsegevel. A `FileInputStream` konstruktorakent
a megnyitando fajl nevet (pontosabban eleresi utjat a projekt
gyokerkonyvtarahoz vagy a futo program helyehez kepest relativan) adjuk
meg egy `String` valtozokent. Ezutan a `readAllBytes()` metodus
segitsegevel egy `byte` tomb formajaban beolvassuk a fajlt teljes
egeszeben. Ez a metodus `IOException`-t dobhat, ezert ezt is le kell
kezelnunk a tanult modszerek egyikevel. Ebben az esetben kulon `catch`
blokkot kapott. Ezutan a `String` osztaly segitsegevel a beolvasott
`byte` tombot szovegge alakitjuk es kiirjuk a konzolra, hogy ha biztosak
vagyunk benne, hogy a beolvasott adat szoveges. Vegul a `close()`
metodussal bezarjuk a fajlt, ami egy nagyon fontos lepes, amire azert
van szukseg, hogy miutan mar nem dolgozunk az allomannyal, az operacios
rendszer tisztaban legyen azzal, hogy gond nelkul engedheti mas
folyamatoknak, hogy hasznaljak a fajlt, mert mi mar kesz vagyunk a
fajlmuveletunkkel.

``` java
try {
    FileInputStream fis = new FileInputStream("adat.txt");
    byte[] beolvasottAdat = fis.readAllBytes();
    System.out.println(new String(beolvasottAdat));
    fileInputStream.close();
} catch (FileNotFoundException fileNotFoundException) {
    fileNotFoundException.printStackTrace();
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

Egy elegansabb formaja a `FileInputStream`-hez hasonlo objektumok
hasznalatanak a `try-with-resources` blokk, ami automatikusan lezarja a
fajlt, amint a `try-catch` blokkunk lezarult.

``` java
try (FileInputStream fis = new FileInputStream("adat.txt")){
    byte[] beolvasottAdat = fis.readAllBytes();
} catch (FileNotFoundException fileNotFoundException) {
    fileNotFoundException.printStackTrace();
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

## Falj iras (byte-okkent)

A `FileInputStream`-hez hasonloan mukodik a `FileOutputStream`, ami egy
parameterkent kapott eleresi uton levo fajlt nyit meg, es a `write()`
metodussal `byte` tombot tud beleirni. Ha a fajl nem letezik, akkor
letre fogja hozni, tehat `FileNotFoundException`-t nem dob, csak abban
az esetben, ha a megjelolt mappa sem letezik, vagy valamilyen okbol
(peldaul engedely hianya) nem tudta letrehozni a fajlt. A kovetkezo
peldaban szinten a `try-with-resources` blokkot hasznaljuk, es egy
`String` valtozo `getBytes()` metodusanak segitsegevel irunk szoveget az
adat.txt fajlba.

``` java
try (FileOutputStream fos = new FileOutputStream("adat.txt")){
    fos.write("Hello".getBytes());
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

## Falj olvasas (String-kent)

A `FileInputStream` kitunoen alkalmazhato szoveges beolvasasra is, de
soronkent beolvasni vagy specialis kodolasu szoveggel dolgozni
viszonylag trukkos lehet, igy amikor kifejezetten szoveget szeretnenk
beolvasni, `BufferedReader` osztalyt hasznalunk. Mivel a
`BufferedReader` nem kifejezetten csak fajlmuveletekhez, hanem akar
halozati muveletekre is alkalmas, igy egy `FileReader` objektumot kap
parameterkent, es majd csak az fogja tartalmazni a hivatkozas a
fajlunkra. A hivatkozas a fajlra tortenhet egy `File` objektummal vagy
egyszeruen String-kent is.

``` java
try (BufferedReader br = new BufferedReader(
        new FileReader(new File("adat.txt")))){
    System.out.println(br.readLine());
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

Vagy ugyanez a `File` hivatkozas nelkul:

``` java
try (BufferedReader br = new BufferedReader(
        new FileReader("adat.txt"))){
...
```

A fenti peldaban szinten az adat.txt fajlt olvassuk be, viszont a
`BufferedReader` osztaly `readLine()` metodusat hasznalva, ami `byte`
tomb helyett `String` objektummal ter vissza. Fontos megjegyezni
azonban, hogy ez a metodus csak az elso sortoresig olvassa be a fajlt,
ha tovabb szeretnem olvasni, akkor ujbol meg kell hivnom, es minden
hivaskor a kovetkezo sorig olvas, egeszen addig, amig mar nincs mit
beolvasni, akkor pedig `null`-al ter vissza. A kovetkezo pelda egy
`while` ciklus segitsegevel addig olvassa es irja ki konzolra a sorokat,
amig el nem erjuk a fajl veget.

``` java
try (BufferedReader br = new BufferedReader(
        new FileReader(new File("adat.txt")))){
    String sor = null;
    while ((sor = br.readLine()) != null) {
        System.out.println(sor);
    }
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

## Falj iras (String-kent)

A `BufferedWriter` szinten hasonlit a `BufferedReader`-re, ugyanugy
peldanyositjuk es ugyanugy `String`-ekkel dolgozunk. A lenti pelda
beleirja az adat.txt-be, hogy "Hello".

``` java
try (BufferedWriter br = new BufferedWriter(
        new FileWriter(new File("adat.txt")))){
    br.write("Hello");
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

Fontos megjegyeznunk azt, hogy amikor fajlba irunk, alapvetoen az
eredeti tartalom felul lesz irva. Ha nem felulirni szeretnenk az adatot,
hanem a vegere irni, akkor azt is megtehetjuk, ha egy `true` erteket is
megadunk a konstruktoraban:

``` java
try (BufferedWriter br = new BufferedWriter(
new FileWriter(new File("adat.txt"), true))){
```

A kovetkezo pelda tobb sort ir a fajlba, 0-tol 9-ig a szamokat, mindet
uj sorba. Sortorest a `newLine()` metodussal irhatunk, vagy String-ek
eseteben a szokasos `"\n"`-el. Figyeljunk oda arra, hogy a `write()`
metodusnak ne adjunk parameterkent szamot, amikor a szamot szovegkent
szeretnenk a fajlba irni, kulonben a szamot `byte`-kent fogja irni, ami
visszakonvertalva String-ge valoszinuleg nem a szam karaktere lesz,
hanem egy specialis karakter vagy egy betu, a karakterkodolastol
fuggoen, ami alapvetoen az operacios rendszer altal van meghatarozva es
a legtobb esetben UTF-8 lesz. Javasolt megismerkedni a gyakori
karakterkodolasokkal es kulonbsegeikkel is.

Segitseg: [Wikipedia -
Karakterkodolasok](https://hu.wikipedia.org/wiki/Kateg%C3%B3ria:Karakterk%C3%B3dol%C3%A1sok)

``` java
try (BufferedWriter br = new BufferedWriter(
    new FileWriter(new File("adat.txt")))){
    for (int i = 0; i < 10; i++) {
        br.write(String.valueOf(i));
        br.newLine();
    }
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

# CSV fajl kezelese

Ugyan rengeteg potencialis gyakorlati almazasa van a most tanultaknak,
mi egy specialis, gyakori esetre fogunk koncentralni: tablazat jellegu,
CSV (vesszovel elvalasztott ertekeket tartalmazo) formatumu adat
feldolgozasara.

A kovetkezo peldakban vegyuk alapul az adat.csv fajlt aminek a tartalma
a kovetkezo:

``` java
gyarto,modell,ev
Toyota,Corolla,2008
Toyota,Yaris,2017
Ford,Focus,2011
Ford,Mondeo,2016
```

## CSV fajl beolvasasa

Az adat.csv fajl a legalapvetobb tablazatformatumot koveti, amelyben a
sorok sortoressel vannak elvalasztva, az oszlopok pedig "," karakterrel,
ami tetszes szerint lehetne tabulator vagy pontosvesszo is. Az elso sor
az oszlopneveket tartalmazza, utana minden sor egy-egy jarmu adatait.

``` java
try (BufferedReader br = new BufferedReader(
        new FileReader(new File("adat.txt")))){
    String sor = null;
    while ((sor = br.readLine()) != null) {
        System.out.println(sor);
    }
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

A fenti pelda segitsegevel beolvashatjuk az adat.csv fajlt es
megjelenithetjuk minden sorat a konzolon, azonban mi szeretnenk kulon
kezelni az oszlopokat. A kovetkezo kodreszlet azt mutatja be, hogy a
`String` osztaly `.split()` metodusa segitsegevel minden "," karakternel
felbonthatjuk a beolvasott sorunkat, es egy sor ertekeit `String` tomb
formaban megkaphatjuk, amin utana index alapjan elerhetjuk az adott
sorban egy bizonyos oszlop erteket. Mivel a cimsort nem szeretnenk
megjeleniteni, a `while` ciklus elott egyszer meghivjuk a `readLine()`
metodust, hogy atugorjuk a fajl elso sorat.

``` java
try (BufferedReader br = new BufferedReader(
        new FileReader(new File("adat.txt")))){
    br.readLine();
    String sor = null;
    String[] ertekek;
    while ((sor = br.readLine()) != null) {
        ertekek = sor.split(",");
        System.out.println("Gyarto: " + ertekek[0] +
                ", Modell: " + ertekek[1] + ", Ev: " + ertekek[2]);
    }
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

A fenti pelda a kovetkezo kimenetet fogja produkalni:

``` java
Gyarto: Toyota, Modell: Corolla, Ev: 2008
Gyarto: Toyota, Modell: Yaris, Ev: 2017
Gyarto: Ford, Modell: Focus, Ev: 2011
Gyarto: Ford, Modell: Mondeo, Ev: 2016
```

Ahhoz, hogy egy egyszeru megjelenitesnel komplexebb muveleteket
vegezhessunk a beolvasott adaton, gyakran celszerubb hagyomanyos
objektumokkal dolgozni, igy letrehozunk egy olyan osztalyt, ami a fajl
egy soraban levo adatokat tarolni tudja.

``` java
public class Auto {
    private String gyarto, modell;
    private int ev;

    ... teljes konstruktor es get metodusok
}
```

A cel tehat hogy a CSV fajl minden sorat egy `Auto` objektumba
beolvassuk, hogy utana azokon tudjunk muveleteket vegezni. A lenti
peldaban letrehozunk egy dinamikus listat ami kepes lesz az `Auto`
objektumok tarolasara. Azert nem tombot hozunk letre, mert nem tudjuk
pontosan hany auto van a fajlunkban. Az elozo peldahoz hasonloan
felbontunk minden sort egyedi ertekekre, majd ezeket az ertekeket
felhasznalva hozunk letre minden sor utan egy uj `Auto` objektumot,
aminek minden parameterekent a beolvasott sor egy-egy oszlopaban levo
ertekeket adunk meg. Figyelj arra, hogy az ev valtozo `int` tipusu,
viszont az `ertekek` tomb minden erteket `String` tipusban tarol, igy at
kell alakitanom az `Integer.parseInt()` metodussal, mielott a
konstruktornak megadhatnam.

Miutan a lenti kod lefutott, egy hagyomanyos listan hagyomanyos
objektumaim lesznek, amivel barmilyen korabban tanult muveletet
elvegezhetek.

``` java
List<Auto> autok = new ArrayList<>();
try (BufferedReader br = new BufferedReader(
        new FileReader(new File("adat.txt")))){
    br.readLine();
    String sor = null;
    String[] ertekek;
    while ((sor = br.readLine()) != null) {
        ertekek = sor.split(",");
        autok.add(new Auto(ertekek[0],
            ertekek[1], Integer.parseInt(ertekek[2]);
    }
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

## CSV fajlba iras

A korabban tanult `BufferedWriter`-t hasznalo eljaras segitsegevel mi is
hozhatunk letre CSV fajlokat, annyi a feladatunk, hogy az ertekeinket
amiket fajlba szeretnenk irni a CSV formatum szabalyai szerint
alakitjuk. Ha egy osztaly peldanyait szeretnenk CSV formaban menteni, a
legelegansabb megoldas az, ha egy metodusban hatarozzuk meg, mikent
reprezentaljuk majd a peldanyokat CSV-sorkent. Az `Auto` osztalyunkat
kiegeszithetjuk az alabbi metodussal:

``` java
String csvSor() {
    return gyarto + "," + modell + "," + ev;
}
```

Ezutan mindossze annyit kell tennunk, hogy az `autok` lista minden
elemen meghivjuk ezt a metodust, es a metodus eredmenyet beleirjuk az
adat.txt fajlba. Mivel a fajl elso sora eredetileg az oszlopneveket
tartalmazza, nem felejtem azt is beleirni.

``` java
try (BufferedWriter br = new BufferedWriter(
    new FileWriter(new File("adat.txt")))){
    br.write("gyarto,modell,ev\n");
    for (Auto a: autok) {
        br.write(a.csvSor());
        br.newLine();
    }
} catch (IOException ioException) {
    ioException.printStackTrace();
}
```

# Feladatok

## Feladat

Olvasd be a feladatsorhoz mellekelt countries.txt fajlt es ird ki minden
sorat a konzolra `FileInputStream` segitsegevel, majd tedd meg ugyanezt
a `BufferedReader` modszerrel.

## Feladat

Szamold meg es ki, hany orszag van osszesen a countries.txt fajlban.

## Feladat

Ird ki a countries.txt fajlbol csak az "S" betuvel kezdodo orszagok
neveit.

## Feladat

Ird bele a countries-forditott.txt fajlba az orszagok neveit forditva
(tehat az elso orszag lesz az utolso).

## Feladat

Olvasd be a feladatsorhoz mellekelt termekek.csv fajlt egy megfeleloen
osszeallitott osztalyt tartalmazo listaba. Figyeld meg alaposan, hogy
milyen valtozokra lesz szukseged, milyen adattipusokat kell
felhasznalnod, es ne felejtsd el atugrani az oszlopneveket tartalmazo
elso sort.

## Feladat

Az elozo feladatban beolvasott adat minden ertekenek az arat noveld
10%-al.

## Feladat

A modositott arakkal rendelkezo termekeket ird bele a
termekek-modositott.csv fajlba.
