package Threading_FileIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryFileLoader extends GenericFileLoader implements Runnable {
    private ArrayList<Integer> bytes;
    Object Lockobject = new Object();
    public BinaryFileLoader(String path) {
        super(path);
        bytes = new ArrayList<>();
    }

    public ArrayList<Integer> getBytes() {
        return bytes;
    }

    @Override
    public void loadFile() throws GenericFileLoaderException {
        try(BufferedInputStream bi =  new BufferedInputStream(new FileInputStream(path))) {

            int singlebyte;
            while ((singlebyte = bi.read()) != -1) {
                    bytes.add(singlebyte);
                synchronized (Lockobject) {
                    Countbytes++;
                }
            }

        } catch (FileNotFoundException e) {
            throw new GenericFileLoaderException(e);
        } catch (IOException e) {
            throw new GenericFileLoaderException(e);
        }
    }


    @Override
    public void run() {
        try {
            loadFile();
        } catch (GenericFileLoaderException e) {
            e.printStackTrace();
        }
    }
}
