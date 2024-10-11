#pragma once
#include "Osoba.h"

class Korisnik : public Osoba {
public:
    Korisnik();
    Korisnik(const Korisnik& korisnik);
    Korisnik(std::string ime, std::string prezime, std::string prebivaliste, int clanarina, bool premium);
    int getClanarina();
    void setClanarina(int clanarina);
    void premiumKorisnik();
    void standarniKorisnik();
    void ispis() override;


private:
    int clanarina;
    bool premium;
}; 
