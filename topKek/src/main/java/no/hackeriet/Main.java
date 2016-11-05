package no.hackeriet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public void run() throws FileNotFoundException {
        String fileName = "kek.43319559636b94db1c945834340b65d68f90b6ecbb70925f7b24f6efc5c2524e.txt";

        TopKek.parse(TopKek.readFile(new FileInputStream(getClass().getClassLoader().getResource(fileName).getFile())));
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }
}
