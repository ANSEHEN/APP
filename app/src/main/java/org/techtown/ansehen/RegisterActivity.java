package org.techtown.ansehen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText nameText;
    EditText pwText;
    EditText phoneText;

    String loginName;
    String loginPw;
    String loginPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        nameText = (EditText)findViewById(R.id.nameText);
        pwText = (EditText)findViewById(R.id.pwText);
        phoneText = (EditText)findViewById(R.id.phoneText);


        Button submit = (Button)findViewById(R.id.registerButton);
        submit.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                loginName = nameText.getText().toString().trim();
                loginPw = pwText.getText().toString().trim();
                loginPhone = phoneText.getText().toString().trim();

                new Thread(new Runnable() {

                    public void run() {

                        runOnUiThread(new Runnable() {

                            public void run() {
                                //messageText.setText("uploading started.....");
                            }
                        });
                        EditText nameText = (EditText)findViewById(R.id.nameText);
                        EditText pwText = (EditText)findViewById(R.id.pwText);
                        EditText phoneText = (EditText)findViewById(R.id.phoneText);

                        String name = nameText.getText().toString();
                        String password = pwText.getText().toString();
                        String inputPhone = phoneText.getText().toString();
                        String phonenum = "010-7777-7777";
                        //Log.e(TAG,"name : "+name);
                        //Log.e(TAG,"passWord : "+password);
                        //Log.e(TAG,"inputPhone : "+inputPhone);

                        httpClient http = new httpClient();
                        http.HttpFileUpload(name,password,phonenum,inputPhone);
                    }
                }).start();
                Intent registerIntent = new Intent(RegisterActivity.this, CameraActivity.class);
                RegisterActivity.this.startActivity(registerIntent);
            }
        });
    }

}
