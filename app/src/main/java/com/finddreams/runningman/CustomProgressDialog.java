package com.finddreams.runningman;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.runningman.R;

/**
 * @Description:自定义对话框
 */
public class CustomProgressDialog extends ProgressDialog {

    private AnimationDrawable mAnimation;//AnimationDrawable是实现Drawable animations的基本类
    private Context mContext;
    private ImageView mImageView;//图片
    private String mLoadingTip;
    private TextView mLoadingTv;//文字描述
    /*	private int count = 0;
        private String oldLoadingTip;*/
    private int mResid;//图片ID

    public CustomProgressDialog(Context context, String content, int id) {
        super(context);
        this.mContext = context;
        this.mLoadingTip = content;
        this.mResid = id;
        setCanceledOnTouchOutside(true);//设置弹出框失去焦点是否隐藏,即点击屏蔽其它地方是否隐藏
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();//初始化代码
        initData();//加载
    }

    private void initData() {

        mImageView.setBackgroundResource(mResid);
        // 通过ImageView对象拿到背景显示的AnimationDrawable
        mAnimation = (AnimationDrawable) mImageView.getBackground();
        // 为了防止在onCreate方法中只显示第一帧的解决方案之一
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();//调用开启
            }
        });
        mLoadingTv.setText(mLoadingTip);//赋值

    }

    private void initView() {
        setContentView(R.layout.progress_dialog);//加载试图
        mLoadingTv = (TextView) findViewById(R.id.loadingTv);
        mImageView = (ImageView) findViewById(R.id.loadingIv);
    }
}
