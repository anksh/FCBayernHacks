package de.hackathon.adidas.adidasproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ankit on 1/20/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<Integer> mViewColors = Collections.emptyList();
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
        View view = LayoutInflater.from(context)
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int color = mViewColors.get(position);
        if (position == 0) {
            holder.leftLayout.getLayoutParams().height = 0;
            holder.leftLayout.getLayoutParams().width = 0;
            RelativeLayout.LayoutParams layoutParams;
            layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 750);
            layoutParams.setMargins(0, 0, 0, 0);
            holder.rightLayout.setLayoutParams(layoutParams);
            holder.rightShoeView.getLayoutParams().height = 0;
            holder.rightShoeView.getLayoutParams().width = 0;



            holder.rightShoeText.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            holder.rightShoeText.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            holder.rightShoeText.setTextColor(context.getResources().getColor(R.color.white));
            holder.rightShoeText.setBackgroundColor(context.getResources().getColor(R.color.black));
            holder.rightShoeText.setText(context.getText(R.string.lease_splash));
            holder.rightShoeText.setGravity(Gravity.CENTER);
        } else {
            holder.leftShoeView.setBackgroundColor(color);
            holder.leftShoeText.setText(R.string.app_name);
            holder.rightShoeView.setBackgroundColor(mViewColors.get(4));
            holder.rightShoeText.setText(R.string.app_name);
        }

    }

    @Override
    public int getItemCount() {
        return mViewColors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public LinearLayout leftLayout;
        public LinearLayout rightLayout;

        public View leftShoeView;
        public TextView leftShoeText;
        public View rightShoeView;
        public TextView rightShoeText;

        private Context ctx;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.nested_layout_left);
            rightLayout = itemView.findViewById(R.id.nested_layout_right);
            leftShoeView = itemView.findViewById(R.id.shoe_view_left);
            leftShoeText = itemView.findViewById(R.id.shoe_text_left);
            rightShoeView = itemView.findViewById(R.id.shoe_view_right);
            rightShoeText = itemView.findViewById(R.id.shoe_text_right);

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
