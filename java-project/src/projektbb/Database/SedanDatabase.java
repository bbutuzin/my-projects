package projektbb.Database;


import projektbb.Interfaces.SedanRepository;
import projektbb.Utilities.Sedan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SedanDatabase implements SedanRepository {

        private List<Sedan> database = new ArrayList();
        private String databaseFilePath = "Sedan.ser";

        public SedanDatabase() {
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
                database.add(new Sedan(UUID.randomUUID(),"Hyundai","Red","Good",120000,"5"));

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
                database = (ArrayList<Sedan>) oi.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public Sedan get(UUID id) {
            for (Sedan se : database) {
                if (se.getUuid().compareTo(id) == 0) {
                    return se;
                }
            }
            return null;
        }

        @Override
        public void remove(Sedan sedan) {
            database.remove(sedan);
        }

        @Override
        public List<Sedan> getAllSedan() {
            return database;
        }
}
