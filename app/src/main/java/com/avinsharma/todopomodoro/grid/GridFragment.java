package com.avinsharma.todopomodoro.grid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avinsharma.todopomodoro.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {


    public GridFragment() {
        // Required empty public constructor
    }

    RecyclerView grid;
    TextView username;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        username =  (TextView) view.findViewById(R.id.user_name_title);
        username.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        grid = (RecyclerView) view.findViewById(R.id.todo_recycler_view);

        ArrayList<GridTodoItem> items = new ArrayList<>();
        items.add(new GridTodoItem("Title 1 kasjdhf askdjfh askdjfh askdfh", 23, 12));
        items.add(new GridTodoItem("Title 1", 23, 12));
        items.add(new GridTodoItem("Title 1", 23, 12));

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        grid.setLayoutManager(layoutManager);

        GridAdapter adapter = new GridAdapter(items);
        grid.setAdapter(adapter);

        return view;
    }

}
