#include <string>
#include <vector>
#include "Korisnik.h"
#include "Film.h"
#include "Zaduzenja.h"
#include "Radnik.h"
using std::vector;
using std::string;

class Videoteka {
public:

	bool provjeraPostojanjaKorisnika(Korisnik* k);
	void dodajFilm(Film *f);
	Zaduzenja* izdajFilm(Film *f, Korisnik *k);
	void vratiFilm(Zaduzenja *z);
	void dodajRadnika(Osoba* r);
	void ispis();
	string getLokacija();
	void setLokacija(string lokacija);
	void dodajKorisnika(Osoba* korisnik);
	
private:
	std::string lokacija;
	vector <Film*> filmovi;
	vector <Osoba*> radnici;
	vector <Osoba*> korisnici;
	vector <Zaduzenja*> zaduzenja;
};