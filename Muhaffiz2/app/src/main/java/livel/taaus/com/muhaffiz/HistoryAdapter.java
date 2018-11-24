package livel.taaus.com.muhaffiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HisoryViewHolder> {
    Context ctxt;
    List<DataHistory> DataHistoryList;

    public HistoryAdapter(Context ctxt, List<DataHistory> dataHistoryList) {
        this.ctxt = ctxt;
        DataHistoryList = dataHistoryList;
    }



    @NonNull
    @Override
    public HistoryAdapter.HisoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater =LayoutInflater.from(ctxt);
        View view=inflater.inflate(R.layout.history_list ,null);

        return new HisoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HisoryViewHolder hisoryViewHolder, int i) {
        DataHistory dataHistory=DataHistoryList.get(i);
        hisoryViewHolder.name.setText(String.valueOf( dataHistory.getActname()));
        hisoryViewHolder.desc.setText(String.valueOf( dataHistory.getActdesc()));
        hisoryViewHolder.acview.setImageDrawable(ctxt.getResources().getDrawable(dataHistory.getActimage()));

    }

    @Override
    public int getItemCount() {
        return DataHistoryList.size();
    }
    public class HisoryViewHolder extends RecyclerView.ViewHolder {
       TextView name,desc;
       ImageView acview;

        public HisoryViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.actname);
            desc=itemView.findViewById(R.id.actdesc);
            acview=itemView.findViewById(R.id.actimge);
        }
    }



}
