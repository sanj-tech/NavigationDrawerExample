package com.jsstech.navigationdrawerex;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Floating Button is clicked",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();
                Toast.makeText(MainActivity.this,"floating button",Toast.LENGTH_SHORT).show();
            }
        });



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment=new HomeFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout1,homeFragment,homeFragment.getTag()).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.course:
                Toast.makeText(this,"You are selected course",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bca:
                Toast.makeText(this," selected bca",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mca:
                Toast.makeText(this,"mca",Toast.LENGTH_SHORT).show();
                break;
        }




        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                //Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
                HomeFragment homeFragment=new HomeFragment();
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layout1,homeFragment,homeFragment.getTag()).commit();
                break;

            case R.id.nav_gallery:
               Galleryragment galleryragment=new Galleryragment();
                FragmentManager fragmentManager1=getSupportFragmentManager();
                fragmentManager1.beginTransaction().replace(R.id.layout1,galleryragment,galleryragment.getTag()).commit();

                //Toast.makeText(this,"Gallery",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_slideshow:
                SlideShowFragment slideShowFragment=new SlideShowFragment();
                FragmentManager fragmentManager2=getSupportFragmentManager();
                fragmentManager2.beginTransaction().replace(R.id.layout1,slideShowFragment,slideShowFragment.getTag()).commit();

                //Toast.makeText(this,"slideShow",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_play:
                playFragment playFragment=new playFragment();
                FragmentManager fragmentManager3=getSupportFragmentManager();
                fragmentManager3.beginTransaction().replace(R.id.layout1,playFragment,playFragment.getTag()).commit();
                //Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
                break;
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


}