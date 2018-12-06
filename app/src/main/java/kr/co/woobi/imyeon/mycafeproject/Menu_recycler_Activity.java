package kr.co.woobi.imyeon.mycafeproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.TextView;

public class Menu_recycler_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView mtextViewTotal;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    SQLiteDatabase mdb;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recycler_view);

        mtextViewTotal=(TextView)findViewById(R.id.textViewTotal);
        dbHelper=new DBHelper(this);
        mdb=dbHelper.getWritableDatabase();

        //textview를 인수로 어댑터한테 넘겨준다.
        adapter=new MRecyclerAdapter(mdb,mtextViewTotal);


        //  getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        ArrayList<HashMap<String,Object>> arrayList= new ArrayList<HashMap<String, Object>>();
//        HashMap<String,Object> hashMap=null;
//        hashMap=new HashMap<String, Object>();
//        hashMap.put("menu","Americano");
//        hashMap.put("price","2500");
//        hashMap.put("count","0");
//        hashMap.put("image",R.drawable.americano);
//        arrayList.add(hashMap);
//
//        hashMap=null;
//        hashMap=new HashMap<String, Object>();
//        hashMap.put("menu","capuccino");
//        hashMap.put("price","4000");
//        hashMap.put("count","0");
//        hashMap.put("image",R.drawable.capuccino);
//        arrayList.add(hashMap);
//
//        hashMap=null;
//        hashMap=new HashMap<String, Object>();
//        hashMap.put("menu","latte");
//        hashMap.put("price","4500");
//        hashMap.put("count","0");
//        hashMap.put("image",R.drawable.latte);
//        arrayList.add(hashMap);

        recyclerView=(RecyclerView)findViewById(R.id.menu_recycler_view);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);;
        //adapter=new MRecyclerAdapter(arrayList);

        recyclerView.setAdapter(adapter);
    }
}