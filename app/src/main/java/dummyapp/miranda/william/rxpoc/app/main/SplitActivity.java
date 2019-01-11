package dummyapp.miranda.william.rxpoc.app.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dummyapp.miranda.william.rxpoc.R;

public class SplitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1, new MainFragment())
                .replace(R.id.fragment2, new MainFragment())
                .commit();
    }
}
