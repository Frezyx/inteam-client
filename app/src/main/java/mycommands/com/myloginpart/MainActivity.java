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
import java.util.Objects;

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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        toLogInButton = findViewById(R.id.to_logIn_layout);

        //инициализация полей ввода
        emailField = findViewById(R.id.EmailFieldInLogIn);
        passwordField = findViewById(R.id.PasswordFieldInLogIn);
        repeatPassField = findViewById(R.id.RepeatFieldInRegist);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick_Regist(View view) throws IOException, JSONException {
        final HttpHelper httpHelper = new HttpHelper();
        final String[] text = {"Прив)"};
        final String qq;

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    if(emailField.getText() != null && passwordField.getText() != null) {

                        String firstPass = String.valueOf(passwordField.getText());
                        String secPass = String.valueOf(repeatPassField.getText());

                        if(firstPass.equals(secPass)){
                            httpHelper.sendPOST(
                                    "https://weinteam.000webhostapp.com/api/controllers/user/userreg.php",
                                    String.valueOf(emailField.getText()),
                                    String.valueOf(passwordField.getText()));
                        } else Log.e("Error with match", "Don't match passwords");
                    }
                    else Log.e("Wrong format", "Didn't enter anything");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Intent i = new Intent(MainActivity.this, EditProfileActivity.class);
        startActivity(i);

    }

    public Object getHttpResponse() {
        OkHttpClient httpClient = new OkHttpClient();
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
        //Intent i = new Intent(MainActivity.this, LogInActivity.class);
        Intent i = new Intent(MainActivity.this, CreateProjectActivity.class);
        startActivity(i);
    }
}
