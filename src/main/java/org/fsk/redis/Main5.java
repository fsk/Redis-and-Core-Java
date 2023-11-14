package org.fsk.redis;

import redis.clients.jedis.JedisPooled;

public class Main5 {

    public static void main(String[] args) {

        JedisPooled jedisPooled = new JedisPooled("localhost", 6379);

        String jsonDocument = "{ \"name\": \"John\", \"age\": 30 }";
        jedisPooled.jsonSetWithEscape("user:123", jsonDocument);

        Object o = jedisPooled.jsonGet("user:123");
        System.out.println(o);
    }

}
