package projektbb.Database;

import projektbb.Interfaces.SUVRepository;
import projektbb.Utilities.Convertible;
import projektbb.Utilities.SUV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SUVDatabase implements SUVRepository {
    private List<SUV> database = new ArrayList();
    private String databaseFilePath = "SUV.ser";

    public SUVDatabase() {
        boolean testForDatabase = checkForDatabase();
        if (testForDatabase == true) {
            readDataFromDatabase();
        } else {
            generateDataForDatabase();
        }
    }

    private boolean checkForDatabase() {
        File databaseFile = new File(databaseFilePath);
        if (databaseFile.exists() && databaseFile.isFile()) {
            return true;
        } else {
            return false;
        }
    }

    private void generateDataForDatabase() {
        File databaseFile = new File(databaseFilePath);
        for (int i = 0; i < 30; i++) {
            database.add(new SUV(UUID.randomUUID(), "BMW", "Blue", "Mint", 2500000,"4x4"));

        }
        try (FileOutputStream fo = new FileOutputStream(databaseFile, false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void readDataFromDatabase() {
        File databaseFile = new File(databaseFilePath);
        try (FileInputStream fi = new FileInputStream(databaseFile);
             ObjectInputStream oi = new ObjectInputStream(fi);) {
            database = (ArrayList<SUV>) oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SUV get(UUID id) {
        for (SUV s : database) {
            if (s.getUuid().compareTo(id) == 0) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void remove(SUV suv) {
        database.remove(suv);
    }

    @Override
    public List<SUV> getAllSUVs() {
        return database;
    }
}





