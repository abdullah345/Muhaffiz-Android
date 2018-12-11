package livel.taaus.com.muhaffiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import livel.taaus.com.muhaffiz.History.Images;
import livel.taaus.com.muhaffiz.Wifi.ActivityWifi;

public class MainActivity extends AppCompatActivity {
    int signincheck=0;
    LinearLayout hist,wifi;String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hist=(LinearLayout)findViewById(R.id.histLinear);
        wifi=(LinearLayout)findViewById(R.id.wifi);
        Intent g=getIntent();
        email=g.getStringExtra("Email");
        hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Images.class);
                intent.putExtra("Email2",email);
                startActivity(intent);
            }
        });

        
        if (signincheck==0)
        {
            //Intent i =new Intent(MainActivity.this,Login.class);
            //startActivity(i);
        }
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ActivityWifi.class);
                startActivity(intent);

            }
        });

    }
}
