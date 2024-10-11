#include "Radnik.h"
#include <iostream>


Radnik::Radnik() :Osoba() {
	placa = 0.0;
}
Radnik::Radnik(std::string ime, std::string prezime, std::string prebivaliste, double placa) : Osoba(ime, prezime, prebivaliste) {
	this->placa = placa;
}
Radnik::Radnik(const Radnik& radnik) {
	ime = radnik.ime;
	prezime = radnik.prezime;
	prebivaliste = radnik.prebivaliste;
	placa = radnik.placa;
}
double Radnik::getPlaca() {
	return placa;
}
void Radnik::setPlaca(double placa) {
	this->placa = placa;
}
void Radnik::ispis() {
	std::cout << "Ime: " << this->ime << " Prezime: " << this->prezime << " Prebivaliste: " << this->prebivaliste << " Plaća: " << this->placa << std::endl;
}

