package org.fsk.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {

        /**
         * REDIS'e HashMap degeri eklemek ve okumak
         */

        JedisPool pool = new JedisPool("localhost", 6379);

        try(Jedis jedis = pool.getResource()) {
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("name", "Furkan");
            hashMap.put("surname", "Kulaksiz");
            hashMap.put("company", "BeeMe");
            jedis.hset("user-session:1234", hashMap);
            System.out.println(jedis.hgetAll("user-session:1234"));
        }

    }

}
