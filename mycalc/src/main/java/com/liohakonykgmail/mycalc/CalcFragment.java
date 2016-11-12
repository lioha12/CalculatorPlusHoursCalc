package com.liohakonykgmail.mycalc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static com.liohakonykgmail.mycalc.HintDialog.IS_CHECKED_HINT;

/**
 * Created by lioha on 08.11.16.
 */

public class CalcFragment extends Fragment implements View.OnClickListener {

    private final String SHOW_DIALOG = "dialog";

    private SharedPreferences sPr;

    private TextView textView;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btn00;
    private Button btnTChK;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnDivision;
    private Button btnMultiply;
    private Button btnEqually;
    private Button btnClear;
    private Button btnDel;
    private Button btnSqw;

    private String str = "";

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        new HintShower().execute();
        /*Log.d("mylog", "onAttach");
        FragmentManager fm = getActivity().getSupportFragmentManager();

        HintDialog dialog = HintDialog.newInstance();
        if(dialog == null)
        {
            return;
        }else{
            dialog.show(fm, SHOW_DIALOG);}*/
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.calculatorscreen, parent, false);

        textView = (TextView)v.findViewById(R.id.textView);
        btn1 = (Button)v.findViewById(R.id.btn1);
        btn2 = (Button)v.findViewById(R.id.btn2);
        btn3 = (Button)v.findViewById(R.id.btn3);
        btn4 = (Button)v.findViewById(R.id.btn4);
        btn5 = (Button)v.findViewById(R.id.btn5);
        btn6 = (Button)v.findViewById(R.id.btn6);
        btn7 = (Button)v.findViewById(R.id.btn7);
        btn8 = (Button)v.findViewById(R.id.btn8);
        btn9 = (Button)v.findViewById(R.id.btn9);
        btn0 = (Button)v.findViewById(R.id.btn0);
        btn00 = (Button)v.findViewById(R.id.btn00);
        btnClear = (Button)v.findViewById(R.id.btnclear);
        btnDel = (Button)v.findViewById(R.id.btnDel);
        btnDivision = (Button)v.findViewById(R.id.btnDivision);
        btnEqually = (Button)v.findViewById(R.id.btnEqually);
        btnMinus = (Button)v.findViewById(R.id.btnMinus);
        btnMultiply = (Button)v.findViewById(R.id.btnMultiply);
        btnPlus = (Button)v.findViewById(R.id.btnPlus);
        btnTChK = (Button)v.findViewById(R.id.btnTChK);
        btnSqw = (Button)v.findViewById(R.id.btnRoot);

        btn0.setOnClickListener(this);
        btn00.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEqually.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnTChK.setOnClickListener(this);
        btnSqw.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                str = str + "0";
                textView.setText(str);
                break;
            case R.id.btn00:
                str += "00";
                textView.setText(str);
                break;
            case R.id.btn1:
                str += "1";
                textView.setText(str);
                break;
            case R.id.btn2:
                str += "2";
                textView.setText(str);
                break;
            case R.id.btn3:
                str += "3";
                textView.setText(str);
                break;
            case R.id.btn4:
                str += "4";
                textView.setText(str);
                break;
            case R.id.btn5:
                str += "5";
                textView.setText(str);
                break;
            case R.id.btn6:
                str += "6";
                textView.setText(str);
                break;
            case R.id.btn7:
                str += "7";
                textView.setText(str);
                break;
            case R.id.btn8:
                str += "8";
                textView.setText(str);
                break;
            case R.id.btn9:
                str += "9";
                textView.setText(str);
                break;
            case R.id.btnTChK:
                if (str.endsWith(".") || str.endsWith("+") || str.endsWith("-") || str.endsWith("*") || str.endsWith("/")) {
                    textView.setText(str);
                } else {
                    str += ".";
                    textView.setText(str);
                }
                break;
            case R.id.btnclear:
                str = "";
                textView.setText(str);
                break;
            case R.id.btnEqually:
                if (str.endsWith(".") || str.endsWith("+") || str.endsWith("-") || str.endsWith("*") ||
                        str.endsWith("/") || str.endsWith("√")) {
                    textView.setText(str);
                    break;
                }
                String s = new Result(str).getResult();
                if (s.equals("Wrong input")) {
                    Toast.makeText(getActivity(), getString(R.string.wrong_input), Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    textView.setText(str + "\n" + "= " + s);
                    str = s;
                    break;
                }
            case R.id.btnDivision:
                if (str.endsWith(".") || str.endsWith("+") || str.endsWith("-") || str.endsWith("*")
                        || str.endsWith("/") || str.endsWith("√")) {
                    textView.setText(str);
                    break;
                }
                str += "/";
                textView.setText(str);
                break;
            case R.id.btnMinus:
                /*if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-")||str.endsWith("*")||str.endsWith("/"))
                {
                    textView.setText(str);
                    break;
                }*/
                str += "-";
                textView.setText(str);
                break;
            case R.id.btnMultiply:
                if (str.endsWith(".") || str.endsWith("+") || str.endsWith("-") || str.endsWith("*") || str.endsWith("/")) {
                    textView.setText(str);
                    break;
                }
                str += "*";
                textView.setText(str);
                break;
            case R.id.btnPlus:
                if (str.endsWith(".") || str.endsWith("+") || str.endsWith("-") || str.endsWith("*") || str.endsWith("/")) {
                    textView.setText(str);
                    break;
                }
                str += "+";
                textView.setText(str);
                break;
            case R.id.btnDel:
                try {
                    str = str.substring(0, str.length() - 1);
                    textView.setText(str);
                } catch (Exception e) {
                    textView.setText("");
                }
                break;
            case R.id.btnRoot:
                if (str.endsWith("0") || str.endsWith("1") || str.endsWith("1") || str.endsWith("2")
                        || str.endsWith("3") || str.endsWith("4") || str.endsWith("5") || str.endsWith("6")
                        || str.endsWith("7") || str.endsWith("8") || str.endsWith("9")) {
                    str = str + "*√";
                    textView.setText(str);
                } else if (str.endsWith("√")) {
                    textView.setText(str);
                    break;
                } else {
                    str += "√";
                    textView.setText(str);
                    break;
                }
        }
    }

    private class HintShower extends AsyncTask<Void, Void, Boolean>{

        HintDialog dialog;
        boolean isShow;
        FragmentManager fm;

        @Override
        protected Boolean doInBackground(Void... params) {
            isShow = loadBoolean();
            return isShow;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean)
            {
                dialog = new HintDialog();
                fm = getActivity().getSupportFragmentManager();
                dialog.show(fm, SHOW_DIALOG);
            }else return;
        }
    }
    public boolean loadBoolean()
    {
        sPr = this.getActivity().getPreferences(MODE_PRIVATE);
        return  sPr.getBoolean(IS_CHECKED_HINT, true);
    }
}