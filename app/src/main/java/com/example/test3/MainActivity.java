package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listViewBtn = findViewById(R.id.btn_list_view);
        Button alertDialogBtn = findViewById(R.id.btn_alert_dialog);
        Button menuBtn = findViewById(R.id.btn_menu);
        Button contextMenuBtn = findViewById(R.id.btn_context_menu);

        listViewBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ListViewActivity.class)));
        alertDialogBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AlertDialogActivity.class)));
        menuBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MenuActivity.class)));
        contextMenuBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ContextMenuActivity.class)));
    }
}