//impleting Runnable interface
// class A implements Runnable {
//     public void run() {
//         for (int i = 0; i < 10; i++) {
//             System.out.println("Inside thread A");
//         }
//     }
// }

// class B implements Runnable {
//     public void run() {
//         for (int i = 0; i < 10; i++) {
//             System.out.println("Inside thread B");
//         }
//     }
// }


// public class RunnableEx {
//     public static void main(String[] args) {
//         System.out.println("Main thread starts here...");
//         Runnable a = new A();
//         Runnable b = new B();
//         Thread t1 = new Thread(a);
//         Thread t2 = new Thread(b);
//         t1.start();
//         t2.start();
//         System.out.println("Main thread ends here...");
//     }
// }

public class RunnableEx {
    public static void main(String[] args) {
        System.out.println("Main thread starts here...");
        Runnable a = ()-> {
            {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Inside thread A");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        Runnable b = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Inside thread B");
                }
            }
        };

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
        System.out.println("Main thread ends here...");
    }
}
