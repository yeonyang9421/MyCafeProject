package kr.co.woobi.imyeon.mycafeproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PageFourFragment extends Fragment {
    RecyclerView recyclerView;
//    TextView mtextViewTotal;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
//    SQLiteDatabase mdb;
//    DBHelper dbHelper;
    private ArrayList<TableOrder> tableOrderArrayList=new ArrayList<>();
    public PageFourFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pagefour, container, false);

//        mtextViewTotal=view.findViewById(R.id.textViewTotal);
//        mtextViewTotal.setText("00");
//        dbHelper=new DBHelper(getContext());
//        mdb=dbHelper.getWritableDatabase();
        //textview를 인수로 어댑터한테 넘겨준다.

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_table);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
//        adapter=new TableAdapter();


        setData();

//        TableOrder tableOrder=new TableOrder("1","아메리카노 1","4000");
        adapter=new TableAdapter(tableOrderArrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void setData() {
        tableOrderArrayList.clear();
        tableOrderArrayList.add(new TableOrder("1","아메리카노", "10500"));
        tableOrderArrayList.add(new TableOrder("1","아메리카노", "10500"));
        tableOrderArrayList.add(new TableOrder("1","카페라테2", "10500"));
        tableOrderArrayList.add(new TableOrder("1","아메", "10500"));
        adapter.notifyDataSetChanged();
    }
}
