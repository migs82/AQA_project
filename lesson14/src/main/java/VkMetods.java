import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

public class VkMetods {
    private static final Logger logger = Logger.getLogger(VkMetods.class);
    private URIBuilder builder;

    public URIBuilder createBasicUrl(String methodName) throws IOException, URISyntaxException {
        String urlName = String.format( "https://api.vk.com/method/wall.%s?", methodName );
        builder = new URIBuilder( urlName );
        builder.setParameter( "access_token", "c9f49b55d850c533f262e3c9728099dcc49c9d5426761f9449a5c184e04d64e2fd742ce8037d9236f786c" )
                .setParameter( "owner_id", "8045198" )
                .setParameter( "v", "5.101" );
        logger.info("Basik URL created.");
        return builder;
    }

    public URIBuilder createGetByIdUrl(String methodName,String postId) throws IOException, URISyntaxException {
        String urlName = String.format( "https://api.vk.com/method/wall.%s?", methodName );
        String posts = String.format( "8045198_%s", postId );
        builder = new URIBuilder( urlName );
        builder.setParameter( "access_token", "c9f49b55d850c533f262e3c9728099dcc49c9d5426761f9449a5c184e04d64e2fd742ce8037d9236f786c" )
                .setParameter( "posts", posts )
                .setParameter( "v", "5.101" );
        logger.info("Post URL created.");
        return builder;
    }

    public URIBuilder createPostUrl(String parameter, String value) throws IOException, URISyntaxException {
        URIBuilder builder = createBasicUrl( "post" );
        builder.setParameter( parameter, value );
        return builder;
    }

    public URIBuilder createEditUrl(String parameter, String value, String postId) throws IOException, URISyntaxException {
        URIBuilder builder = createBasicUrl( "edit" );
        builder.setParameter( parameter, value );
        builder.setParameter( "post_id", postId );
        return builder;
    }

    public URIBuilder createDeleteUrl(String postId) throws IOException, URISyntaxException {
        URIBuilder builder = createBasicUrl( "delete" );
        builder.setParameter( "post_id", postId );
        return builder;
    }

    public HttpResponse execute(URIBuilder builder) throws IOException, URISyntaxException {
        HttpGet request = new HttpGet( builder.build() );
        HttpClient client = HttpClientBuilder.create().build();
        return client.execute( request );
    }

}
