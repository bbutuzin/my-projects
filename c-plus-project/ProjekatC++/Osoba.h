#pragma once
#include <string>

class Osoba {
public:
	Osoba();
	Osoba(std::string prebivaliste);
	Osoba(std::string ime, std::string prezime, std::string prebivaliste);
	std::string getIme();
	std::string getPrezime();
	std::string getPrebivaliste();
	void setIme(std::string ime);
	void setPrezime(std::string prezime);
	void setPrebivaliste(std::string prebivaliste);
	virtual void ispis() = 0;

protected:
	std::string ime;
	std::string prezime;
	std::string prebivaliste;
}; 
