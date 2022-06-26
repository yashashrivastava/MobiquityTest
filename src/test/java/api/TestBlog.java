package api;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.is;

public class TestBlog {

    String endpointUrl = "https://my-json-server.typicode.com/typicode/demo";
    Blog sut = new Blog(endpointUrl);

    @Test
    public void testUserExist(){
        sut.getProfile().then()
                .body("name",is("Delphine"));
    }

    @Test
    public void testAllPostsExist(){
        from(sut.getPosts().asInputStream()).getList("title").containsAll(Arrays.asList("Post 1", "Post 2", "Post 3"));
    }

    @Test
    public void testIfCommentsContainsValidEmail(){
        String emailRegexPattern = "^(.+)@(\\S+)$";
        var pattern = Pattern.compile(emailRegexPattern);

        boolean allMatches = from(sut.getComments().asInputStream()).getList("body")
                .stream()
                .allMatch(x -> pattern.matcher(x.toString()).matches());

        assert(allMatches);
    }



}
