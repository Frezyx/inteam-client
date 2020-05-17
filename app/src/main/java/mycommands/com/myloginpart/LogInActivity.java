package mycommands.com.myloginpart;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {
    Button toRegistButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        toRegistButton = findViewById(R.id.to_regist_layout);
    }

    public void onClick_ToRegist(View view)
    {
        this.finish();
    }

    public void onClick_logIn(View view)
    {
        Intent i = new Intent(LogInActivity.this, UsersActivity.class);
        startActivity(i);
    }
}
