package com.example.androidpl_hw_4.task_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidpl_hw_4.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityTask1 extends AppCompatActivity {

    private static final String TAG = "MainActivityTask1";

    @BindView(R.id.text_view_time_of_year)
    TextView editTextTimeOfYear;

    @BindView(R.id.text_view_year)
    TextView editTextYear;

    private JsonTimeFoYear json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        String jsonString = "{\n" +
                "  \"time_of_year\": \"summer\",\n" +
                "  \"year\": 2019\n" +
                "}";
        Gson gson = new GsonBuilder().create();
        json = gson.fromJson(jsonString, JsonTimeFoYear.class);
    }

    @SuppressLint("SetTextI18n")
    @OnClick(R.id.button_start_task_1)
    public void OnClick() {
        Log.d(TAG, "onClick time of year: " + json.timeOfYear);
        editTextTimeOfYear.setText("Time if year: " + json.timeOfYear);

        Log.d(TAG, "onClick year: " + json.year);
        editTextYear.setText("Year: " + json.year);
    }
}
