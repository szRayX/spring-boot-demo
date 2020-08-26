package com.ray.frame.util;

/**
 * SFIDGenerator
 *
 * @author xuel
 * @create 2020/8/25 14:01
 * @since 0.0.1
 */
public class SFIDGenerator {
    private static final long startTime = 7000000000000L;
    private static final int maxSequence = 99;
    private static int workerId = 0;
    private static int sequence = 1;
    private static long lastTimestamp = -1L;

    public SFIDGenerator() {
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; ++i) {
            long id = nextId();
            System.out.println(id);
        }

    }

    public static synchronized long nextId() {
        long timestamp = currentTime();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        } else {
            if (lastTimestamp == timestamp) {
                ++sequence;
                if (sequence > 99) {
                    timestamp = blockTillNextMillis(lastTimestamp);
                    sequence = 1;
                }
            } else {
                sequence = 1;
            }

            lastTimestamp = timestamp;
            return Long.parseLong(timestamp + 7000000000000L + "" + workerId + String.format("%02d", sequence));
        }
    }

    public static void setWorkerId(int workerId) {
        workerId = workerId;
    }

    protected static long blockTillNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = currentTime(); timestamp <= lastTimestamp; timestamp = currentTime()) {
            ;
        }

        return timestamp;
    }

    protected static long currentTime() {
        return System.currentTimeMillis();
    }
}
