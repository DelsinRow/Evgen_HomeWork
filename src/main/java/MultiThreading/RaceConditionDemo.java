package udemy.multithreading;


public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        Balance balance = new Balance();
        BankAccount task = new BankAccount();
        task.setBalance(balance);

        Thread john = new Thread(task);
        Thread anita = new Thread(task);

        Thread check = new Thread(new Runnable() {
            @Override
            public void run() {
                while (john.isAlive() && anita.isAlive() ) {
                    System.out.println("john :" + john.getState());
                    System.out.println("anita :" + anita.getState());
                }
            }
        });


        john.setName("John");
        anita.setName("Anita");
        john.start();
        anita.start();

        check.start();

    }
}

class BankAccount implements Runnable {

    private Balance balance;

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public void run() {
        makeWithdrawal(75);
        if (balance.getBalance() < 0) {
            System.out.println("Money overdrawn!!!");
        }
    }

    private synchronized void makeWithdrawal(int amount) {
        if (balance.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw ...");
            balance.setBalance(balance.getBalance() - amount);
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + " bucks");
        } else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
    }

}

class Balance {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}