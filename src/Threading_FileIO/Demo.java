package Threading_FileIO;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static Threading_FileIO.GenericFileLoader.Countbytes;

public class Demo {
    public static void main(String[] args) throws GenericFileLoaderException, InterruptedException {
        //var
        String path = "C:\\Users\\nikikachelmaier\\Desktop\\";
        /*ArrayList<TextFileLoader> tfs = new ArrayList<>();
        ArrayList<BinaryFileLoader> bfs = new ArrayList<>();*/
        ArrayList<Thread> threads = new ArrayList<>();

        //Eingabe
        Scanner Files = new Scanner(System.in);
        String files = Files.nextLine();

//System.out.println(files);

        //String seperator
        String[] parts = files.split(";");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].contains(".txt")) {
//                tfs.add(new TextFileLoader(path + parts[i]));
                threads.add(new Thread(new TextFileLoader(path + parts[i])));
            } else threads.add(new Thread(new BinaryFileLoader(path + parts[i])));

//                bfs.add(new BinaryFileLoader(path + parts[i]));
        }
        /*for (BinaryFileLoader bf : bfs) {
            threads.add(new Thread(bf));
        }
        for (TextFileLoader tf : tfs) {
            threads.add(new Thread(tf));
        }*/
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        //Souts
        for (Thread thread : threads) {
            System.out.println(thread);
        }
        System.out.println(Countbytes);

    }
}
