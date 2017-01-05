package com.qianfeng.scrollviewandviewpagerandlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class InfoFragment extends Fragment {

    private ListView listView;


    private int count;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        listView = (ListView) view.findViewById(R.id.lv);
        count=getArguments().getInt("count");
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return count;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = new TextView(getContext());
                    convertView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 120));
                }
                ((TextView) convertView).setGravity(Gravity.CENTER);
                ((TextView) convertView).setText("position" + position);
                return convertView;
            }
        });
        return view;
    }
}
