package Threading_FileIO;

import java.io.*;
import java.util.ArrayList;

public class TextFileLoader extends GenericFileLoader implements Runnable {

    private ArrayList<String> content;
    private Object Lockobject = new Object();

    public TextFileLoader(String path) {
        super(path);
        content = new ArrayList<>();
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public void loadFile() throws GenericFileLoaderException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
                synchronized (Lockobject) {
                    Countbytes += line.length();
                }
            }
            /*while (br.read() != -1) {
                synchronized (Lockobject) {
                    Countbytes++;
                }
            }*/
        } catch (FileNotFoundException e) {
            throw new GenericFileLoaderException(e);
        } catch (IOException e) {
            throw new GenericFileLoaderException();
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
