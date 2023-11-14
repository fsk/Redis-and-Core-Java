package org.fsk.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;

import java.util.List;

public class Main3 {

    public static void main(String[] args) {

        JedisPooled jedis = new JedisPooled("localhost", 6379);

        jedis.lpush("queue#tasks", "firstTask");
        jedis.lpush("queue#tasks", "secondTask");

        jedis.lrange("queue#tasks", 0, -1).forEach(System.out::println);

    }

}
