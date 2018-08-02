package com.yyh.status.key.new_add;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.yyh.status.key.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by desaco on 2017/10/19.
 * 邀请记录Adapter
 */
public class InviteRecordsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UserRecordBean> mRecordsList;
    private Context mContext;
    private LayoutInflater mInflater;

    public InviteRecordsAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mRecordsList = new ArrayList<UserRecordBean>();
    }

    // 清空集合，将新的数据加入到集合中
    public void clearAndPutList(List<UserRecordBean> list) {
        if (list == null) {
            return;
        }
        if (mRecordsList != null && mRecordsList.size() > 0) {
            mRecordsList.clear();
        }
        directPutList(list);
    }

    // 直接将新的数据加入到集合中
    public void directPutList(List<UserRecordBean> list) {
        if (list == null) {
            return;
        }
        mRecordsList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecordsHolder(mInflater.inflate(R.layout.item_invite_records, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        UserRecordBean recordsBean = mRecordsList.get(position);
        ((RecordsHolder) holder).tvInviteTime.setText(recordsBean.getTime());
        ((RecordsHolder) holder).tvInviteNum.setText(recordsBean.getCount() + "人");
    }

    @Override
    public int getItemCount() {
        return mRecordsList.size();
    }

    class RecordsHolder extends RecyclerView.ViewHolder {
        TextView tvInviteTime;
        TextView tvInviteNum;

        RecordsHolder(View view) {
            super(view);
            tvInviteTime = (TextView) view.findViewById(R.id.invite_time_tv);
            tvInviteNum = (TextView) view.findViewById(R.id.invite_num_tv);
        }
    }
}
