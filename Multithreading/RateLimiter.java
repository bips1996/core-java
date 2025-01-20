//package Multithreading;
///*
// * Imagine you have a bucket that gets filled with tokens at the rate of 1 token per second.
// * The bucket can hold a maximum of N tokens.
// * Implement a thread-safe class that lets threads get a token when one is available.
// * If no token is available, then the token-requesting threads should block.
// * The class should expose an API called getToken that various threads can call to get a token //
// */
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//class GenerateToken {
//    private final String token;
//    public GenerateToken(Integer index) {
//        this.token = "Token:" + index;
//    }
//    public String getToken() {
//        return token;
//    }
//}
//
//class TokenBucket {
//    int bucketSize;
//    List<String> tokens;
//
//    TokenBucket(int maxTokens) {
//        this.bucketSize = maxTokens;
//        this.currentBucketIndex = 0;
//    }
//
//    public String getToken(){
//        if()
//    }
//
//    public synchronized  int createToken() {
//        if( currentToken < maxTokens)
//            currentToken = currentToken+1;
//        return currentToken;
//    }
//
//    public boolean isTokenAvailable() {
//        if(Math.abs(maxTokens- currentToken)>0)
//            return true;
//        return false;
//    }
//}
//
//public class Ratelimiter {
//    public static void main(String[] args) {
//
//        ExecutorService e = Executors.newFixedThreadPool(20);
//        TokenBucket t = new TokenBucket(10);
//        int ctr =0;
//        while(ctr< 100) {
//            t.createToken();
//            try {
//                Thread.sleep(100);
//            } catch(Exception e1){
//                throw e1;
//            }
//            ctr++;
//        }
//
//        for(int i = 0;i<20;i++) {
//            Runnable r = () -> {
//                System.out.println("Created a thread");
//            };
//            int token = t.getToken();
//
//            if(token == -1)
//            {
//                System.out.println("Max Requests achieved");
//                try {
//                    Thread.sleep(100);
//                } catch(Exception e2){
//                    throw e2;
//                }
//            } else {
//                e.submit(r);
//                System.out.println("Thread executed with token"+token);
//            }
//        }
//    }
//}
