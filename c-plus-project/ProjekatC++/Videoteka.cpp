#include "Videoteka.h"
#include <vector>
#include <iostream>
#include <exception>
#include "Iznimka.h"



void Videoteka::vratiFilm(Zaduzenja* z) {

	this->filmovi.push_back(z->getFilm());
	z->setVracen(true);

}

Zaduzenja* Videoteka::izdajFilm(Film* f, Korisnik* k) {
	try {
		if (provjeraPostojanjaKorisnika(k)) {
			Zaduzenja* z = new Zaduzenja(k, f);
			this->zaduzenja.push_back(z);
			this->filmovi.erase(std::remove(filmovi.begin(), filmovi.end(), f), filmovi.end());
			return z;
		}
		else {
			
			throw Iznimka("Korisnik mora biti uclanjen u videoteku da bi iznajmio film.",18,"");
		}
	} catch (Iznimka& ex){
		std::cout << ex.what() << std::endl;
		std::cout << "Broj linije: " << ex.get_line() << std::endl;
	}
}

void Videoteka::dodajFilm(Film* f) {
	this->filmovi.push_back(f);
}


void Videoteka::dodajRadnika(Osoba* r) {
	this->radnici.push_back(r);
}


void Videoteka::dodajKorisnika(Osoba* korisnik) {
	this->korisnici.push_back(korisnik);
}

std::string Videoteka::getLokacija() {
	return lokacija;
}

void Videoteka::setLokacija(string lokacija) {
	this->lokacija = lokacija;
}
void Videoteka::ispis() {
	std::cout << "-------------------------------------------------------------------------------------------------------\nINFORMACIJE O VIDEOTECI\n\n" << std::endl;
	std::cout << "Lokacija Videoteke: " << this->lokacija << "\n";
	std::cout << "Filmovi u videoteci: ";
	try {
		if (korisnici.size() == 0) {
			throw 100;
		}
		for (int i = 0; i < ((filmovi.size()) - 1); i++) {
			std::cout << filmovi[i]->getNaziv() << ", ";
		}
		std::cout << filmovi[filmovi.size() - 1]->getNaziv() << ".\n";
	}
	catch (int num) {
		std::cout << "\nVideoteka nema filmove!" << std::endl;
		std::cout << "Broj greske: " << num << std::endl;
	}
	std::cout << "Radnici u videoteci: ";
	try {
		for (int i = 0; i < ((radnici.size()) - 1); i++) {
			std::cout << radnici[i]->getIme() << " " << radnici[i]->getPrezime() << ", ";
		}
		std::cout << radnici[radnici.size() - 1]->getIme() << " " << radnici[radnici.size() - 1]->getPrezime() << ".\n";
	}
	catch (int num) {
		std::cout << "\nVideoteka nema radnike!" << std::endl;
		std::cout << "Broj greske: " << num << std::endl;
	}
	std::cout << "Korisnici videoteke: ";
	try {
		if(korisnici.size() == 0){
		throw 300;
		}
		for (int i = 0; i < ((korisnici.size()) - 1); i++) {
			std::cout << korisnici[i]->getIme() << " " << korisnici[i]->getPrezime() << ", ";
		}
		std::cout << korisnici[radnici.size() - 1]->getIme() << " " << korisnici[radnici.size() - 1]->getPrezime() << ".\n";
	}
	catch (int num) {
		std::cout << "\nVideoteka nema korisnike!" << std::endl;
		std::cout << "Broj greske: " << num <<std::endl;
	}
	std::cout << "Zaduzenja u videoteci:\n";
	try {
		if (zaduzenja.size() == 0) {
			throw 400;
		}
		for (int i = 0; i < ((zaduzenja.size()) - 1); i++) {
			zaduzenja[i]->ispis();
			std::cout << ",\n";
		}
		zaduzenja[zaduzenja.size() - 1]->ispis();

	}
	catch (int num) {
		std::cout << "\nVideoteka nema zaduzenja!" << std::endl;
		std::cout << "Broj greske: " << num << std::endl;
	}
}
bool Videoteka::provjeraPostojanjaKorisnika(Korisnik* k) {
	for (int i = 0; i < korisnici.size(); i++) {
		if (korisnici[i] == k) {
			return true;
		}
	}
	return false;
}