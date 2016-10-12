import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import java.util.Map;

/**
 * Created by C_Train on 12/10/2016.
 */
public class sampleClient {

    CouchDbClient dbClient = new CouchDbClient();

    CouchDbClient dbClient1 = new CouchDbClient("couchdb.properties");

    CouchDbClient dbClient2 = new CouchDbClient("db-name", true, "http", "127.0.0.1", 5984, null, null);

    CouchDbProperties properties = new CouchDbProperties()
            .setDbName("db-name")
            .setCreateDbIfNotExist(true)
            .setProtocol("https")
            .setHost("example.com")
            .setPort(443)
            .setUsername("username")
            .setPassword("secret")
            .setMaxConnections(100)
            .setConnectionTimeout(0);

    CouchDbClient dbClient3 = new CouchDbClient(properties);


//    dbClient.shutdown();
//    dbClient1.shu

    Map<String, Object> map = new HashMap<>();

    map.put("_id", "doc-id");
    map.put("title", "value");
    dbClient.save(map);
    JsonObject json = new JsonObject();
    json.addProperty("_id", "doc-id");
    json.add("array", new JsonArray());
    dbClient.save(json);
    String jsonstr = "{\"title\":\"val\"}";
    JsonObject jsonobj = dbClient.getGson().fromJson(jsonstr, JsonObject.class);
    dbClient.save(jsonobj);
}
