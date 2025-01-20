@FunctionalInterface
interface MyFunctionalInterface {
    void display();
}

public class InterfaceWithLambdaEx {
    public static void main(String[] args) {

        //inner class
        class A implements MyFunctionalInterface {
            public void display() {
                System.out.println("Inside display");
            }
        }

        //anonymous inner class
        MyFunctionalInterface m = () -> System.out.println("Inside display");
        m.display();
    }

    
}
