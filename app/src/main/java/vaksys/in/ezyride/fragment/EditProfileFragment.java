package vaksys.in.ezyride.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vaksys.in.ezyride.R;
import vaksys.in.ezyride.activity.SearchRideActivity;
import vaksys.in.ezyride.activity.SigninActivity;

/**
 * Created by dell980 on 4/21/2016.
 */
public class EditProfileFragment extends Fragment {

    EditText from, to;
    Button btnSearch, btnOffer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.edit_profile_fragment, container, false);

        btnSearch = (Button) rootView.findViewById(R.id.btn_search);
        btnOffer = (Button) rootView.findViewById(R.id.offerRide);

        btnOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SearchRideActivity.class);
                startActivity(i);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.activity_signin);
                TextView signup;
                signup = (TextView) v.findViewById(R.id.signup);

                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog dialog1 = new Dialog(getActivity());
                        dialog1.setContentView(R.layout.signup);

                        dialog1.show();
                        dialog.cancel();
                    }
                });



                dialog.show();*/
                Intent i = new Intent(getActivity().getApplicationContext(), SigninActivity.class);
                startActivity(i);
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }
}
