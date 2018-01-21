package de.hackathon.adidas.adidasproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ankit on 1/20/18.
 */

public class LeaseFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected GridLayoutManager manager;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lease_fragment, container, false);


        ArrayList<ShoeView> data = initData();

        recyclerView = view.findViewById(R.id.recyclerView);
        manager = new GridLayoutManager(
                getActivity(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override public int getSpanSize(int position) {
                return (position == 0) ? 2 : 1;
            }
        });

        recyclerView.setLayoutManager(manager);

        adapter = new MyAdapter(getContext(), data);
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

    private ArrayList<ShoeView> initData() {
        ArrayList<ShoeView> shoes = new ArrayList<>();

        shoes.add(new ShoeView(R.mipmap.stan_smith, R.string.app_name));
        shoes.add(new ShoeView(R.mipmap.stan_smith, R.string.app_name));
        shoes.add(new ShoeView(R.mipmap.stan_smith, R.string.app_name));
        shoes.add(new ShoeView(R.mipmap.stan_smith, R.string.app_name));
        shoes.add(new ShoeView(R.mipmap.stan_smith, R.string.app_name));
        shoes.add(new ShoeView(R.mipmap.stan_smith, R.string.app_name));
        shoes.add(new ShoeView(R.mipmap.stan_smith, R.string.app_name));
        shoes.add(new ShoeView(R.mipmap.stan_smith, R.string.app_name));

        return shoes;
    }

}
