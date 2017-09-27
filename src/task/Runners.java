package task;


import static java.lang.Thread.sleep;

public class Runners implements Runnable {

    private long deliveryTime;

    public Runners(long deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public void run() {
        System.out.println("Курьер будет ехать к Вам " + deliveryTime*5 + " минут");
        try {
            sleep(deliveryTime*5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Курьер доставил пиццу, вновь он будет доступен через "+ deliveryTime*5+ " минут");

    }


}
