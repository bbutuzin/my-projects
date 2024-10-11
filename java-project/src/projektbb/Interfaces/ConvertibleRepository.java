package projektbb.Interfaces;



import projektbb.Utilities.Convertible;

import java.util.List;
import java.util.UUID;

public interface ConvertibleRepository {

    Convertible get(UUID id);
    List<Convertible> getAllConvertibles();
    void remove (Convertible coupe);
}
