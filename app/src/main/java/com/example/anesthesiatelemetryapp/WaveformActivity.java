package com.example.anesthesiatelemetryapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.Random;

public class WaveformActivity extends AppCompatActivity {

    // delcaring valriables
    private LineChart chart;
    private LineDataSet lineDataSet;
    private final Random random = new Random();
    private final Handler handler = new Handler();

    private Button collapseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waveforms);

        // inialize chart and set it's background color
        chart = findViewById(R.id.chart);
        chart.setBackgroundColor(getResources().getColor(R.color.white));

        // Initializing LineDataSet for chart
        lineDataSet = new LineDataSet(null, "Random Data");
        lineDataSet.setLineWidth(2.5f);
        lineDataSet.setColor(getResources().getColor(R.color.purple_700));
        // Enable cubic interpolation
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setCubicIntensity(0.2f); // Set the intensity for cubic lines (default 0.2f)

        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);

        // Set LineData with LineDataSet to teh chart
        LineData data = new LineData(lineDataSet);
        chart.setData(data);
        chart.getDescription().setEnabled(false); // chart description on bottom right

        // Start the data generation for the chart
        generateData();

        //collapse chart view when clicked
        collapseButton = (Button) findViewById(R.id.collapse);
        collapseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openVitalSignActivity();  // goes back to vital sign activity page
            }
        });
    }

    /**
     * Method is used to Generate data for the Chart
     */
    private void generateData() {
        // Create a runnable task to update the chart
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                addEntry(); // Add a new data entry
                handler.postDelayed(this, 200); // Run this task again after one second
            }
        };

        handler.postDelayed(runnable, 200); // Initially delay one second, then it will run every second
    }

    /**
     * Methods is used to add a new entry to the chart
     */
    private void addEntry() {
        LineData data = chart.getData();

        if (data != null) {
            lineDataSet = (LineDataSet) data.getDataSetByIndex(0);
            if (lineDataSet == null) {
                lineDataSet = new LineDataSet(null, "Random Data");
                data.addDataSet(lineDataSet);
            }

            // Generate a random number between 5 and 20
            int randomNum = random.nextInt(16) + 5;

            // Add a new random value to the chart
            data.addEntry(new Entry(lineDataSet.getEntryCount(), randomNum), 0);

            // Remove oldest entry if max size is reached
            if (lineDataSet.getEntryCount() > 20) {
                lineDataSet.removeFirst();
                for (Entry entry : lineDataSet.getValues()) {
                    entry.setX(entry.getX() - 1); // Shift to the left
                }
            }
            data.notifyDataChanged();
            chart.notifyDataSetChanged();
            chart.setVisibleXRangeMinimum(20);
            chart.setVisibleXRangeMaximum(20);
            chart.moveViewToX(data.getEntryCount());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null); // Stop the handler when activity not visible
    }

    // Open VitalSignsActivity Page
    public void openVitalSignActivity(){
        Intent intent = new Intent(WaveformActivity.this, VitalSignsActivity.class);
        startActivity(intent);
    }
}
