package com.example.freefood.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.freefood.R;

public class HomeFragment extends Fragment {

    private EditText _carbohydrates, _protein, _fats, _gram;
    private TextView _calories, _gramText;
    private float gram = 100;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        _carbohydrates = (EditText) view.findViewById(R.id.carbohydratesEditText);
        _protein = (EditText) view.findViewById(R.id.proteinEditText);
        _fats = (EditText) view.findViewById(R.id.fatsEditText);
        _gram = (EditText) view.findViewById(R.id.gramEditText);

        _calories = (TextView) view.findViewById(R.id.additional_textView);
        _gramText = (TextView) view.findViewById(R.id.textViewGram);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        _fats.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                _calories.setText(String.valueOf(CalculatedCalories()) + " ккал");
                _gramText.setText("На " + gram + " грамм продукта");
            }
        });
        _carbohydrates.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                _calories.setText(String.valueOf(CalculatedCalories()) + " ккал");
                _gramText.setText("На " + gram + " грамм продукта");
            }
        });
        _protein.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                _calories.setText(String.valueOf(CalculatedCalories()) + " ккал");
                _gramText.setText("На " + gram + " грамм продукта");
            }
        });
        _gram.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                _calories.setText(String.valueOf(CalculatedCalories()) + " ккал");
                _gramText.setText("На " + gram + " грамм продукта");
            }
        });
    }

    private float CalculatedCalories(){
        float carbohydrates, protein, fats;

        try{
            carbohydrates = Float.parseFloat( _carbohydrates.getText().toString());
            protein = Float.parseFloat(_protein.getText().toString());
            fats = Float.parseFloat( _fats.getText().toString());
        } catch (Exception e){
            return 0;
        }
        try{
            gram = Float.parseFloat( _gram.getText().toString());
        }catch (Exception e){
            gram = 100f;
        }


        float calories;

        calories =Math.round((carbohydrates * 4 + protein * 4 + fats * 9) * (gram / 100));
        return  calories;
    }
}