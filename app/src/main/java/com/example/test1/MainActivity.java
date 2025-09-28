package com.example.test1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 加载一个空布局（确保布局文件存在）
        setContentView(R.layout.empty_layout);

        // 正确获取根容器（不强制转换类型，使用 ViewGroup 父类）
        ViewGroup rootView = findViewById(android.R.id.content);

        // 动态创建 TextView 并添加到根容器
        TextView textView = new TextView(this);
        textView.setText("Hello World");
        textView.setTextSize(24);
        rootView.addView(textView);
    }
}