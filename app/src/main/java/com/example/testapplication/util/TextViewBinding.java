package com.example.testapplication.util;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class TextViewBinding {
    private TextViewBinding() {

    }

    @BindingAdapter(value = "android:text")
    public static void setNumber(TextView textView, int number) {
        textView.setText("" + number);
    }
}
