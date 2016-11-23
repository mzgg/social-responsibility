package com.volsay1.volkan.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
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



public class Sign_up extends Activity {
    TextView Login_repeat;
    Button kButton;
    AlertDialog.Builder builder;

    EditText kEditKullanici, kEditEmail, kEditPassword, kEditAdi, kEditSoyadi, kEditTelefon;
    String RegisterAdi, RegisterSoyadi, RegisterKadi, RegisterSifre, RegisterTelno, RegisterEmail, mesaj, ErrorString = "";
    int durum, tip;
    CheckBox onay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singup_layout);

        Login_repeat = (TextView) findViewById(R.id.already_user);
        Login_repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yeni = new Intent(Sign_up.this, singin.class);
                startActivity(yeni);
            }
        });
        builder = new AlertDialog.Builder(Sign_up.this);
        builder.setTitle("Kayit ol");
        builder.setMessage("");

        kButton = (Button) findViewById(R.id.signUpBtn);
        kEditKullanici = (EditText) findViewById(R.id.k_adi);
        kEditEmail = (EditText) findViewById(R.id.userEmailId);
        kEditPassword = (EditText) findViewById(R.id.password);
        kEditAdi = (EditText) findViewById(R.id.name);
        kEditSoyadi = (EditText) findViewById(R.id.surname);
        kEditTelefon = (EditText) findViewById(R.id.phone);
        onay = (CheckBox) findViewById(R.id.terms_conditions);

        kButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegisterAdi = kEditAdi.getText().toString().trim();
                RegisterSoyadi = kEditSoyadi.getText().toString().trim();
                RegisterKadi = kEditKullanici.getText().toString().trim();
                RegisterSifre = kEditPassword.getText().toString().trim();
                RegisterEmail = kEditEmail.getText().toString().trim();
                RegisterTelno = kEditTelefon.getText().toString().trim();
                if (RegisterEmail.matches("") || RegisterAdi.matches("") || RegisterSoyadi.matches("") || RegisterSifre.matches("")) {
                    ErrorString = "";
                    if (RegisterEmail.matches("")) {

                        ErrorString += "* Email Boþ Lütfen Doldorunuz\n";
                    }
                    if (RegisterAdi.matches("")) {

                        ErrorString += "* Adiniz Boþ Lütfen Doldorunuz\n";
                    }
                    if (RegisterSoyadi.matches("")) {

                        ErrorString += "* Soyadiniz Boþ Lütfen Doldorunuz\n";

                    }
                    if (RegisterSifre.matches("")) {

                        ErrorString += "* Þifreniz Boþ Lütfen Doldorunuz\n";

                    }
                    if (RegisterTelno.matches("")) {

                        ErrorString += "* Telefon Numarnaýz Boþ Lütfen Doldorunuz\n";

                    }

                    Toast.makeText(Sign_up.this, ErrorString, Toast.LENGTH_SHORT).show();

                } else {

                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest sr = new StringRequest(Request.Method.POST, "http://eticaret.merkezyazilim.com/service/kayit", new Response.Listener<String>() {
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

                                        alertMesaj("Sunucuya Eriþilemedi");
                                    } else if (tip == 4) {
                                        alertMesaj("KullanıcıAdı ve Şifre Hatalı");

                                    } else if (tip == 5) {

                                        alertMesaj(mesaj);
                                    }

                                } else if (durum == 1) {


                                    Intent RegisterdenAnasayfaya = new Intent(getApplicationContext(), Anasayfa.class);
                                    startActivity(RegisterdenAnasayfaya);

                                }


                                Log.d("My App", obj.toString());

                            } catch (Throwable t) {
                                Log.e("My App", "Could not parse malformed JSON: \"" + response + "\"");
                                alertMesaj("Bir problemle karþýlaþtýk, Hatayý bize bildirin");
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            alertMesaj("SQLite ile hata durumlarý eklenecek");
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("adi", RegisterAdi);
                            params.put("soyadi", RegisterSoyadi);
                            params.put("kadi", RegisterKadi);
                            params.put("sifre", RegisterSifre);
                            params.put("email", RegisterEmail);
                            params.put("tel", RegisterTelno);

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


    public void alertMesaj(String mesaj) {
        builder.setMessage(mesaj);
        builder.show();



}




}


