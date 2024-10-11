// ProjekatC++.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Film.h"
#include "Videoteka.h"
#include "Korisnik.h"

int main()
{   //Rad sa klasom Film
    //Kreiranje objekata tipa Film pozivom konstruktora
    Film film1("The Lord of the Rings: The Fellowship of the Ring", 178, "Peter Jackson", 2001);
    Film film2("The Lord of the Rings: The Two Towers", 179, "Peter Jackson", 2002);
    Film film3("The Lord of the Rings: The Return of the King", 201, "Peter Jackson", 2003);
    Film film4("Harry Potter and the Sorcerer's Stone", 152, "Chris Columbus", 2001);
    Film film5;
    //Unos podata u objekat tipa film preko setter metoda
    film5.setNaziv("Interstellar");
    film5.setReziser("Christopher Nolan");
    film5.setGodinaIzdanja(2014);
    film5.setTrajanje(169);
    //Ispis svojstva objekata preko getter metoda
    std::cout << film1.getNaziv() << std::endl;
    std::cout << film2.getReziser() << std::endl;
    std::cout << film3.getGodinaIzdanja() << std::endl;
    std::cout << film3.getTrajanje() << std::endl;
    std::cout << "Naziv filma: " << film5.getNaziv() << ", Reziser: " << film5.getReziser() << ", Godina izdanja: " << film5.getGodinaIzdanja() << ", Duzina trajanja: " << film5.getTrajanje() << "min" << std::endl;
    std::cout << "-------------------------------------------------------------------------------------------------------" << std::endl;
    //Rad sa klasom Korisnik:
    Korisnik korisnik1;
    //Unios podataka u objeka tipa Korisnik preko setter metoda
    korisnik1.setIme("Andreas");
    korisnik1.setPrezime("Misir");
    korisnik1.setPrebivaliste("Neka adrsa 1");
    korisnik1.setClanarina(550);
    korisnik1.premiumKorisnik();
    korisnik1.standarniKorisnik();
    //Rad sa klasom Radnik:
    Radnik radnik1("Matija", "Trpimirovic", "Ulica 2", 5000);
    //Rad sa klason Videoteka:
    Videoteka videoteka1;
    //Unos filmova u videoteku:
    videoteka1.dodajFilm(&film1);
    videoteka1.dodajFilm(&film2);
    videoteka1.dodajFilm(&film3);
    //Unos radnika u videoteku
    videoteka1.dodajRadnika(&radnik1);
    //Unos lokacije videoteke
    videoteka1.setLokacija("Neka ulica 2"); 
    //Rad sa klasom Zaduzenja preko klase Videoteka
    Zaduzenja *z1 = videoteka1.izdajFilm(&film1, &korisnik1);
    videoteka1.dodajKorisnika(&korisnik1);
    Zaduzenja* z2 = videoteka1.izdajFilm(&film2, &korisnik1);
    z2->ispis();
    videoteka1.vratiFilm(z2);
    videoteka1.ispis();
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
