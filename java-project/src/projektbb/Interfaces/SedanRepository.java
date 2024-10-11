package projektbb.Interfaces;



import projektbb.Utilities.Sedan;

import java.util.List;
import java.util.UUID;

public interface SedanRepository {
    Sedan get(UUID id);

    List<Sedan> getAllSedan();

    void remove(Sedan coupe);

}
