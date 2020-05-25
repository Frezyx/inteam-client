package mycommands.com.myloginpart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {
    int position;
    String userName;
    int image;
    double rating;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        recieveIntent();


    }

    public void recieveIntent(){
        Intent i = getIntent();
        position = i.getIntExtra("psoition", 0);
        userName = i.getStringExtra("username");
        image = i.getIntExtra("imageURL", 0);
        rating = i.getDoubleExtra("rating", 0.0);

    }
}
