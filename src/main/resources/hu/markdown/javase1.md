# Java SE 1

## Java alapok JShell kornyezetben

Ebben a feladatsorban a Java programozas alapjaival fogsz megismerkedni a Java konzolos kornyezetenek hasznalataval, a JShell-el. A feladatsor fontos alapokat fektet le valtozok kezelesevel, muveletek irasaval es a linearis programozas elso lepeseivel kapcsolatban, amik a legelso programozasi koncepciok amiket megtanulunk, igy a legfontosabbak is. Minden kovetkezo programozasi tananyag erre a tudasra fog epiteni. A feladatsor elvegzesehez szukseged lesz a JShell kornyezetre, amit az `jshell` paranccsal tudsz elohivni, ha a JDK-t korabban feltelepitetted a szamitogepdre. Ha ez nem tortent meg, a Java hivatalos honlapjan megtalalod a telepitesi utmutatot.

# Valtozok

Ebben a feladatban megismerkedunk a programozas egyik legalapvetobb koncepciojaval, a valtozokkal. Megtanuljuk oket letrehozni, modositani, muveletekkel felhasznalni es megjeleniteni oket.

## Adattipusok

A Java nyelvben minden valtozonak kotelezo adattipust meghatarozni. Rengeteg beepitett adattipus van a nyelvben es sajat tipusokat is tudunk letrehozni, de egyelore nehany alapveto tipussal ismerkedunk meg:


| **Adattipus** | **Tarolt adat**       | **Alapertek** | **Pelda ertekek** |
| :--- | :--- | :--- | :--- |
| `int`           | egesz szam            | `0`             | `-10`, `0`, `2021`      |
| `double`        | tort szam             | `0.0`           | `-1.25`, `0.0`, `3.14`  |
| `boolean`       | logikai ertek         | `false`         | `true`, `false`       |
| `String`        | szoveg (karakterlanc) | `null`          | `""`, `"Hello!"`      |

*Alap Java adattipusok*



## Valtozo letrehozasa

Egy valtozo letrehozasa jellemzoen ket reszbol all, egy deklaraciobol es egy inicializaciobol. A deklaracio letrehoz egy ures valtozot a megadott nevvel, az inicializacio pedig megadja a valtozo kezdoerteket amit kesobb ha szeretnenk tudunk valtoztatni.

```java
int i = 12;
```

```java
double d = 4.5;
```

```java
boolean b = true;
```

```java
String s = "Hello!";
```

## Valtozok modositasa

Egy valtozot korabban letrehoztunk, akkor annak az erteket elulirhatjuk, de a tipusat nem valtoztathatjuk meg. Egy mar korabban etrehozott valtozo hivasakor az adattipust nem kell ujbol meghatarozni. a megis ujbol beirjuk az adattipust, Java azt fogja hinni, hogy megint gy valtozot deklaralunk.

```java
int a = 12;
a = 5;
```

```java
String s = "Hello!";
s = "Hello World!";
```

```java
boolean b = false;
b = true;
```

## Feladatok

### Feladat

Hozz letre minden adattipussal 2 valtozot kulonbozo ertekekkel.

### Feladat

Mi tortenik, ha

- deklaralsz egy erteket de nem inicializalod,

- olyan erteket adsz egy valtozonak ami mas tipushoz tartozik,

- int valtozoba egy nagyon nagy szamot (nagyobb mint 2147483647)
  mentesz?

# Operatorok

Ebben a feladatban nehany alapveto operator (muveleti jel) hasznalatat
targyaljuk.

