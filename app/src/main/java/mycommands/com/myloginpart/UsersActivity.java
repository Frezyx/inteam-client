package mycommands.com.myloginpart;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Contacts;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.OkHttpClient;

public class UsersActivity extends AppCompatActivity {
    ListView listView;
    UserListAdapter adapter;
    ArrayList<Item> items = new ArrayList<Item>();
    final HttpHelper httpHelper = new HttpHelper();

    ImageButton to_users;
    ImageButton to_teams;
    ImageButton to_projects;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_list);
        Objects.requireNonNull(getSupportActionBar()).hide();

        to_users = findViewById(R.id.users_search_button);
        to_teams = findViewById(R.id.teams_search_button);
        to_projects = findViewById(R.id.projects_search_button);

        //заполнение ListView
        listView = findViewById(R.id.users_list);
        fillDataWithProjects();
        adapter = new UserListAdapter(this, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(UsersActivity.this, UserProfileActivity.class);
                i.putExtra("position", position);
                Item user = adapter.getUser(position);
                i.putExtra("username", user.name);
                i.putExtra("imageURL", user.image);
                i.putExtra("rating", user.rating);
                startActivity(i);
            }
        });
    }

    public void onClick_usersSearch(View view){
        items.clear();
        fillDataWithUsers();
        adapter.notifyDataSetChanged();

        to_projects.setImageResource(R.drawable.projects_search_button);
        to_teams.setImageResource(R.drawable.teams_button);
        to_users.setImageResource(R.drawable.users_active_button);
    }

    public void onClick_teamsSearch(View view){
        items.clear();
        fillDataWithTeams();
        adapter.notifyDataSetChanged();

        to_projects.setImageResource(R.drawable.projects_search_button);
        to_teams.setImageResource(R.drawable.teams_active_button);
        to_users.setImageResource(R.drawable.people_button);
    }

    public void onClick_projectsSearch(View view){
        items.clear();
        fillDataWithProjects();
        adapter.notifyDataSetChanged();

        to_projects.setImageResource(R.drawable.projects_active_button);
        to_teams.setImageResource(R.drawable.teams_button);
        to_users.setImageResource(R.drawable.people_button);
    }

    void fillDataWithProjects() {
        for(int i = 1; i < 12; i++){
            items.add(new Item(String.valueOf(i), R.drawable.user_avatar, 124));
        }
    }

    void fillDataWithUsers() {
        final ArrayList<Item>[] usersList = new ArrayList[]{new ArrayList<Item>()};

        //final ArrayList<Item>[] finalUsersList = new ArrayList[]{usersList};
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        usersList[0] = httpHelper.getJson(
                                "https://weinteam.000webhostapp.com/api/controllers/user/usergetall.php");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < usersList[0].size(); i++) {
            items.add(new Item(usersList[0].get(i).name, R.drawable.user_avatar, usersList[0].get(i).rating));
        }
        //items = usersList;
    }

    void fillDataWithTeams() {
        for(int i = 1; i < 12; i++){
            items.add(new Item(String.valueOf(i), R.drawable.teams_avatar, R.string.teams_decription));
        }
    }
}
