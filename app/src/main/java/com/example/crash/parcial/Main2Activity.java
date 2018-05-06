package com.example.crash.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List<Contact> contactList;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contactList = new ArrayList<>();
        contactList.add(new Contact("Roberto",R.drawable.contact_img,"Henriquez",201264560,0001,"roberto@gmail.com","Casa", "may 30"));
        contactList.add(new Contact("Ariel",R.drawable.contact_img,"Castro",201264560,0002,"castro@gmail.com","Casa", "Junio 15"));
        contactList.add(new Contact("Christian",R.drawable.contact_img,"Rivera",201264560,0003,"rivera@gmail.com","Casa", "Noviembre 9"));
        contactList.add(new Contact("Ricardo",R.drawable.contact_img,"Santillana",201264560,0004,"santillana@gmail.com","Casa", "Marzo 8"));
        contactList.add(new Contact("Roberto",R.drawable.contact_img,"Henriquez",201264560,0001,"roberto@gmail.com","Casa", "may 30"));
        contactList.add(new Contact("Ariel",R.drawable.contact_img,"Castro",201264560,0002,"castro@gmail.com","Casa", "Junio 15"));
        contactList.add(new Contact("Christian",R.drawable.contact_img,"Rivera",201264560,0003,"rivera@gmail.com","Casa", "Noviembre 9"));
        contactList.add(new Contact("Ricardo",R.drawable.contact_img,"Santillana",201264560,0004,"santillana@gmail.com","Casa", "Marzo 8"));
        contactList.add(new Contact("Roberto",R.drawable.contact_img,"Henriquez",201264560,0001,"roberto@gmail.com","Casa", "may 30"));
        contactList.add(new Contact("Ariel",R.drawable.contact_img,"Castro",201264560,0002,"castro@gmail.com","Casa", "Junio 15"));
        contactList.add(new Contact("Christian",R.drawable.contact_img,"Rivera",201264560,0003,"rivera@gmail.com","Casa", "Noviembre 9"));
        contactList.add(new Contact("Ricardo",R.drawable.contact_img,"Santillana",201264560,0004,"santillana@gmail.com","Casa", "Marzo 8"));
        contactList.add(new Contact("Roberto",R.drawable.contact_img,"Henriquez",201264560,0001,"roberto@gmail.com","Casa", "may 30"));
        contactList.add(new Contact("Ariel",R.drawable.contact_img,"Castro",201264560,0002,"castro@gmail.com","Casa", "Junio 15"));
        contactList.add(new Contact("Christian",R.drawable.contact_img,"Rivera",201264560,0003,"rivera@gmail.com","Casa", "Noviembre 9"));
        contactList.add(new Contact("Ricardo",R.drawable.contact_img,"Santillana",201264560,0004,"santillana@gmail.com","Casa", "Marzo 8"));

        RecyclerView reciclerView = (RecyclerView) findViewById(R.id.reciclerView_list);
        adapter = new RecyclerViewAdapter(this, contactList);
        reciclerView.setLayoutManager(new GridLayoutManager(this, 3));
        reciclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, AddContactActivity.class);
                Main2Activity.this.startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_contact_acivity,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<Contact> newList = new ArrayList<>();
        for (Contact contact: contactList){
            String name = contact.getName().toLowerCase();
            if(name.contains(newText)){
                newList.add(contact);
            }
        }

        adapter.setFilter(newList);
        return true;
    }
}
