package com.finddreams.runningman;

import java.util.Timer;
import java.util.TimerTask;

import com.example.runningman.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * @author http://blog.csdn.net/finddreams
 * @Description: 奔跑小人的动画进度条对话框，可以用作加载数据界面
 */
public class RuningManActivity extends Activity {
    CustomProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_runing_man);
    }

    /**
     * 显示美团进度对话框
     *
     * @param v
     */
    public void showmeidialog(View v) {
        dialog = new CustomProgressDialog(this, "正在加载中", R.anim.frame);
        dialog.show();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                dialog.dismiss();
            }
        };
        timer.schedule(task, 1000 * 10); //3秒后 关闭
    }

    /**
     * 显示顺丰快递员进度对话框
     *
     * @param v
     */
    public void showsfdialog(View v) {
        CustomProgressDialog dialog = new CustomProgressDialog(this, "正在加载中", R.anim.frame2);
        dialog.show();
    }
}
