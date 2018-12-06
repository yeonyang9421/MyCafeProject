package kr.co.woobi.imyeon.mycafeproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyCafe.db";
    public static final String TABLE_NAME = "cafe";
    public static final int DATABASE_VESION = 1;
    public static final String COLUMN_MENU_NAME = "menu";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_COUNT = "count";
    public static final String COLUMN_ID = "_id";

    private static final String SQL_CREATE_ETRIES =
            String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT,%s TEXT, %s TEXT)",
                    TABLE_NAME,
                    COLUMN_ID,
                    COLUMN_MENU_NAME,
                    COLUMN_PRICE,
                    COLUMN_COUNT);
    private static final String SQL_DELETE_ENTTIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static final String SQL_SELECT_ENTRIES =
            "SELECT * FROM " + TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VESION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ETRIES);

        String[] names = {"Americano", "Cafelatte", "Capuccino","Moca"};
        String[] prices = {"2000", "4000", "5000","4500"};
        String sql = "insert into cafe values (null, ?, ?, '0')";

        for(int i=0; i<names.length; i++) {
            db.execSQL(sql, new Object[] {names[i], prices[i]});
        }

//        String[] name={"americano","capuccino","latte","moca"};
//        String[] price={"2000", "4500", "4000","5000"};
//        String count="0";
//       db.execSQL("INSERT INTO cafe  VALUES (null,'"+ name + "','" + price + "','" + count + "')");
//        db.execSQL("INSERT INTO cafe  VALUES (null,'"+ name + "','" + price + "','" + count + "')");
//        db.execSQL("INSERT INTO cafe  VALUES (null,'"+ name + "','" + price + "','" + count + "')");

//        for(int i=0; i<3; i++) {
//            String count = " 0 ";
//            String j = String.valueOf(i);
//            String q = "INSERT INTO myorder VALUES (null,'" + j + "', '" + j + "','" + count + "')";
//            db.execSQL(q);
//        }

        //민경샘꺼
//        String name="americano";
//        String price="2000";
//        String count="0";

//        db.execSQL("INSERT INTO cafe  VALUES (null,'"+ name + "','" + price + "','" + count + "')");
//        db.execSQL("INSERT INTO cafe  VALUES (null,'"+ name + "','" + price + "','" + count + "')");
//        db.execSQL("INSERT INTO cafe  VALUES (null,'"+ name + "','" + price + "','" + count + "')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTTIES);
        db.execSQL(SQL_CREATE_ETRIES);
    }
}