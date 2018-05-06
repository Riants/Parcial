package com.example.crash.parcial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class contact_activity extends AppCompatActivity {

    private TextView nameView, lastnameView, phoneView, emailView, addressView, birthdateView, idView;
    private ImageView imageView, callView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        nameView = (TextView) findViewById(R.id.contact_name);
        lastnameView = (TextView) findViewById(R.id.contact_lastname);
        phoneView = (TextView) findViewById(R.id.contact_number);
        emailView = (TextView) findViewById(R.id.contact_email);
        addressView = (TextView) findViewById(R.id.contact_address);
        birthdateView = (TextView) findViewById(R.id.contact_birthdate);
        idView = (TextView) findViewById(R.id.contact_id);
        imageView = (ImageView) findViewById(R.id.contact_image);
        callView = (ImageView) findViewById(R.id.call);


        Intent intent = getIntent();
        final String name = intent.getExtras().getString("name");
        String lastname = intent.getExtras().getString("lastname");
        final int phone = intent.getExtras().getInt("phone");
        String email = intent.getExtras().getString("email");
        String address = intent.getExtras().getString("address");
        String bithdate = intent.getExtras().getString("birthdate");
        int image = intent.getExtras().getInt("image");
        int id = intent.getExtras().getInt("id");

        nameView.setText(name);
        lastnameView.setText(lastname);
        phoneView.setText(phone + "");
        emailView.setText(email);
        addressView.setText(address);
        birthdateView.setText(bithdate);
        idView.setText(id + "");
        imageView.setImageResource(image);
        callView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(contact_activity.this, "No call permission", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,name);
                intent.setType("text/plain");
                startActivity(intent);

            }
        });

    }
}
