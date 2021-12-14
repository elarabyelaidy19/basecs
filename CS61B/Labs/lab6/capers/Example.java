package capers;

import java.io.File;
import java.io.IOException;

public class Example {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));

        File f = new File("lab6/capers/dummy.txt");
        f.createNewFile();

    }
}
