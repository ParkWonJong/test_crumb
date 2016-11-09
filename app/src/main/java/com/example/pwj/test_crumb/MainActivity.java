package com.example.pwj.test_crumb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {
    private EditText id, name, phone, email, password;
    private Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkUtil.setNetworkPolicy();
        id = (EditText)findViewById(R.id.editText);
        name = (EditText)findViewById(R.id.editText2);
        phone = (EditText)findViewById(R.id.editText3);
        email = (EditText)findViewById(R.id.editText4);
        password = (EditText)findViewById(R.id.editText5);

        btn_send = (Button)findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PHPRequest request = new PHPRequest("http://1.236.122.117/Data_insert.php");
                    String result = request.PhPtest(String.valueOf(id.getText()),String.valueOf(name.getText()),String.valueOf(phone.getText()),String.valueOf(email.getText()),String.valueOf(password.getText()));
                    if(result.equals("1")){
                        Toast.makeText(getApplication(),"Put success",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplication(),"Put error",Toast.LENGTH_SHORT).show();
                    }
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
            }
        });
    }
}