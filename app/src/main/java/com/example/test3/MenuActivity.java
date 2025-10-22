package com.example.test3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tvTest = findViewById(R.id.tv_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_common) {
            Toast.makeText(this, "点击了普通菜单项", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu_font_small) {
            tvTest.setTextSize(10);
        } else if (itemId == R.id.menu_font_medium) {
            tvTest.setTextSize(16);
        } else if (itemId == R.id.menu_font_large) {
            tvTest.setTextSize(20);
        } else if (itemId == R.id.menu_font_red) {
            tvTest.setTextColor(Color.RED);
        } else if (itemId == R.id.menu_font_black) {
            tvTest.setTextColor(Color.BLACK);
        }
        return super.onOptionsItemSelected(item);
    }
}