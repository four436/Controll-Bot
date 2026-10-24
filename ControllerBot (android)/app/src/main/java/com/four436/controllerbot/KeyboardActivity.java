package com.four436.controllerbot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;


public class KeyboardActivity extends AppCompatActivity {

    private boolean escPressed = false;
    private boolean tabPressed = false;
    private boolean capsLockPressed = false;
    private boolean shiftPressed = false;
    private boolean ctrlPressed = false;
    private boolean winPressed = false;
    private boolean altPressed = false;
    private boolean spacePressed = false;
    private boolean altGrPressed = false;
    private boolean backspacePressed = false;
    private boolean enterPressed = false;
    private boolean clickSw=false;
    private boolean funcBtnPressed = false;
    private boolean letterAndNumberBtnPressed = false;
    private boolean symbolKeyBtnPressed = false;
    private boolean upArrowPressed = false;
    private boolean downArrowPressed = false;
    private boolean leftArrowPressed = false;
    private boolean rightArrowPressed = false;
    private int funcBtnSlc = 15;
    private char symbolKeySlc = ' ';
    private String letterAndNumberKeySlc = "";
    private MaterialButton escBtn;
    private MaterialButton tabBtn;
    private MaterialButton capsLockBtn;
    private MaterialButton shiftBtn;
    private MaterialButton ctrlBtn;
    private MaterialButton winBtn;
    private MaterialButton altBtn;
    private MaterialButton spaceBtn;
    private MaterialButton altGrBtn;
    private MaterialButton backspaceBtn;
    private MaterialButton enterBtn;
    private MaterialButton shiftBtn2;
    private MaterialButton ctrlBtn2;
    private MaterialButton funcBtnSpi;
    private MaterialSwitch holdSw;
    private MaterialButton  letterAndNumberBtnSp;
    private MaterialButton SymbolKeyBtnSp;
    private MaterialButton upArrowBtn;
    private MaterialButton downArrowBtn;
    private MaterialButton leftArrowBtn;
    private MaterialButton rightArrowBtn;

