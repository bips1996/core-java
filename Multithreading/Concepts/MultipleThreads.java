package Multithreading.Concepts;


class AdditionThread implements Runnable {
    SharedResource sr;
    SharedResource sr2;
    AdditionThread(SharedResource sr,SharedResource sr2){
        this.sr = sr;
        this.sr2 = sr2;
    }

    public void run() {
        for(int i =0;i<1000;i++) {
            System.out.println("1- Inside Addition Thread");
            this.sr.value+=1;
            this.sr2.value+=2;
        }
    }
}

class MultiplicationThread implements Runnable {
    SharedResource sr;
    SharedResource sr2;

    MultiplicationThread(SharedResource sr, SharedResource sr2){
        this.sr = sr;
        this.sr2 = sr2;
    }
    
    public void run() {
        for(int i =0;i<1000;i++) {
            System.out.println("2- Inside Multiplication Thread");
            this.sr2.value+=2;
            this.sr.value+=1;
        }
    }
}


public class MultipleThreads {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource(1), sr2 = new SharedResource(1);

        AdditionThread at = new AdditionThread(sr,sr2);
        MultiplicationThread mt = new MultiplicationThread(sr,sr2);

        Thread atr = new Thread(at);
        Thread mtr = new Thread(mt);

        atr.start();
        mtr.start();
        try {
            atr.join();
            mtr.join();
        } catch(Exception e) {
             e.printStackTrace();
        }

        System.out.println("Final value = "+ sr.value+ "sr2 =  "+sr2.value);

    }
}
