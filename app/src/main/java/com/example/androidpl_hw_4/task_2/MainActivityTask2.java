package com.example.androidpl_hw_4.task_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.androidpl_hw_4.R;
import com.example.androidpl_hw_4.task_2.retrofit.RetrofitPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityTask2 extends AppCompatActivity implements MainView{

     private static final String TAG = "MainActivityTask2";

    @BindView(R.id.edit_text)
    EditText editText;

    @BindView(R.id.image_view)
    ImageView imageView;

    @BindView(R.id.text_name)
    TextView textViewName;

    @BindView(R.id.text_company)
    TextView textViewCompany;

    private RetrofitPresenter retrofitPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_task2);

        ButterKnife.bind(this);

        retrofitPresenter = new RetrofitPresenter(this);
    }

    @OnClick(R.id.button_start_task_2)
    public void onClick() {
        String nameLogin = editText.getText().toString();
        if(!nameLogin.isEmpty()) {
            Log.d(TAG, "onClick edit text: " + nameLogin);
            retrofitPresenter.getString(nameLogin);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setUser(JsonUser jsonUser) {
        if(jsonUser != null) {
            textViewName.setVisibility(View.VISIBLE);
            textViewName.setText("Login user: " + jsonUser.login);
            textViewCompany.setVisibility(View.VISIBLE);
            textViewCompany.setText("Company user: " + jsonUser.company);

            setImageView(jsonUser);
        }
    }

    private void setImageView(JsonUser jsonUser) {
        Glide
                .with(this)
                .load(jsonUser.avatar)
                .into(imageView);
    }
}
