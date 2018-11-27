package livel.taaus.com.muhaffiz.History;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
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

    FirebaseRecyclerAdapter<ImageTable , ViewHolderAdapter> adapter;


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
        Toast.makeText(getApplicationContext(),"g",Toast.LENGTH_SHORT).show();
        loadImages();

        
        change.child("ImageTable").addValueEventListener(new ValueEventListener() {
                                                             @Override
                                                             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                 Toast.makeText(Images.this,"hanky panky hue",Toast.LENGTH_SHORT).show();
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
               Picasso.get().load(model.getUrl()).into(viewHolder.imageViewCard);
               viewHolder.textViewCard.setText(model.getName());
               Log.i("NameJe",model.getName());
           }
       };

       recyclerView.setAdapter(adapter);

    }
}
