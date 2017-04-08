package com.avinsharma.todopomodoro.grid;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avinsharma.todopomodoro.R;

import java.util.ArrayList;

/**
 * Created by Avin on 07-04-2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private ArrayList<GridTodoItem> items;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public TextView itemCount;
        public TextView pomodoroCount;

        public ViewHolder(View view, TextView title, TextView itemCount, TextView pomodoroCount) {
            super(view);
            this.title = title;
            this.itemCount = itemCount;
            this.pomodoroCount = pomodoroCount;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public GridAdapter(ArrayList<GridTodoItem> items) {
        this.items = items;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_list_item, parent, false);
        TextView title = (TextView) view.findViewById(R.id.title_text_view);
        TextView itemCount = (TextView) view.findViewById(R.id.item_count_text_view);
        TextView pomodoroCount = (TextView) view.findViewById(R.id.pomodoro_count_text_view);

        ViewHolder vh = new ViewHolder(view, title, itemCount, pomodoroCount);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.d("GridAdapter", items.get(position).getTitle());
        holder.title.setText(items.get(position).getTitle());
        String itemCountText = "Tasks: " + String.valueOf(items.get(position).getItemCount());
        holder.itemCount.setText(itemCountText);
        String pomodoroText = "Pomodoros: " + String.valueOf(items.get(position).getPomodoroCount());
        holder.pomodoroCount.setText(pomodoroText);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}