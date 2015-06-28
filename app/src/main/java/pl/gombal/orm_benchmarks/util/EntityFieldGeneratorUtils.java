package pl.gombal.orm_benchmarks.util;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class EntityFieldGeneratorUtils {

    private static final char[] SYMBOLS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public static final int DEFAULT_RANDOM_NUMBER_RANGE = 20000;

    protected int uniqueNumberRange = DEFAULT_RANDOM_NUMBER_RANGE;

    private LinkedList<Integer> uniqueList;


    private static EntityFieldGeneratorUtils instance;

    public static synchronized EntityFieldGeneratorUtils getInstance() {
        if (instance == null)
            throw new InstantiationError("Initialize first EntityFieldGeneratorUtils by call init()!");
        return instance;
    }

    public static void init() {
        init(DEFAULT_RANDOM_NUMBER_RANGE);
    }

    public static void init(int uniqueNumberRange) {
        instance = new EntityFieldGeneratorUtils(uniqueNumberRange);
        instance.uniqueNumberRange = uniqueNumberRange;
    }

    public static void reset() {
        instance = new EntityFieldGeneratorUtils(instance.uniqueNumberRange);
    }


    private EntityFieldGeneratorUtils(int uniqueNumberRange) {
        uniqueList = new LinkedList<>();
        for (int i = 0; i < uniqueNumberRange; i++)
            uniqueList.add(i);

        Collections.shuffle(uniqueList);
    }


    public static String getRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char c = SYMBOLS[random.nextInt(SYMBOLS.length)];
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public int getNextUniqueRandomInt() {
        if (uniqueList.isEmpty())
            throw new IllegalStateException("UniqueList is empty! Please reset EntityFieldGeneratorUtils or init with higher int parameter!");

        return uniqueList.pop();
    }

    public static int getRandomInt(int range) {
        return new Random().nextInt(range);
    }

    public static double getRandomDouble(int range) {
        Random random = new Random();
        int number = random.nextInt(range - 1);
        return number * random.nextDouble();
    }

}
