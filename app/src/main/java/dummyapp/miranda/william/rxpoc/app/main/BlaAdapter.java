package dummyapp.miranda.william.rxpoc.app.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dummyapp.miranda.william.rxpoc.R;
import dummyapp.miranda.william.rxpoc.framework.Bla;

public class BlaAdapter extends RecyclerView.Adapter<BlaAdapter.BlaViewHolder> {

    private List<Bla> data;

    public BlaAdapter() {
        this.data = new ArrayList<>();
    }

    @NonNull
    @Override
    public BlaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bla_item, viewGroup, false);

        return new BlaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlaViewHolder blaViewHolder, int i) {
        blaViewHolder.setData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void swap(List<Bla> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    public static class BlaViewHolder extends RecyclerView.ViewHolder {

        private final TextView viewName;

        public BlaViewHolder(@NonNull View itemView) {
            super(itemView);
            viewName = itemView.findViewById(R.id.name);
        }

        public void setData(Bla bla) {
            viewName.setText(bla.getName());
        }
    }
}
