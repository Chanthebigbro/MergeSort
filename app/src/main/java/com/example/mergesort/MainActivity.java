package com.example.mergesort;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.*;
import android.view.View;
import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> sampleArray;

    private Button executionButton;
    private TextView givenList;
    private TextView sortSequence;

    private String output = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sampleArray = new ArrayList<String>();
        this.sampleArray.add("5");
        this.sampleArray.add("2");
        this.sampleArray.add("8");
        this.sampleArray.add("3");
        this.sampleArray.add("13");
        this.sampleArray.add("5");
        this.sampleArray.add("5");
        this.sampleArray.add("8");
        this.sampleArray.add("1");

        this.givenList = this.findViewById(R.id.Src2);
        this.sortSequence = this.findViewById(R.id.Src3);

        this.executionButton = this.findViewById(R.id.B1);

        this.givenList.setText(buildString(sampleArray));

    }

    private String buildString(ArrayList<String> theList) //temporal function
    {
        String s = "";
        for (int i = 0; i <theList.size(); i++)
        {
            s = s + theList.get(i) + " ";
        }
        return s;
    }

    private String buildStringFromArrayList(ArrayList<String> theList, int begin, int end)
    {
        String s = "";
        for(int i = begin; i < end; i++)
        {
            s = s + theList.get(i) + " ";
        }
        return s;
    }

    private void sortFunction(ArrayList<String> theList, int len)
    {
        if(len<2)return;

        int mid = len/2;
        ArrayList<String> left;
        ArrayList<String> right;

        left = new ArrayList<String>();
        right = new ArrayList<String>();

        for (int i = 0; i < len; ++i)
        {
            if(i<mid){
                left.add(theList.get(i));
            }
            else{
                right.add(theList.get(i));
            }
        }
        this.output = this.output + buildStringFromArrayList(left,0,left.size()) +"\n";
        sortFunction(left, mid);

        this.output = this.output + buildStringFromArrayList(right,0,right.size()) + "\n";
        sortFunction(right, len - mid);

    }

    public void executionButton(View v)
    {
        if(v == this.executionButton)
        {
            sortFunction(sampleArray,sampleArray.size());
            this.sortSequence.setText(this.output);
        }
    }


}