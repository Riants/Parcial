package com.example.crash.parcial;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class AddContactActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText nameEdit, lastnameEdit, phoneEdit, emailEdit, addressEdit, idEdit;
    private TextView bdayTxt;
    private Button bdayButton, addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameEdit = (EditText) findViewById(R.id.name_edit);
        lastnameEdit = (EditText) findViewById(R.id.lastname_edit);
        phoneEdit = (EditText) findViewById(R.id.phone_edit);
        emailEdit = (EditText) findViewById(R.id.email_edit);
        addressEdit = (EditText) findViewById(R.id.address_edit);
        idEdit = (EditText) findViewById(R.id.id_edit);
        bdayTxt = (TextView) findViewById(R.id.Bday);
        bdayButton = (Button) findViewById(R.id.buttonBday);
        addButton = (Button) findViewById(R.id.buttonAdd);

        bdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment datePick = new DatePickerFragment();
                datePick.show(getSupportFragmentManager(),"date picker");
            }
        });

        if (savedInstanceState != null){
            nameEdit.setText(savedInstanceState.getString("name"));
            lastnameEdit.setText(savedInstanceState.getString("lastname"));
            phoneEdit.setText(savedInstanceState.getString("phone"));
            emailEdit.setText(savedInstanceState.getString("email"));
            addressEdit.setText(savedInstanceState.getString("address"));
            idEdit.setText(savedInstanceState.getString("id"));
            bdayTxt.setText(savedInstanceState.getString("birthday"));
        }



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddContactActivity.this, Main2Activity.class);
                intent.putExtra("name",nameEdit.getText());
                intent.putExtra("lastname",lastnameEdit.getText());
                intent.putExtra("phone",phoneEdit.getText());
                intent.putExtra("email",emailEdit.getText());
                intent.putExtra("address",addressEdit.getText());
                intent.putExtra("birthday",bdayTxt.getText());
                intent.putExtra("id",idEdit.getText());
                AddContactActivity.this.startActivity(intent);

            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        bdayTxt = (TextView) findViewById(R.id.Bday);
        bdayTxt.setText(dateString);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("name",nameEdit.toString());
        outState.putString("lastname",lastnameEdit.toString());
        outState.putString("phone",phoneEdit.toString());
        outState.putString("email",emailEdit.toString());
        outState.putString("address",addressEdit.toString());
        outState.putString("birthday",bdayTxt.getText().toString());
        outState.putString("id",idEdit.toString());

        super.onSaveInstanceState(outState);
    }
}
