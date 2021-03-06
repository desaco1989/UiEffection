package com.yyh.status.key;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.yyh.status.key.Header_zoomOut_recover.SlidingScrollViewActivity;
import com.yyh.status.key.base.BaseActivity;
import com.yyh.status.key.R;
import com.yyh.status.key.inteml.ActionBarClickListener;
import com.yyh.status.key.new_add.InviteRecordsAdapter;
import com.yyh.status.key.new_add.UserRecordBean;
import com.yyh.status.key.scroll_gradient.ScrollGradientActivity;
import com.yyh.status.key.widget.TranslucentActionBar;
import com.yyh.status.key.widget.TranslucentScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述：</br>
 * Android沉浸式状态栏 + scrollView顶部伸缩 + actionBar渐变
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public class MainActivity extends BaseActivity implements ActionBarClickListener, TranslucentScrollView.TranslucentChangedListener {

    private TranslucentScrollView translucentScrollView;
    private TranslucentActionBar actionBar;
    private View zoomView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initData();
    }

    private void init() {
        //TODO actionBar
        actionBar = (TranslucentActionBar) findViewById(R.id.actionbar);
        //初始actionBar
        actionBar.setData("我的", 0, null, 0, null, null);
        //开启渐变
        actionBar.setNeedTranslucent();
        //设置状态栏高度
        actionBar.setStatusBarHeight(getStatusBarHeight());

        //TODO ScrollView
        translucentScrollView = (TranslucentScrollView) findViewById(R.id.pullzoom_scrollview);
        //设置透明度变化监听
        translucentScrollView.setTranslucentChangedListener(this);
        //关联需要渐变的视图
        translucentScrollView.setTransView(actionBar);

        //TODO 伸缩的视图
//        zoomView = findViewById(R.id.lay_header);
//        //关联伸缩的视图
//        translucentScrollView.setPullZoomView(zoomView);

        //jump_srollview
        TextView bt = (TextView) findViewById(R.id.jump_srollview);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();//SlidingScrollViewActivity
                intent.setClass(MainActivity.this, SlidingScrollViewActivity.class);
                startActivity(intent);
            }
        });
        //jump_srollview_gradient
        TextView srollview_gradient = (TextView) findViewById(R.id.jump_srollview_gradient);
        srollview_gradient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();//SlidingScrollViewActivity
                intent.setClass(MainActivity.this, ScrollGradientActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {//TODO add  list_recyclerview

        List<UserRecordBean> recordBeans = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            UserRecordBean bean = new UserRecordBean();
            bean.setTime("2018-07-24");
            bean.setCount(i);
            recordBeans.add(bean);
        }

        RecyclerView rv = (RecyclerView) findViewById(R.id.list_recyclerview);
        InviteRecordsAdapter adapter = new InviteRecordsAdapter(this);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);
        adapter.clearAndPutList(recordBeans);

    }

    @Override
    public void onLeftClick() {

    }

    @Override
    public void onRightClick() {

    }

    @Override
    public void onTranslucentChanged(int transAlpha) {
        actionBar.tvTitle.setVisibility(transAlpha > 48 ? View.VISIBLE : View.GONE);//48
    }

}
