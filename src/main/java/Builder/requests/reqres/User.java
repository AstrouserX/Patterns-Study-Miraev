package Builder.requests.reqres;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("id")
    private String id;

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }
}
