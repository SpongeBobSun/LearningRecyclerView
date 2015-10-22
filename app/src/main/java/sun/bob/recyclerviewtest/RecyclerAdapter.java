package sun.bob.recyclerviewtest;

import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import dpl.bobsun.dummypicloader.DummyPicLoader;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by bob.sun on 15/10/22.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private ArrayList<PicFileInfo> pics;
    private Context mContext;
    public RecyclerAdapter(Context context){
        this.mContext = context;
        pics = new ArrayList();
        File picDir = new File(Environment.getExternalStorageDirectory().getPath() + "/DCIM");
        File[] files = picDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                if (s.endsWith(".jpg") || s.endsWith(".png") || s.endsWith(".bmp") || s.endsWith(".JPG") || s.endsWith(".BMP") || s.endsWith(".PNG"))
                    return true;
                return false;
            }
        });
        Observable.from(files)
                .subscribe(new Action1<File>() {
                    @Override
                    public void call(File file) {
                        PicFileInfo add = new PicFileInfo();
                        add.fileName = file.getName();
                        add.filePath = file.getPath();
                        add.size =  file.length();
                        pics.add(add);
                    }
                });
//        PicFileInfo toadd;
//        for (int i = 0; i < files.length; i++){
//            toadd = new PicFileInfo();
//            toadd.filePath = files[i].getPath();
//            toadd.fileName = files[]
//            pics.add(files[i].getPath());
//        }
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card, parent, false);
        view.setOnClickListener(new RecyclerOnClickListener(MainActivity.recyclerView));

        //Pass the inflated view to viewholder so it can populate it's holders.
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        PicFileInfo picFileInfo = pics.get(position);
        DummyPicLoader.getInstance(mContext)
                .resize(100, 100)
                .loadImageFromFile(picFileInfo.filePath, imageView);
        holder.textViewMain.setText(picFileInfo.fileName);
        holder.textViewSub.setText("" + picFileInfo.size);

    }

    @Override
    public int getItemCount() {
        return pics.size();
    }

    class PicFileInfo{
        String filePath;
        String fileName;
        long size;
    }
}
