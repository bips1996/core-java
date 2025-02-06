package Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 Collection of key-value pair. keys are unique and values can be duplicate
 */
public class MapCollection {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<Integer, String>(); // Sorted Order
        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(); // Preserves the order of insertion
    }
}
