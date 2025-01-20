enum Color {
    RED(100), GREEN(800), BLUE(3000);
    private int val;
    Color(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
    
    public void setVal(int val) {
        this.val = val;
    }
}

public class EnumClassEx {
    public static void main(String[] args) {
        Color c = Color.RED;
        System.out.println(c);
        System.out.println(c.getVal());
        c.setVal(200);
        System.out.println(c.getVal());
    }
}
