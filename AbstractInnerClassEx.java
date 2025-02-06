// class A {
//    public void m() {
//        System.out.println("Inside A->m");
//    }
//    //inner abstract class
//    abstract class B {
//        public void m() {
//            System.out.println("Inside A->B->m");
//        }
//    }
// }
//
//
//
//
//public class AbstractInnerClassEx
// {
//    public static void main(String[] args) {
//        A a = new A();
//
//        //inner anonymous class
//        A.B b = a.new B() {
//            public void m() {
//                System.out.println("Inside C -> A->B->m");
//            }
//        };
//
//        b.m();
//    };
//}