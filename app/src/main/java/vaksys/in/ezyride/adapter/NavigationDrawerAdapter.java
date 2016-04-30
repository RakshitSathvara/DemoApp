package vaksys.in.ezyride.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import vaksys.in.ezyride.R;
import vaksys.in.ezyride.pojo.NavDrawerItem;

/**
 * Created by dell980 on 4/21/2016.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private String[] titles;
    private int[] icons;

    public NavigationDrawerAdapter(Context context, String[] titles, int[] icons) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.titles = titles;
        this.icons = icons;

    }

    @Override
    public NavigationDrawerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NavigationDrawerAdapter.MyViewHolder holder, int position) {
        holder.title.setText(titles[position]);
        holder.icon.setImageResource(icons[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            icon = (ImageView) itemView.findViewById(R.id.icon);
        }
    }
}
