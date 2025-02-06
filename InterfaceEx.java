//// class - class extends
//// interface - interface extends
//// class - interface implements
//
//
//interface Ex1 {
//    int x = 10; //all the variables in interface are public, static and final by default
//    String y = "Hello";
//    //all the methods in interface are public and abstract by default
//    void show();
//}
//
//interface Ex2 {
//    void show();
//}
//
//// A interface can extend multiple interfaces
//interface Ex3 extends Ex1, Ex2 {
//    void show();
//    void display();
//}
//
//// A class can implement multiple interfaces
//class B implements Ex1, Ex2 {
//    public void show() {
//        System.out.println("Inside B->show");
//    }
//}
//
//public class InterfaceEx {
//    public static void main(String[] args) {
//        Ex1 e = new B();
//        e.show();
//        System.out.println("x = " + Ex1.x);
//        System.out.println("y = " + Ex1.y);
//    }
//
//}
