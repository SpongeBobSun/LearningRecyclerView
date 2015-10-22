package sun.bob.recyclerviewtest;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by bob.sun on 15/10/22.
 */
public class RecyclerOnClickListener implements View.OnClickListener {
    private RecyclerView mRecyclerView;

    public RecyclerOnClickListener(RecyclerView recyclerView){
        mRecyclerView = recyclerView;
    }
    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Clicked on " + mRecyclerView.getChildLayoutPosition(v), Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
    }
}