    private Spinner funcBtnSp;
    private Spinner symbolKeySp;
    private Spinner letterAndNumberKeySp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        escBtn = findViewById(R.id.esc);
        tabBtn = findViewById(R.id.tab);
        capsLockBtn = findViewById(R.id.capsLock);
        shiftBtn = findViewById(R.id.shift);
        ctrlBtn = findViewById(R.id.ctrl);
        winBtn = findViewById(R.id.win);
        altBtn = findViewById(R.id.alt);
        spaceBtn = findViewById(R.id.space);
        altGrBtn = findViewById(R.id.altGr);
        backspaceBtn = findViewById(R.id.backspace);
        enterBtn = findViewById(R.id.enter);
        shiftBtn2 = findViewById(R.id.shift2);
        ctrlBtn2 = findViewById(R.id.ctrl2);
        holdSw = findViewById(R.id.holdSw);
        funcBtnSpi = findViewById(R.id.funcBtnSp);
        letterAndNumberBtnSp = findViewById(R.id.letterAndNumberBtn);
        SymbolKeyBtnSp = findViewById(R.id.SymbolKeyBtn);
        upArrowBtn = findViewById(R.id.uparrow);
        downArrowBtn = findViewById(R.id.downarrow);
        leftArrowBtn = findViewById(R.id.leftarrow);
        rightArrowBtn = findViewById(R.id.rightarrow);
        funcBtnSp = findViewById(R.id.functionBtnSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.functionBtnData));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        funcBtnSp.setAdapter(adapter);
        funcBtnSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(parent.getItemAtPosition(position).toString()){
                    case "F1":
                        funcBtnSlc = 1;
                        break;
                    case "F2":
                        funcBtnSlc = 2;
                        break;
                    case "F3":
                        funcBtnSlc = 3;
                        break;
                    case "F4":
                        funcBtnSlc = 4;
                        break;
                    case "F5":
                        funcBtnSlc = 5;
                        break;
                    case "F6":
                        funcBtnSlc = 6;
                        break;
                    case "F7":
                        funcBtnSlc = 7;
                        break;
                    case "F8":
                        funcBtnSlc = 8;
                        break;
                    case "F9":
                        funcBtnSlc = 9;
                        break;
                    case "F10":
                        funcBtnSlc = 10;
                        break;
                    case "F11":
                        funcBtnSlc = 11;
                        break;
                    case "F12":
                        funcBtnSlc = 12;
                        break;
                    default:
                        funcBtnSlc = 15;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        symbolKeySp = findViewById(R.id.symbolKeySpinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.symbolsKeyData));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        symbolKeySp.setAdapter(adapter2);
        symbolKeySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (parent.getItemAtPosition(position).toString()){
                    case "!":
                        symbolKeySlc = '!';
                        break;
                    case "\"":
                        symbolKeySlc = '\"';
                        break;
                    case "#":
                        symbolKeySlc = '#';
                        break;
                    case "$":
                        symbolKeySlc = '$';
                        break;
                    case "%":
                        symbolKeySlc = '%';
                        break;
                    case "&":
                        symbolKeySlc = '&';
                        break;
                    case "'":
                        symbolKeySlc = '\'';
                        break;
                    case "(":
                        symbolKeySlc = '(';
                        break;
                    case ")":
                        symbolKeySlc = ')';
                        break;
                    case "*":
                        symbolKeySlc = '*';
                        break;
                    case "+":
                        symbolKeySlc = '+';
                        break;
                    case ",":
                        symbolKeySlc = ',';
                        break;
                    case "-":
                        symbolKeySlc = '-';
                        break;
                    case ".":
                        symbolKeySlc = '.';
                        break;
                    case "/":
                        symbolKeySlc = '/';
                        break;
                    case ":":
                        symbolKeySlc = ':';
                        break;
                    case ";":
                        symbolKeySlc = ';';
                        break;
                    case "<":
                        symbolKeySlc = '<';
                        break;
                    case "=":
                        symbolKeySlc = '=';
                        break;
                    case ">":
                        symbolKeySlc = '>';
                        break;
                    case "?":
                        symbolKeySlc = '?';
                        break;
                    case "@":
                        symbolKeySlc = '@';
                        break;
                    case "[":
                        symbolKeySlc = '[';
                        break;
                    case "\\":
                        symbolKeySlc = '\\';
                        break;
                    case "]":
                        symbolKeySlc = ']';
                        break;
                    case "^":
                        symbolKeySlc = '^';
                        break;
                    case "_":
                        symbolKeySlc = '_';
                        break;
                    case "`":
                        symbolKeySlc = '`';
                        break;
                    case "{":
                        symbolKeySlc = '{';
                        break;
                    case "|":
                        symbolKeySlc = '|';
                        break;
                    case "}":
                        symbolKeySlc = '}';
                        break;
                    case "~":
                        symbolKeySlc = '~';
                        break;
                    default:
                        symbolKeySlc = ' ';
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        letterAndNumberKeySp = findViewById(R.id.letterAndNumberKeySpinner);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.letterAndNumberBtnData));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        letterAndNumberKeySp.setAdapter(adapter3);
        letterAndNumberKeySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                letterAndNumberKeySlc = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void backBtn(View view){
        Intent intent = new Intent(KeyboardActivity.this, ChooseControlActivity.class);
        startActivity(intent);

    }

    public void escBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickEscBtn();
        } else{
            escPressed = !escPressed;
            changeBackground(escBtn, escPressed);
            KeyboardCommunication.escBtn(escPressed);
        }
    }
    public void tabBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickTabBtn();
        } else {
            tabPressed = !tabPressed;
            changeBackground(tabBtn, tabPressed);
            KeyboardCommunication.tabBtn(tabPressed);
        }
    }
    public void capsLockBtn(View view){
        if(holdSw.isChecked()) {
            KeyboardCommunication.clickCapsLockBtn();
        } else {
            capsLockPressed = !capsLockPressed;
            changeBackground(capsLockBtn, capsLockPressed);
            KeyboardCommunication.capsLockBtn(capsLockPressed);
        }
    }
    public void shiftBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickShiftBtn();
        } else {
            shiftPressed = !shiftPressed;
            changeBackground(shiftBtn, shiftPressed);
            changeBackground(shiftBtn2, shiftPressed);
            KeyboardCommunication.shiftBtn(shiftPressed);
        }
    }
    public void ctrlBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickCtrlBtn();
        } else {
            ctrlPressed = !ctrlPressed;
            changeBackground(ctrlBtn, ctrlPressed);
            changeBackground(ctrlBtn2, ctrlPressed);
            KeyboardCommunication.ctrlBtn(ctrlPressed);
        }
    }
    public void winBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickWinBtn();
        } else {
            winPressed = !winPressed;
            changeBackground(winBtn, winPressed);
            KeyboardCommunication.winBtn(winPressed);
        }
    }
    public void altBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickAltBtn();
        } else {
            altPressed = !altPressed;
            changeBackground(altBtn, altPressed);
            KeyboardCommunication.altBtn(altPressed);
        }

    }
    public void spaceBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickSpaceBtn();
        } else {
            spacePressed = !spacePressed;
            changeBackground(spaceBtn, spacePressed);
            KeyboardCommunication.spaceBtn(spacePressed);
        }
    }
    public void altGrBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickAltGrBtn();
        } else {
            altGrPressed = !altGrPressed;
            changeBackground(altGrBtn, altGrPressed);
            KeyboardCommunication.altGrBtn(altGrPressed);
        }
    }
    public void backspaceBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickBackspaceBtn();
        } else {
            backspacePressed = !backspacePressed;
            changeBackground(backspaceBtn, backspacePressed);
            KeyboardCommunication.backspaceBtn(backspacePressed);
        }
    }
    public void enterBtn(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickEnterBtn();
        } else {
            enterPressed = !enterPressed;
            changeBackground(enterBtn, enterPressed);
            KeyboardCommunication.enterBtn(enterPressed);
        }
    }


    public void functioBtnAct(View view){
        if(holdSw.isChecked()){
            funcBtnSpi.setText("Click");
            KeyboardCommunication.clickFuncBtn(funcBtnSlc);
        }else if(!holdSw.isChecked() && funcBtnPressed){
            funcBtnSpi.setText("Press");
            funcBtnPressed = !funcBtnPressed;
            KeyboardCommunication.FuncBtn(funcBtnSlc, funcBtnPressed);
        } else if (!holdSw.isChecked() && !funcBtnPressed) {
            funcBtnPressed = !funcBtnPressed;
            funcBtnSpi.setText("Release");
            KeyboardCommunication.FuncBtn(funcBtnSlc, funcBtnPressed);
        }
    }

    public void letterAndNumberBtnAct(View view){
        if(holdSw.isChecked()){
            letterAndNumberBtnSp.setText("Click");
            KeyboardCommunication.clickLetterAndNumberBtn(letterAndNumberKeySlc.charAt(0));
        }else if(!holdSw.isChecked() && letterAndNumberBtnPressed){
            letterAndNumberBtnSp.setText("Press");
            letterAndNumberBtnPressed = !letterAndNumberBtnPressed;
            KeyboardCommunication.LetterAndNumberBtn(letterAndNumberKeySlc.charAt(0), letterAndNumberBtnPressed);
        } else if (!holdSw.isChecked() && !funcBtnPressed) {
            letterAndNumberBtnPressed = !letterAndNumberBtnPressed;
            letterAndNumberBtnSp.setText("Release");
            KeyboardCommunication.LetterAndNumberBtn(letterAndNumberKeySlc.charAt(0), letterAndNumberBtnPressed);

        }
    }

    public void symbolBtnAct(View view){
        if(holdSw.isChecked()){
            SymbolKeyBtnSp.setText("Click");
            KeyboardCommunication.clickSymbolKeyBtn(symbolKeySlc);
        }else if(!holdSw.isChecked() && symbolKeyBtnPressed){
            SymbolKeyBtnSp.setText("Press");
            symbolKeyBtnPressed = !symbolKeyBtnPressed;
            KeyboardCommunication.symbolKeyBtn(symbolKeySlc, symbolKeyBtnPressed);
        } else if (!holdSw.isChecked() && !symbolKeyBtnPressed) {
            symbolKeyBtnPressed = !symbolKeyBtnPressed;
            SymbolKeyBtnSp.setText("Release");
            KeyboardCommunication.symbolKeyBtn(symbolKeySlc, symbolKeyBtnPressed);
        }
    }

    public void holdSw(View view){
        if(holdSw.isChecked()){
            funcBtnSpi.setText("Click");
            unclick();
        }
    }

    public void releaseAll(View view){
        unclick();
    }

    public void unclick(){
        funcBtnPressed = false;
        funcBtnSpi.setText("Press");
        letterAndNumberBtnPressed = false;
        letterAndNumberBtnSp.setText("Press");
        symbolKeyBtnPressed = false;
        SymbolKeyBtnSp.setText("Press");
        escPressed = false;
        tabPressed = false;
        capsLockPressed = false;
        shiftPressed = false;
        ctrlPressed = false;
        winPressed = false;
        altPressed = false;
        spacePressed = false;
        altGrPressed = false;
        backspacePressed = false;
        enterPressed = false;
        changeBackground(escBtn, escPressed);
        changeBackground(tabBtn, tabPressed);
        changeBackground(capsLockBtn, capsLockPressed);
        changeBackground(shiftBtn, shiftPressed);
        changeBackground(ctrlBtn, ctrlPressed);
        changeBackground(winBtn, winPressed);
        changeBackground(altBtn, altPressed);
        changeBackground(spaceBtn, spacePressed);
        changeBackground(altGrBtn, altGrPressed);
        changeBackground(backspaceBtn, backspacePressed);
        changeBackground(enterBtn, enterPressed);
        changeBackground(shiftBtn2, shiftPressed);
        changeBackground(ctrlBtn2, ctrlPressed);
        KeyboardCommunication.escBtn(escPressed);
        KeyboardCommunication.tabBtn(tabPressed);
        KeyboardCommunication.capsLockBtn(capsLockPressed);
        KeyboardCommunication.shiftBtn(shiftPressed);
        KeyboardCommunication.ctrlBtn(ctrlPressed);
        KeyboardCommunication.winBtn(winPressed);
        KeyboardCommunication.altBtn(altPressed);
        KeyboardCommunication.spaceBtn(spacePressed);
        KeyboardCommunication.altGrBtn(altGrPressed);
        KeyboardCommunication.backspaceBtn(backspacePressed);
        KeyboardCommunication.enterBtn(enterPressed);
        KeyboardCommunication.FuncBtn(funcBtnSlc, funcBtnPressed);
        KeyboardCommunication.LetterAndNumberBtn(letterAndNumberKeySlc.charAt(0), letterAndNumberBtnPressed);
        KeyboardCommunication.symbolKeyBtn(symbolKeySlc, symbolKeyBtnPressed);
    }

    public void upArrow(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickArrowBtn(0);
        } else {
            upArrowPressed = !upArrowPressed;
            changeBackground(upArrowBtn, upArrowPressed);
            KeyboardCommunication.pressArrowBtn(0 ,upArrowPressed);
        }
    }
    public void downArrow(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickArrowBtn(1);
        } else {
            downArrowPressed = !downArrowPressed;
            changeBackground(downArrowBtn, downArrowPressed);
            KeyboardCommunication.pressArrowBtn(1 ,downArrowPressed);
        }
    }
    public void leftArrow(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickArrowBtn(2);
        } else {
            leftArrowPressed = !leftArrowPressed;
            changeBackground(leftArrowBtn, leftArrowPressed);
            KeyboardCommunication.pressArrowBtn(2 ,leftArrowPressed);
        }
    }
    public void rightArrow(View view){
        if(holdSw.isChecked()){
            KeyboardCommunication.clickArrowBtn(3);
        } else {
            rightArrowPressed = !rightArrowPressed;
            changeBackground(rightArrowBtn, rightArrowPressed);
            KeyboardCommunication.pressArrowBtn(3 ,rightArrowPressed);
        }
    }

    public void changeBackground(MaterialButton btn, boolean pressed){
        if(pressed){
            btn.setBackgroundColor(getColor(R.color.pressed));
        }else{
            btn.setBackgroundColor(getColor(R.color.white));
        }

    }

}