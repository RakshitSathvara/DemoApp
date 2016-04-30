package vaksys.in.ezyride.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import vaksys.in.ezyride.R;

public class SigninActivity extends Activity {

    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signup = (TextView) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SigninActivity.this,SignupActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
