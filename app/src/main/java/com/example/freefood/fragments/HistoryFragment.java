package com.example.freefood.fragments;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.freefood.R;
import com.example.freefood.adapter.AdapterHistoryAdapter;
import com.example.freefood.classes.DataBaseHelper;
import com.example.freefood.classes.DataProduct;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    RecyclerView dataProductRecyclerView;
    SQLiteDatabase dataBase;
    DataBaseHelper dataBaseHelper;
    Cursor cursor;
    SimpleCursorAdapter adapter;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        dataBaseHelper = new DataBaseHelper(getActivity().getApplicationContext());
        dataProductRecyclerView = (RecyclerView) view.findViewById(R.id.RecView);

        setDataRecycler(view);

        return view;
    }


    private void setDataRecycler(View view) {
        // открываем подключение
        dataBase = dataBaseHelper.getReadableDatabase();

        //получаем данные из бд в виде курсора
        cursor =  dataBase.rawQuery("SELECT * FROM "+ DataBaseHelper.TABLE, null);

        //Список заметок
        ArrayList<DataProduct> dataP = new ArrayList<>();

        //Добавление заметок из бд в список
        while (cursor.moveToNext()){
            dataP.add(
                    new DataProduct(cursor.getFloat(1),
                                    cursor.getFloat(2),
                                    cursor.getFloat(3),
                                    cursor.getFloat(4),
                                    cursor.getFloat(5)));
        }

        //Закрытие соединения с бд и курсора
        dataBase.close();
        cursor.close();

        //Указываем настройки для отображения списка заметок
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        dataProductRecyclerView = view.findViewById(R.id.RecView);
        dataProductRecyclerView.setLayoutManager(layoutManager);

        AdapterHistoryAdapter adap = new AdapterHistoryAdapter(getContext(), dataP);
        dataProductRecyclerView.setAdapter(adap);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        dataBase.close();
        cursor.close();
    }
}