| **Operator** | **Adattipus**       | **Muvelet** | **Hasznalat** |
| :--- | :--- | :--- | :--- |
| `-`           | egesz szam            | `0`                       | `-10`, `0`, `2021`          |
| `+`           | tort szam             | `0.0`                     | `-1.25`, `0.0`, `3.14`      |
| `-`           | logikai ertek         | `false`                   | `true`, `false`             |
| `*`           | szoveg (karakterlanc) | `null`                    | `""`, `"Hello!"`            |
| `= `          | Barmilyen tipus       | Ertekadas                 | `a = 5`                       |
| `+ `          | Szam/String           | Osszeadas/Osszefuzes      | `a = 1 + 2` <br> `hello = "Hel"+ "lo"`|
| `- `          | Szam                  | Kivonas                   | `a = 2 - 1`                   |
| `* `          | Szam                  | Szorzas                   | `a = 2 * 3`                   |
| `/ `          | Szam                  | Osztas                    | `a = 10 / 5`                  |
| `\%`          | Szam                  | Maradekkepzes             | `a = 10 \% 3` (=`1`)          |
| `! `          | Boolean               | Negacio                   | `b = !false` (=`true`)      |
| `&&`          | Boolean               | Es                        | `false && false `(=`false`) `false && true` (=`false`) `true && true` (=`true`)        |
| `\|\|`        | Boolean               | Vagy                      | `false \|\| false` (=`false`) `false \|\| true` (=`true`) `true \|\| true` (=`true`) |
| `== `         | Barmilyen bemenet, Boolean kimenet | Egyenloseg        |`5 == 3` (=`false`) |
| `!= `         | Barmilyen bemenet, Boolean kimenet | Egyenlotlenseg    |`5 != 3` (=`true`)  |
| `>  `         | Szam                  | Nagyobb mint              | `1 > 2  `                 |
| `<  `         | Szam                  | Kisebb mint               | `1 < 2  `                 |
| `>= `         | Szam                  | Nagyobb vagy egyenlo mint | `2 <= 2 `                 |
| `<= `         | Szam                  | Kisebb vagy egyenlo mint  | `2 >= 2 `                 |

*Alap Java operatorok*


## Alap operatorok

Fontos! A == egyenloseg vizsgalo operator kizarolag primitiv tipusokkal (pl.: int, double, boolean) mukodik. String-eket es mas nem primitiv tipusokat a reverzibilis `.equals()` fuggvennyel hasonlitunk ossze. A == operator ezeken a tipusokon csak akkor fog igazat adni eredmenyuk, ha egy valtozot onmagaval hasonlitasz ossze.

```java
String s1 = "abcd";
String s2 = "abc";
boolean egyenloseg = s1.equals(s2);
boolean egyenloseg2 = s2.equals(s1);
```

## Operatorok hasznalata

```java
double pi = 3.14;
int R = 10;
double terulet = pi * R * R;
String eredmeny = "A kor terulete " + terulet + ".";
```

```java
int kor = 22;

boolean gyermek = kor < 12;
boolean serdulo = kor >= 12 && kor < 19;
boolean felnott = kor >= 19 && kor < 60;
boolean idos = kor >= 60;

boolean kotelezoSisak = !felnott;
boolean kotelezoFelugyelet = !(felnott);
boolean ingyenJegy = gyermek || idos;
```

## Feladatok

### Feladat

Minden operatorral vegezz legalabb 2 muveletet. Talalj ki praktikus, valos problemakat amiket ezekkel az operatorokkal lehet megoldani.

### Feladat

Mi tortenik, ha

- String-et osszefuzol egy masik, nem String valtozoval,

- boolean operatort hasznalsz int valtozokkal vagy forditva,

- ket osszeadott int eredmenye nagyobb mint 2147483647),

- int es double valtozokkal vegyesen vegzel muveleteket?

### Feladat

A megfelelo operatorok hasznalataval vegezz maradekos osztast.
`a = 20` `b = 4` `hanyados = ?` `maradek = ?`

### Feladat

Mi lesz a boolean B erteke az alabbi muveletek utan? Eloszor probald meg
fejben megoldani, majd ellenorizd magad JShell-ben.

```java
int a = 4;
int b = 3;
boolean B = a > b;
```

