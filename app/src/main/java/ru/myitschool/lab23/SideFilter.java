package ru.myitschool.lab23;

import android.text.InputFilter;
import android.text.Spanned;

public class SideFilter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            String fullNumber = dest.toString() + source.toString();
            double input = Double.parseDouble(fullNumber);

            if (0 <= input && input <= 1.0e12) {
                return null;
            }
        } catch (NumberFormatException ignored) { }
        return "";
    }
}
