package kr.co.woobi.imyeon.mycafeproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageOneFragment extends Fragment {
    RecyclerView recyclerView;
    TextView mtextViewTotal;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    SQLiteDatabase mdb;
    DBHelper dbHelper;
    public PageOneFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pageone,container, false);
        mtextViewTotal=view.findViewById(R.id.textViewTotal);
        dbHelper=new DBHelper(getContext());
        mdb=dbHelper.getWritableDatabase();
        //textview를 인수로 어댑터한테 넘겨준다.
        adapter=new MRecyclerAdapter(mdb,mtextViewTotal);
        recyclerView=(RecyclerView)view.findViewById(R.id.menu_recycler_view);

        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);;
        //adapter=new MRecyclerAdapter(arrayList);

        recyclerView.setAdapter(adapter);
        return view;
    }
}
