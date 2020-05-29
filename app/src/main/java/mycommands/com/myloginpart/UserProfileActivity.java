package mycommands.com.myloginpart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {
    //обозначение переданных полей
    int position;
    String userName;
    int image;
    double rating;

    //инициализация кнопок
    ImageView avatar;
    TextView username;
    TextView education;
    TextView oldness;
    TextView ratingField;
    TextView decription_about_yourself;
    TextView tags;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        recieveIntent();

        //инициализация элемнтов профиля
        avatar = findViewById(R.id.user_profile_avatar);
        username = findViewById(R.id.user_profile_name);
        ratingField = findViewById(R.id.rating);

        //заполнение
        avatar.setImageResource(image);
        username.setText(userName);
        ratingField.setText(String.valueOf(rating));
    }

    public void recieveIntent(){
        Intent i = getIntent();
        position = i.getIntExtra("psoition", 0);
        userName = i.getStringExtra("username");
        image = i.getIntExtra("imageURL", 0);
        rating = i.getDoubleExtra("rating", 0.0);

    }
}
