#pragma once
#include "Osoba.h"

class Radnik : public Osoba {
public:
    Radnik();
    Radnik(std::string ime, std::string prezime, std::string prebivaliste, double placa);
    double getPlaca();
    void setPlaca(double placa);
    Radnik(const Radnik& radnik);
    void ispis() override;

private:
    double placa;

};
