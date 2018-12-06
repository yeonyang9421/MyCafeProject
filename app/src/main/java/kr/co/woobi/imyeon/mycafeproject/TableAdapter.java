package kr.co.woobi.imyeon.mycafeproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.MyViewHolder> {
    private ArrayList<TableOrder> tableOrderArrayList;
//    private String tablenum, tableorder, tabletot;

//    public TableAdapter(String tablenum, String tableorder, String tabletot) {
//        this.tablenum = tablenum;
//        this.tableorder = tableorder;
//        this.tabletot = tabletot;
//    }


    public TableAdapter(ArrayList<TableOrder> tableOrderArrayList) {
        this.tableOrderArrayList = tableOrderArrayList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
//        MyViewHolder myViewHolder = (MyViewHolder) holder;
       holder.mTableNum.setText(tableOrderArrayList.get(i).getTablenum());
        holder.mTableOrder.setText(tableOrderArrayList.get(i).getOrder());
        holder.mTalbeTotal.setText(tableOrderArrayList.get(i).getTotal());
    }

    @Override
    public int getItemCount() {
        return tableOrderArrayList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
       private TextView mTableNum, mTableOrder, mTalbeTotal;

        public MyViewHolder(@NonNull View view) {
            super(view);
            mTableNum = view.findViewById(R.id.tablenum);
            mTableOrder = view.findViewById(R.id.tableorder);
            mTalbeTotal = view.findViewById(R.id.textViewTotal);
        }
    }
}