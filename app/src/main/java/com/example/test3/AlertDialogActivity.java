package com.example.test3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        Button showDialogBtn = findViewById(R.id.btn_show_dialog);
        showDialogBtn.setOnClickListener(v -> {
            // 加载自定义对话框布局
            View dialogView = LayoutInflater.from(AlertDialogActivity.this)
                    .inflate(R.layout.dialog_custom, null);

            // 创建对话框
            AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
            builder.setView(dialogView);
            AlertDialog dialog = builder.create();
            dialog.show();

            // 获取对话框中的按钮和输入框
            Button cancelBtn = dialogView.findViewById(R.id.btn_cancel);
            Button signInBtn = dialogView.findViewById(R.id.btn_sign_in);
            EditText usernameEt = dialogView.findViewById(R.id.et_username);
            EditText passwordEt = dialogView.findViewById(R.id.et_password);

            // 取消按钮点击事件
            cancelBtn.setOnClickListener(v1 -> dialog.dismiss());

            // 登录按钮点击事件
            signInBtn.setOnClickListener(v1 -> {
                String username = usernameEt.getText().toString();
                String password = passwordEt.getText().toString();
                Toast.makeText(AlertDialogActivity.this,
                        "用户名：" + username + "，密码：" + password,
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
        });
    }
}