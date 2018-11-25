package livel.taaus.com.muhaffiz.History;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import livel.taaus.com.muhaffiz.R;

public class ViewHolderAdapter extends RecyclerView.ViewHolder {

   public ImageView imageViewCard ;
   public TextView textViewCard;

    public ViewHolderAdapter(@NonNull View itemView) {
        super(itemView);

        imageViewCard = itemView.findViewById(R.id.actImagee);
        textViewCard = itemView.findViewById(R.id.actTextview);

    }
}
