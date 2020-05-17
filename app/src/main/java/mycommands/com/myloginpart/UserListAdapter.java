package mycommands.com.myloginpart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {
    private Context ctx;
    private LayoutInflater lInflater;
    private ArrayList<User> objects;

    UserListAdapter(Context context, ArrayList<User> users) {
        ctx = context;
        objects = users;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = new View(ctx);
        if(view == null){
            view = lInflater.inflate(R.layout.one_user_layout, parent, false);
        }
        User user = getUser(position);
        ((ImageView) view.findViewById(R.id.avatar)).setImageResource(user.image);
        ((TextView) view.findViewById(R.id.username)).setText(user.name);
        ((TextView) view.findViewById(R.id.rating)).setText((int) user.rating);
        ((ImageView) view.findViewById(R.id.rate_star)).setImageResource(R.drawable.rating_star);
        ((ImageView) view.findViewById(R.id.background)).setImageResource(R.drawable.user_backgroung);

        return view;
    }

    private User getUser(int position) {
        return ((User) getItem(position));
    }
}
