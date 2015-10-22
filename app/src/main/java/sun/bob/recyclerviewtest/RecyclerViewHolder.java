package sun.bob.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bob.sun on 15/10/22.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textViewMain;
    TextView textViewSub;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.id_card_image);
        textViewMain = (TextView) itemView.findViewById(R.id.id_main_text);
        textViewSub = (TextView) itemView.findViewById(R.id.id_sub_text);


    }
}
