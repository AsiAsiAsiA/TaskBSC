package com.example.taskbsc.ui;

import android.os.Bundle;

import com.example.taskbsc.R;
import com.example.taskbsc.moxyandroidx.MvpAppCompatActivity;

import androidx.fragment.app.Fragment;

public class MainActivity extends MvpAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            loadFragment(CurrencyListFragment.newInstance());
        }
    }

    //Размещение фрагмента во фрейм
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
