package nedev.hogoshi.util;

import java.util.Random;

public class Randomizer {

    public static String generateRandomKey(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static boolean generateRandomBoolean() {
        Random rand = new Random();

        boolean i = rand.nextBoolean();
        if(i) {
            return true;
        } else {
            return false;
        }
    }

    public static int generateRandomNumb(int numbers) {
        Random rnd = new Random();
        int i = rnd.nextInt(numbers);

        if(i < i / 2) {
            return 1;
        } else if(i > i / 2) {
            return 2;
        } else {
            return 3;
        }
    }

}
