#include "Iznimka.h"
#include <string>


  
  Iznimka::Iznimka(const char* msg, int line, const char* info ) : std::exception(msg),
        line(line),
        info(info)
    {
    }

    int Iznimka::get_line() const { 
        return line; 
    }
    const char* Iznimka::get_info() const { 
        return info; 
    }








