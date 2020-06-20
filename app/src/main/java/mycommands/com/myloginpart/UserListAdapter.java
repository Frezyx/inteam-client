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
    private ArrayList<Item> objects;

    UserListAdapter(Context context, ArrayList<Item> users) {
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
        View view = convertView;
        if(view == null){
            view = lInflater.inflate(R.layout.one_user_layout, parent, false);
        }
        Item user = getUser(position);
            if(user != null) {
                ((ImageView) view.findViewById(R.id.avatar)).setImageResource(user.image);
                ((TextView) view.findViewById(R.id.username)).setText(user.name);
                ((TextView) view.findViewById(R.id.rating)).setText(String.valueOf(user.rating));
                //((ImageView) view.findViewById(R.id.rate_star)).setImageResource(R.drawable.rating_star);
                //((ImageView) view.findViewById(R.id.background)).setImageResource(R.drawable.user_backgroung);
            }

        return view;
    }

    public Item getUser(int position) {
        return ((Item) getItem(position));
    }
}
