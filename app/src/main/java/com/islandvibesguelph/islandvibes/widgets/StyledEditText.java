package com.islandvibesguelph.islandvibes.widgets;

/**
 * Created by djriddy on 2016-01-05.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.islandvibesguelph.islandvibes.R;


public class StyledEditText extends LinearLayout{
    private EditText mTxtValue;
    private String mLabel;
    private TextView mTxtLabel;
    private Drawable mErrIcon;

    public StyledEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_edittext, this, true);

        //Set the inputType on the EditText view
        int[] inputTypeAttr = new int[] { android.R.attr.inputType };
        int index = 0;
        TypedArray a = context.obtainStyledAttributes(attrs, inputTypeAttr, 0, 0);
        int inputType = a.getInt(index, -1);
        a.recycle();

        a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Fields, 0, 0);
        mLabel = a.getString(R.styleable.Fields_label);
        a.recycle();

        if (mLabel != null) {
            mTxtLabel = (TextView)findViewById(R.id.label);
            mTxtLabel.setText(mLabel);
        }

        mTxtValue = (EditText) findViewById(R.id.value);
        mTxtValue.setInputType(inputType);
        mErrIcon = context.getResources().getDrawable(R.drawable.icon_error);
        mErrIcon.setBounds(0, 0, mErrIcon.getIntrinsicWidth(), mErrIcon.getIntrinsicHeight());
    }

    public String getValue() {
        String value = mTxtValue.getText().toString();
        if (value != null) {
            return value.trim();
        }
        return null;
    }

    public void setValue(String value){

        if (value != null) {
            mTxtValue.setText(value);
        } else {
            mTxtValue.setText("");
        }
    }

    public void setError(String error) {
        mTxtValue.setError(error, mErrIcon);
    }

    public void clearError() {
        mTxtValue.setError(null);
    }

    public void addTextTextChangedListener(TextWatcher watcher) {
        mTxtValue.addTextChangedListener(watcher);
    }

    public void setValidationListener(OnFocusChangeListener listener) {
        mTxtValue.setFocusable(true);
        mTxtValue.setOnFocusChangeListener(listener);
    }

}

