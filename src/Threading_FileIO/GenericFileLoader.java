package Threading_FileIO;

public abstract class GenericFileLoader  {
    protected String path;
    public static int Countbytes;


    public GenericFileLoader(String path) {
        this.path = path;
    }

    public abstract void loadFile() throws GenericFileLoaderException;
}
