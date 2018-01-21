package de.hackathon.adidas.adidasproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class MyAdapterFanClub extends MyAdapter {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FUNCLUB_ITEM = 3;


    private List<ShoeView> mViewShoes = Collections.emptyList();
    private Context context;

    public MyAdapterFanClub(Context context, List<ShoeView> shoes) {
        super(context,shoes);
        this.mViewShoes = shoes;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_item, parent, false);
            return new ItemViewHolder(view, context);
        }
        else {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.recycler_header_fanclub, parent, false);
            return new HeaderViewHolder(view);
        }
    }

}
