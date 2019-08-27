package com.example.rural_healthy_mom_to_be.View;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rural_healthy_mom_to_be.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import com.example.rural_healthy_mom_to_be.R;

public class WeightGraphFragment extends Fragment {
    View vWeightGraph;
    private LineChart chart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        vWeightGraph = inflater.inflate(R.layout.weighttrackerfragment, container, false);

        chart = vWeightGraph.findViewById(R.id.weight_line_chart);
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        chart.setPinchZoom(true);

        // get the legend (only possible after setting data)
        Legend l = chart.getLegend();
        l.setEnabled(true);

        //draw at background
        chart.setDrawGridBackground(true);

        chart.setDrawBorders(true);

        chart.setNoDataText("No data at present");

        //get X axis
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(0.5f);
//        //replace 3
        xAxis.setLabelCount(3+1, true);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum((float) 3);
        xAxis.setDrawGridLines(true);

        LineDataSet ds1 = new LineDataSet(lineEntries1(), "min weight");

        ds1.setDrawValues(false);
        ds1.enableDashedLine(10f, 5f, 0f);
        ds1.enableDashedHighlightLine(10f, 5f, 0f);
        ds1.setColor(Color.GREEN);
        ds1.setDrawCircles(false);
        ds1.setLineWidth(1f);
        ds1.setCircleRadius(0);
        ds1.setValueTextSize(10f);
        ds1.setFormLineWidth(2f);
        ds1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
        ds1.setFormSize(15.f);

        LineDataSet ds2 = new LineDataSet(lineEntries2(), "max weight");

        ds2.setDrawValues(false);
        ds2.enableDashedLine(10f, 5f, 0f);
        ds2.enableDashedHighlightLine(10f, 5f, 0f);
        ds2.setColor(Color.RED);
        ds2.setDrawCircles(false);
        ds2.setLineWidth(1f);
        ds2.setCircleRadius(0);
        ds2.setValueTextSize(10f);
        ds2.setFormLineWidth(2f);
        ds2.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
        ds2.setFormSize(15.f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(ds1);
            dataSets.add(ds2);
        LineData data = new LineData(dataSets);
        chart.setData(data);

        Description description = new Description();
        description.setText("Weight Gain Each Week");
        description.setEnabled(true);
        chart.setDescription(description);

        //refresh
        chart.invalidate();





        return vWeightGraph;
    }

    private ArrayList<Entry> lineEntries1()
    {
        ArrayList<Entry>lineEntries1=new ArrayList<>();
        lineEntries1.add(new BarEntry(0,0));
        lineEntries1.add(new BarEntry(1,40));
        lineEntries1.add(new BarEntry(2,65));
        lineEntries1.add(new BarEntry(3,80));
        return lineEntries1;
    }

    private ArrayList<Entry> lineEntries2()
    {
        ArrayList<Entry>lineEntries2=new ArrayList<>();
        lineEntries2.add(new BarEntry(0,0));
        lineEntries2.add(new BarEntry(1,50));
        lineEntries2.add(new BarEntry(2,75));
        lineEntries2.add(new BarEntry(3,90));
        return lineEntries2;
    }

}