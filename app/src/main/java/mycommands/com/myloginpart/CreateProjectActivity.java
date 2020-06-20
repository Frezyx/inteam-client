package mycommands.com.myloginpart;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CreateProjectActivity extends AppCompatActivity {
    ImageButton ITtypeButton;
    ImageButton SocialtypeButton;
    ImageButton CreativetypeButton;
    ImageButton SportstypeButton;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_project_layout);
        Objects.requireNonNull(getSupportActionBar()).hide();

        ITtypeButton = findViewById(R.id.it_point_button);
        SocialtypeButton = findViewById(R.id.social_point_button);
        CreativetypeButton = findViewById(R.id.creative_point_button);
        SportstypeButton = findViewById(R.id.sports_point_button);
    }

    public void onClick_ITtype(View view){
        ITtypeButton.setImageResource(R.drawable.on_point_types);
        SocialtypeButton.setImageResource(R.drawable.off_point_types);
        CreativetypeButton.setImageResource(R.drawable.off_point_types);
        SportstypeButton.setImageResource(R.drawable.off_point_types);
    }

    public void onClick_Socialtype(View view){
        ITtypeButton.setImageResource(R.drawable.off_point_types);
        SocialtypeButton.setImageResource(R.drawable.on_point_types);
        CreativetypeButton.setImageResource(R.drawable.off_point_types);
        SportstypeButton.setImageResource(R.drawable.off_point_types);
    }

    public void onClick_Creativetype(View view){
        ITtypeButton.setImageResource(R.drawable.off_point_types);
        SocialtypeButton.setImageResource(R.drawable.off_point_types);
        CreativetypeButton.setImageResource(R.drawable.on_point_types);
        SportstypeButton.setImageResource(R.drawable.off_point_types);
    }

    public void onClick_Sportstype(View view){
        ITtypeButton.setImageResource(R.drawable.off_point_types);
        SocialtypeButton.setImageResource(R.drawable.off_point_types);
        CreativetypeButton.setImageResource(R.drawable.off_point_types);
        SportstypeButton.setImageResource(R.drawable.on_point_types);
    }
}
