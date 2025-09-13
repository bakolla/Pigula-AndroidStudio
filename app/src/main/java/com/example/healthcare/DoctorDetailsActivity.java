package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Imię: Jan Kowalski", "Adres: Warszawa", "Doświadczenie: 5 lat", "Telefon: 123456789", "600"},
                    {"Imię: Anna Nowak", "Adres: Kraków", "Doświadczenie: 15 lat", "Telefon: 987654321", "900"},
                    {"Imię: Piotr Wiśniewski", "Adres: Gdańsk", "Doświadczenie: 8 lat", "Telefon: 234567890", "300"},
                    {"Imię: Maria Wójcik", "Adres: Wrocław", "Doświadczenie: 6 lat", "Telefon: 456789123", "500"},
                    {"Imię: Krzysztof Zieliński", "Adres: Poznań", "Doświadczenie: 7 lat", "Telefon: 567890234", "800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Imię: Katarzyna Kowal", "Adres: Warszawa", "Doświadczenie: 5 lat", "Telefon: 123456789", "600"},
                    {"Imię: Ewa Kamińska", "Adres: Kraków", "Doświadczenie: 15 lat", "Telefon: 987654321", "900"},
                    {"Imię: Zofia Kaczmarek", "Adres: Gdańsk", "Doświadczenie: 8 lat", "Telefon: 234567890", "300"},
                    {"Imię: Tomasz Woźniak", "Adres: Wrocław", "Doświadczenie: 6 lat", "Telefon: 456789123", "500"},
                    {"Imię: Alicja Nowak", "Adres: Poznań", "Doświadczenie: 7 lat", "Telefon: 567890234", "800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Imię: Adam Majewski", "Adres: Warszawa", "Doświadczenie: 4 lata", "Telefon: 123456789", "200"},
                    {"Imię: Andrzej Lewandowski", "Adres: Kraków", "Doświadczenie: 5 lat", "Telefon: 987654321", "300"},
                    {"Imię: Monika Duda", "Adres: Gdańsk", "Doświadczenie: 7 lat", "Telefon: 234567890", "300"},
                    {"Imię: Paweł Szymański", "Adres: Wrocław", "Doświadczenie: 6 lat", "Telefon: 456789123", "500"},
                    {"Imię: Michał Walczak", "Adres: Poznań", "Doświadczenie: 7 lat", "Telefon: 567890234", "600"}
            };
    private String[][] doctor_details4 =
            {
                    {"Imię: Wojciech Kwiatkowski", "Adres: Warszawa", "Doświadczenie: 5 lat", "Telefon: 123456789", "600"},
                    {"Imię: Damian Bąk", "Adres: Kraków", "Doświadczenie: 15 lat", "Telefon: 987654321", "900"},
                    {"Imię: Bartosz Zieliński", "Adres: Gdańsk", "Doświadczenie: 8 lat", "Telefon: 234567890", "300"},
                    {"Imię: Łukasz Stępień", "Adres: Wrocław", "Doświadczenie: 6 lat", "Telefon: 456789123", "500"},
                    {"Imię: Grzegorz Sadowski", "Adres: Poznań", "Doświadczenie: 7 lat", "Telefon: 567890234", "800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Imię: Aleksander Sobczak", "Adres: Warszawa", "Doświadczenie: 5 lat", "Telefon: 123456789", "1600"},
                    {"Imię: Daniel Kaczmarek", "Adres: Kraków", "Doświadczenie: 15 lat", "Telefon: 987654321", "1900"},
                    {"Imię: Piotr Wróbel", "Adres: Gdańsk", "Doświadczenie: 8 lat", "Telefon: 234567890", "1300"},
                    {"Imię: Michał Zieliński", "Adres: Wrocław", "Doświadczenie: 6 lat", "Telefon: 456789123", "1500"},
                    {"Imię: Wojciech Włodarczyk", "Adres: Poznań", "Doświadczenie: 7 lat", "Telefon: 567890234", "1800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}