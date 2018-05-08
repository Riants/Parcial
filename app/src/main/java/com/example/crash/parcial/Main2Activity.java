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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        contactList.add(new Contact("Roberto",R.drawable.contact_img,"Henriquez",201264560,1,"roberto@gmail.com","Santa Tecla", dateFormat(1992,4,30)));
        contactList.add(new Contact("Ariel",R.drawable.contact_img,"Castro",201264560,2,"castro@gmail.com","Sonsonate", dateFormat(1996,5,15)));
        contactList.add(new Contact("Christian",R.drawable.contact_img,"Rivera",201264560,3,"rivera@gmail.com","Lourdes", dateFormat(1996,10,9)));
        contactList.add(new Contact("Ricardo",R.drawable.contact_img,"Santillana",201264560,4,"santillana@gmail.com","Queszaltepeq", dateFormat(1992,2,8)));
        contactList.add(new Contact("Melissa",R.drawable.contact_img,"Romero",201264560,5,"romero@gmail.com","Col. Zacamil", dateFormat(1998,5,26)));
        contactList.add(new Contact("Gabriela",R.drawable.contact_img,"Henriquez",201264560,6,"henriquez@gmail.com","Alpes Suizos", dateFormat(1989,8,24)));
        contactList.add(new Contact("Michael",R.drawable.contact_img,"Granados",201264560,7,"granados@gmail.com","Mejicanos", dateFormat(1995,0,26)));
        contactList.add(new Contact("Mercedes",R.drawable.contact_img,"Henriquez",201264560,8,"mercy@gmail.com","Santa Tecla", dateFormat(1963,6,21)));
        contactList.add(new Contact("Alejandro",R.drawable.contact_img,"Flores",201264560,9,"flores@gmail.com","La Paz", dateFormat(1994,10,24)));
        contactList.add(new Contact("Marco",R.drawable.contact_img,"Lopez",201264560,10,"lopez@gmail.com","Cuscatlan", dateFormat(1965,9,15)));
        contactList.add(new Contact("Jose",R.drawable.contact_img,"Hernandez",201264560,11,"hernan@gmail.com","Zacatecoluca", dateFormat(1999,11,31)));
        contactList.add(new Contact("Juan",R.drawable.contact_img,"Monterrosa",201264560,12,"juancho@gmail.com","Europa", dateFormat(1992,6,12)));
        contactList.add(new Contact("Rigoberta",R.drawable.contact_img,"Menchu",201264560,13,"rigo@gmail.com","Guatemala", dateFormat(1978,3,6)));
        contactList.add(new Contact("Jorge",R.drawable.contact_img,"Alas",201264560,14,"dalas@gmail.com","Europa", dateFormat(1992,8,25)));
        contactList.add(new Contact("Alberto",R.drawable.contact_img,"Aquino",201264560,15,"aquino@gmail.com","Merliot", dateFormat(1984,8,15)));
        contactList.add(new Contact("Fatima",R.drawable.contact_img,"Alfaro",201264560,16,"fati@gmail.com","Taiwan", dateFormat(1996,5,5)));


        /*Intent intent = getIntent();

        if (intent != null) {
            String name = intent.getExtras().getString("name");
            String lastname = intent.getExtras().getString("lastname");
            int phone = intent.getExtras().getInt("phone");
            String email = intent.getExtras().getString("email");
            String address = intent.getExtras().getString("address");
            String bithdate = intent.getExtras().getString("birthdate");
            int id = intent.getExtras().getInt("id");
            contactList.add(new Contact(name, R.drawable.contact_img, lastname, phone, id, email, address, bithdate));
        }
        */

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

    public String dateFormat(int year, int month, int dayOfMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        return dateString;
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

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
