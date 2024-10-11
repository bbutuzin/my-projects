package projektbb.Database;

import projektbb.Interfaces.ConvertibleRepository;
import projektbb.Utilities.Convertible;
import projektbb.Utilities.SUV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class ConvertibleDatabase implements ConvertibleRepository {

    static Logger log=Logger.getLogger(projektbb.Utilities.Logger.LOGGER_STRING);
    private List<Convertible> database=new ArrayList();
    private String databaseFilePath="Convertible.ser";

    public ConvertibleDatabase(){
        boolean testForDatabase=checkForDatabase();
        if(testForDatabase==true){
            readDataFromDatabase();
        }else{
            generateDataForDatabase();
        }
    }
    private boolean checkForDatabase(){
        File databaseFile=new File(databaseFilePath);
        if(databaseFile.exists() && databaseFile.isFile()){
            return true;
        }else{
            return false;
        }
    }
    private void generateDataForDatabase(){
        File databaseFile=new File(databaseFilePath);
        for(int i=0;i<30;i++){
            database.add(new Convertible(UUID.randomUUID(),"Ferrari","Blue","Mint",15000000,300));

        }
        try (FileOutputStream fo=new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou=new ObjectOutputStream(fo)){
                 ou.writeObject(database);
                 log.info("Convertible database succesfully created");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void readDataFromDatabase(){
        File databaseFile=new File(databaseFilePath);
        try(FileInputStream fi=new FileInputStream(databaseFile);
        ObjectInputStream oi=new ObjectInputStream(fi);){
        database=(ArrayList<Convertible>)oi.readObject();
        log.info("Convertible database succesfully loaded");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Convertible get(UUID id) {
        for(Convertible c : database){
            if(c.getUuid().compareTo(id) == 0){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Convertible> getAllConvertibles() {
        generateDataForDatabase();
        return database;
    }

    @Override
    public void remove(Convertible convertible) {
        database.remove(convertible);
    }
}

