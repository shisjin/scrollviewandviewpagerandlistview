package com.qianfeng.scrollviewandviewpagerandlistview;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private List<Fragment> fragmentList;

    private List<String> titles;

    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        initViewPager();
    }

    private void initViewPager() {
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }


            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        };
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, true);
        addTabLayout();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("info", viewPager.getHeight() + "");
            }
        }, 2000);
    }

//    private ImageView getImageView(int resId) {
//        ImageView iv = new ImageView(this);
//        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        BitmapFactory.Options option = new BitmapFactory.Options();
//        option.inJustDecodeBounds = false;
//        option.inSampleSize = 4;
//        Bitmap bm = BitmapFactory.decodeResource(getResources(), resId);
//        iv.setImageBitmap(bm);
//        return iv;
//    }


    private void addTabLayout() {
        Fragment fragment = new InfoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count", 50);
        fragment.setArguments(bundle);
        fragmentList.add(fragment);

        fragment = new InfoFragment();
        bundle = new Bundle();
        bundle.putInt("count", 5);
        fragment.setArguments(bundle);
        fragmentList.add(fragment);

        fragment = new InfoFragment();
        bundle = new Bundle();
        bundle.putInt("count", 20);
        fragment.setArguments(bundle);
        fragmentList.add(fragment);


        fragment = new InfoFragment();
        bundle = new Bundle();
        bundle.putInt("count", 13);
        fragment.setArguments(bundle);
        fragmentList.add(fragment);

        fragment = new InfoFragment();
        bundle = new Bundle();
        bundle.putInt("count", 41);
        fragment.setArguments(bundle);
        fragmentList.add(fragment);

        fragment = new InfoFragment();
        bundle = new Bundle();
        bundle.putInt("count", 100);
        fragment.setArguments(bundle);
        fragmentList.add(fragment);

        fragment = new InfoFragment();
        bundle = new Bundle();
        bundle.putInt("count", 50);
        fragment.setArguments(bundle);
        fragmentList.add(fragment);
        for (int i = 0; i < fragmentList.size(); i++) {
            titles.add("page" + i);
        }
        adapter.notifyDataSetChanged();
    }
}
