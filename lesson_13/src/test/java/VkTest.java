import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class VkTest {

    @DataProvider
    public Object[][] postMessageTestSource() {
        return new Object[][]{{"message", "Test text"}};
    }

    @Test(dataProvider = "postMessageTestSource")
    public void postMessageTest(String parameter, String value) throws IOException, URISyntaxException, ParseException {
        VkMetods vkMetods = new VkMetods();
        URIBuilder builder = vkMetods.createPostUrl( parameter, value );
        String execute = EntityUtils.toString( vkMetods.execute( builder ).getEntity() );
        String expectedExecute = "\"post_id\":";
        Assert.assertEquals( execute.substring( 13, 23 ), expectedExecute );
    }

    @DataProvider
    public Object[][] editMessageTestSource() {
        return new Object[][]{{"message", "New test text"}};
    }

    @Test(dataProvider = "editMessageTestSource")
    public void editMessageTest(String parameter, String value, String postId) throws IOException, URISyntaxException, ParseException {
        VkMetods vkMetods = new VkMetods();
        URIBuilder builder = vkMetods.createEditUrl( parameter, value, postId);
        String execute = EntityUtils.toString( vkMetods.execute( builder ).getEntity() );
        String expectedExecute = "\"post_id\":";
        Assert.assertEquals( execute.substring( 13, 23 ), expectedExecute );
    }

    @Test()
    public void deleteMessageTest(String postId) throws IOException, URISyntaxException, ParseException {
        VkMetods vkMetods = new VkMetods();
        URIBuilder builder = vkMetods.createDeleteUrl(postId);
        String execute = EntityUtils.toString( vkMetods.execute( builder ).getEntity() );
        System.out.println( execute );
        String expectedExecute = "{\"response\":1}";
        Assert.assertEquals( execute, expectedExecute );
    }

}
