package com.liyong.listviewunfolded.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liyong.listviewunfolded.R;
import com.liyong.listviewunfolded.listener.MyClickListener;
import com.liyong.listviewunfolded.listener.MyClickListener2;

/**
 * Created by Administrator on 2017/4/27.
 */

public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private int mLastPosition = -1;
    private MyClickListener mListener;
    private MyClickListener2 mListener2;
    private LayoutInflater mLayoutInflater;

    public ListAdapter(Context mContext, MyClickListener mListener,
                       MyClickListener2 mListener2) {
        this.mContext = mContext;
        this.mListener = mListener;
        this.mListener2 = mListener2;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_list, null);
            holder.tv_chat = (TextView) convertView.findViewById(R.id.tv_chat);
            holder.tv_giving_gifts = (TextView) convertView.findViewById(R.id.tv_giving_gifts);
            holder.iv_up_down = (ImageView) convertView.findViewById(R.id.iv_up_down);
            holder.hint_view = convertView.findViewById(R.id.hint_view);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        //切换隐藏部分的显示和图标的改变
        if (position == mLastPosition) {
            holder.hint_view.setVisibility(View.VISIBLE);
            holder.iv_up_down.setImageResource(R.mipmap.img_up);
        } else {
            holder.hint_view.setVisibility(View.GONE);
            holder.iv_up_down.setImageResource(R.mipmap.img_down);
        }
        //点我1
        holder.tv_chat.setOnClickListener(mListener);
        holder.tv_chat.setTag(position);
        //点我2
        holder.tv_giving_gifts.setOnClickListener(mListener2);
        holder.tv_giving_gifts.setTag(position);
        return convertView;
    }

    //改变隐藏部分的控制符
    public void changeImageVisable(int position) {
        if (position != mLastPosition) {
            mLastPosition = position;
        } else {
            mLastPosition = -1;
        }
        notifyDataSetChanged();
    }

    /**
     * 行布局
     */
    class Holder {
        TextView tv_chat;
        TextView tv_giving_gifts;
        ImageView iv_up_down;
        View hint_view;
    }
}
