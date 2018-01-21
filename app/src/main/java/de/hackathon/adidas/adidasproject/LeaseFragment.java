package de.hackathon.adidas.adidasproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;

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

        FloatingActionButton button = view.findViewById(R.id.event_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "Hello button!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(view.getContext(), text, duration);
                toast.show();
                Log.d("Button", "onClick");
            }
        });


        return view;
    }
}
