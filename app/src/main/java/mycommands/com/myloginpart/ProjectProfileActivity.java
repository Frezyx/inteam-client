package mycommands.com.myloginpart;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ProjectProfileActivity extends AppCompatActivity {
    int position;
    String name;
    int image;
    double rating;

    ImageView avatar;
    TextView projectName;
    TextView ratingField;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_profile);
        Objects.requireNonNull(getSupportActionBar()).hide();

        recieveIntent();

        avatar = findViewById(R.id.project_avatar);
        projectName = findViewById(R.id.project_name);
        ratingField = findViewById(R.id.views_count_text);

        avatar.setImageResource(image);
        projectName.setText(name);
        ratingField.setText(String.valueOf(rating));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void recieveIntent(){
        Intent i = getIntent();
        position = i.getIntExtra("position", 0);
        name = Objects.requireNonNull(i.getExtras().get("name")).toString();
        image = i.getIntExtra("imageURL", R.drawable.project_avatar);
        rating = i.getDoubleExtra("rating", 0.0);

    }
}
