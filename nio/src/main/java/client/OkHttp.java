package client;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * 使用 OkHttp 访问 HttpServer01
 *
 * @author luchao
 * @date 2021/12/24
 */
public class OkHttp {

    public static void main(String[] args) throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        String url = "http://localhost:8801";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(Objects.requireNonNull(response.body()).string());
    }

}
