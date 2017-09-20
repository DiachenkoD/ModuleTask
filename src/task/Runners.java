package task;

import java.util.Scanner;

public class Runners implements Runnable {
    @Override
    public void run() {

        StreetMap object = new StreetMap();
        System.out.println("Your adrese?");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(object.getArr().toString());

    }
}
