package com.team8303.smartbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EditPasscodeActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    TextView passcodeNameText;
    EditText name;
    EditText number;
    Button generateButton;
    TextView type;
    Spinner dropDownMenu;
    TextView description;
    TextView notifyTitlePO, notifyDescriptionPO;
    Switch setNotificationsPO;
    TextView notifyTitleTR, notifyDescriptionTR;
    Switch setNotificationsTR;
    CheckBox sun, mon, tues, wed, thurs, fri, sat;
    Button saveButton;
    EditText setDate1, setDate2, setTime1, setTime2;
    TextView startDate, endDate, startTime, endTime;
    RadioButton allDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_passcode);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        passcodeNameText = findViewById(R.id.passcodeNameText);
        name = findViewById(R.id.passcodeName);
        number = findViewById(R.id.passcodeNumber);
        generateButton = findViewById(R.id.generateButton);
        type = findViewById(R.id.passcodeType);
        dropDownMenu = findViewById(R.id.dropDownMenu);
        description = findViewById(R.id.passcodeDescription);
        notifyTitlePO = findViewById(R.id.notifications1);
        notifyDescriptionPO = findViewById(R.id.notificationDescription1);
        setNotificationsPO = findViewById(R.id.notificationSwitch1);
        notifyTitleTR = findViewById(R.id.notifications2);
        notifyDescriptionTR = findViewById(R.id.notificationDescription2);
        setNotificationsTR = findViewById(R.id.notificationSwitch2);
        sun = findViewById(R.id.sun);
        mon = findViewById(R.id.mon);
        tues = findViewById(R.id.tues);
        wed = findViewById(R.id.wed);
        thurs = findViewById(R.id.thur);
        fri = findViewById(R.id.fri);
        sat = findViewById(R.id.sat);
        allDay = findViewById(R.id.daySwitch);
        setDate1 = findViewById(R.id.calendar1);
        setDate2 = findViewById(R.id.calendar2);
        setTime1 = findViewById(R.id.time1);
        setTime2 = findViewById(R.id.time2);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        startTime = findViewById(R.id.startTime);
        endTime = findViewById(R.id.endTime);
        saveButton = findViewById(R.id.saveButton);

        dropDownMenu.setOnItemSelectedListener(this);

        List<String> passcodeTypes = new ArrayList<>();
        passcodeTypes.add("Permanent");
        passcodeTypes.add("Temporary");
        passcodeTypes.add("Repeat");
        passcodeTypes.add("One-time");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, passcodeTypes);


        dropDownMenu.setAdapter(adapter);
        dropDownMenu.setSelection(0);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randcode = new Random().nextInt(999999);
                String str = String.format("%06d", randcode);
                number.setText(str);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add passcode to firebase
                Intent intent = new Intent(EditPasscodeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int index, long id) {
        String item = parent.getItemAtPosition(index).toString();

        if(item.equals("Permanent")) {
            type.setText("Permanent");
            description.setText("Passcode is permanent by default");
            notifyTitlePO.setVisibility(View.VISIBLE);
            notifyDescriptionPO.setVisibility(View.VISIBLE);
            setNotificationsPO.setVisibility(View.VISIBLE);
            notifyTitleTR.setVisibility(View.GONE);
            notifyDescriptionTR.setVisibility(View.GONE);
            setNotificationsTR.setVisibility(View.GONE);
            sun.setVisibility(View.GONE);
            mon.setVisibility(View.GONE);
            tues.setVisibility(View.GONE);
            wed.setVisibility(View.GONE);
            thurs.setVisibility(View.GONE);
            fri.setVisibility(View.GONE);
            sat.setVisibility(View.GONE);
            allDay.setVisibility(View.GONE);
            setDate1.setVisibility(View.GONE);
            setDate2.setVisibility(View.GONE);
            setTime1.setVisibility(View.GONE);
            setTime2.setVisibility(View.GONE);
            startTime.setVisibility(View.GONE);
            endTime.setVisibility(View.GONE);
            startDate.setVisibility(View.GONE);
            endDate.setVisibility(View.GONE);
        } else if (item.equals("Temporary")) {
            type.setText("Temporary");
            description.setText("Works over a period of time");
            notifyTitleTR.setVisibility(View.VISIBLE);
            notifyDescriptionTR.setVisibility(View.VISIBLE);
            setNotificationsTR.setVisibility(View.VISIBLE);
            notifyTitlePO.setVisibility(View.GONE);
            notifyDescriptionPO.setVisibility(View.GONE);
            setNotificationsPO.setVisibility(View.GONE);
            sun.setVisibility(View.GONE);
            mon.setVisibility(View.GONE);
            tues.setVisibility(View.GONE);
            wed.setVisibility(View.GONE);
            thurs.setVisibility(View.GONE);
            fri.setVisibility(View.GONE);
            sat.setVisibility(View.GONE);
            allDay.setVisibility(View.VISIBLE);
            setDate1.setVisibility(View.VISIBLE);
            setDate2.setVisibility(View.VISIBLE);
            setTime1.setVisibility(View.VISIBLE);
            setTime2.setVisibility(View.VISIBLE);
            startTime.setVisibility(View.VISIBLE);
            endTime.setVisibility(View.VISIBLE);
            startDate.setVisibility(View.VISIBLE);
            endDate.setVisibility(View.VISIBLE);
        } else if (item.equals("Repeat")) {
            type.setText("Repeat");
            description.setText("Repeated passcode repeats weekly");
            notifyTitleTR.setVisibility(View.VISIBLE);
            notifyDescriptionTR.setVisibility(View.VISIBLE);
            setNotificationsTR.setVisibility(View.VISIBLE);
            notifyTitlePO.setVisibility(View.GONE);
            notifyDescriptionPO.setVisibility(View.GONE);
            setNotificationsPO.setVisibility(View.GONE);
            sun.setVisibility(View.VISIBLE);
            mon.setVisibility(View.VISIBLE);
            tues.setVisibility(View.VISIBLE);
            wed.setVisibility(View.VISIBLE);
            thurs.setVisibility(View.VISIBLE);
            fri.setVisibility(View.VISIBLE);
            sat.setVisibility(View.VISIBLE);
            allDay.setVisibility(View.GONE);
            setDate1.setVisibility(View.GONE);
            setDate2.setVisibility(View.GONE);
            setTime1.setVisibility(View.GONE);
            setTime2.setVisibility(View.GONE);
            startTime.setVisibility(View.GONE);
            endTime.setVisibility(View.GONE);
            startDate.setVisibility(View.GONE);
            endDate.setVisibility(View.GONE);
        } else if (item.equals("One-time")) {
            type.setText("One-time");
            description.setText("One-time passcode expires after first usage");
            notifyTitlePO.setVisibility(View.VISIBLE);
            notifyDescriptionPO.setVisibility(View.VISIBLE);
            setNotificationsPO.setVisibility(View.VISIBLE);
            notifyTitleTR.setVisibility(View.GONE);
            notifyDescriptionTR.setVisibility(View.GONE);
            setNotificationsTR.setVisibility(View.GONE);
            sun.setVisibility(View.GONE);
            mon.setVisibility(View.GONE);
            tues.setVisibility(View.GONE);
            wed.setVisibility(View.GONE);
            thurs.setVisibility(View.GONE);
            fri.setVisibility(View.GONE);
            sat.setVisibility(View.GONE);
            allDay.setVisibility(View.GONE);
            setDate1.setVisibility(View.GONE);
            setDate2.setVisibility(View.GONE);
            setTime1.setVisibility(View.GONE);
            setTime2.setVisibility(View.GONE);
            startTime.setVisibility(View.GONE);
            endTime.setVisibility(View.GONE);
            startDate.setVisibility(View.GONE);
            endDate.setVisibility(View.GONE);
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }

}