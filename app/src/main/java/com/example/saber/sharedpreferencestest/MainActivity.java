package com.example.saber.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnRestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btn_save_data);
        btnRestore = (Button)findViewById(R.id.btn_restore_data);
        //存储数据
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.apply();
            }
        });

        //读取数据
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
                String name = sp.getString("name","");
                int age = sp.getInt("age",-1);
                boolean married = sp.getBoolean("married",false);
                Log.d("info","name is "+name);
                Log.d("info","age is "+age);
                Log.d("info","married is "+married);

            }
        });


    }
}
