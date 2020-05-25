package mycommands.com.myloginpart;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class LogInActivity extends AppCompatActivity {
    Button toRegistButton;
    EditText emailField;
    EditText passwordField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        toRegistButton = findViewById(R.id.to_regist_layout);
        emailField = findViewById(R.id.EmailFieldInLogIn);
        passwordField = findViewById(R.id.PasswordFieldInLogIn);
    }

    public void onClick_ToRegist(View view)
    {
        this.finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick_logIn(View view) throws IOException {
        final HttpHelper httpHelper = new HttpHelper();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //httpHelper.sendGET("https://weinteam.000webhostapp.com/api/controllers/user/userget.php");
                    httpHelper.sendPOST(
                            "https://weinteam.000webhostapp.com/api/controllers/user/userget.php",
                            String.valueOf(emailField.getText()),
                            String.valueOf(passwordField.getText()));
                    /*                  httpHelper.asyncGET();*/
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Intent i = new Intent(LogInActivity.this, UsersActivity.class);
        startActivity(i);
    }
}
