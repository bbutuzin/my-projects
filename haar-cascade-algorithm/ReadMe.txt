HAAR CASCADE 

Haar Cascade je algoritam računalnog vida koji se koristi za detekciju objekata, posebno za detekciju lica na slikama i video zapisima. 
Prvi su ga predstavili Viola i Jones 2001. i od tada je postao popularan pristup detekciji objekata zbog svoje točnosti i brzine.
Algoritam Haar Cascade funkcionira tako da identificira značajke objekta, kao što su rubovi, linije i kontrasti boja, i koristi te značajke za razlikovanje objekta od pozadine. 
Te su značajke organizirane u kaskadu klasifikatora koji se koriste za identifikaciju objekta korak po korak. 
Ovaj proces uključuje ispitivanje slike u malim regijama ili "prozorima" i određivanje sadrži li svaki prozor predmet interesa. 
Ako se utvrdi da prozor ne sadrži objekt, on se odbacuje i algoritam prelazi na sljedeći prozor. Ovaj proces se nastavlja sve dok se ne pregleda cijela slika i dok se ne identificiraju sva područja koja sadrže objekt.
Uvježbavanje algoritma Haar Cascade uključuje davanje velikog broja pozitivnih i negativnih primjera objekta koji treba detektirati. 
Pozitivni primjeri su slike koje sadrže predmet, dok su negativni primjeri slike koje ga ne sadrže. 
Algoritam zatim koristi tehniku ​​strojnog učenja poznatu kao Adaboost za odabir najinformativnijih značajki i njihovo kombiniranje u snažan klasifikator.
Adaboost radi tako da iterativno obučava slijed slabih klasifikatora na podacima za obuku, pri čemu se svaki klasifikator fokusira na primjere koje je najteže klasificirati. 
Konačni klasifikator je ponderirana kombinacija slabih klasifikatora, s većom težinom danom onima koji imaju dobre rezultate na podacima o obuci.
Haar Cascade ima nekoliko prednosti u odnosu na druge algoritme za otkrivanje objekata. Jedna od njegovih primarnih prednosti je brzina.
Algoritam može brzo obraditi veliki broj prozora, što ga čini prikladnim za aplikacije u stvarnom vremenu. Uz to, algoritam je vrlo precizan i može detektirati objekte s visokim stupnjem preciznosti.
Međutim, algoritam Haar Cascade također ima neka ograničenja. Ne može se boriti sa složenim pozadinama ili kada je objekt koji treba detektirati malen i nije dobro definiran. 
Osim toga, za dobru izvedbu potrebna je velika količina podataka o obuci, što u nekim slučajevima može biti teško dobiti.
Unatoč svojim ograničenjima, Haar Cascade ostaje popularan algoritam za detekciju objekata, posebno za detekciju lica. Korišten je u raznim aplikacijama, uključujući sigurnost i nadzor, robotiku i proširenu stvarnost.

KOD

Prvo ćemo uvesti biblioteku  cv2 iz kojih ćemo pozivati potrebne funkcije.

-----------
import cv2
------------

Korak nakon toga ćemo odrediti video koji ćemo koristi pomoću VideoCaptura.
Zatim ćemo u 'human_cascade' učitati datoteku haarcascade_fullbody.xml koja je unaprijed obučeni model haar cascade.
To se radi putem cascade klasifikatora. Uvježbani su s nekoliko stotina "pozitivnih" uzoraka prikaza određenog objekta i proizvoljnih "negativnih" slika iste veličine. 
Nakon što se klasifikator uvježba, može se primijeniti na područje slike i detektirati dotični objekt.
CascadeClassifier je poseban slučaj skupnog učenja koji se temelji na ulančavanju nekoliko klasifikatora, koristeći sve informacije prikupljene iz izlaza danog klasifikatora kao dodatne informacije za sljedeći klasifikator u kaskadi.



-------------------------------------
cap = cv2.VideoCapture('Humans.mp4')
human_cascade = cv2.CascadeClassifier('frontalFace.xml')
-------------------------------------

Moramo mu dati instrukciju da hvata frame po frame.

----------------------
ret, frame = cap.read()
----------------------

Zatim u 'sivom', pretvaramo sliku u sliku u sive tonove. To činimo jer je za svaki piksel potrebno manje informacija.

----------------------------------------------
gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
----------------------------------------------

human_cascade.detectMultiScale izdvaja granične okvire svih identificiranih tijela.
U detectMultiScale, prvi proslijeđeni parametar je naziv slike.
Drugi proslijeđeni parametar je faktor mjerila, koji je parametar koji određuje koliko je veličina slike smanjena pri svakoj mjeri slike.
MinNeighbors je treći parametar koji specificira koliko susjeda treba imati svaki pravokutnik kandidat da ga zadrži.
U tijelima ćemo imati četiri koordinate, x,y,w,h.

----------------------------------------------------
humans = human_cascade.detectMultiScale(gray, 1.9, 1)
----------------------------------------------------

Nakon toga prikaz samog frame koji nam je potreban za šta koristimo image show odnosno čovjeka ili lice koje nam je potrebno unutar pravokutnika.
X je x-koordinata, a y je y-koordinata.
W je širina lica, a h je visina lica.
Stoga će x+w i y+h dati donje desne koordinate detektiranih lica.
Cv2.rectangle() crta pravokutnik oko detektiranih lica. Prosljeđujemo naziv slike i (x,y) i (x+w,y+h) koordinate za crtanje pravokutnika.
(0,255,255) označava boju pravokutnika. OpenCV radi u BGR formatu. 
Koristeći for petlju, izvući ćemo x,y,w,h koordinate iz tijela.
Zatim ćemo pomoću tih koordinata nacrtati pravokutnik oko otkrivenih ljudi.

-------------------------------------------------------------------
    for (x, y, w, h) in humans:
        cv2.rectangle(frame, (x, y), (x + w, y + h), (255, 0, 0), 2)

    cv2.imshow('frame', frame)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
-------------------------------------------------------------------

cap.realase će pustiti capture koji smo korsitili.
DestructAllWindows() će ukloniti sve prozore koji su bili otvoreni nakon završetka programa.

-----------------------
cap.release()
cv2.destroyAllWindows()
-----------------------

OSVRT

NEDOSTACI
NEPRECIZNOST- Postoji mnogo ljudi koji nisu otkriveni, a ponekad se jedna osoba otkrije dvaput. Također, često trepere, tj. ponekad se detektiraju, a ponekad ne. Dakle, ovo je rani pristup koji nije baš precizan u usporedbi s drugim modernim pristupima.
NEPRIKLADNI GRANIČNI OKVIRI - Otkriveni granični okviri nisu baš prikladni i čvrsti.
PREDNOSTI
BRZINA - Ova metoda je vrlo brza u usporedbi s drugim tehnikama detekcije objekata kao što su YOLO, Mask R-CNN, SSD, Faster R-CNN itd. Ovaj pristup zahtijeva manje računalne snage.Može se pokrenuti bez GPU-a.



