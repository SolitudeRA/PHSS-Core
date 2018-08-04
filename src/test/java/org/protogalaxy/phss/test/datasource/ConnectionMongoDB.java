package org.protogalaxy.phss.test.datasource;

import com.mongodb.MongoClient;
import org.junit.Test;


public class ConnectionMongoDB {
    @Test
    public void connection() {
        MongoClient mongoClient = new MongoClient("localhost");
        System.out.println(mongoClient.getDatabase("protogalaxy").listCollectionNames().first());
    }

    @Test
    public void operation(){

    }
}
