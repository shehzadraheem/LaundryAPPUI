package com.userpanel.friend.laundryapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userpanel.friend.laundryapp.R;
import com.userpanel.friend.laundryapp.adapter.HomeAdapter;
import com.userpanel.friend.laundryapp.adapter.NotificationAdapter;
import com.userpanel.friend.laundryapp.model.Item;
import com.userpanel.friend.laundryapp.model.Notification;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {


    RecyclerView recyclerView;
    Context mContext;
    NotificationAdapter adapter;
    List<Notification> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        setAdapter();
    }


    private void initView(View view) {
        recyclerView = view.findViewById(R.id.order_RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.HORIZONTAL,false));

        recyclerView.setHasFixedSize(true);

    }

    private void setAdapter() {

        initModel();

        adapter = new NotificationAdapter(mContext,list);
        recyclerView.setAdapter(adapter);
    }

    private void initModel() {
        list = new ArrayList<>();

        list.add(new Notification(R.drawable.ic_box,"Order No # 23445","Confirmed"));
        list.add(new Notification(R.drawable.ic_box,"Order No # 23445","Confirmed"));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}