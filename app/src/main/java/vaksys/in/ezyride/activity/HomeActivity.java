package vaksys.in.ezyride.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vaksys.in.ezyride.R;

public class HomeActivity extends AppCompatActivity {

    private TextView skip;
    private Button btnFbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnFbLogin = (Button) findViewById(R.id.btnFbLogin);
        skip = (TextView) findViewById(R.id.skip);

        btnFbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SearchRideActivity.class));
            }
        });


    }
}
