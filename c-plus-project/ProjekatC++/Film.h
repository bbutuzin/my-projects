#pragma once
#include<string>

class Film {
public:
    Film();
    Film(std::string naziv, int trajanje, std::string reziser, int godinaIzdanja);
    std::string getNaziv();
    int getTrajanje();
    std::string getReziser();
    int getGodinaIzdanja();
    void setNaziv(std::string naziv);
    void setTrajanje(int trajanje);
    void setReziser(std::string reziser);
    void setGodinaIzdanja(int godinaIzdanja);
    void ispis();

protected:
    std::string naziv;
    int trajanje;
    std::string reziser;
    int godinaIzdanja;
};