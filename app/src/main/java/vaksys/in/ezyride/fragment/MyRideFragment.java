package vaksys.in.ezyride.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import vaksys.in.ezyride.R;
import vaksys.in.ezyride.adapter.ExpandedListItemView;
import vaksys.in.ezyride.util.ExpandableView;

/**
 * Created by dell980 on 4/21/2016.
 */
public class MyRideFragment extends Fragment {

    ImageView composeMail;

    private ExpandableView topExpandableView;
    private ExpandableView middleExpandableView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_ride_fragment, container, false);

        topExpandableView = (ExpandableView) rootView.findViewById(R.id.activity_main_top_expandable_view);
        middleExpandableView = (ExpandableView) rootView.findViewById(R.id.activity_main_top_expandable_view1);

        createTopExpandableView();
        createMiddleExpandableView();

        composeMail = (ImageView) rootView.findViewById(R.id.composeMail);

        composeMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.compose_mail);
                //dialog.setTitle("Title...");


                dialog.show();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    public void addContentView(ExpandableView view, String stringList, boolean showCheckbox) {

        ExpandedListItemView itemView = new ExpandedListItemView(getActivity());
        itemView.setText(stringList, showCheckbox);
        view.addContentView(itemView);

    }


    private void createTopExpandableView() {
        String[] androidVersionNameList = getResources().getStringArray(R.array.android_version_names);

        topExpandableView.fillData(R.drawable.dot, getString(R.string.android_names), false);
        addContentView(topExpandableView, "Audi A7", true);
        addContentView(topExpandableView, "Haundai", true);
//        topExpandableView.addContentView(expandableViewLevel1);
    }

    private void createMiddleExpandableView() {
        String[] androidVersionNameList = getResources().getStringArray(R.array.android_version_names);

        middleExpandableView.fillData(R.drawable.dot, getString(R.string.android_codes), false);
        //middleExpandableView.setVisibleLayoutHeight(getResources().getDimensionPixelSize(R.dimen.new_visible_height));
        addContentView(middleExpandableView, "Audi A7", true);
        addContentView(middleExpandableView, "Haundai", true);
        //addContentView(middleExpandableView, androidVersionNameList, false);
    }
}
