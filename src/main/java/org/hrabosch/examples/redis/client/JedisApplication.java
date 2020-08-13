package org.hrabosch.examples.redis.client;

import redis.clients.jedis.Jedis;

import java.util.Scanner;

public class JedisApplication {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        do {
            System.out.print("1 - Insert ; 2 - Get ; 0 - Exit : ");

            selection = scanner.nextInt();

            switch (selection) {
            case 1:
                createInsert(scanner, jedis);
                break;
            case 2:
                callGet(scanner, jedis);
                break;
            default:

            }
        } while (selection != 0);

    }

    private static void callGet(Scanner scanner, Jedis jedis) {
        System.out.println("Insert key to get: ");
        String key = scanner.next();
        System.out.println("====================");
        System.out.println("Result:");
        System.out.println(jedis.get(key));
        System.out.println("====================");

    }

    private static void createInsert(Scanner scanner, Jedis jedis) {
        System.out.println("Insert Key: ");
        String key = scanner.next();
        System.out.println("Insert Value: ");
        String value = scanner.next();
        System.out.println("====================");
        System.out.println(jedis.set(key, value));
        System.out.println("====================");
    }

}
