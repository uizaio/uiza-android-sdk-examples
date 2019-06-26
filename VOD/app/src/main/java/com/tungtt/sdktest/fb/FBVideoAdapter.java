package com.tungtt.sdktest.fb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.tungtt.sdktest.R;
import vn.uiza.core.utilities.LImageUtil;
import vn.uiza.restapi.uiza.model.v3.metadata.getdetailofmetadata.Data;

public class FBVideoAdapter extends RecyclerView.Adapter<FBVideoAdapter.MovieViewHolder> {
    public interface Callback {
        public void onClick(Data data, int position);
    }

    private Context context;
    private Callback callback;
    private List<Data> dataList;

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout ll;
        public TextView tv;
        public ImageView iv;

        public MovieViewHolder(View view) {
            super(view);
            ll = (LinearLayout) view.findViewById(R.id.ll);
            tv = (TextView) view.findViewById(R.id.tv);
            iv = (ImageView) view.findViewById(R.id.iv);
        }
    }

    public FBVideoAdapter(Context context, List<Data> dataList, Callback callback) {
        this.context = context;
        this.dataList = dataList;
        this.callback = callback;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fb, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.tv.setText(data.getName());
        LImageUtil.load(context, data.getThumbnail(), holder.iv);
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onClick(data, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}