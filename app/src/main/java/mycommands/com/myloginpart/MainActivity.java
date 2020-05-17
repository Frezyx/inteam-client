package mycommands.com.myloginpart;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
Button toLogInButton;
String query = "https://weinteam.000webhostapp.com/api/controllers/user/userget.php";
HttpURLConnection connection = null;
EditText emailField;
EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toLogInButton = findViewById(R.id.to_logIn_layout);
        emailField = findViewById(R.id.EmailFieldInRegist);
        passwordField = findViewById(R.id.PasswordFieldInRegist);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick_Regist(View view) throws IOException {

        final TextView textView = (TextView) findViewById(R.id.test);
        final String[] text = {"Прив)"};
        new Thread(new Runnable() {
            @Override
            public void run() {
                text[0] = getHttpResponse().toString();
                /*URL url = null;
                try {
                    url = new URL(query);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                try {
                    assert url != null;
                    connection = (HttpURLConnection)url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    connection.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
                connection.setRequestProperty("Content-Type", "application/json; utf-8");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);

                String jsonInputString = "{\"email\": \"hui\", \"password\": \"pasasi\"}";

                try(OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

                /*try(BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    if (response != null) {
                        TextView textView = (TextView) findViewById(R.id.test);
                        textView.setText(response.toString());
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        }).start();

        textView.setText(text[0]);
        /*Intent i = new Intent(MainActivity.this, LogInActivity.class);
        startActivity(i);*/
    }

    public Object getHttpResponse() {
        OkHttpClient httpClient = new OkHttpClient();

        //String url = "http://4pda.ru";
        Request request = new Request.Builder()
                .url(query)
                .build();

        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();
        } catch (IOException e) {
            Log.e("SOS", "error in getting response get request okhttp");
        }
        return 0;
    }

    public void onClick_ToLogIn(View view){
        Intent i = new Intent(MainActivity.this, LogInActivity.class);
        startActivity(i);
    }
}
