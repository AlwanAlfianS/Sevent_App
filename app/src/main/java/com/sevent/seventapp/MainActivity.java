package com.sevent.seventapp;

import android.app.SearchManager;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sevent.seventapp.Adapter.TabPagerAdapter;
import com.sevent.seventapp.Category.CategoryFrag;
import com.sevent.seventapp.MyEvent.MyEventFrag;
import com.sevent.seventapp.Profile.ProfileFrag;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    TabLayout tabs;
    Toolbar toolbar;
    ViewPager pager;
    TabPagerAdapter adapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        setSupportActionBar(toolbar);

        adapter.setFragmentList(new TimelineFrag());
        adapter.setFragmentList(new CategoryFrag());
        adapter.setFragmentList(new MyEventFrag());
        adapter.setFragmentList(new ProfileFrag());

        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        tabs.setOnTabSelectedListener(this);
        setIcon();
    }

    private void setIcon() {
        int icons[] = {R.drawable.time, R.drawable.kategori, R.drawable.calendar,
                R.drawable.user};
        for(int x =0; x< tabs.getTabCount(); x++){
            tabs.getTabAt(x).setIcon(icons[x]);
        }
    }

    private void initComponent() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new TabPagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        searchView = (SearchView)item.getActionView();
        SearchManager searchManager = (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
        searchView.setQueryHint("Search...");
        searchView.setIconifiedByDefault(false);
        return super.onCreateOptionsMenu(menu);
    }
}
