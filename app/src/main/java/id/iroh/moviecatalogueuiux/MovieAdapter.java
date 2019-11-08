package id.iroh.moviecatalogueuiux;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    Context mContext;
    List<Movie> mData;

    public MovieAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.baris_item,viewGroup,false);
        final MyViewHolder holder = new MyViewHolder(v);

        holder.baris_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent details = new Intent(context, DetailActivity.class);
                details.putExtra(DetailActivity.EXTRA_MOVIE, mData.get(i));
                context.startActivity(details);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_judul.setText(mData.get(i).getJudul());
        myViewHolder.tv_deskripsi.setText(mData.get(i).getDeskripsi());
        final Movie moviess= mData.get(i);
        Glide.with(myViewHolder.baris_item.getContext())
                .load(moviess.getThisposter())
                .apply(new RequestOptions().override(200, 300))
                .into(myViewHolder.img_poster);

        myViewHolder.baris_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent details = new Intent(context, DetailActivity.class);
                details.putExtra(DetailActivity.EXTRA_MOVIE, mData.get(i));
                context.startActivity(details);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout baris_item;
        private TextView tv_judul;
        private TextView tv_deskripsi;
        private ImageView img_poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            baris_item = (RelativeLayout) itemView.findViewById(R.id.baris);
            tv_judul = (TextView) itemView.findViewById(R.id.tv_judul);
            tv_deskripsi = (TextView) itemView.findViewById(R.id.tv_deskripsi);
            img_poster = (ImageView) itemView.findViewById(R.id.img_poster);
        }
    }

}
