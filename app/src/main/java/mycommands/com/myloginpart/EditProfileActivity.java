package mycommands.com.myloginpart;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class EditProfileActivity extends AppCompatActivity {
    ImageButton add_avatar;

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
        Intent i = new Intent(EditProfileActivity.this, UsersActivity.class);
        startActivity(i);
    }
}
