package com.hfs.custominputview.keybord;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hfs.custominputview.R;

/**
 * @author HuangFusheng
 * @date 2020-03-10
 * description 自定义输入View
 */
public class NumberInputView extends LinearLayout {

    /**
     * 展示当前输入数字
     */
    private TextView[] mInputViews;
    /**
     * 展示未输入圆点
     */
    private ImageView[] mDotViews;
    /**
     * 预留的字符
     */
    private String mPreText;
    /**
     * 文字颜色
     */
    private int mTextColor;

    public NumberInputView(Context context) {
        this(context, null);
    }

    public NumberInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NumberInputView);
        mPreText = ta.getString(R.styleable.NumberInputView_pre_text);
        mTextColor = ta.getColor(R.styleable.NumberInputView_text_color, Color.parseColor("#2780F8"));
        ta.recycle();
        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_numer_input, null);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        this.addView(view);
        bindView(view);
        updateInputNum(mPreText);
    }

    /**
     * BindView
     *
     * @param view
     */
    private void bindView(View view) {
        mInputViews = new TextView[4];
        mInputViews[0] = (TextView) view.findViewById(R.id.tv_number_input_num_1);
        mInputViews[1] = (TextView) view.findViewById(R.id.tv_number_input_num_2);
        mInputViews[2] = (TextView) view.findViewById(R.id.tv_number_input_num_3);
        mInputViews[3] = (TextView) view.findViewById(R.id.tv_number_input_num_4);

        for (int i = 0; i < mInputViews.length; i++) {
            mInputViews[i].setTextColor(mTextColor);
        }

        mDotViews = new ImageView[4];
        mDotViews[0] = (ImageView) view.findViewById(R.id.iv_number_input_num_1);
        mDotViews[1] = (ImageView) view.findViewById(R.id.iv_number_input_num_2);
        mDotViews[2] = (ImageView) view.findViewById(R.id.iv_number_input_num_3);
        mDotViews[3] = (ImageView) view.findViewById(R.id.iv_number_input_num_4);
    }

    /**
     * 更新界面显示
     */
    public void updateInputNum(String luckNum) {

        if (TextUtils.isEmpty(luckNum)) {
            for (TextView textView : mInputViews) {
                textView.setText("");
            }
            for (ImageView dotView : mDotViews) {
                dotView.setVisibility(VISIBLE);
            }
            return;
        }
        for (TextView textView : mInputViews) {
            textView.setText("");
        }

        for (ImageView dotView : mDotViews) {
            dotView.setVisibility(VISIBLE);
        }
        char[] luckNumChar = luckNum.toCharArray();
        for (int i = 0; i < luckNumChar.length; i++) {
            mInputViews[i].setText(luckNumChar[i] + "");
            mDotViews[i].setVisibility(INVISIBLE);
        }

    }
}
