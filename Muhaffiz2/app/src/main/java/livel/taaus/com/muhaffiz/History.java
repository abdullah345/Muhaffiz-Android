package livel.taaus.com.muhaffiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    RecyclerView recyclerView;
    HistoryAdapter adapter;
    List<DataHistory> dataHistoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        dataHistoryList=new ArrayList<>();
        recyclerView= (RecyclerView)findViewById(R.id.histrc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataHistoryList.add(new DataHistory("Throw","detected",R.drawable.login));
        adapter=new HistoryAdapter(this,dataHistoryList);
        recyclerView.setAdapter(adapter);
    }
}
