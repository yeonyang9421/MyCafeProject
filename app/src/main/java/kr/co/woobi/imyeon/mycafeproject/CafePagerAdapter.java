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
            case 3:
                PageFourFragment tab4=new PageFourFragment();
                return tab4;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       return mPageTitles[position];
    }
}
