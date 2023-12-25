package com.example.freefood.fragments;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.freefood.R;
import com.example.freefood.activitys.MainActivity;
import com.example.freefood.classes.DataBaseHelper;

public class HomeFragment extends Fragment {

    private Button btnAddHistory;
    private EditText _carbohydrates, _protein, _fats, _gramm;
    private TextView _calories, _grammText;
    private float gramm = 100.0f;

    private SQLiteDatabase dataBase;
    private DataBaseHelper dataBaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        dataBaseHelper = new DataBaseHelper(getActivity().getApplicationContext());
        dataBase = dataBaseHelper.getReadableDatabase();

        _carbohydrates = (EditText) view.findViewById(R.id.carbohydratesEditText);
        _protein = (EditText) view.findViewById(R.id.proteinEditText);
        _fats = (EditText) view.findViewById(R.id.fatsEditText);
        _gramm = (EditText) view.findViewById(R.id.gramEditText);

        _calories = (TextView) view.findViewById(R.id.additional_textView);
        _grammText = (TextView) view.findViewById(R.id.textViewGram);

        btnAddHistory = (Button) view.findViewById(R.id.addHistory);


        btnAddHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();

                cv.put(DataBaseHelper.COLUMN_PROTEINS, _protein.getText().toString());
                cv.put(DataBaseHelper.COLUMN_CALORIES, _calories.getText().toString());
                cv.put(DataBaseHelper.COLUMN_CARBOHYDRATES, _carbohydrates.getText().toString());
                cv.put(DataBaseHelper.COLUMN_FATS, _fats.getText().toString());
                cv.put(DataBaseHelper.COLUMN_GRAM, _gramm.getText().toString());

                dataBase = dataBaseHelper.getReadableDatabase();
                dataBase.insert(DataBaseHelper.TABLE, null, cv);
                dataBase.close();
            }
        });



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
                if (gramm < 1000){
                    _grammText.setText("На " + gramm + " грамм продукта");
                }
                else _grammText.setText("На " + gramm / 1000 + " кг продукта");

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
                if (gramm < 1000){
                    _grammText.setText("На " + gramm + " грамм продукта");
                }
                else _grammText.setText("На " + gramm / 1000 + " кг продукта");
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
                if (gramm < 1000){
                    _grammText.setText("На " + gramm + " грамм продукта");
                }
                else _grammText.setText("На " + gramm / 1000 + " кг продукта");
            }
        });
        _gramm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {


                _calories.setText(String.valueOf(CalculatedCalories()) + " ккал");

                if (gramm < 1000){
                    _grammText.setText("На " + gramm + " грамм продукта");
                }
                else _grammText.setText("На " + gramm / 1000 + " кг продукта");

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
            gramm = Float.parseFloat( _gramm.getText().toString());
        }catch (Exception e){
            gramm = 100;
        }


        float calories;

        calories =Math.round((carbohydrates * 4 + protein * 4 + fats * 9) * (gramm / 100));
        return  calories;
    }
}