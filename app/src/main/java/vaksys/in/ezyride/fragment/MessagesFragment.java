package vaksys.in.ezyride.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import vaksys.in.ezyride.R;
import vaksys.in.ezyride.adapter.CustomPagerAdapter;

/**
 * Created by dell980 on 4/21/2016.
 */
public class MessagesFragment extends Fragment implements LocationListener {

    GoogleMap mMap;
    Location location;

    int[] mResources = {
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile,
    };

    String[] km = {"105 KM Shared", "1067 KM Shared", "103 KM Shared", "199 KM Shared", "456 KM Shared"};
    String[] name = {"asd", "asd", "asd", "asd", "asd"};
    String[] pm = {"04:00 PM", "04:00 PM", "04:00 PM", "04:00 PM", "04:00 PM"};
    String[] rs = {"234", "467", "4356", "456", "78"};
    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.messages_fragment, container, false);


        mMap = ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getContext());

        // Showing status
        if (status == ConnectionResult.SUCCESS) {
            Toast.makeText(getActivity(), "Available", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(getActivity(), "Google Play Services not Available", Toast.LENGTH_SHORT).show();
        }

        final LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        //boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);


        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            return rootView;
        }
        mMap.setMyLocationEnabled(true);


        // Getting Current Location
        location = locationManager.getLastKnownLocation(provider);

        if (location != null) {
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(provider, 20000, 0, this);

        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {

                boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

                if (gps) {
                    Toast.makeText(getActivity()
                            , "setMyLocationEnabled Pressed"
                            , Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity()
                            , "setMyLocationEnabled not working"
                            , Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }

                return false;
            }
        });

        mCustomPagerAdapter = new CustomPagerAdapter(getActivity(), mResources, km, name, pm, rs);

        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mViewPager.setPageMargin(-400);
        mViewPager.setClipToPadding(false);
        mViewPager.setPadding(0, 0, 30, 0);
        //mViewPager.setPageMargin(3);
        mViewPager.setAdapter(mCustomPagerAdapter);

        return rootView;
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();

        // Getting longitude of the current location
        double longitude = location.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Showing the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        Toast.makeText(getActivity()
                , "Latitude:" + latitude + ", Longitude:" + longitude
                , Toast.LENGTH_SHORT).show();

        Log.e("MAP: ", "Latitude:" + latitude + ", Longitude:" + longitude);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
