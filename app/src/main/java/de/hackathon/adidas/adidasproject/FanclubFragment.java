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

import butterknife.ButterKnife;

public class FanclubFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected GridLayoutManager manager;
    private MyAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fanclub_fragment, container, false);
        ButterKnife.bind(this, view);


        ArrayList<ShoeView> data = initData();

        recyclerView = view.findViewById(R.id.recyclerViewFan);
        manager = new GridLayoutManager(
                getActivity(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position == 0) ? 2 : 1;
            }
        });

        recyclerView.setLayoutManager(manager);

        adapter = new MyAdapterFanClub(getContext(), data);
        recyclerView.setAdapter(adapter);

//        FloatingActionButton button = view.findViewById(R.id.event_button_fan);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CharSequence text = "Hello button!";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(view.getContext(), text, duration);
//                toast.show();
//                Log.d("Button", "onClick");
//            }
//        });

        return view;
    }

    private ArrayList<ShoeView> initData() {
        ArrayList<ShoeView> shoes = new ArrayList<>();

        shoes.add(new ShoeView(R.mipmap.fcbshoe, R.string.fcbshoe_descirption, R.string.copa_super_price));
        shoes.add(new ShoeView(R.mipmap.fcbshoe2, R.string.fcbshoe2_descirption, R.string.copa_premium_price));
        shoes.add(new ShoeView(R.mipmap.fcbshoe3, R.string.fcbshoe3_descirption, R.string.copa_tango_price));
        shoes.add(new ShoeView(R.mipmap.fcbshoe4, R.string.fcbshoe4_descirption, R.string.copa_tango_181_price));
        shoes.add(new ShoeView(R.mipmap.fcbshoe5, R.string.fcbshoe5_descirption, R.string.predator_tango_price));
        shoes.add(new ShoeView(R.mipmap.shirt1, R.string.shirt1_descirption, R.string.nemeziz_tango_price));
        shoes.add(new ShoeView(R.mipmap.shirt12, R.string.shirt2_descirption, R.string.nemeziz_tango_171_price));
        shoes.add(new ShoeView(R.mipmap.shirt13, R.string.shirt3_descirption, R.string.pp_ace_price));
        shoes.add(new ShoeView(R.mipmap.shirt14, R.string.shirt4_descirption, R.string.nemeziz_tango_price));
        shoes.add(new ShoeView(R.mipmap.kurtka, R.string.kurtka_descirption, R.string.samba_millenium_price));
        shoes.add(new ShoeView(R.mipmap.bluza, R.string.bluza_descirption, R.string.x_tango_price));
        shoes.add(new ShoeView(R.mipmap.short1, R.string.short1_descirption, R.string.x_tango_price));
        shoes.add(new ShoeView(R.mipmap.kalesony, R.string.kalesony_descirption, R.string.x_tango_price));

        return shoes;
    }
}