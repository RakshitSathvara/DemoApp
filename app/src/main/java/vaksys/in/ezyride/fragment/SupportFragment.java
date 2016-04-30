package vaksys.in.ezyride.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import vaksys.in.ezyride.R;
import vaksys.in.ezyride.adapter.ExpandedListItemView;
import vaksys.in.ezyride.util.ExpandableView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by dell980 on 4/21/2016.
 */
public class SupportFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    public static final String TAG = "DATE";
    android.app.FragmentManager mFragmentManager;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    private ExpandableView topExpandableView;
    private ExpandableView middleExpandableView;

    EditText etDate, etTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.support_fragment, container, false);


        topExpandableView = (ExpandableView) rootView.findViewById(R.id.activity_main_top_expandable_view);
        middleExpandableView = (ExpandableView) rootView.findViewById(R.id.activity_main_middle_expandable_view);

        createTopExpandableView();
        createMiddleExpandableView();

        mFragmentManager = getActivity().getFragmentManager();


        etDate = (EditText) rootView.findViewById(R.id.dateSupport);
        etDate.setTextIsSelectable(false);

        etTime = (EditText) rootView.findViewById(R.id.timeSupport);
        etTime.setTextIsSelectable(false);

        etDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    datePickerDialog.show(mFragmentManager, "DepartDate");
                }
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show(mFragmentManager, "DepartDate");
            }
        });

        etTime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    timePickerDialog.show(mFragmentManager, "Time");
                }
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show(mFragmentManager, "Time");
            }
        });

        Calendar calendar = Calendar.getInstance();
        datePickerDialog = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        timePickerDialog = TimePickerDialog.newInstance(this, Calendar.HOUR_OF_DAY, Calendar.MINUTE, false);
        // Inflate the layout for this fragment
        return rootView;
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
        etDate.setText(date);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String secondString = second < 10 ? "0" + second : "" + second;
        String time = hourString + "h" + minuteString + "m" + secondString + "s";
        etTime.setText(time);
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
        //topExpandableView.addContentView(expandableViewLevel1);
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
