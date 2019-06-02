package Model.Utilities;
import Model.Game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class FileHelper {

    private static final String filepath = "save";

    public void writeObjectToFile(Object serObj) {
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Game loadObjectToFile() {
        try {

            FileInputStream fis = new FileInputStream("save");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Game game = (Game) ois.readObject();
            ois.close();
            return game;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


