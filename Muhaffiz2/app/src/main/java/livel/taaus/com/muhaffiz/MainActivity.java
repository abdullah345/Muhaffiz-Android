package livel.taaus.com.muhaffiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import livel.taaus.com.muhaffiz.History.Images;

public class MainActivity extends AppCompatActivity {
    int signincheck=0;
    LinearLayout hist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hist=(LinearLayout)findViewById(R.id.histLinear);
        hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Images.class);
                startActivity(intent);
            }
        });
        
        if (signincheck==0)
        {
            //Intent i =new Intent(MainActivity.this,Login.class);
            //startActivity(i);
        }

    }
}
