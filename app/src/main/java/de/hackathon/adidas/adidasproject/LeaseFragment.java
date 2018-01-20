package de.hackathon.adidas.adidasproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ankit on 1/20/18.
 */

public class LeaseFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected LinearLayoutManager manager;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lease_fragment, container, false);


        ArrayList<Integer> viewColors = new ArrayList<>();
        viewColors.add(Color.BLACK);
        viewColors.add(Color.YELLOW);
        viewColors.add(Color.MAGENTA);
        viewColors.add(Color.RED);
        viewColors.add(Color.BLUE);


        recyclerView = view.findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(
                getActivity());
        recyclerView.setLayoutManager(manager);

        adapter = new MyAdapter(getContext(), viewColors);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
