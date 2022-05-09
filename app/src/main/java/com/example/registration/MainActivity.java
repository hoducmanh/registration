package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    boolean invalid = false;
    String Colector="";
    TextView txtalertName;
    EditText UserName,UserMssv,UserCccd,UserPhoneNum,UserHomeCountry,UserEmail,UserPlace;
    Button SubmitSave;
    RadioButton Malebtn,Femalbtn;
    CheckBox c,java,python;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.SpCountry);
        UserName=findViewById(R.id.userName);
        UserMssv=findViewById(R.id.userMssv);
        UserCccd=findViewById(R.id.userCccd);
        UserPhoneNum=findViewById(R.id.userPhoneNum);
        UserHomeCountry=findViewById(R.id.userHomeCountry);
        UserEmail=findViewById(R.id.userEmail);
        UserPlace=findViewById(R.id.userPlace);
        txtalertName=findViewById(R.id.userAlert);
        Malebtn =findViewById(R.id.Male);
        Femalbtn=findViewById(R.id.Female);
        c=findViewById(R.id.C);
        java=findViewById(R.id.Java);
        python=findViewById(R.id.Python);
        SubmitSave=findViewById(R.id.btnSubmit);
        SubmitSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = UserName.getText().toString();
                String MSSV=UserMssv.getText().toString();
                String CCCD=UserCccd.getText().toString();
                String homeCountry=UserHomeCountry.getText().toString();
                String phonenum=UserPhoneNum.getText().toString();
                String email=UserEmail.getText().toString();
                String place=UserPlace.getText().toString();

                if (name.isEmpty()){
                    Toast.makeText(MainActivity.this,"Pleas fill the password field",Toast.LENGTH_SHORT).show();
                }


                else if(MSSV.isEmpty()){
                    Toast.makeText(MainActivity.this,"Pleas fill the password field",Toast.LENGTH_SHORT).show();
                }


                else if (CCCD.isEmpty()){
                    Toast.makeText(MainActivity.this,"Pleas fill the Contact field",Toast.LENGTH_SHORT).show();
                }

                else if (phonenum.isEmpty()){
                    Toast.makeText(MainActivity.this,"Pleas fill the Comment field",Toast.LENGTH_SHORT).show();
                }

                else if (homeCountry.isEmpty()){
                    Toast.makeText(MainActivity.this,"Pleas fill the Comment field",Toast.LENGTH_SHORT).show();
                }

                else if (place.isEmpty()){
                    Toast.makeText(MainActivity.this,"Pleas fill the Comment field",Toast.LENGTH_SHORT).show();
                }

                else if (email.isEmpty()){
                    Toast.makeText(MainActivity.this,"Pleas fill the Comment field",Toast.LENGTH_SHORT).show();
                }
                else{
                    Colector+=name+"\n";
                    Colector+=MSSV+"\n";
                    Colector+=CCCD+"\n";
                    Colector+=phonenum+"\n";
                    Colector+=homeCountry+"\n";
                    Colector+=place+"\n";
                    Colector+=email+"\n";
                    if (c.isChecked()){
                        Colector+="C"+"\n";
                        if (java.isChecked()){
                            Colector+="Java"+"\n";
                        }
                        if (python.isChecked()){
                            Colector+="Python"+"\n";
                        }
                    }
                    Toast.makeText(MainActivity.this,"User Info \n:"+Colector,Toast.LENGTH_SHORT).show();
                }

            }
        });

        List<String> categorySubject=new ArrayList<>();
        categorySubject.add("Chọn môn học");
        categorySubject.add("Kỹ thuật máy tính");
        categorySubject.add("Khoa học máy tính");
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categorySubject);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if(parent.getItemAtPosition(position).equals("Chọn môn học")){
                    //Do Nothing

                }
                else{
                    String item=parent.getItemAtPosition(position).toString();
                    Colector+=item+"\n";
                    Toast.makeText(MainActivity.this, "Môn học đã chọn: "+item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}