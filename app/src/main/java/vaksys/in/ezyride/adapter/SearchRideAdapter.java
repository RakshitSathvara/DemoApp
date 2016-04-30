package vaksys.in.ezyride.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vaksys.in.ezyride.R;

/**
 * Created by dell980 on 4/26/2016.
 */
public class SearchRideAdapter extends RecyclerView.Adapter<SearchRideAdapter.MyViewHolder> {

    private Context context;
    private String[] kmShared;
    private String[] userName;
    private String[] from;
    private String[] pm;
    private String[] seats;
    private String[] rs;

    public SearchRideAdapter(Context context, String[] kmShared, String[] userName, String[] from, String[] pm,
                             String[] seats, String[] rs) {
        this.context = context;
        this.kmShared = kmShared;
        this.userName = userName;
        this.from = from;
        this.pm = pm;
        this.seats = seats;
        this.rs = rs;
    }

    @Override
    public SearchRideAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_ride_row, parent, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(SearchRideAdapter.MyViewHolder holder, int position) {
        holder.kmShared.setText(kmShared[position]);
        holder.userName.setText(userName[position]);
        holder.from.setText(from[position]);
        holder.pm.setText(pm[position]);
        holder.seats.setText(seats[position]);
        holder.rs.setText(rs[position]);
    }

    @Override
    public int getItemCount() {
        return kmShared.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView kmShared, userName, from, pm, seats, rs;

        public MyViewHolder(View itemView) {
            super(itemView);

            kmShared = (TextView) itemView.findViewById(R.id.km_shared);
            userName = (TextView) itemView.findViewById(R.id.user);
            from = (TextView) itemView.findViewById(R.id.from);
            pm = (TextView) itemView.findViewById(R.id.fromTime);
            seats = (TextView) itemView.findViewById(R.id.seats);
            rs = (TextView) itemView.findViewById(R.id.money);
        }
    }
}
