package com.yyh.status.key.Header_zoomOut_recover;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.yyh.status.key.R;

/**
 * Android实现ScrollView顶部布局上滑缩小，下滑恢复- http://download.csdn.net/download/yanjunhui2011/10028253
 */
public class SlidingScrollViewActivity extends AppCompatActivity {

    private MyScrollView scrollView;

    private View headerView;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_scrollview);

        init();
    }

    private void init() {
        scrollView = (MyScrollView) findViewById(R.id.scrollview);
        headerView = findViewById(R.id.lay_header);
        imgView = (ImageView) findViewById(R.id.civ_avatar);

        headerView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.setHeaderView(headerView, imgView);
            }
        });

    }

}
