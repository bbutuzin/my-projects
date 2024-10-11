#include "Korisnik.h"
#include <iostream>

Korisnik::Korisnik() : Osoba() {
    this->clanarina = 0;
    this->premium = false;
}
Korisnik::Korisnik(std::string ime, std::string prezime, std::string prebivaliste, int clanarina, bool premium) : Osoba(ime, prezime, prebivaliste) {
    this->clanarina = clanarina;
    this->premium = premium;
}

// copy konstruktor
// shallow copy - nije problem u ovom slucaju
Korisnik::Korisnik(const Korisnik& korisnik) {
    this->ime = korisnik.ime;
    this->prezime = korisnik.prezime;
    this->prebivaliste = korisnik.prebivaliste;
    this->clanarina = korisnik.clanarina;
    this->premium = korisnik.premium;
}

void Korisnik::premiumKorisnik() {
    if (this->clanarina > 500) {
        premium = true;
        std::cout << "Premium korisnik" << std::endl;
    }
    else {
        premium = false;
        std::cout << "Nemate dovoljno za premium clanarinu" << std::endl;
    }
}

void Korisnik::standarniKorisnik() {
    if (this->clanarina > 200 && this->clanarina < 500) {
        std::cout << "Standarni korisnik " << std::endl;
    }
    else {
        std::cout << "Nije standardni korisnik" << std::endl;
    }
}

int Korisnik::getClanarina() {
    return clanarina;
}
void Korisnik::setClanarina(int clanarina) {
    this->clanarina = clanarina;
}

void Korisnik::ispis() {
    std::cout << "Ime: " << this->ime << " Prezime: " << this->prezime << " Prebivaliste: " << this->prebivaliste << " Clanarina: " << this->clanarina << std::endl;
}
