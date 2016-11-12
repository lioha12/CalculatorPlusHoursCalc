package com.liohakonykgmail.mycalc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lioha on 08.11.16.
 */

public class HoursCalcFragment extends Fragment implements View.OnClickListener{
    private TextView textView2;
    private Button btnCH;
    private Button btnDELH;
    private Button btn1H;
    private Button btn2H;
    private Button btn3H;
    private Button btn4H;
    private Button btn5H;
    private Button btn6H;
    private Button btn7H;
    private Button btn8H;
    private Button btn9H;
    private Button btn0H;
    private Button btnPlH;
    private Button btnMinusH;
    private Button btnEqH;
    private Button btnTchH;

    private String str = "";

    private SharedPreferences sPr;
    private final String LIST_SIZE = "listSize";

    private ArrayList<String> resultList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hourscalc, container, false);

        btn0H = (Button)v.findViewById(R.id.btn0H);
        btn1H = (Button)v.findViewById(R.id.btn1H);
        btn2H = (Button)v.findViewById(R.id.btn2H);
        btn3H = (Button)v.findViewById(R.id.btn3H);
        btn4H = (Button)v.findViewById(R.id.btn4H);
        btn5H = (Button)v.findViewById(R.id.btn5H);
        btn6H = (Button)v.findViewById(R.id.btn6H);
        btn7H = (Button)v.findViewById(R.id.btn7H);
        btn8H = (Button)v.findViewById(R.id.btn8H);
        btn9H = (Button)v.findViewById(R.id.btn9H);
        btnCH = (Button)v.findViewById(R.id.btnCH);
        btnDELH = (Button)v.findViewById(R.id.btnDELH);
        btnEqH = (Button)v.findViewById(R.id.btnEqH);
        btnMinusH = (Button)v.findViewById(R.id.btnMinusH);
        btnPlH = (Button)v.findViewById(R.id.btnPlH);
        btnTchH = (Button)v.findViewById(R.id.btnTchH);
        textView2 = (TextView)v.findViewById(R.id.tvH);

        btn0H.setOnClickListener(this);
        btn1H.setOnClickListener(this);
        btn2H.setOnClickListener(this);
        btn3H.setOnClickListener(this);
        btn4H.setOnClickListener(this);
        btn5H.setOnClickListener(this);
        btn6H.setOnClickListener(this);
        btn7H.setOnClickListener(this);
        btn8H.setOnClickListener(this);
        btn9H.setOnClickListener(this);
        btnEqH.setOnClickListener(this);
        btnTchH.setOnClickListener(this);
        btnMinusH.setOnClickListener(this);
        btnPlH.setOnClickListener(this);
        btnDELH.setOnClickListener(this);
        btnCH.setOnClickListener(this);

        load();

        registerForContextMenu(textView2);

        return v;
    }

    public void onDestroy()
    {
        super.onDestroy();
        save();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        switch (v.getId()){
            case R.id.tvH:
                for(int i = 1; i <= resultList.size(); i++)
                {
                    menu.add(0, i, 0, resultList.get(i-1));
                }
                break;
        }
    }
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case 1:
                str = resultList.get(0);
                textView2.setText(str);
                break;
            case 2:
                str = resultList.get(1);
                textView2.setText(str);
                break;
            case 3:
                str = resultList.get(2);
                textView2.setText(str);
                break;
            case 4:
                str = resultList.get(3);
                textView2.setText(str);
                break;
            case 5:
                str = resultList.get(4);
                textView2.setText(str);
                break;
            case 6:
                str = resultList.get(5);
                textView2.setText(str);
                break;
            case 7:
                str = resultList.get(6);
                textView2.setText(str);
                break;
            case 8:
                str = resultList.get(7);
                textView2.setText(str);
                break;
            case 9:
                str = resultList.get(8);
                textView2.setText(str);
                break;
            case 10:
                str = resultList.get(9);
                textView2.setText(str);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0H:
                str += "0";
                textView2.setText(str);
                break;
            case R.id.btn1H:
                str += "1";
                textView2.setText(str);
                break;
            case R.id.btn2H:
                str += "2";
                textView2.setText(str);
                break;
            case R.id.btn3H:
                str += "3";
                textView2.setText(str);
                break;
            case R.id.btn4H:
                str += "4";
                textView2.setText(str);
                break;
            case R.id.btn5H:
                str += "5";
                textView2.setText(str);
                break;
            case R.id.btn6H:
                str += "6";
                textView2.setText(str);
                break;
            case R.id.btn7H:
                str += "7";
                textView2.setText(str);
                break;
            case R.id.btn8H:
                str += "8";
                textView2.setText(str);
                break;
            case R.id.btn9H:
                str += "9";
                textView2.setText(str);
                break;
            case R.id.btnPlH:
                str += "+";
                textView2.setText(str);
                break;
            case R.id.btnMinusH:
                str += "-";
                textView2.setText(str);
                break;
            case R.id.btnEqH:
                if(str.endsWith(".")||str.endsWith("+")||str.endsWith("-"))
                {
                    textView2.setText(str);
                    break;
                }
                try {
                    String s = new HoursResult().getResult(str);
                    if(resultList.size() < 10) {
                        resultList.add(s);
                    }
                    else if(resultList.size() >= 10)
                    {
                        resultList.remove(0);
                        resultList.add(s);
                    }
                    save();
                    textView2.setText(str + "\n" + "= " + s);
                    str = s;
                    break;
                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(), "Неверный ввод!", Toast.LENGTH_LONG).show();
                    break;
                }

            case R.id.btnCH:
                str = "";
                textView2.setText(str);
                break;
            case R.id.btnDELH:
                try {
                    str = str.substring(0, str.length() - 1);
                    textView2.setText(str);
                }catch (Exception e)
                {
                    str = "";
                    textView2.setText(str);
                }
                break;
            case R.id.btnTchH:
                if(str.endsWith(":"))
                {
                    textView2.setText(str);
                    break;
                } else if (str.endsWith("+") || str.endsWith("-"))
                {
                    str = str + "0:";
                    textView2.setText(str);
                    break;
                }
                else {
                    str += ":";
                    textView2.setText(str);
                    break;
                }
        }
    }

    private void save()
    {
        sPr = this.getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPr.edit();
        editor.putInt(LIST_SIZE, resultList.size());
        editor.commit();

        for(int i = 0; i < resultList.size(); i++)
        {
            editor.putString(String.valueOf(i), resultList.get(i));
            editor.commit();
        }
    }
    private void load()
    {
        sPr = this.getActivity().getPreferences(MODE_PRIVATE);
       // Log.d("mylog", "--- HORS ---" + sPr.toString());
        int si = sPr.getInt(LIST_SIZE, 0);

        for(int i = 0; i < si; i++)
        {
            String s = sPr.getString(String.valueOf(i), "");
            resultList.add(i, s);
        }
        //SharedPreferences.Editor ed = sPr.edit();
        sPr.edit().clear();
    }


}
