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

public class MRecyclerAdapter extends RecyclerView.Adapter<MRecyclerAdapter.MyViewHolder> {
    ArrayList<HashMap<String, Object>> arrayList = null;
    private SQLiteDatabase mdb;
    int i = 0;
    int total = 0;
    ArrayList<Integer> arrprice = new ArrayList<>();
    //멤버변수 선언 필요
    TextView mparentTextview;

    //매개변수로 텍스트뷰를 가져온다.
    public MRecyclerAdapter(SQLiteDatabase db,TextView parentTextview) {
        mdb = db;
        mparentTextview=parentTextview;
        String query = new StringBuilder().append(DBHelper.SQL_SELECT_ENTRIES).toString();
        Cursor cursor = mdb.rawQuery(query, null);
        ArrayList<HashMap<String, Object>> arrayList1 = new ArrayList<>();

        HashMap<String, Object> hashMap = null;

        while (cursor.moveToNext()) {
            int[] image = {R.drawable.americano, R.drawable.capuccino, R.drawable.latte, R.drawable.moca};
            hashMap = new HashMap<String, Object>();
            hashMap.put("menu", cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_MENU_NAME)));
            hashMap.put("price", cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PRICE)));
            hashMap.put("count", cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_COUNT)));
            hashMap.put("image", image[i]);
            arrayList1.add(hashMap);
            String str = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PRICE));
            arrprice.add(Integer.parseInt(str));
            i++;
        }
        this.arrayList = arrayList1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cardlayout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        HashMap<String, Object> hashMap = arrayList.get(position);
        holder.mItemmenu.setText((String) hashMap.get("menu"));
        holder.mItemcount.setText((String) hashMap.get("count"));
        holder.mItemprice.setText((String) hashMap.get("price"));
        holder.mItemImage.setImageResource((Integer) hashMap.get("image"));
        holder.mItemcount.setText("0");


        holder.mItemImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Toast.makeText(v.getContext(), "주문이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                Integer c = Integer.parseInt(((TextView) holder.mItemcount).getText().toString()) + 1;
                ((TextView) holder.mItemcount).setText(c.toString());
                //   int p2= holder.getLayoutPosition();

                plusTotal(v, holder);
            }
        });


        holder.mbuttonMinus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String count = ((TextView) holder.mItemcount).getText().toString();
                if (count.equals("0") || count == null) {
                    ((TextView) holder.mItemcount).setText("0");
                } else {
                    Integer c = Integer.parseInt(((TextView) holder.mItemcount).getText().toString()) - 1;
                    ((TextView) holder.mItemcount).setText(c.toString());

                    minusTotal(v, holder);

                }
            }
        });
    }

    private void minusTotal(View v, @NonNull MyViewHolder holder) {

        total -= arrprice.get(holder.getLayoutPosition());
        Toast.makeText(v.getContext(), "Total : " + String.valueOf(total), Toast.LENGTH_SHORT).show();
        mparentTextview.setText( "Total : " + String.valueOf(total));


    }

    private void plusTotal(View v, @NonNull MyViewHolder holder) {
        total += arrprice.get(holder.getLayoutPosition());
        Toast.makeText(v.getContext(), "Total : " + String.valueOf(total), Toast.LENGTH_SHORT).show();
        mparentTextview.setText( String.valueOf("Total : " +  total));
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mItemImage;
        public TextView mItemmenu, mItemprice, mItemcount;
        public Button mbuttonMinus;


        public MyViewHolder(@NonNull View view) {
            super(view);

            mItemImage = (ImageView) view.findViewById(R.id.item_image);
            mItemmenu = (TextView) view.findViewById(R.id.item_menu);
            mItemprice = (TextView) view.findViewById(R.id.item_price);
            mItemcount = (TextView) view.findViewById(R.id.item_count);
            mbuttonMinus = (Button) view.findViewById(R.id.delete);
        }
    }
}