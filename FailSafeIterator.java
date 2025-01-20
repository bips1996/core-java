import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterator {
    public static void main(String[] args) {

        //following code throws java.util.ConcurrentModificationException as modification is happening while iterating the list
        // ArrayList<Integer> al = new ArrayList<Integer>();
        // al.add(1);
        // al.add(2);

        // Iterator it = al.iterator();

        // while(it.hasNext()) {
        //     Integer ele = (Integer)it.next();
        //     System.out.println(ele);
        //     al.add(ele);
        // }


        CopyOnWriteArrayList<Integer> al = new CopyOnWriteArrayList<Integer>();
        al.add(1);
        al.add(2);

        Iterator<Integer> it = al.iterator();

        while(it.hasNext()) {
            Integer ele = (Integer)it.next();
            System.out.println(ele);
            al.add(3);
        }


    }
}
