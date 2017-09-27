package task;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StreetMap {
    private Map<String, int[]> arr = new HashMap<>();
    private int[][] distances;
    private ArrayList<String> streetsNumbers = new ArrayList<>();
    private int courierCount;
    private int startPoint;
    private int pathCount;
    final String DIVIDER = "/";

    public int getPathCount() {
        return pathCount;
    }

    public void setPathCount(int pathCount) {
        this.pathCount = pathCount;
    }

    public void adreser() throws FileNotFoundException {

        String[] maxStr = FileWorker.read("pizza.txt").split(DIVIDER);
        for (int i = 0; i < maxStr.length; i++) {
            switch (i) {
                case 0: {
                    arr = trueAddressed(maxStr[i]);
                    break;
                }
                case 1: {
                    distances = distance(maxStr[i]);
                    break;
                }
                case 2: {
                    maxStr[i] = maxStr[i].replace("\n", "");
                    startPoint = superIntParser(maxStr[i]);
                    break;
                }
                case 3: {
                    maxStr[i] = maxStr[i].replace("\n", "");
                    courierCount = superIntParser(maxStr[i]);
                    break;
                }
            }
        }
    }

    private Map<String, int[]> trueAddressed(String str) {
        String[] array;
        Map<String, int[]> arrer = new HashMap<>();
        String[] arr = str.split("\n");
        String[] tempStr;
        for (String strop :
                arr) {
            tempStr = strop.split("p");
            array = tempStr[1].split(" ");
            int[] array1 = new int[2];
            array1[0] = Integer.parseInt(array[0]);
            array1[1] = Integer.parseInt(array[1]);
            arrer.put(tempStr[0], array1);
            streetsNumbers.add(tempStr[0]);
        }

        return arrer;
    }

    private int[][] distance(String str) {
        String[] arr = str.split("[\n ]");
        int[][] arr1 = new int[this.arr.size()][this.arr.size()];
        pathCount = arr1.length;

        for (int j = 0; j < arr.length; j += 2) {
            arr1[superIntParser(arr[j]) - 1][superIntParser(arr[j + 1]) - 1] = vectorLooker(
                    this.arr.get(streetsNumbers.get(superIntParser(arr[j]) - 1)),
                    this.arr.get(streetsNumbers.get(superIntParser(arr[j + 1]) - 1)));
            arr1[superIntParser(arr[j + 1]) - 1][superIntParser(arr[j]) - 1] = arr1[superIntParser(arr[j]) - 1][superIntParser(arr[j + 1]) - 1];
        }


        return arr1;
    }

    private int vectorLooker(int[] first, int[] second) {

        return (int) (Math.sqrt(Math.pow((second[0] - first[0]), 2) + Math.pow((second[1] - first[1]), 2)));

    }

    private int superIntParser(String str) {
        return Integer.parseInt(str);
    }

    public Map<String, int[]> getArr() {
        return arr;
    }

    public void setArr(Map<String, int[]> arr) {
        this.arr = arr;
    }

    public int[][] getDistances() {
        return distances;
    }

    public void setDistances(int[][] distances) {
        this.distances = distances;
    }

    public ArrayList<String> getStreetsNumbers() {
        return streetsNumbers;
    }

    public void setStreetsNumbers(ArrayList<String> streetsNumbers) {
        this.streetsNumbers = streetsNumbers;
    }

    public int getCourierCount() {
        return courierCount;
    }

    public void setCourierCount(int courierCount) {
        this.courierCount = courierCount;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }
}
