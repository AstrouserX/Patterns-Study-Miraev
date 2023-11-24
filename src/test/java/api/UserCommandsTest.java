package api;

import Builder.requests.reqres.ReqresRequests;
import Builder.requests.reqres.User;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserCommandsTest {
    static String name;
    static String job;

    @BeforeClass
    public void precondition() {
        name = "david";
        job = "AQA";
    }

    @Test
    public void userCreateTest() {
        User user = ReqresRequests.createUser()
                .withName(name)
                .withJob(job)
                .sendCreateRequest()
                .GetSerializedObject()
                ;

        System.out.println(user.getId());

        //Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(dependsOnMethods = {"userCreateTest"})
    public void userUpdateTest() {
        ReqresRequests response = ReqresRequests.updateUser()
                .withJob("programmer")
                .withName("D")
                .sendUpdateRequest()
                ;

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    /**
    @Test(dependsOnMethods = {"userCreateTest"})
    public void userGetTest() {
        ReqresRequests response = ReqresRequests.getUser().sendGetRequest("2");

        Assert.assertEquals(response.getJson().get("data.first_name"), "Janet");
    }
    */
}
