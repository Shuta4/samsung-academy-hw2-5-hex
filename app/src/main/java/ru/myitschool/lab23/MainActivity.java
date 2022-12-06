package ru.myitschool.lab23;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import java.util.Locale;

import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TrickyHexahedron";
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

        HexahedronCalculator[] calculators = {
                new SidesLengthsSumCalculator(),
                new DiagonalLengthCalculator(),
                new FullAreaCalculator(),
                new VolumeCalculator()
        };

        binding.container.calculate.setOnClickListener(view -> {
            int selected = binding.container.spinner.getSelectedItemPosition();
            if (selected == Spinner.INVALID_POSITION) {
                return;
            }
            try {
                binding.container.solution.setText(String.format(
                        Locale.getDefault(), "%.5f", calculators[selected].calculate(
                                Double.parseDouble(binding.container.sideA.getText().toString()),
                                Double.parseDouble(binding.container.sideB.getText().toString()),
                                Double.parseDouble(binding.container.sideC.getText().toString())
                        )
                ));
            } catch (NumberFormatException e) {
                Log.w(TAG, "Not a number in side input.");
            }
        });

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        binding.container.solution.setOnClickListener(view -> {
            ClipData clip = ClipData.newPlainText("solution", ((TextView) view).getText());
            clipboard.setPrimaryClip(clip);
        });
    }
}
