package vaksys.in.ezyride.activity;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import vaksys.in.ezyride.R;
import vaksys.in.ezyride.fragment.AboutUsFragment;
import vaksys.in.ezyride.fragment.EditProfileFragment;
import vaksys.in.ezyride.fragment.FragmentDrawer;
import vaksys.in.ezyride.fragment.HowItWorksFragment;
import vaksys.in.ezyride.fragment.MessagesFragment;
import vaksys.in.ezyride.fragment.MyRideFragment;
import vaksys.in.ezyride.fragment.PrivacyPolicyFragment;
import vaksys.in.ezyride.fragment.SupportFragment;
import vaksys.in.ezyride.fragment.WalletFragment;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    Button offerRide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        offerRide = (Button) findViewById(R.id.offerRide);

        offerRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OfferRideActivity.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        //displayView(0);
    }

    /*private void displayView(int position) {
        switch (position) {
            case 0:
                Intent profileIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(profileIntent);
                break;
            case 1:
                break;
            default:
                break;
        }

        *//*Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new EditProfileFragment();
                title = getString(R.string.title_editprofile);
                break;
            case 1:
                fragment = new MyRideFragment();
                title = getString(R.string.title_myride);
                break;
            case 2:
                fragment = new WalletFragment();
                title = getString(R.string.title_wallet);
                break;
            case 3:
                fragment = new AboutUsFragment();
                title = getString(R.string.title_aboutus);
                break;
            case 4:
                fragment = new SupportFragment();
                title = getString(R.string.title_support);
                break;
            case 5:
                fragment = new HowItWorksFragment();
                title = getString(R.string.title_howitworks);
                break;
            case 6:
                fragment = new PrivacyPolicyFragment();
                title = getString(R.string.title_privacypolicy);
                break;
            case 7:
                fragment = new MessagesFragment();
                title = getString(R.string.title_messages);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }*//*
    }*/

    @Override
    public void onDrawerItemSelected(View view, int position) {
        //displayView(position);

        switch (position) {
            case 0:
                Intent profileIntent = new Intent(MainActivity.this, EditProfileActivity.class);
                startActivity(profileIntent);
                break;
            case 1:
                Intent myRideIntent = new Intent(MainActivity.this, MyRideActivity.class);
                startActivity(myRideIntent);
                break;
            case 2:
                Intent carDetail = new Intent(MainActivity.this, CarDetailActivity.class);
                startActivity(carDetail);
                break;
            case 3:
                Intent details = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(details);
                break;
            default:
                break;
        }
    }


}
