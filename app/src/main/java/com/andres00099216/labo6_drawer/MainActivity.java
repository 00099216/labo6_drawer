package com.andres00099216.labo6_drawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private int fragmento = 0;
    public static List<modelo> list = new ArrayList<>();
    private static List<modelo>  list1 = new ArrayList<>();
    private static List<modelo>  list2 = new ArrayList<>();
    private static List<modelo> list3 = new ArrayList<>();
    private static List<modelo>  list4 = new ArrayList<>();
    private static List<modelo>  list5 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            fragmento = savedInstanceState.getInt("SAVE");
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawer = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                asignador_de_lista(item.getOrder());
                fragmento = item.getOrder();
                drawer.closeDrawers();
                return true;
            }
        });

        listas();
        asignador_de_lista(fragmento);
    }
    private void listas() {
        list = new ArrayList<>();

        list1 = new ArrayList<>();
        list1.add(new modelo("Pizza", "Es circular y su caja cuadrada", R.drawable.pizza));


        list2 = new ArrayList<>();
        list2.add(new modelo("Hamburguesa", "pan, carne,carne, queso, tocino y pan", R.drawable.hamburguesa));

        list3 = new ArrayList<>();
        list3.add(new modelo("soda", "Sprite de preferencia", R.drawable.soda));

        list4 = new ArrayList<>();
        list4.add(new modelo("papas", "grandes y con salsa de queso", R.drawable.papas));

        list5 = new ArrayList<>();
        list5.add(new modelo("Pie", "de manzana", R.drawable.pie));
    }
    private void asignador_de_lista(int id){
        switch (id){
            case 0:
                list = list1;
                break;
            case 1:
                list = list2;
                break;
            case 2:
                list = list3;
                break;
            case 3:
                list = list4;
                break;
            case 4:
                list = list5;
                break;
        }
        MenuFragmento fragment = new MenuFragmento();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contentLayout, fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("SAVE", fragmento);
        super.onSaveInstanceState(savedInstanceState);
    }
}