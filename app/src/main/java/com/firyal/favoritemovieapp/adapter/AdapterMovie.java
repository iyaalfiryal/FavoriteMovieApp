package com.firyal.favoritemovieapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firyal.favoritemovieapp.BuildConfig;
import com.firyal.favoritemovieapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.ViewHolder> {
    private Context mContext;
    private Cursor mCursor;


    public void setmCursor(Cursor mCursor) {
        this.mCursor = mCursor;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AdapterMovie.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.listitem_movie, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovie.ViewHolder holder, int position) {
        if (mCursor.moveToPosition(position)) {
            holder.judul.setText(mCursor.getString(mCursor.getColumnIndexOrThrow("original_title")));
            holder.time.setText(mCursor.getString(mCursor.getColumnIndexOrThrow("release_date")));
            Glide.with(mContext)
                    .load(BuildConfig.URLIMAGE + mCursor.getString(mCursor.getColumnIndexOrThrow("poster_path")))
                    .into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView judul, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            judul = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.time);
        }
    }
}
