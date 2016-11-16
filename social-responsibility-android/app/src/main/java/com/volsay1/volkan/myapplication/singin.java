package com.volsay1.volkan.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class singin extends Activity {
    TextView Sing_up_layout, Forget_password_layout;
    EditText emailET, pwdET;
    ProgressDialog prgDialog;
    Button btn;
    CheckBox goster;
    String Error_String;
    int durum,tip;
    String ErrorString="",AlertString,mesaj;

    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Sing_up_layout = (TextView) findViewById(R.id.createAccount);
        emailET = (EditText) findViewById(R.id.login_emailid);
        pwdET = (EditText) findViewById(R.id.login_password);

        builder = new AlertDialog.Builder(singin.this);
        builder.setTitle("Merhaba");
        builder.setMessage(AlertString);


        goster = (CheckBox) findViewById(R.id.show_hide_password);
        prgDialog = new ProgressDialog(this);
        prgDialog.setCancelable(false);

        goster.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//parola visible
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (goster.isChecked()) {
                    pwdET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    pwdET.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

        Sing_up_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//kayıt ol layout
                Intent yeni = new Intent(singin.this, Sign_up.class);
                startActivity(yeni);
            }
        });
        Forget_password_layout = (TextView) findViewById(R.id.forgot_password);

        Forget_password_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//unuttum layout
                Intent yeni = new Intent(singin.this, Forget.class);
                startActivity(yeni);
            }
        });
        btn = (Button) findViewById(R.id.loginBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailET.getText().toString().trim();
                final String password = pwdET.getText().toString().trim();

                if (email.matches("") || password.matches("")) {
                    Error_String = "";
                    if (email.matches("")) {

                        Error_String += "* Kullanıcı Adı Boş Lütfen Doldorunuz\n";

                    }
                    if (password.matches("")) {

                        Error_String += "* Şifre Boş Lütfen Doldorunuz\n";

                    }
                    alertMesaj(ErrorString);
                }else {
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest sr = new StringRequest(Request.Method.POST, "http://eticaret.merkezyazilim.com/service/giris", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            try {

                                JSONObject obj = new JSONObject(response);
                                durum = obj.getInt("durum");
                                tip = obj.getInt("type");
                                mesaj = obj.getString("mesaj");
                                if (durum == 0) {

                                    if (tip == 1) {
                                        alertMesaj("Veriler Gönderilemedi Lütfen Daha Sonra Tekrar Deneyin");

                                    } else if (tip == 2) {

                                        alertMesaj(mesaj);

                                    } else if (tip == 3) {

                                        alertMesaj("Sunucuya Erişilemedi");
                                    } else if (tip == 4) {
                                        alertMesaj("Kullanıcı Adı ve Şifre Hatalı");

                                    } else if (tip == 5) {

                                        alertMesaj(mesaj);
                                    }

                                } else if (durum == 1) {

                                    if (tip == 0) {

                                       Intent ıntent=new Intent(getApplicationContext(),Anasayfa.class);
                                        startActivity(ıntent);


                                    }

                                }


                                Log.d("My App", obj.toString());

                            } catch (Throwable t) {
                                Log.e("My App", "Could not parse malformed JSON: \"" + response + "\"");
                                alertMesaj(t.getMessage());
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            alertMesaj("SQLite ile hata durumları eklenecek");
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("kadi", email);
                            params.put("sifre", password);

                            return params;
                        }

                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("Content-Type", "application/x-www-form-urlencoded");
                            return params;
                        }
                    };
                    queue.add(sr);


            }
        }



    });


    }
    public void alertMesaj(String mesaj){

        builder.setMessage(mesaj);
        builder.show();

    }
}