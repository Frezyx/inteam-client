package mycommands.com.myloginpart;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpHelper {
    private final OkHttpClient httpClient = new OkHttpClient();


    //POST - запрос
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void sendGET(String link) throws IOException {
        Request request = new Request.Builder()
                .url(link)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response headers
/*            Headers responseHeaders = response.headers();*/
/*            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }*/

            // Get response body
            //Тут получение тела ответа (Всё что нужно в нашем случае)
            System.out.println(response.body().string());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void sendPOST(String link) throws IOException {

        // form parameters
        RequestBody formBody = new FormBody.Builder()
                //Параментры для тела запроса
                .add("username", "abc")
                .add("password", "123")
                .add("custom", "secret")
                .build();

        Request request = new Request.Builder()
                .url(link)
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }

    }

    //Асинхронный get
    public String asyncGET(String link) throws IOException {
        final String[] respText = {""}; //Времеменное поля для проверки результата обработки
        Request request = new Request.Builder()
                .url(link)
                .build();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            httpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try (ResponseBody responseBody = response.body()) {
                        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                        // Get response headers
                        Headers responseHeaders = response.headers();
                        for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                        }

                        // Get response body
                        System.out.println(responseBody.string());
                        respText[0] = responseBody.string();
                    }
                }
            });
        }
        return  respText[0];
    }
}
