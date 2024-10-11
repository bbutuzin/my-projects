package projektbb.Interfaces;

import projektbb.Utilities.Coupe;


import java.util.List;
import java.util.UUID;

public interface CoupeRepository {
    Coupe get(UUID id);
    List<Coupe> getAllCoupe();
    void remove (Coupe coupe);
}
