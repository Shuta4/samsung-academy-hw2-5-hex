package ru.myitschool.lab23;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SideFilter[] filters = {new SideFilter()};
        binding.container.sideA.setFilters(filters);
        binding.container.sideB.setFilters(filters);
        binding.container.sideC.setFilters(filters);

        binding.container.calculate.setOnClickListener(view -> {

        });

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        binding.container.solution.setOnClickListener(view -> {
            ClipData clip = ClipData.newPlainText("solution", ((TextView) view).getText());
            clipboard.setPrimaryClip(clip);
        });
    }
}
