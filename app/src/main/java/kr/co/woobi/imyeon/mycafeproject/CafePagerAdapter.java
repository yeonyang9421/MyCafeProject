package kr.co.woobi.imyeon.mycafeproject;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CafePagerAdapter extends FragmentPagerAdapter {
int mNumOfTab;
private String[] mPageTitles;

    public CafePagerAdapter(FragmentManager fm, String[] pageTitles) {
        super(fm);
        mPageTitles=pageTitles;
    }



    public CafePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                PageOneFragment tab1=new PageOneFragment();
                return tab1;
            case 1:
                PageTwoFragment tab2=new PageTwoFragment();
                return tab2;
            case 2:
                PageThreeFragment tab3=new PageThreeFragment();
                return tab3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       return mPageTitles[position];
    }
}