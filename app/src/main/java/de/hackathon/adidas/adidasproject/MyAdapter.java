package de.hackathon.adidas.adidasproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by ankit on 1/20/18.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;


    private List<ShoeView> mViewShoes = Collections.emptyList();
    private Context context;

    public MyAdapter(Context context, List<ShoeView> shoes) {
        this.mViewShoes = shoes;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;

        }

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
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
                    .inflate(R.layout.recycler_header, parent, false);
            return new HeaderViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder) {
            ShoeView shoe = mViewShoes.get(position);
            ((ItemViewHolder) holder).shoeView.setImageResource(shoe.getShoeImage());
            ((ItemViewHolder) holder).shoeText.setText(shoe.getShoeText());

        }
    }

    @Override
    public int getItemCount() {
        return mViewShoes.size();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public View View;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            View = itemView;
        }
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView shoeView;
        public TextView shoeText;
        private Context ctx;

        public ItemViewHolder(View itemView, Context context) {
            super(itemView);
            shoeView = itemView.findViewById(R.id.shoe_view);
            shoeText = itemView.findViewById(R.id.shoe_text);
            itemView.setOnClickListener(this);
            this.ctx = context;
        }


        @Override
        public void onClick(View view) {
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(ctx, text, duration);
            toast.show();
            Log.d("View Item", "onClick");
        }

    }

}
