package task;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientSpeaker {

    private Map<Integer, String> menu = new HashMap<>();

    private void fuller() {
        menu.put(1, "Неаполитана");
        menu.put(2, "Челентана");
        menu.put(3, "Мясная");
        menu.put(4, "Ататана");
        menu.put(5, "Карбонара");
        menu.put(6, "Маргарита");
        menu.put(7, "Путана");
    }


    private String[] strings = {"\t\t\tМеню", "1.Неаполитана", "2.Челентана", "3.Мясная", "4.Ататана"
            , "5.Карбонара", "6.Маргарита", "7.Путана", "Что предпочитаете на пожрать? Выбери номер или название"};

    public void getStartToGetFood() throws FileNotFoundException {
        StreetMap obj = new StreetMap();
        obj.adreser();
        fuller();
        propositor();
        addresser(obj.getStreetsNumbers());

    }

    private void propositor() {
        for (String str : this.strings
                ) {
            System.out.println(str);
        }
        shortScanner();
    }

    private void addresser(ArrayList arrayList) {
        System.out.println("Выберите улицу, на которую необходима доставка");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + ". " + arrayList.get(i));
        }
        
    }

    private int shortScanner() {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        System.out.println("Вы выбрали " + menu.get(p));
        return p;
    }

}
