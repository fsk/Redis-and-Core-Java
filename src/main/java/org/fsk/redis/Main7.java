package org.fsk.redis;

import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.search.Document;
import redis.clients.jedis.search.Query;
import redis.clients.jedis.search.aggr.AggregationBuilder;
import redis.clients.jedis.search.aggr.AggregationResult;
import redis.clients.jedis.search.aggr.Reducers;

import java.util.List;

public class Main7 {

    /**
     * Main6 ' daki eklenen idx'lerin uygulanmasi
     */
    public static void main(String[] args) {

        JedisPooled jedisPooled = new JedisPooled("localhost", 6379);

        /*Query query1 = new Query("*");
        List<Document> result1 = jedisPooled.ftSearch("idx:bicycle", query1).getDocuments();
        System.out.println("Documents found:" + result1.size());*/

        //Query query2 = new Query("@model:Jigger");
        /*List<Document> result2 = jedisPooled.ftSearch("idx:bicycle", query2).getDocuments();
        System.out.println(result2);*/

        /*Query price = query2.returnFields("price");
        List<Document> documents = jedisPooled.ftSearch("idx:bicycle", price).getDocuments();
        System.out.println(documents);*/

        /*Query query4 = new Query("@price:[500 1000]");
        List<Document> result4 = jedisPooled.ftSearch("idx:bicycle", query4).getDocuments();
        System.out.println(result4);*/

        AggregationBuilder ab = new AggregationBuilder("*").groupBy("@condition",
                Reducers.count().as("count"));
        AggregationResult ar = jedisPooled.ftAggregate("idx:bicycle", ab);
        for (int i = 0; i < ar.getTotalResults(); i++) {
            System.out.println(ar.getRow(i).getString("condition") + " - "
                    + ar.getRow(i).getString("count"));
        }
    }

}