```java
int a = 4;
int b = 3;
boolean B = a <= b || a != 3;
```

```java
int a = 4;
int b = 3;
boolean c = !(a > b || a < b);
boolean d = a % 2 == 0;
boolean B = c || d;
```

# Kiiras konzolra

A JShell engedelyezi, hogy egy erteket megtekintsunk egyszeruen azzal, hogy beirjuk egy valtozo nevet vagy egy muveletet, de a konzolra kiirasnak kulon parancsa van: `System.out.println("Szoveg")`. Ez egy beepitett fuggveny ami egy `String` tipusu objektumot kap parameterkent es azt megjeleniti. Gyakran ha nem `String` tipusu objektumot kap akkor megprobalja automatikusan String-ge atalakitani.

```java
String hello = "Hello ";
String world = "World!";
System.out.println(hello + world);
```

```java
String nev = "Juliska";
int kor = 22;
System.out.println("Hello, a nevem " + nev + " es "
    + kor + " eves vagyok.");
```

# If-Else

Az If-Else egy a sok vezerloszerkezet kozul, amit a Java nyelvben hasznalunk. Alapvetoen a program szabalyosan parancsrol parancsra, felulrol lefele ugrik, de vannak helyzetek amikor egy kondiciotol fuggoen szeretnenk valtoztatni, hogy mit csinaljon a programunk. Az If-Else vezerloszerkezet a legegyszerubb ilyen megoldas, amivel a valosagban is gyakran talalkozunk:

Ha \[kondicio\] akkor \[tortenjen valami\]

Peldaul:

```java
int a = 4;
if(a > 2) {
    System.out.println("a nagyobb mint 2");
}
```

Ha \[kondicio\] akkor \[tortenjen valami\], kulonben \[tortenjen valami mas\]

Peldaul:

```java
int a = 4;
if(a > 2) {
    System.out.println("a nagyobb mint 2");
} else {
    System.out.println("a nem nagyobb mint 2")
}
```

Ha \[kondicio\] akkor \[tortenjen valami\], kulonben ha \[masodik kondicio\] akkor \[tortenjen valami mas\], kulonben ha \[masodik kondicio\] akkor \[tortenjen valami mas\] , kulonben \[tortenjen valami mas\].

```java
int a = 4;
if(a > 2) {
    System.out.println("a nagyobb mint 2");
} else if (a > 1) {
    System.out.println("a nem nagyobb mint 2 de nagyobb mint 1");
} else if (a >= 0) {
    System.out.println("a nem nagyobb mint 2 es nem nagyobb mint 1,
        de nagyobb vagy egyenlo 0-val");
} else {
    System.out.println("a nem nagyobb mint 2, nem nagyobb mint 1
        es nem nagyobb vagy egyenlo 0-val");
}
```

## Feladatok

### Feladat

Mit fognak kiirni a konzolra a kovetkezo kodreszletek? Eloszor probald
meg fejben megoldani, majd ellenorizd magad JShell-ben.

```java
int a = 4;
int b = 3;
int c = 0;
if(a > b) {
    c = a;
} else {
    c = b;
}
System.out.println(c);
```

```java
int a = 4;
int b = 3;
if(a == b) {
    System.out.println(a);
} else if (a > b){
    System.out.println(a);
} else {
    System.out.println(b);
}
```

```java
Strin nev = "Julcsika";
int kor = 7;
if(nev.equals("Julcsika") && kor <= 7) {
    System.out.println("Szia Julcsika!");
} else if(kor <= 7) {
    System.out.println("Szia!");
} else {
    System.out.println("Udvozlet!");
}
```

```java
int a = 4;
int b = 3;
int c = 5;

if(a < b || a < c) {
    a = b;
    if(a >= c) {
        System.out.println(a);
    } else {
        a = c;
        System.out.println(a);
    }
} else {
    System.out.println(a == b);
}
```