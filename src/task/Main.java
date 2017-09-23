package task;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\t\t\tМеню"+'\n'+"1.Неаполитана");

        StreetMap creator = new StreetMap();
        creator.adreser();
        Runners runners = new Runners();
        Thread runner = new Thread(runners);
        runner.start();


    }
}
