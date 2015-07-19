package pl.gombal.orm_benchmarks.io.util;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class EntityFieldGeneratorUtils {

    private static final char[] SYMBOLS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public static final int RAW_SQL_ENTITY_FIELD_GENERATOR_ID = 100;
    public static final int GREEN_DAO_ENTITY_FIELD_GENERATOR_ID = 200;
    public static final int ORM_LITE_ENTITY_FIELD_GENERATOR_ID = 300;
    public static final int ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID = 400;
    public static final int SUGAR_ORM_ENTITY_FIELD_GENERATOR_ID = 500;

    public static final int DEFAULT_RANDOM_NUMBER_RANGE = 100000;

    protected int uniqueNumberRange = DEFAULT_RANDOM_NUMBER_RANGE;

    private LinkedList<Integer> uniqueList;


    private static Map<Integer, EntityFieldGeneratorUtils> instances = new HashMap<>();

    public static synchronized EntityFieldGeneratorUtils getInstance(int instanceID) {
        return getInstance(instanceID, DEFAULT_RANDOM_NUMBER_RANGE);
    }

    public static synchronized EntityFieldGeneratorUtils getInstance(int instanceID, int uniqueNumberRange) {
        EntityFieldGeneratorUtils generatorUtils = instances.get(instanceID);
        if (generatorUtils == null) {
            generatorUtils = new EntityFieldGeneratorUtils(uniqueNumberRange);
            instances.put(instanceID, generatorUtils);
        }
        return generatorUtils;
    }

    public static void reset(int instanceID) {
        EntityFieldGeneratorUtils generatorUtils = instances.get(instanceID);
        if (generatorUtils == null)
            throw new InstantiationError("Can not reset EntityFieldGeneratorUtils instance with id = " + instanceID);
        generatorUtils = new EntityFieldGeneratorUtils(generatorUtils.uniqueNumberRange);
        instances.put(instanceID, generatorUtils);
    }

    public static void clearAllInstances() {
        instances.clear();
    }


    private EntityFieldGeneratorUtils(int uniqueNumberRange) {
        this.uniqueNumberRange = uniqueNumberRange;
        uniqueList = new LinkedList<>();
        for (int i = 0; i < uniqueNumberRange; i++)
            uniqueList.add(i);

        Collections.shuffle(uniqueList);
    }

    public int getUniqueNumberRange() {
        return uniqueNumberRange;
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
