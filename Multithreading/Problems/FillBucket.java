package Multithreading.Problems;

import java.util.ArrayList;
import java.util.List;

class Bucket {
    int bucketSize;
    int currentIndex;

    public Bucket(int bucketSize) {
        this.bucketSize = bucketSize;
        this.currentIndex = 0;
    }
    public int getBucketSize() {
        return bucketSize;
    }

    public void fill() {
        if(currentIndex >= bucketSize) return;
        currentIndex++;
    }
}

public class FillBucket {
    public static void main(String[] args) {

    }
}
