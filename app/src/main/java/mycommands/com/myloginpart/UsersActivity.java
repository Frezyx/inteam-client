package mycommands.com.myloginpart;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<User> users = new ArrayList<User>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_list);
        listView = findViewById(R.id.users_list);
        fillData();
        UserListAdapter adapter = new UserListAdapter(this, users);
        listView.setAdapter(adapter);
    }

    void fillData() {
        for(int i = 1; i < 5; i++){
            users.add(new User("Пользователь " + i, R.drawable.user_avatar, 5.0 - i * 0.5));
        }
    }
}
