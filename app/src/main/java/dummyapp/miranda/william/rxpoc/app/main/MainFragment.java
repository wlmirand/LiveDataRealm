package dummyapp.miranda.william.rxpoc.app.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dummyapp.miranda.william.rxpoc.R;
import dummyapp.miranda.william.rxpoc.framework.Bla;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(new BlaAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Observe the Live Data provided by the ViewModel
        viewModel.getAllBlaLiveData().observe(this, new Observer<List<Bla>>() {
            @Override
            public void onChanged(@Nullable List<Bla> newList) {
                //When the Data changes, update the Adapter
                ((BlaAdapter) recyclerView.getAdapter()).swap(newList);
            }
        });
    }
}
