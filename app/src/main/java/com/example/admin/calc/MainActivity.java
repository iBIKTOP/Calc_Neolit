package com.example.admin.calc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner1,spinner2,spinner3;
    EditText etCustomer,etCarrier,etReturn,etDelta,etPersent;
    RadioButton radioButton1,radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //************* установка спиннеров*************************
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        //spinner3 = (Spinner)findViewById(R.id.spinner3);
        //создаем адаптер на основе моего лейаута и массива с данными
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,R.array.pay,R.layout.spinner_text);
        //устанавливаем метод показа адаптера
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        //загоняем адаптер в спинер
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        //spinner3.setAdapter(adapter);
        //spinner3.setSelection(2);
        //***********************************************************
        //*****находим елементы и устанавливаем слушатели************
        Button generate = (Button)findViewById(R.id.Generate);
        generate.setOnClickListener(this);
        Button number_1 = (Button)findViewById(R.id.number_1);
        number_1.setOnClickListener(this);
        Button number_2 = (Button)findViewById(R.id.number_2);
        number_2.setOnClickListener(this);
        Button number_3 = (Button)findViewById(R.id.number_3);
        number_3.setOnClickListener(this);
        Button number_4 = (Button)findViewById(R.id.number_4);
        number_4.setOnClickListener(this);
        Button number_5 = (Button)findViewById(R.id.number_5);
        number_5.setOnClickListener(this);
        Button number_6 = (Button)findViewById(R.id.number_6);
        number_6.setOnClickListener(this);
        Button number_7 = (Button)findViewById(R.id.number_7);
        number_7.setOnClickListener(this);
        Button number_8 = (Button)findViewById(R.id.number_8);
        number_8.setOnClickListener(this);
        Button number_9 = (Button)findViewById(R.id.number_9);
        number_9.setOnClickListener(this);
        Button number_0 = (Button)findViewById(R.id.number_0);
        number_0.setOnClickListener(this);
        Button number_point = (Button)findViewById(R.id.number_point);
        number_point.setOnClickListener(this);
        Button clear = (Button)findViewById(R.id.btClear);
        clear.setOnClickListener(this);
        Button delete = (Button)findViewById(R.id.btDelete);
        delete.setOnClickListener(this);
        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton1.setOnClickListener(this);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton2.setOnClickListener(this);
        etCustomer = (EditText)findViewById(R.id.etCustomer);
        etCarrier = (EditText)findViewById(R.id.etCarrier);
        etReturn = (EditText)findViewById(R.id.etReturn);
        etDelta = (EditText)findViewById(R.id.etDelata);
        etPersent = (EditText)findViewById(R.id.etPersent);
        //********************************************************************

    }
    //это метод который переделывает double в String и меняет запятые на точки
    public String doMyDecimalFormat(double d){
        String df = new DecimalFormat("#0.00").format(d);
        df = df.replace(",",".");
        return df;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Generate:
                double dCustomer = Double.valueOf(etCustomer.getText().toString());
                double dCarrier = Double.valueOf(etCarrier.getText().toString());
                double dReturn = Double.valueOf(etReturn.getText().toString());
                //варианты оплат по Украине**********************************************************
                if (spinner1.getSelectedItem().toString().equals("Б/Г з ПДВ")&&spinner2.getSelectedItem().toString().equals("Б/Г з ПДВ")&&radioButton1.isChecked()){
                    double dDelta = (dCustomer-dCarrier)-((dCustomer-dCarrier)*0.2)-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                if (spinner1.getSelectedItem().toString().equals("Б/Г з ПДВ")&&spinner2.getSelectedItem().toString().equals("Б/Г на єдиний")&&radioButton1.isChecked()){
                    double dDelta = (dCustomer-(dCustomer*0.176))-dCarrier-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                if (spinner1.getSelectedItem().toString().equals("Б/Г з ПДВ")&&spinner2.getSelectedItem().toString().equals("Софт/Нал")&&radioButton1.isChecked()){
                    double dDelta = (dCustomer-(dCustomer*0.2))-dCarrier-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                if (spinner1.getSelectedItem().toString().equals("Б/Г на єдиний")&&spinner2.getSelectedItem().toString().equals("Б/Г з ПДВ")&&radioButton1.isChecked()){
                    double dDelta = (dCustomer-dCarrier)-((dCustomer-dCarrier)*0.06)-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                if (spinner1.getSelectedItem().toString().equals("Б/Г на єдиний")&&spinner2.getSelectedItem().toString().equals("Б/Г на єдиний")&&radioButton1.isChecked()){
                    double dDelta = (dCustomer-dCarrier)-((dCustomer-dCarrier)*0.06)-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                if (spinner1.getSelectedItem().toString().equals("Б/Г на єдиний")&&spinner2.getSelectedItem().toString().equals("Софт/Нал")&&radioButton1.isChecked()){
                    double dDelta = (dCustomer-(dCustomer*0.06))-dCarrier-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                if (spinner1.getSelectedItem().toString().equals("Софт/Нал")&&spinner2.getSelectedItem().toString().equals("Софт/Нал")&&radioButton1.isChecked()){
                    double dDelta = dCustomer-dCarrier-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                //варианты оплат Межгород**********************************************************
                if (spinner1.getSelectedItem().toString().equals("Б/Г з ПДВ")&&spinner2.getSelectedItem().toString().equals("Б/Г з ПДВ")&&radioButton2.isChecked()){
                    double dDelta = (dCustomer-dCarrier)-((dCustomer-dCarrier)*0.2)-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                if (spinner1.getSelectedItem().toString().equals("Б/Г з ПДВ")&&spinner2.getSelectedItem().toString().equals("Б/Г на єдиний")&&radioButton2.isChecked()){
                    double dDelta = (dCustomer-dCarrier)-((dCustomer-dCarrier)*0.2)-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
//                if (spinner1.getSelectedItem().toString().equals("Б/Г з ПДВ")&&spinner2.getSelectedItem().toString().equals("Софт/Нал")&&radioButton2.isChecked()){
//                    double dDelta = (dCustomer-(dCustomer*0.2))-dCarrier-dReturn;
//                    double dPersent = (dDelta*100)/dCustomer;
//                    if (dDelta%1==0){
//                        etDelta.setText(String.valueOf((int)dDelta));
//                    }else{
//                        etDelta.setText(doMyDecimalFormat(dDelta));
//                    }
//                    etPersent.setText(String.valueOf(dPersent));
//                    break;
//                }
                if (spinner1.getSelectedItem().toString().equals("Б/Г на єдиний")&&spinner2.getSelectedItem().toString().equals("Б/Г з ПДВ")&&radioButton2.isChecked()){
                    double dDelta = (dCustomer-dCarrier)-((dCustomer-dCarrier)*0.06)-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
                if (spinner1.getSelectedItem().toString().equals("Б/Г на єдиний")&&spinner2.getSelectedItem().toString().equals("Б/Г на єдиний")&&radioButton2.isChecked()){
                    double dDelta = (dCustomer-dCarrier)-((dCustomer-dCarrier)*0.06)-dReturn;
                    double dPersent = (dDelta*100)/dCustomer;
                    if (dDelta%1==0){
                        etDelta.setText(String.valueOf((int)dDelta));
                    }else{
                        etDelta.setText(doMyDecimalFormat(dDelta));
                    }
                    etPersent.setText(String.valueOf(dPersent));
                    break;
                }
//                if (spinner1.getSelectedItem().toString().equals("Б/Г на єдиний")&&spinner2.getSelectedItem().toString().equals("Софт/Нал")&&radioButton2.isChecked()){
//                    double dDelta = (dCustomer-(dCustomer*0.06))-dCarrier-dReturn;
//                    double dPersent = (dDelta*100)/dCustomer;
//                    if (dDelta%1==0){
//                        etDelta.setText(String.valueOf((int)dDelta));
//                    }else{
//                        etDelta.setText(doMyDecimalFormat(dDelta));
//                    }
//                    etPersent.setText(String.valueOf(dPersent));
//                    break;
//                }
//                if (spinner1.getSelectedItem().toString().equals("Софт/Нал")&&spinner2.getSelectedItem().toString().equals("Софт/Нал")&&radioButton2.isChecked()){
//                    double dDelta = dCustomer-dCarrier-dReturn;
//                    double dPersent = (dDelta*100)/dCustomer;
//                    if (dDelta%1==0){
//                        etDelta.setText(String.valueOf((int)dDelta));
//                    }else{
//                        etDelta.setText(doMyDecimalFormat(dDelta));
//                    }
//                    etPersent.setText(String.valueOf(dPersent));
//                    break;
//                }
                //*********************************************************************
                else{
                    Toast.makeText(getApplicationContext(),"Такий варіант оплати неможливий!",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btClear:
                etCustomer.setText("0");
                etCarrier.setText("0");
                etReturn.setText("0");
                etDelta.setText("0");
                etPersent.setText("0");
                break;

            case R.id.btDelete:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        //ничего не делаем
                        break;
                    }
                    if (etCustomer.getText().length()>1){
                        etCustomer.setText(etCustomer.getText().toString().substring(0, etCustomer.getText().length() - 1));
                        break;
                    }
                    if (etCustomer.getText().length()==1){
                        etCustomer.setText("0");
                        break;
                    }
                }

                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (R.id.etCarrier == this.getCurrentFocus().getId()){
                        if (etCarrier.getText().toString().equals("0")){
                            //ничего не делаем
                            break;
                        }
                        if (etCarrier.getText().length()>1){
                            etCarrier.setText(etCarrier.getText().toString().substring(0, etCarrier.getText().length() - 1));
                            break;
                        }
                        if (etCarrier.getText().length()==1){
                            etCarrier.setText("0");
                            break;
                        }
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (R.id.etReturn == this.getCurrentFocus().getId()){
                        if (etReturn.getText().toString().equals("0")){
                            //ничего не делаем
                            break;
                        }
                        if (etReturn.getText().length()>1){
                            etReturn.setText(etReturn.getText().toString().substring(0, etReturn.getText().length() - 1));
                            break;
                        }
                        if (etReturn.getText().length()==1){
                            etReturn.setText("0");
                            break;
                        }
                    }
                }
                break;
            case R.id.number_1:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("1");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"1");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("1");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"1");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("1");
                    }else{
                        etReturn.setText(etReturn.getText()+"1");
                    }
                }
                break;
            case R.id.number_2:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("2");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"2");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("2");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"2");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("2");
                    }else{
                        etReturn.setText(etReturn.getText()+"2");
                    }
                }
                break;
            case R.id.number_3:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("3");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"3");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("3");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"3");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("3");
                    }else{
                        etReturn.setText(etReturn.getText()+"3");
                    }
                }
                break;
            case R.id.number_4:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("4");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"4");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("4");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"4");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("4");
                    }else{
                        etReturn.setText(etReturn.getText()+"4");
                    }
                }
                break;
            case R.id.number_5:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("5");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"5");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("5");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"5");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("5");
                    }else{
                        etReturn.setText(etReturn.getText()+"5");
                    }
                }
                break;
            case R.id.number_6:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("6");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"6");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("6");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"6");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("6");
                    }else{
                        etReturn.setText(etReturn.getText()+"6");
                    }
                }
                break;
            case R.id.number_7:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("7");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"7");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("7");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"7");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("7");
                    }else{
                        etReturn.setText(etReturn.getText()+"7");
                    }
                }
                break;
            case R.id.number_8:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("8");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"8");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("8");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"8");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("8");
                    }else{
                        etReturn.setText(etReturn.getText()+"8");
                    }
                }
                break;
            case R.id.number_9:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("9");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"9");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("9");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"9");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("9");
                    }else{
                        etReturn.setText(etReturn.getText()+"9");
                    }
                }
                break;
            case R.id.number_0:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("0");
                    }else{
                        etCustomer.setText(etCustomer.getText()+"0");
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("0");
                    }else{
                        etCarrier.setText(etCarrier.getText()+"0");
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("0");
                    }else{
                        etReturn.setText(etReturn.getText()+"0");
                    }
                }
                break;
            case R.id.number_point:
                if (R.id.etCustomer == this.getCurrentFocus().getId()){
                    if (etCustomer.getText().toString().equals("0")){
                        etCustomer.setText("0.");
                    }else{
                        if (!etCustomer.getText().toString().contains(".")) {
                            etCustomer.setText(etCustomer.getText() + ".");
                        }
                    }
                }
                if (R.id.etCarrier == this.getCurrentFocus().getId()){
                    if (etCarrier.getText().toString().equals("0")){
                        etCarrier.setText("0.");
                    }else{
                        if (!etCarrier.getText().toString().contains(".")) {
                            etCarrier.setText(etCarrier.getText() + ".");
                        }
                    }
                }
                if (R.id.etReturn == this.getCurrentFocus().getId()){
                    if (etReturn.getText().toString().equals("0")){
                        etReturn.setText("0.");
                    }else{
                        if (!etReturn.getText().toString().contains(".")) {
                            etReturn.setText(etReturn.getText() + ".");
                        }
                    }
                }
                break;
        }
    }
}