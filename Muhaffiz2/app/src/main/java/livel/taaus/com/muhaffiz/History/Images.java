package livel.taaus.com.muhaffiz.History;

import android.app.Notification;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import livel.taaus.com.muhaffiz.R;

public class Images extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference images ,change;
String email2;
    FirebaseRecyclerAdapter<ImageTable , ViewHolderAdapter> adapter;
    NotificationCompat.Builder mBuilder;
    NotificationManagerCompat notificationManager;
    Handler h;int delay;Button start;

    Runnable runnable;
    int check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerImage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        database =FirebaseDatabase.getInstance();
        images = database.getReference(DBnames.IMAGE_TABLE);
        change = database.getReference(DBnames.IMAGE_TABLE);
        start=(Button)findViewById(R.id.btnstrt);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

Intent intent=getIntent();
email2=intent.getStringExtra("Email2");
        mBuilder = new NotificationCompat.Builder(Images.this,"1")
                .setSmallIcon(R.drawable.th)
                .setContentTitle("System has detected Suspecious Actvity ")
                .setContentText("Throw")
                .setSound(soundUri)

                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
         notificationManager = NotificationManagerCompat.from(Images.this);

        h = new Handler();
         delay = 15*1000; //1 second=1000 milisecond, 15*1000=15seconds



        loadImages();
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try { Thread.sleep(5000); }
                catch (InterruptedException e) {}

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        scheduleJob();
                        // yaha gudu g wo code likho jo bar bar chalna he

                    }
                });
            }
        };
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check == 0) {
                    thread.start();
                    start.setText("Stop");
                }

                if (check == 1) {
thread.stop();
                    start.setText("Start");
                }
            }
        });


        
        images.addValueEventListener(new ValueEventListener() {
                                                             @Override
                                                             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                 Toast.makeText(Images.this,"hanky panky hue",Toast.LENGTH_SHORT).show();
                                                                 dataSnapshot.child("name").getValue();
                                                                 notificationManager.notify(1, mBuilder.build());


                                                             }

                                                             @Override
                                                             public void onCancelled(@NonNull DatabaseError databaseError) {

                                                             }
                                                         }

        );





    }


    private void loadImages() {

       adapter =new FirebaseRecyclerAdapter<ImageTable, ViewHolderAdapter>(ImageTable.class,
               R.layout.cardview,
               ViewHolderAdapter.class,
               images) {
           @Override
           protected void populateViewHolder(ViewHolderAdapter viewHolder, ImageTable model, int position) {
if (model.getEmail().equals(email2)){
                  Picasso.get().load(model.getUrl()).into(viewHolder.imageViewCard);
                  viewHolder.textViewCard.setText(model.getName());}

           }
       };

       recyclerView.setAdapter(adapter);



    }



    void scheduleJob(){



                Toast.makeText(Images.this,"Checking",Toast.LENGTH_SHORT).show();
                //Do something after 100ms
                images.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Toast.makeText(getApplicationContext(),"system detected",Toast.LENGTH_SHORT).show();
                        notificationManager.notify(1, mBuilder.build());
Toast.makeText(Images.this,String.valueOf(dataSnapshot.getValue()),Toast.LENGTH_SHORT).show();
                       // Toast.makeText(Images.this,"hanky panky hue",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });









    }

}
