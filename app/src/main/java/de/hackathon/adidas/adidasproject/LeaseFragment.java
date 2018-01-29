package de.hackathon.adidas.adidasproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
//                LeaseChoosingDialog dialog = new LeaseChoosingDialog();
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                ft.add(android.R.id.content, dialog).addToBackStack(null).commit();
            }
        });


        return view;
    }

    private ArrayList<ShoeView> initData() {
        ArrayList<ShoeView> shoes = new ArrayList<>();

        shoes.add(new ShoeView(R.mipmap.copa_super, R.string.copa_super_description, R.string.copa_super_price));
        shoes.add(new ShoeView(R.mipmap.copa_premium, R.string.copa_premium_description, R.string.copa_premium_price));
//        shoes.add(new ShoeView(R.mipmap.copa_tango, R.string.copa_tango_description, R.string.copa_tango_price));
        shoes.add(new ShoeView(R.mipmap.copa_tango_181, R.string.copa_tango_181_description, R.string.copa_tango_181_price));
        shoes.add(new ShoeView(R.mipmap.predator_tango, R.string.predator_tango_description, R.string.predator_tango_price));
        shoes.add(new ShoeView(R.mipmap.nemeziz_tango_blue, R.string.nemeziz_tango_blue_description, R.string.nemeziz_tango_price));
        shoes.add(new ShoeView(R.mipmap.nemeziz_tango_171, R.string.nemeziz_tango_171_description, R.string.nemeziz_tango_171_price));
        shoes.add(new ShoeView(R.mipmap.pp_ace, R.string.pp_ace_description, R.string.pp_ace_price));
        shoes.add(new ShoeView(R.mipmap.nemeziz_tango, R.string.nemeziz_tango_description, R.string.nemeziz_tango_price));
        shoes.add(new ShoeView(R.mipmap.samba_millenium, R.string.samba_millenium_description, R.string.samba_millenium_price));
        shoes.add(new ShoeView(R.mipmap.x_tango, R.string.x_tango_description, R.string.x_tango_price));
        shoes.add(new ShoeView(R.mipmap.nemeziz_tango_white, R.string.nemeziz_tango_white_description, R.string.nemeziz_tango_price));
        shoes.add(new ShoeView(R.mipmap.pp_171, R.string.pp_171_description, R.string.pp_171_price));
        shoes.add(new ShoeView(R.mipmap.ultraboost, R.string.ultraboost_description, R.string.ultraboost_tango_price));
        shoes.add(new ShoeView(R.mipmap.prophere, R.string.prophere_description, R.string.prophere_price));
        shoes.add(new ShoeView(R.mipmap.alphabounce, R.string.alphabounce_description, R.string.alphabounce_price));
//        shoes.add(new ShoeView(R.mipmap.nmd, R.string.nmd_description, R.string.nmd_price));

        Collections.sort(shoes, new Comparator<ShoeView>() {
            @Override
            public int compare(ShoeView shoeView, ShoeView t1) {
                String lhs = getContext().getString(shoeView.getShoeText());
                String rhs = getContext().getString(t1.getShoeText());
                return lhs.compareTo(rhs);
            }
        });


        return shoes;
    }

}
