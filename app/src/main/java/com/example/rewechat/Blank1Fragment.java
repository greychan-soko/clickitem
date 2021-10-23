package com.example.rewechat;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blank1Fragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> data;
    private Context context;
    private adaptervieww adapterviewww;
    private TextView textView;
    private SwipeRefreshLayout refreshLayout;

    public Blank1Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank1, container, false);
        context=this.getActivity();
        recyclerView= view.findViewById(R.id.recylerview);
        textView=view.findViewById(R.id.textView);
        refreshLayout=view.findViewById(R.id.refreshlayout);

        String[] products={"GreysonChance","WhyDont'tWe","Bbno$","GirlInRed","Casper"};
        String[] prices={"Seasons","what am i","take a trip","girls","constantin"};
        String[] configurations={"1997-08-16 欧美歌手","美国流行乐队 由5个solo艺人组成","1995-06-30 加拿大说唱歌手","1997-10-10 欧美女歌手","2003-2-20 德国男模"};
        int[] png={R.drawable.grey,R.drawable.whydw,R.drawable.bbno,R.drawable.girl,R.drawable.cas};
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        for(int i=0;i<products.length;i++) {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("PRODUCT", products[i]);
            item.put("PRICE", prices[i]);
            item.put("CONFIGURATION", configurations[i]);
            item.put("PNG",png[i]);

                items.add(item);
        }

        adapterviewww=new adaptervieww(items,context);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterviewww);


        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.teal_200));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                textView.setText("正在刷新.....");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("刷新成功！！！");
                        refreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });

        return view;
    }
}