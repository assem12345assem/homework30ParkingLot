import java.util.Random;

public class RandomGenerator {
    public static int getRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
    public static String getThreeLetters() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 3;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString.toUpperCase();
    }
}
