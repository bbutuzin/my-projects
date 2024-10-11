#include "Korisnik.h"
#include "Film.h"

class Zaduzenja {
public:
    Zaduzenja();
    Zaduzenja(Korisnik *korisnik, Film *film);
    Zaduzenja(const Zaduzenja& zaduzenja); // onda mora biti deep copy zbog pok.
    int getPovratniRok();
    void setPovratniRok(int povratniRok);
    bool getVracen();
    void setVracen(bool vracen);
    Korisnik* getKorisnik();
    void setKorisnik(Korisnik *korisnik);
    Film* getFilm();
    void setFilm(Film *film);
    void ispis();

protected:
    Film *film;
    Korisnik *korisnik;
    bool vracen;
    int povratniRok;
};

// TODO: nova klasa Iznimka koja nasljeduje exception. IznimkaFilm -> Iznimke.h