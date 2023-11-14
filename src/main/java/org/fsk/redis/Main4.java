package org.fsk.redis;

import redis.clients.jedis.JedisPooled;

import java.util.Set;

public class Main4 {

    public static void main(String[] args) {

        JedisPooled jedis = new JedisPooled("localhost", 6379);

        jedis.sadd("nicknames", "nickname#1");
        jedis.sadd("nicknames", "nickname#2");
        jedis.sadd("nicknames", "nickname#1");

        Set<String> nicknames = jedis.smembers("nicknames");
        boolean exists = jedis.sismember("nicknames", "nickname#1");

    }

}
