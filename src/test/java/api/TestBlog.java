package api;

import org.junit.Test;

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
    public void testUserPostsExist(){
        System.out.println(from(sut.getPosts().asInputStream()).getList("title").get(0));
    }




}
