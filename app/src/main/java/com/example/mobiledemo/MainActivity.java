package com.example.mobiledemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobiledemo.base.BaseActivity;
import com.example.mobiledemo.utils.BarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.mobiledemo.R.id.toolbar;

public class MainActivity extends BaseActivity {

    @BindView(R.id.head)
    CircleImageView mHead;
    @BindView(R.id.mobile)
    TextView mMobile;
    @BindView(R.id.main_fl_title)
    RelativeLayout mMainFlTitle;
    @BindView(R.id.main_tv_toolbar_title)
    TextView mMainTvToolbarTitle;
    @BindView(toolbar)
    Toolbar mToolbar;
    @BindView(R.id.main_abl_app_bar)
    AppBarLayout mMainAblAppBar;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        BarUtils.setColor(this, Color.parseColor("#5DC9D3"), 0);
        ButterKnife.bind(this);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mMainAblAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int halfScroll = appBarLayout.getTotalScrollRange() / 2;
                int offSetAbs = Math.abs(verticalOffset);
                float percentage;
                if (offSetAbs < halfScroll) {
                    mMainTvToolbarTitle.setText("摩拜单车");
                    percentage = 1 - (float) offSetAbs / (float) halfScroll;
                } else {
                    mMainTvToolbarTitle.setText("个人中心");
                    percentage = (float) (offSetAbs - halfScroll) / (float) halfScroll;
                }
                mToolbar.setAlpha(percentage);
            }
        });
    }
}
