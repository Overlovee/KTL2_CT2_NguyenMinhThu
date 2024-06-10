package com.example.ktl2_ct2_nguyenminhthu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.ktl2_ct2_nguyenminhthu.Models.Country;
import com.example.ktl2_ct2_nguyenminhthu.databinding.ActivityCountryDetailBinding;

public class CountryDetailActivity extends AppCompatActivity {

    private ActivityCountryDetailBinding activityCountryDetailBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCountryDetailBinding = ActivityCountryDetailBinding.inflate(getLayoutInflater());
        setContentView(activityCountryDetailBinding.getRoot());
        Intent intent = getIntent();
        Country country = (Country) intent.getSerializableExtra("country");

        Glide.with(this).load(country.getImgUrl()).into(activityCountryDetailBinding.imageViewItem);
        activityCountryDetailBinding.textViewCommonName.setText(country.getCommonName());
        activityCountryDetailBinding.textViewOfficialName.setText(country.getOfficialName());
        activityCountryDetailBinding.textViewCapital.setText(country.getCapital());
        activityCountryDetailBinding.textViewContinent.setText(country.getContinent());
        activityCountryDetailBinding.textViewLanguage.setText(country.getLanguage());
        activityCountryDetailBinding.textViewPopulation.setText(String.valueOf(country.getPopulation()));

        addEvents();
    }
    void addEvents(){
        activityCountryDetailBinding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}