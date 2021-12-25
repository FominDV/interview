package ru.fomin.ping;

public class PingPong {

    private Object lock = new Object();
    private PingValue currentValue = PingValue.PING;

    private enum PingValue {

        PING("ping"), PONG("pong");

        private String value;

        PingValue(String value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        new Thread(()-> pingPong.ping()).start();
        new Thread(()-> pingPong.pong()).start();
    }

    private void ping(){
        synchronized (lock){
            for (int i = 0; i < 10; i++) {
                while (currentValue!=PingValue.PING){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(currentValue.value);
                currentValue=PingValue.PONG;
                lock.notify();
            }
        }
    }

    private void pong(){
        synchronized (lock){
            for (int i = 0; i < 10; i++) {
                while (currentValue!=PingValue.PONG){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(currentValue.value);
                currentValue=PingValue.PING;
                lock.notify();
            }
        }
    }

}
