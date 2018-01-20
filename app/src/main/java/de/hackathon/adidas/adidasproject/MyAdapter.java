package de.hackathon.adidas.adidasproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by ankit on 1/20/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<Integer> mViewColors = Collections.emptyList();
    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;
    private Context context;

    // data is passed into the constructor
    public MyAdapter(Context context, List<Integer> colors) {
//        this.mInflater = LayoutInflater.from(context);
        this.mViewColors = colors;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int color = mViewColors.get(position);
        holder.myView.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return mViewColors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public View myView;
        private Context ctx;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            myView = itemView.findViewById(R.id.shoeView);
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

//    public interface ItemClickListener {
//        void
//    }

}
