#include "Osoba.h"
#include <string>
#include <iostream>

// inicijalizacijska lista
//Osoba::Osoba() :ime(""), prezime(""), prebivaliste("") {
//}

// delegiranje konstruktora
Osoba::Osoba() : Osoba("", "", "") { }

Osoba::Osoba(std::string prebivaliste) : Osoba("", "", prebivaliste) { }

Osoba::Osoba(std::string ime, std::string prezime, std::string prebivaliste) {
	setIme(ime);
	setPrezime(prezime);
	setPrebivaliste(prebivaliste);
}

std::string Osoba::getIme() {
	return ime;
}

std::string Osoba::getPrezime() {
	return prezime;
}

std::string Osoba::getPrebivaliste() {
	return prebivaliste;
}

void Osoba::setIme(std::string ime) {
	this->ime = ime;
}

void Osoba::setPrezime(std::string prezime) {
	this->prezime = prezime;
}

void Osoba::setPrebivaliste(std::string prebivaliste) {
	this->prebivaliste = prebivaliste;
}

