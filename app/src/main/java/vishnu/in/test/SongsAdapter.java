package vishnu.in.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by vishn on 5/20/2017.
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.MyViewHolder> {

    private List<Songs> songsList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, time,desc;
        public ImageView thumb;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            time = (TextView) view.findViewById(R.id.time);
            desc = (TextView) view.findViewById(R.id.desc);
            thumb = (ImageView)view.findViewById(R.id.thumb);
        }
    }


    public SongsAdapter(List<Songs> songsList,Context context) {
        this.songsList = songsList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardrow, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Songs song = songsList.get(position);
        holder.title.setText(song.getTitle());
        holder.time.setText(song.getTime());
        holder.desc.setText(song.getDescription());

        Glide.with(context).load(song.getUrl()).centerCrop().into(holder.thumb);
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }
}