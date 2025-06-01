package com.example.doubleactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.doubleactivity.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button sumButton = findViewById(R.id.button);
        sumButton.setOnClickListener(v -> {
            EditText firstNumberEditText = findViewById(R.id.firstNumberEditText);
            EditText secondNumberEditText = findViewById(R.id.secondNumberEditText);

            try {
                double n1 = Double.parseDouble(firstNumberEditText.getText().toString());
                double n2 = Double.parseDouble(secondNumberEditText.getText().toString());
                double sum = n1 + n2;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("SUM_RESULT", sum);
                startActivity(intent);
            } catch (NumberFormatException e) {

                firstNumberEditText.setError("Введите число");
                secondNumberEditText.setError("Введите число");
            }
        });

    }

    @Override protected void onStart() { super.onStart(); }
    @Override protected void onResume() { super.onResume(); }
    @Override protected void onPause() { super.onPause(); }
    @Override protected void onStop() { super.onStop(); }
    @Override protected void onRestart() { super.onRestart(); }
    @Override protected void onDestroy() { super.onDestroy(); }
}