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

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
Button toLogInButton;
String query = "https://weinteam.000webhostapp.com/api/controllers/user/userget.php";
HttpURLConnection connection = null;
EditText emailField;
EditText passwordField;
EditText repeatPassField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toLogInButton = findViewById(R.id.to_logIn_layout);

        //инициализация полей ввода
        emailField = findViewById(R.id.EmailFieldInLogIn);
        passwordField = findViewById(R.id.PasswordFieldInLogIn);
        repeatPassField = findViewById(R.id.RepeatFieldInRegist);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick_Regist(View view) throws IOException, JSONException {
        final HttpHelper httpHelper = new HttpHelper();
        TextView textView = (TextView) findViewById(R.id.test);
        //final String email = String.valueOf(emailField.getText());
        //final String pass = String.valueOf(passwordField.getText());
        final String[] text = {"Прив)"};
        final String qq;

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //httpHelper.sendGET("https://weinteam.000webhostapp.com/api/controllers/user/userget.php");
                    if(emailField.getText() != null && passwordField.getText() != null) {

                        if(passwordField.getText() == repeatPassField.getText())
                         httpHelper.sendPOST(
                                "https://weinteam.000webhostapp.com/api/controllers/user/userreg.php",
                                 String.valueOf(emailField.getText()),
                                 String.valueOf(passwordField.getText()));
                        else Log.e("Error with match", "Don't match passwords");
                        /*                  httpHelper.asyncGET();*/
                    }
                    else Log.e("Wrong format", "Didn't enter anything");
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                text[0] = getHttpResponse().toString();

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

        //textView.setText(js[0].getString("email"));
    }

    public Object getHttpResponse() {
        OkHttpClient httpClient = new OkHttpClient();

        //String url = "http://4pda.ru";
        Request request = new Request.Builder()
                .url(query)
                .build();

        Response response = null;
        try {
            System.out.println(request.url().toString());

            response = httpClient.newCall(request).execute();
            System.out.println(response);
            System.out.println(response.isSuccessful());
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
