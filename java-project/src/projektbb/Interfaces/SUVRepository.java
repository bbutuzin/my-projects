package projektbb.Interfaces;

import projektbb.Utilities.SUV;

import java.util.List;
import java.util.UUID;

public interface SUVRepository {
    SUV get(UUID id);
    List<SUV>getAllSUVs();
    void remove (SUV suv);
}
