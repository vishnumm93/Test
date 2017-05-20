package vishnu.in.test;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import vishnu.in.test.OneFragment;
import vishnu.in.test.TwoFragment;
import vishnu.in.test.ThreeFragment;



public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ViewPager.OnPageChangeListener {

    private ViewPager mPager;
    private LinearLayout mDotsLayout;
    private int mDotsCount;
    static TextView mDotsText[];
    private int mPosition = 0;
    private ImageAdapter mAdapter;
    private ViewPager viewPager;

    public ArrayList<String> SampleArrayList = new ArrayList<String>();
    private TabLayout tabLayout;
    private Integer[] IMAGES= {R.mipmap.video,R.mipmap.image,R.mipmap.miles};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mPager = (ViewPager) findViewById(R.id.image_pagerview);
        mDotsLayout = (LinearLayout) findViewById(R.id.image_count);
        mPager.addOnPageChangeListener(this);
        mAdapter = new ImageAdapter(getApplicationContext());

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons1();

        loadimages();


    }

//    private void setupTabIcons() {
//
//        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabOne.setText("VIDEOS");
//        // tabOne.setTextColor(Color.parseColor("#f44141"));
//        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.video, 0, 0);
//        tabLayout.getTabAt(0).setCustomView(tabOne);
//
//        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabTwo.setText("IMAGES");
//        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.image, 0, 0);
//        tabLayout.getTabAt(1).setCustomView(tabTwo);
//
//        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabThree.setText("MILESTONE");
//        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.miles, 0, 0);
//        tabLayout.getTabAt(2).setCustomView(tabThree);
//
//
//    }
    private void setupTabIcons1() {
        tabLayout.getTabAt(0).setIcon(IMAGES[0]).setText("VIDEOS");
        tabLayout.getTabAt(1).setIcon(IMAGES[1]).setText("IMAGES");
        tabLayout.getTabAt(2).setIcon(IMAGES[2]).setText("MILESTONES");
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#e64a19"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#e64a19"), PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "ONE");
        adapter.addFrag(new TwoFragment(), "TWO");
        adapter.addFrag(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void loadimages(){

        String[] arr = {"https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150","https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150","https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150","https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150"};
        // here we count the number of images we have to know how many dots
        // we need
      // mDotsCount = arr.length;

//        for (int i=0;i<size;i++){
//
//            String name = ResponseBody.getProperty().getImages().get(i);
//
//            SampleArrayList.add(name);
//
//            Log.d("name","-"+name);
//        }

        SampleArrayList = new ArrayList<>(Arrays.asList(arr));

        mDotsCount = SampleArrayList.size();

        // mDotsCount = SampleArrayList.size();
        Log.d("sizecount","-"+mDotsCount);
        mDotsText = new TextView[mDotsCount];

        // here we set the dots
        for (int i = 0; i < mDotsCount; i++) {
            mDotsText[i] = new TextView(getApplicationContext());
            mDotsText[i].setText(".");
            mDotsText[i].setTextSize(45);
            mDotsText[i].setTypeface(null, Typeface.BOLD);
            mDotsText[i].setTextColor(android.graphics.Color.GRAY);
            mDotsLayout.addView(mDotsText[i]);
        }
        mAdapter.setList(SampleArrayList);
        mPager.setAdapter(mAdapter);
        // method to set the selected dot color
        setSelectedDotColor(mPosition);
        // Setting the animation for the banner images
        Timer timer = new Timer();
        timer.schedule(new UpdateTimeTask(), 3000, 3000);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        mPosition = position;

        setSelectedDotColor(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setSelectedDotColor(int position) {
        // setting all dot colors to default color
        for (int i = 0; i < mDotsCount; i++) {
            mDotsText[i].setTextColor(getApplicationContext().getResources().getColor(
                    R.color.dark_grey));
        }
        // setting the selected position's color
        mDotsText[position].setTextColor(getApplicationContext().getResources().getColor(
                R.color.magenta));
    }

    class UpdateTimeTask extends TimerTask {
        public void run() {
            mPager.post(new Runnable() {
                public void run() {

                    if (mPager.getCurrentItem() < mAdapter
                            .getCount() - 1) {
                        mPager.setCurrentItem(
                                mPager.getCurrentItem() + 1, true);


                    } else {
                        mPager.setCurrentItem(0, true);

                    }
                }
            });
        }
    }





        @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
