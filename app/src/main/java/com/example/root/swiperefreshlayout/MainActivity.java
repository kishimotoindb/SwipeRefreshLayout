package com.example.root.swiperefreshlayout;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * 以下问题均是关于swipe_refresh_layout
 * 问题列表:
 * 1.直接调用setRefreshing()方法是否会出发onRefresh()回调
 * 结论:
 */

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_set_freshing)
    Button mBtnSetFreshing;
    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @Bind(R.id.activity_main)
    RelativeLayout mActivityMain;
    @Bind(R.id.tv_label)
    TextView mTvLabel;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //问题1
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTvLabel.setText("第"+(i++) + "次回调onRefresh()");
            }
        });
    }

    @OnClick({R.id.btn_set_freshing})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_set_freshing:
                mSwipeLayout.setRefreshing(true);
                break;
        }
    }
}
