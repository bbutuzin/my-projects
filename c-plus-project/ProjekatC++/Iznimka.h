#pragma once
#include <exception>
#include <string>
class Iznimka : public std::exception {


public:

    Iznimka(const char* msg, int line, const char* info = "");

    int get_line() const;
    const char* get_info() const;
private:
    int line;
    const char* info;
};



