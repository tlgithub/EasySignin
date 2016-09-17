package com.easysignin.easysignin;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.view.ViewGroup;

import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView classRecycler;
    private List<Integer> markers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        markers = Arrays.asList(R.drawable.circle,R.drawable.circle2,R.drawable.circle3
                ,R.drawable.circle4,R.drawable.circle5,R.drawable.circle6);
        classRecycler = (RecyclerView) findViewById(R.id.class_recycler);
        classRecycler.setLayoutManager(new LinearLayoutManager(this));
        classRecycler.setAdapter(new ClassAdapter(markers));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.scan) {
            Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.work) {


        } else if (id == R.id.data) {

        } else if (id == R.id.setting) {

        }else if (id == R.id.about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class ClassAdapter extends RecyclerView.Adapter<ClassViewHolder> {
        private List<Integer> markers;
        public ClassAdapter(List<Integer> markers) {
            this.markers = markers;
        }

        @Override
        public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.classitem,null);
            return new ClassViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ClassViewHolder holder, int position) {
            holder.timelineView.setMarkerDrawable(getResources().getDrawable(markers.get(position%6)));

        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }

    private class ClassViewHolder extends RecyclerView.ViewHolder{
        private TimelineView timelineView;
        public ClassViewHolder(View itemView) {
            super(itemView);
            timelineView = (TimelineView) itemView.findViewById(R.id.timeline);
        }
    }
}
