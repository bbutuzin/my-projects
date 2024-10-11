#include "Zaduzenja.h"
#include <iostream>

Zaduzenja::Zaduzenja() {
    korisnik = nullptr;
    film = nullptr;
    vracen = false;
    povratniRok = 0;
}

Zaduzenja::Zaduzenja(Korisnik *korisnik, Film *film) {
    this->korisnik = korisnik;
    this->film = film;
    this->vracen = false;
    this->povratniRok = 14;
}

Zaduzenja::Zaduzenja(const Zaduzenja& zaduzenja) {
    if (korisnik != nullptr) {
        korisnik = new Korisnik(*(zaduzenja.korisnik));
    }else {
        korisnik = nullptr;
    }
    if (film != nullptr) {
        film = new Film(*(zaduzenja.film));
    }
    else {
        film = nullptr;
    }
    this->vracen = zaduzenja.vracen;
    this->povratniRok = zaduzenja.povratniRok;
}


bool Zaduzenja::getVracen() {
        return vracen;
    
}

void Zaduzenja::setVracen(bool vracen) {
    this->vracen = vracen;
}

int Zaduzenja::getPovratniRok() {
    return povratniRok;
}

void Zaduzenja::setPovratniRok(int povratniRok) {
    this->povratniRok = povratniRok;
}

Film* Zaduzenja::getFilm() {
    return film;
}

void Zaduzenja::setFilm(Film *film) {
    this->film = film;
}

Korisnik* Zaduzenja::getKorisnik() {
    return korisnik;
}

void Zaduzenja::setKorisnik(Korisnik* korisnik) {
    this->korisnik = korisnik;
}

void Zaduzenja::ispis() {
    std::cout << "-------------------------------------------------------------------------------------------------------\nINFORMACIJE O ZADUZENJU\n\n" << std::endl;
    std::cout << "Korisnik: " << this->getKorisnik()->getIme() << " " << this->getKorisnik()->getPrezime() << "\nFilm: " << this->getFilm()->getNaziv()
        << "\nPovratni rok: " << this->getPovratniRok() << " dana, ";
    if (this->getVracen()) {
        std::cout << " vracen." << std::endl;
    }
    else {
        std::cout << " nije vracen." << std::endl;
    }
}