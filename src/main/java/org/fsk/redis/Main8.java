package org.fsk.redis;


import redis.clients.jedis.*;
import redis.clients.jedis.search.FTCreateParams;
import redis.clients.jedis.search.IndexDataType;
import redis.clients.jedis.search.Query;
import redis.clients.jedis.search.schemafields.NumericField;
import redis.clients.jedis.search.schemafields.TagField;
import redis.clients.jedis.search.schemafields.TextField;


/**
 * Connect to Redis Cluster with JedisCluster
 */
public class Main10 {

    public static void main(String[] args) {

        JedisPooled jedis = new JedisPooled("localhost", 6379);


        Person person1 = new Person("Furkan", "Kulaksiz", "abc@gmail.com", 29, "Ankara");
        Person person2 = new Person("Ahmet", "Abc", "def@gmail.com", 30, "Istanbul");
        Person person3 = new Person("Mehmet", "Xyx", "klm@gmail.com", 30, "Ankara");


        jedis.ftCreate("idx:users",
                FTCreateParams.createParams()
                        .on(IndexDataType.JSON)
                        .addPrefix("user:"),
                TextField.of("$.name").as("name"),
                TagField.of("$.city").as("city"),
                NumericField.of("$.age").as("age")
        );

        jedis.jsonSetWithEscape("user:1", person1);
        jedis.jsonSetWithEscape("user:2", person2);
        jedis.jsonSetWithEscape("user:3", person3);

        var query = new Query("Paul @age:[30 40]");
        var result = jedis.ftSearch("idx:users", query).getDocuments();
        System.out.println(result);

    }

}
