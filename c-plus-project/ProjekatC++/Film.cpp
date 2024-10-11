#include "Film.h"
#include <string>
#include <iostream>

Film::Film() :naziv(""), trajanje(0), reziser(""), godinaIzdanja() {
}
Film::Film(std::string naziv, int trajanje, std::string reziser, int godinaIzdanja) {
	setNaziv(naziv);
	setTrajanje(trajanje);
	setReziser(reziser);
	setGodinaIzdanja(godinaIzdanja);

}

std::string Film::getNaziv() {
	return naziv;
}
int Film::getTrajanje() {
	return trajanje;
}
std::string Film::getReziser() {
	return reziser;
}
int Film::getGodinaIzdanja() {
	return godinaIzdanja;
}
void Film::setNaziv(std::string naziv) {
	this->naziv = naziv;
}
void Film::setTrajanje(int trajanje) {
	this->trajanje = trajanje;
}
void Film::setReziser(std::string reziser) {
	this->reziser = reziser;
}
void Film::setGodinaIzdanja(int godinaIzdanja) {
	this->godinaIzdanja = godinaIzdanja;
}

void Film::ispis() {
	std::cout << "-------------------------------------------------------------------------------------------------------\nINFORMACIJE O FILMU\n\n" << std::endl;
	std::cout << "Naziv: " << this->getNaziv() << ", Trajanje: " << this->getTrajanje() << ", Reziser: " << this->getReziser() << ", Godina izdanja: " << this->getGodinaIzdanja() << "." << std::endl;
}