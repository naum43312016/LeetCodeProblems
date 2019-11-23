package naum.asafov.com.CountPrimes204;
/*
204. Count Primes

 */
public class Main {
    public static void main(String[] args) {
        int i = 10;
        int x = new Solution().countPrimes(i);
        System.out.println(x);
    }
}

class Solution {
    public int countPrimes(int n) {
        if(n<=1) return 0;
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i<isPrime.length; i++){
            isPrime[i] = true;
        }

        for(int i = 2; i<isPrime.length; i++){

            if(isPrime[i]){
                for(int k =2; i*k<isPrime.length; k++){
                    isPrime[i*k] =false;
                }
            }
        }
        int count = 0;
        for(boolean i : isPrime){
            if(i)count++;
        }
        return count;
    }
}