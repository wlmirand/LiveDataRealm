package dummyapp.miranda.william.rxpoc.app.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import dummyapp.miranda.william.rxpoc.R;
import dummyapp.miranda.william.rxpoc.framework.Bla;

public class FullActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(new BlaAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Observe the Live Data provided by the ViewModel
        /*viewModel.getResultListLiveData().observe(this, newList -> {
            //When the Data changes, update the Adapter
            ((BlaAdapter) recyclerView.getAdapter()).swap(newList);
        });

        viewModel.getRealmUpdateMediator().observe(this, observer -> FullActivity.this.viewModel.setResultListLiveData());*/
    }
}
