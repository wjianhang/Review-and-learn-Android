package com.example.lakalaka.a2018103_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private void Log(String d) {
        Log.d("tag", d);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log("onStart:活动由不可见变为可见的时候调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log("onResume:活动准备好和用户进行交互的时候进行调用,此活动一定位于返回栈的顶端,并且处于运行状态");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log("onPause:在系统准备去启动或者恢复另一个活动的时候调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log("onStop:在活动完全不可见的时候调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log("onDestroy:活动被销毁之前调用");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log("onRestart:在活动由停止状态变为运行状态之前调用,即被重新启用");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData="Something you just type";
        outState.putString("data_key",tempData);
    }

    private Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity",this.toString());
        mcontext=this;
        if(savedInstanceState!=null){
            String tempData=savedInstanceState.getString("data_key");
            Log(tempData);
        }



        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        Button standard= (Button) findViewById(R.id.btn_standard);

        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,MainActivity.class);
                startActivity(intent);
            }
        });

        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, Normal_Activity.class);
                startActivity(intent);

            }
        });
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, Normal_Activity.class);
                startActivity(intent);
            }
        });

    }
}
