package vaksys.in.ezyride.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vaksys.in.ezyride.R;
import vaksys.in.ezyride.adapter.SearchRideAdapter;
import vaksys.in.ezyride.util.DividerItemDecoration;

/**
 * Created by dell980 on 4/26/2016.
 */
public class DateOne extends Fragment {

    private String[] kmShared = {"105 KM shared", "106 KM shared", "107 KM shared", "107 KM shared", "167 KM shared", "187 KM shared"};
    private String[] userName = {"sdaf", "sdaf", "sdaf", "sdaf", "sdaf", "sdaf"};
    private String[] from = {"From Chennai to Bangalore", "From Chennai to Bangalore", "From Chennai to Bangalore",
            "From Chennai to Bangalore", "From Chennai to Bangalore", "From Chennai to Bangalore"};
    private String[] pm = {"04:00 PM", "04:00 PM", "04:00 PM", "04:00 PM", "04:00 PM", "04:00 PM"};
    private String[] seats = {"3 Seats", "4 Seats", "3 Seats", "4 Seats", "8 Seats", "6 Seats"};
    private String[] rs = {"900", "467", "4897", "9834", "7848", "7848"};

    private RecyclerView recyclerView;
    private SearchRideAdapter searchRideAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.date_one_fragment, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        searchRideAdapter = new SearchRideAdapter(getActivity(), kmShared, userName, from, pm, seats, rs);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(searchRideAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }
}
