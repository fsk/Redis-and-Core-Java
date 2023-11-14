package org.fsk.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Main {
    public static void main(String[] args) {

        /**
         * REDIS'e key-value deger eklemek
         */
        JedisPool pool = new JedisPool("localhost", 6379);
        try(Jedis jedis = pool.getResource()) {
            jedis.set("name", "Furkan Sahin Kulaksiz");
            System.out.println(jedis.get("name"));
        }
    }
}