package mycommands.com.myloginpart;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Objects;

public class EditProfileActivity extends AppCompatActivity {
    ImageButton add_avatar;
    EditText name;
    EditText surname;
    EditText city;
    EditText edu;
    EditText oldness;
    EditText about_yourself;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_layout);
        Objects.requireNonNull(getSupportActionBar()).hide();

        add_avatar = findViewById(R.id.edit_photo_button);
        add_avatar.setImageResource(R.drawable.add_photo_button);
    }

    public void onClick_createProfile(View view){
        /*final HttpHelper httpHelper = new HttpHelper();
        TextView textView = (TextView) findViewById(R.id.test);
        final String[] text = {"Прив)"};
        final String qq;

        new Thread(new Runnable() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                try {
                        httpHelper.sendPOST(
                                "https://weinteam.000webhostapp.com/api/controllers/user/userreg.php",
                                String.valueOf(emailField.getText()),
                                String.valueOf(passwordField.getText()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

        Intent i = new Intent(EditProfileActivity.this, UsersActivity.class);
        startActivity(i);
    }
}
