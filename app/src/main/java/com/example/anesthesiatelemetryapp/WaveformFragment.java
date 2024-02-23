package com.example.anesthesiatelemetryapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.Random;

public class WaveformFragment extends Fragment {
    // delcaring valriables
    private LineChart chart;
    private LineDataSet lineDataSet;
    private final Random random = new Random();
    private final Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_waveform, container, false);

        // Initialize chart and set its background color
        chart = view.findViewById(R.id.chart);
        chart.setBackgroundColor(Color.WHITE); // Direct color value or use ContextCompat.getColor(getContext(), R.color.white) for color resources

        // Initializing LineDataSet for chart
        lineDataSet = new LineDataSet(null, "Random Data");
        lineDataSet.setLineWidth(2.5f);
        lineDataSet.setColor(Color.parseColor("#673AB7")); // Example color, replace with actual color resource or definition
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setCubicIntensity(0.2f);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);

        // Set LineData with LineDataSet to the chart
        LineData data = new LineData(lineDataSet);
        chart.setData(data);
        chart.getDescription().setEnabled(false); // Chart description on bottom right

        // Start the data generation for the chart
        generateData();

        return view;
    }

    /**
     * Method is used to generate data for the Chart
     */
    private void generateData() {
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
     * Method is used to add a new entry to the chart
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
    public void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null); // Stop the handler when the fragment is not visible
    }

}
