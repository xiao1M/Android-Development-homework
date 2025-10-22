package com.example.test3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> dataList;
    private String[] animalNames = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] animalImages = {
            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.elephant
    };
    private int lastSelectedPosition = -1; // 记录上一个选中位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);
        dataList = new ArrayList<>();

        // 填充数据
        for (int i = 0; i < animalNames.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", animalNames[i]);
            map.put("image", animalImages[i]);
            dataList.add(map);
        }

        // 创建 SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dataList,
                R.layout.item_animal,
                new String[]{"name", "image"},
                new int[]{R.id.tv_animal_name, R.id.iv_animal_image}
        );

        listView.setAdapter(adapter);

        // 设置点击事件
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String animalName = animalNames[position];
            Toast.makeText(ListViewActivity.this, "选中了：" + animalName, Toast.LENGTH_SHORT).show();

            // 重置上一个选中项
            if (lastSelectedPosition != -1) {
                View lastView = listView.getChildAt(lastSelectedPosition - listView.getFirstVisiblePosition());
                if (lastView != null) {
                    lastView.setSelected(false);
                }
            }

            // 设置当前项为选中状态（背景变红）
            view.setSelected(true);
            lastSelectedPosition = position;

            // 发送通知（保持不变）
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(animalName)
                    .setContentText("这是关于" + animalName + "的通知")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }

            notificationManager.notify(1, builder.build());
        });
    }
}