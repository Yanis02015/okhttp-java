import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        RequestBody body = new FormBody.Builder()
                .add("email","TEST")
                .add("password","2000")
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:3000/api/auth/login")
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response);

        /*

        JSONObject obj = new JSONObject();
        obj.put("email","TEST");
        obj.put("password","2000");

        System.out.println(obj.toString());

        new OkHttpClient().newCall(new Request.Builder()
                        .addHeader("Content-Type", "application/json")
                        .url("http://localhost:3000/api/auth/login")
                        .post(RequestBody.create(
                                MediaType.parse("application/json; charset=utf-8"),
                                "{\"password\":\"2000\",\"email\":\"TEST\"}")
                        ).build())
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        System.out.println(response.body().string());
                    }
                }); */
    }
}