package kr.co.woobi.imyeon.mycafeproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar=findViewById(R.id.toolbar);
        TabLayout mTab = findViewById(R.id.tabs);
        ViewPager  mViewPager=findViewById(R.id.viewpager);
        CafePagerAdapter mCafePagerAdapter= new CafePagerAdapter(getSupportFragmentManager(), new String[]{"주문현황", "Take-out","매출현황"});
        mViewPager.setAdapter(mCafePagerAdapter);
        mTab.setupWithViewPager(mViewPager);
    }
}
