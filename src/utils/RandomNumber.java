package utils;

public class RandomNumber {

    private RandomNumber(){

    }

    public static int fromRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
