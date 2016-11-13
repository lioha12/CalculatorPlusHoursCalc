package com.liohakonykgmail.mycalc;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import android.widget.CheckBox;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lioha on 08.11.16.
 */

public class HintDialog extends DialogFragment {

    private CheckBox checkBox;
    private SharedPreferences sPr;
    public static final String IS_CHECKED_HINT = "is_dialog_hint_checked";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Log.d("mylog", "onCreateDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_layout, null);
        builder.setTitle(R.string.hint_title);
        builder.setView(v);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                save();
            }
        });

        checkBox = (CheckBox)v.findViewById(R.id.showing);
        checkBox.setChecked(false);

        return builder.create();
    }
    private void save()
    {
        sPr = this.getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPr.edit();
        boolean c = !checkBox.isChecked();
        editor.putBoolean(IS_CHECKED_HINT, c);
        editor.commit();
    }
}