package com.example.anesthesiatelemetryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.Random;

public class VitalSignsActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton OR_001expandButton; // button to expand the vital chart for OR-001
    private ImageButton OR_002expandButton; // button to expand the vital chart for OR-002
    private ImageButton OR_003expandButton; // button to expand the vital chart for OR-003
    private ImageButton OR_004expandButton; // button to expand the vital chart for OR-004
    private ImageButton OR_005expandButton; // button to expand the vital chart for OR-005
    private ImageButton OR_006expandButton; // button to expand the vital chart for OR-006

    // Group Chat buttons
    private ImageButton OR_001GroupChatButton; // OR-001 Groupchat button
    private ImageButton OR_002GroupChatButton; // OR-002 Groupchat button
    private ImageButton OR_003GroupChatButton; // OR-003 Groupchat button
    private ImageButton OR_004GroupChatButton; // OR-004 Groupchat button
    private ImageButton OR_005GroupChatButton; // OR-005 Groupchat button
    private ImageButton OR_006GroupChatButton; // OR-006 Groupchat button

    // Alarm Buttons
    private ImageButton OR_001AlarmButton; // OR-001 Alarm Button
    private ImageButton OR_002AlarmButton; // OR-002 Alarm Button
    private ImageButton OR_003AlarmButton; // OR-003 Alarm Button
    private ImageButton OR_004AlarmButton; // OR-004 Alarm Button
    private ImageButton OR_005AlarmButton; // OR-005 Alarm Button
    private ImageButton OR_006AlarmButton; // OR-006 Alarm Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_signs);


        // --- declare values
        // Expand button for vital chart
        OR_001expandButton = findViewById(R.id.openOR_001);
        OR_002expandButton = findViewById(R.id.openOR_002);
        OR_003expandButton = findViewById(R.id.openOR_003);
        OR_004expandButton = findViewById(R.id.openOR_004);
        OR_005expandButton = findViewById(R.id.openOR_005);
        OR_006expandButton = findViewById(R.id.openOR_006);

        OR_001expandButton.setOnClickListener(this);
        OR_002expandButton.setOnClickListener(this);
        OR_003expandButton.setOnClickListener(this);
        OR_004expandButton.setOnClickListener(this);
        OR_005expandButton.setOnClickListener(this);
        OR_006expandButton.setOnClickListener(this);


        // Groupchat Buttons
        OR_001GroupChatButton = findViewById(R.id.messageOR_001); // Groupchat for OR-01 Button
        OR_002GroupChatButton = findViewById(R.id.messageOR_002);
        OR_003GroupChatButton = findViewById(R.id.messageOR_003);
        OR_004GroupChatButton = findViewById(R.id.messageOR_004);
        OR_005GroupChatButton = findViewById(R.id.messageOR_005);
        OR_006GroupChatButton = findViewById(R.id.messageOR_006);

        OR_001GroupChatButton.setOnClickListener(this);
        OR_002GroupChatButton.setOnClickListener(this);
        OR_003GroupChatButton.setOnClickListener(this);
        OR_004GroupChatButton.setOnClickListener(this);
        OR_005GroupChatButton.setOnClickListener(this);
        OR_006GroupChatButton.setOnClickListener(this);

        // Alarm Buttons
        OR_001AlarmButton = findViewById(R.id.alarmOR_001); // Groupchat for OR-01 Button
        OR_002AlarmButton = findViewById(R.id.alarmOR_002);
        OR_003AlarmButton = findViewById(R.id.alarmOR_003);
        OR_004AlarmButton = findViewById(R.id.alarmOR_004);
        OR_005AlarmButton = findViewById(R.id.alarmOR_005);
        OR_006AlarmButton = findViewById(R.id.alarmOR_006);

        OR_001AlarmButton.setOnClickListener(this);
        OR_002AlarmButton.setOnClickListener(this);
        OR_003AlarmButton.setOnClickListener(this);
        OR_004AlarmButton.setOnClickListener(this);
        OR_005AlarmButton.setOnClickListener(this);
        OR_006AlarmButton.setOnClickListener(this);
    } // end of onCreate Method

    /**
     * This method is used to open the WaveformActivity Page
     */
    private void openWaveformActivity() {
        Intent intent = new Intent(VitalSignsActivity.this, WaveformActivity.class);
        startActivity(intent);
    }

    /**
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
       if (v.getId() == R.id.messageOR_001) { // when user presses the OR-001 Group Chat button

        } else if (v.getId() == R.id.messageOR_002) { // when user presses the OR-002 Group Chat button

       } else if (v.getId() == R.id.messageOR_003) { // when user presses the OR-003 Group Chat button

       } else if (v.getId() == R.id.messageOR_004) { // when user presses the OR-004 Group Chat button

       } else if (v.getId() == R.id.messageOR_005) { // when user presses the OR-005 Group Chat button

       } else if (v.getId() == R.id.messageOR_006) { // when user presses the OR-006 Group Chat button

       } else if (v.getId() ==R.id.openOR_001){  // when the user presses the OR-001 expand button,
           generateChart(R.id.waveformFragmentContainer1); // open or close WaveformFragment

        } else if (v.getId() ==R.id.openOR_002){  // when the user presses the OR-001 expand button,
           generateChart(R.id.waveformFragmentContainer2);

       } else if (v.getId() ==R.id.openOR_003){  // when the user presses the OR-001 expand button,
           generateChart(R.id.waveformFragmentContainer3);

       } else if (v.getId() ==R.id.openOR_004){  // when the user presses the OR-001 expand button,
           generateChart(R.id.waveformFragmentContainer4);

       } else if (v.getId() ==R.id.openOR_005){  // when the user presses the OR-001 expand button,
           generateChart(R.id.waveformFragmentContainer5);

       } else if (v.getId() ==R.id.openOR_006){  // when the user presses the OR-001 expand button,
           generateChart(R.id.waveformFragmentContainer6);

       } else if (v.getId() == R.id.alarmOR_001) {

        } else if (v.getId() == R.id.alarmOR_002) {

       } else if (v.getId() == R.id.alarmOR_003) {

       } else if (v.getId() == R.id.alarmOR_004) {

       } else if (v.getId() == R.id.alarmOR_005) {

       } else if (v.getId() == R.id.alarmOR_006) {

       }

    }// end of onClick Method

    // function to generate a chart and put it into container based on id
    // changes the container from gone to visible or back to gone
    public void generateChart(int id) {
        FrameLayout container = findViewById(id);
        boolean isVisible = container.getVisibility() == View.VISIBLE;

        // will need to research FragmentTransaction more carefully as I do not fully understand it yet
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // if container is not visible, turn it on
        if (!isVisible) {
            // initialize a new waveformFragment object
            // for now, the fragment object produces random data not associated with specific room
            WaveformFragment fragment = new WaveformFragment();
            transaction.replace(id, fragment);
            container.setVisibility(View.VISIBLE); // make container visible
        } else {
            // if container is visible, turn it off
            Fragment fragment = getSupportFragmentManager().findFragmentById(id);
            if (fragment != null) {
                transaction.remove(fragment);
            }
            container.setVisibility(View.GONE);
        }
        transaction.commit();
    }

} // end of VitalSignsActivity Class