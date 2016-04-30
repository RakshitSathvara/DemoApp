package vaksys.in.ezyride.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import vaksys.in.ezyride.R;
import vaksys.in.ezyride.adapter.ExpandedListItemView;
import vaksys.in.ezyride.util.ExpandableView;

public class EditProfileActivity extends AppCompatActivity {

    ImageView composeMail;

    private Toolbar toolbar;


    private ExpandableView topExpandableView;
    //private ExpandableView middleExpandableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        setTitle("Profile");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        topExpandableView = (ExpandableView) findViewById(R.id.activity_main_top_expandable_view11111);
       // middleExpandableView = (ExpandableView) findViewById(R.id.activity_main_top_expandable_view1);

        createTopExpandableView();
        //createMiddleExpandableView();

        composeMail = (ImageView) findViewById(R.id.composeMail);

        composeMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.compose_mail);
                //dialog.setTitle("Title...");


                dialog.show();
            }
        });
    }

    public void addContentView(ExpandableView view, String stringList, boolean showCheckbox) {

        ExpandedListItemView itemView = new ExpandedListItemView(this);
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

    /*private void createMiddleExpandableView() {
        String[] androidVersionNameList = getResources().getStringArray(R.array.android_version_names);

        middleExpandableView.fillData(R.drawable.dot, getString(R.string.android_codes), false);
        //middleExpandableView.setVisibleLayoutHeight(getResources().getDimensionPixelSize(R.dimen.new_visible_height));
        addContentView(middleExpandableView, "Audi A7", true);
        addContentView(middleExpandableView, "Haundai", true);
        //addContentView(middleExpandableView, androidVersionNameList, false);
    }*/
}
