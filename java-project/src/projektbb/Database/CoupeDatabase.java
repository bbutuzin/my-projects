package projektbb.Database;

import projektbb.Interfaces.CoupeRepository;
import projektbb.Utilities.Coupe;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CoupeDatabase implements CoupeRepository {
    private List<Coupe> database = new ArrayList();
    private String databaseFilePath = "Coupe.ser";

    public CoupeDatabase() {
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
            database.add(new Coupe(UUID.randomUUID(),"Audi","Green","Mint",170000,"Adjustable"));

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
            database = (ArrayList<Coupe>) oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Coupe get(UUID id) {
        for (Coupe c : database) {
            if (c.getUuid().compareTo(id) == 0) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void remove(Coupe coupe) {
        database.remove(coupe);
    }

    @Override
    public List<Coupe> getAllCoupe() {
        return database;
    }
}
