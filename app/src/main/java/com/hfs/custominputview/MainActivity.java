package com.hfs.custominputview;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hfs.custominputview.keybord.NumberInputView;
import com.hfs.custominputview.keybord.NumberKeyboardView;
import com.hfs.custominputview.keybord.OnNumberKeyboardInputListener;

public class MainActivity extends AppCompatActivity implements OnNumberKeyboardInputListener {

    private NumberInputView mNumberInputViewInviteContact;
    private NumberKeyboardView mNumberKeyboardViewInviteContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberInputViewInviteContact = findViewById(R.id.number_input_view_invite_contact);
        mNumberKeyboardViewInviteContact = findViewById(R.id.number_keyboard_view_invite_contact);

        mNumberKeyboardViewInviteContact.setOnNumberKeyboardInputListener(this);
    }

    @Override
    public void onInputValue(String input, boolean complete) {
        mNumberInputViewInviteContact.updateInputNum(input);
        if (complete) {
            Toast.makeText(this, "输入完成--->" + input, Toast.LENGTH_SHORT).show();
        }
    }
}
