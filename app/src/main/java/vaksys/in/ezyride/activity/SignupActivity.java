package vaksys.in.ezyride.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import vaksys.in.ezyride.R;

/**
 * Created by dell980 on 4/25/2016.
 */
public class SignupActivity extends Activity {

    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, ConfirmActivity.class));
                finish();
            }
        });
    }
}
