import java.util.ArrayList;

public class UniqueArrayList {

}

class UniqueArray extends ArrayList {
    public boolean add(Object o) {
        if(this.contains(o)){
            return true;
        }
        else {
            return super.add(o);
        }
    }
}
