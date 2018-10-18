package com.example.administrator.listviewlocalrefresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18.
 */

public class LocalRefreshAdapter extends BaseAdapter{
    private Context mContext;
    private List<String> names;
    public LocalRefreshAdapter(Context mContext, List<String> names) {
        super();
        this.mContext = mContext;
        this.names = names;
    }
    @Override
    public int getCount() {
        return names == null?0:names.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);

            holder = new ViewHolder();
            holder.idText = (TextView) convertView.findViewById(R.id.idTv);
            holder.nameText = (TextView) convertView.findViewById(R.id.nameTv);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.idText.setText("ID:"+position);
        String name = names.get(position);
        holder.nameText.setText(name);

        return convertView;
    }

    private static class ViewHolder {
        private TextView idText;
        private TextView nameText;
    }

    public void updateView(int posi,String name, ListView listView) {
        int index1 = listView.getFirstVisiblePosition();
        int index2 = listView.getLastVisiblePosition();
        if (posi >= index1 && posi <= index2) {
            View view = listView.getChildAt(posi - index1);
            ViewHolder holder = (ViewHolder) view.getTag();
            holder.nameText.setText(name);
            names.set(posi, name);
        } else {
            names.set(posi, name);
        }
    }
}
