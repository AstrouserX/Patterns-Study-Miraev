package Builder.requests.reqres;

import Builder.requests.Request;
import org.json.JSONObject;

public class ReqresRequests extends Request {
    ReqresRequests() {}

    private JSONObject requestParams;

    private String endpointUrl = "/users";

    public static CreateUser createUser() {
        return new ReqresRequests().new CreateUser();
    }

    public static UpdateUser updateUser() {
        return new ReqresRequests().new UpdateUser();
    }

    public static GetUser getUser() {
        return new ReqresRequests().new GetUser();
    }

    public class CreateUser{

        public CreateUser() {
            spec = restAssuredRequest();
            requestParams = new JSONObject();
        }

        public CreateUser withName(String name) {
            requestParams.put("name", name);
            return this;
        }

        public CreateUser withJob(String job) {
            requestParams.put("job", job);
            return this;
        }

        public void sendPost() {
            resp = spec
                    .body(requestParams.toString())
                    .baseUri(baseUrl)
                    .post(endpointUrl)
            ;

        }

        public ReqresRequests sendCreateRequest() {
            sendPost();
            return ReqresRequests.this;
        }
    }

    public class UpdateUser{

        public UpdateUser() {
            spec = restAssuredRequest();
            requestParams = new JSONObject();
        }

        public UpdateUser withName(String name) {
            requestParams.put("name", name);
            return this;
        }

        public UpdateUser withJob(String job) {
            requestParams.put("job", job);
            return this;
        }

        public void sendPut() {
            resp = spec
                    .body(requestParams.toString())
                    .baseUri(baseUrl)
                    .put(endpointUrl + "/2")
            ;
        }

        public ReqresRequests sendUpdateRequest() {
            sendPut();
            return ReqresRequests.this;
        }
    }

    public class GetUser{

        public GetUser() {
            spec = restAssuredRequest();
        }

        public void sendGet(String id) {
            resp = spec
                    .baseUri(baseUrl)
                    .get(endpointUrl + "/" + id)
            ;
        }

        public ReqresRequests sendGetRequest(String userId) {
            sendGet(userId);
            return ReqresRequests.this;
        }
    }
}
