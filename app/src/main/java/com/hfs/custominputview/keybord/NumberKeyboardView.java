package com.hfs.custominputview.keybord;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hfs.custominputview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangFusheng
 * @date 2020-03-10
 * description 自定义数字键盘
 */
public class NumberKeyboardView extends LinearLayout implements View.OnClickListener {

    /**
     * 所有按键
     */
    private TextView[] mTextViews;
    /**
     * 删除
     */
    private ImageView mIvDelete;

    /**
     * 保存所有输入的值
     */
    private List<String> mInputKeys = new ArrayList<>();

    /**
     * 点击回调事件
     */
    private OnNumberKeyboardInputListener mOnNumberKeyboardInputListener;

    public NumberKeyboardView(Context context) {
        super(context);
        initView();
    }

    public NumberKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    /**
     * View初始化
     */
    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_number_keyboard, null);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        this.addView(view);

        bindView(view);
    }

    public void setOnNumberKeyboardInputListener(OnNumberKeyboardInputListener onNumberKeyboardInputListener) {
        this.mOnNumberKeyboardInputListener = onNumberKeyboardInputListener;
    }

    /**
     * FindViewById
     */
    private void bindView(View view) {

        mTextViews = new TextView[10];
        mTextViews[0] = view.findViewById(R.id.key_1);
        mTextViews[1] = view.findViewById(R.id.key_2);
        mTextViews[2] = view.findViewById(R.id.key_3);
        mTextViews[3] = view.findViewById(R.id.key_4);
        mTextViews[4] = view.findViewById(R.id.key_5);
        mTextViews[5] = view.findViewById(R.id.key_6);
        mTextViews[6] = view.findViewById(R.id.key_7);
        mTextViews[7] = view.findViewById(R.id.key_8);
        mTextViews[8] = view.findViewById(R.id.key_9);
        mTextViews[9] = view.findViewById(R.id.key_0);

        mIvDelete = view.findViewById(R.id.key_delete);

        for (int i = 0; i < 10; i++) {
            mTextViews[i].setOnClickListener(this);
        }

        mIvDelete.setOnClickListener(this);

    }

    /**
     * 往List中添加
     *
     * @param str
     */
    private void addKey2List(String str) {
        if (mInputKeys == null) {
            mInputKeys = new ArrayList<>();
        }
        if (mInputKeys.size() < 4) {
            mInputKeys.add(str);
            if (mOnNumberKeyboardInputListener != null) {
                mOnNumberKeyboardInputListener.onInputValue(getAllInputStr(), mInputKeys.size() == 4);
            }
        }

    }

    /**
     * 删除最后一个值
     */
    private void delKey2List() {
        if (mInputKeys == null || mInputKeys.size() <= 0) {
            return;
        }
        mInputKeys.remove(mInputKeys.size() - 1);
        if (mOnNumberKeyboardInputListener != null) {
            mOnNumberKeyboardInputListener.onInputValue(getAllInputStr(), mInputKeys.size() == 4);
        }
    }

    /**
     * 获取所有的输入内容
     *
     * @return
     */
    private String getAllInputStr() {
        if (mInputKeys == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String str : mInputKeys) {
            sb.append(str);
        }
        return sb.toString();
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.key_1) {
            addKey2List("1");
        } else if (id == R.id.key_2) {
            addKey2List("2");
        } else if (id == R.id.key_3) {
            addKey2List("3");
        } else if (id == R.id.key_4) {
            addKey2List("4");
        } else if (id == R.id.key_5) {
            addKey2List("5");
        } else if (id == R.id.key_6) {
            addKey2List("6");
        } else if (id == R.id.key_7) {
            addKey2List("7");
        } else if (id == R.id.key_8) {
            addKey2List("8");
        } else if (id == R.id.key_9) {
            addKey2List("9");
        } else if (id == R.id.key_0) {
            addKey2List("0");
        } else if (id == R.id.key_delete) {
            delKey2List();
        }
    }
}
