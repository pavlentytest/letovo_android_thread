package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        tv = findViewById(R.id.textView2);
         btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // не падает!!!!!
                Thread th1 = new Thread() {
                    @Override
                    public void run() {
                        tv.setText("Выполняется шаг #");
                    }
                };
                th1.start();


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DDD","Нажали на вторую кнопку!");
            }
        });
    }

    public void doSlow()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}