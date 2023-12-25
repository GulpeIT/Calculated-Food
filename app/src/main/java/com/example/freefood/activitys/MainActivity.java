package com.example.freefood.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.freefood.R;
import com.example.freefood.classes.DataBaseHelper;
import com.example.freefood.classes.DataProduct;
import com.example.freefood.databinding.ActivityMainBinding;
import com.example.freefood.fragments.HomeFragment;
import com.example.freefood.fragments.HistoryFragment;
import com.example.freefood.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase dataBase;
    private DataBaseHelper dataBaseHelper;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBaseHelper = new DataBaseHelper(getApplicationContext());
        dataBase = dataBaseHelper.getReadableDatabase();

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.main){
                replaceFragment(new HomeFragment());
            }
            /*if (item.getItemId() == R.id.settings){
                replaceFragment(new SettingsFragment());
            }*/
            if (item.getItemId() == R.id.information){
                replaceFragment(new HistoryFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataBase.execSQL("DELETE FROM " + DataBaseHelper.TABLE);

    }
}