package com.siso.android.vocalpref;

import static android.view.KeyEvent.KEYCODE_A;
import static android.view.KeyEvent.KEYCODE_E;
import static android.view.KeyEvent.KEYCODE_I;
import static android.view.KeyEvent.KEYCODE_O;
import static android.view.KeyEvent.KEYCODE_U;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnKeyListener, View.OnClickListener {

    TextView txName;
    EditText etContent;
    TextView txVowels;
    Button deleteVowels;
    SharedPreferences.Editor myEditor;
    SharedPreferences Data;
    String strVowels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etContent=(EditText) findViewById(R.id.etContent);
        txVowels=(TextView) findViewById(R.id.txVowels);
        txName=(TextView) findViewById(R.id.txName);
        etContent.setOnKeyListener(this);

        Data=getSharedPreferences("preferences",0);
        myEditor=Data.edit();
        strVowels=Data.getString("vowels","aeiou");
        txVowels.setText(strVowels);

        deleteVowels=(Button) findViewById(R.id.btDeleteVowels);
        deleteVowels.setOnClickListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();

        strVowels=txVowels.getText().toString();
        myEditor.putString("vowels",strVowels);
        myEditor.apply();
    }

    public boolean onKey(View v, int keyCode, KeyEvent event){

        if ((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode==KEYCODE_A)){
            txVowels.append("a");
        }else if ((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode==KEYCODE_E)){
            txVowels.append("e");
        }else if ((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode==KEYCODE_I)){
            txVowels.append("i");
        }else if ((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode==KEYCODE_O)){
            txVowels.append("o");
        }else if ((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode==KEYCODE_U)){
            txVowels.append("u");
        }


        return false;
    }

    @Override
    public void onClick(View view) {
        txVowels.setText("");
    }
}