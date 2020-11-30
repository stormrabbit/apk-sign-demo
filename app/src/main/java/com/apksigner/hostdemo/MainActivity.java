package com.apksigner.hostdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.apksigner.weiboreader.ChannelInfo;
import com.apksigner.weiboreader.ChannelReader;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.demo);
        try {
            ChannelInfo channelInfo = ChannelReader.get(new File(getApplication().getApplicationInfo().sourceDir));
            String info = channelInfo.getChannel();
            textView.setText(TextUtils.isEmpty(info) ? "未找到渠道名称！":info);
        }catch (Exception ex) {
            ex.printStackTrace();
            textView.setText ("未找到渠道名称！");
        }
    }
}
