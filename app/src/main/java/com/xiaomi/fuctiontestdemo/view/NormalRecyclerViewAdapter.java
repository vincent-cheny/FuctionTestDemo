package com.xiaomi.fuctiontestdemo.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaomi.fuctiontestdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenyong1 on 5/1/16.
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {

    private static final String TAG = NormalRecyclerViewAdapter.class.getSimpleName();

    private final LayoutInflater mInflater;
    private final Context mContext;
    private String[] mTitles;

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public NormalRecyclerViewAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mTitles = context.getResources().getStringArray(R.array.titles);
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    @Override
    public NormalRecyclerViewAdapter.NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_text, parent, false);
        return new NormalTextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NormalRecyclerViewAdapter.NormalTextViewHolder holder, final int position) {
        holder.textView.setText(mTitles[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.text_view)
        TextView textView;

        public NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
