package com.example.doubleactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.doubleactivity.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        double sumResult = getIntent().getDoubleExtra("SUM_RESULT", 0);
        TextView resultTextView = findViewById(R.id.textView2);
        resultTextView.setText("Result " + sumResult);
    }

    @Override protected void onStart() { super.onStart(); }
    @Override protected void onResume() { super.onResume(); }
    @Override protected void onPause() { super.onPause(); }
    @Override protected void onStop() { super.onStop(); }
    @Override protected void onRestart() { super.onRestart(); }
    @Override protected void onDestroy() { super.onDestroy(); }
}