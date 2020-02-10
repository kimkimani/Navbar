package com.example.kim.navbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        Toolbar toolbar=(Toolbar) findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar );

        DrawerLayout drawer=(DrawerLayout) findViewById ( R.id.drawer_layout );
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle (
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener ( toggle );
        toggle.syncState ();

        NavigationView navigationView=(NavigationView) findViewById ( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener ( this );
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer=(DrawerLayout) findViewById ( R.id.drawer_layout );
        if ( drawer.isDrawerOpen ( GravityCompat.START ) ) {
            drawer.closeDrawer ( GravityCompat.START );
        } else {
            super.onBackPressed ();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate ( R.menu.main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id=item.getItemId ();

        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_settings ) {
            return true;
        }

        return super.onOptionsItemSelected ( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id=item.getItemId ();

        if ( id == R.id.sportpesa ) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager ().beginTransaction ();
            ft.replace ( R.id.main_content,new Tab1 () );
            Intent i = new Intent ( MainActivity.this,Main2Activity.class );
            startActivity ( i );
            // Handle the camera action
        } else if ( id == R.id.bet365 ) {
            Intent i = new Intent ( MainActivity.this,Main2Activity.class );
            startActivity ( i );

        } else if ( id == R.id.betin ) {
            Intent i = new Intent ( MainActivity.this,Main2Activity.class );
            startActivity ( i );

        } else if ( id == R.id.betway ) {
            Intent i = new Intent ( MainActivity.this,Main2Activity.class );
            startActivity ( i );

        } else if ( id == R.id.xbet ) {
            Intent i = new Intent ( MainActivity.this,Main2Activity.class );
            startActivity ( i );

        } else if ( id == R.id.lolly ) {
            Intent i = new Intent ( MainActivity.this,Main2Activity.class );
            startActivity ( i );

        }
        else if ( id == R.id.naira ) {
            Intent i = new Intent ( MainActivity.this,Main2Activity.class );
            startActivity ( i );
        } else if ( id == R.id.nijaa ) {
            Intent i = new Intent ( MainActivity.this,Main2Activity.class );
            startActivity ( i );
        }



        DrawerLayout drawer=(DrawerLayout) findViewById ( R.id.drawer_layout );
        drawer.closeDrawer ( GravityCompat.START );
        return true;
    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1 (), "Soccer");
        adapter.addFragment(new Tab2(), "Betslip");
        adapter.addFragment(new Tab3(), "Basket");
        adapter.addFragment(new Tab4(), "Rugbay");
        adapter.addFragment(new Tab5(), "Jacport");



        viewPager.setAdapter(adapter);
    }
}
