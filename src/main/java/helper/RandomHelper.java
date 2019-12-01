package helper;

import java.util.Random;

public class RandomHelper {

    public static int getRandomNumber(int size) {
        Random rand = new Random();
        return rand.nextInt(size);
    }
}
