package com.example.calculatorapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
import net.objecthunter.exp4j.operator.Operator;

public class MainActivity extends AppCompatActivity {

    private TextView formulaTxt, resultTxt;
    private String formula, result;
    private Button deleteLastBtn;
    private Operator fac;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initNavView();
        }

        if (savedInstanceState != null) {
            formula = savedInstanceState.getString("formulaStr");
            result = savedInstanceState.getString("resultStr");
            updateFormulaTxt();
        }
    }

    private void init() {
        formulaTxt = findViewById(R.id.formulaView);
        resultTxt = findViewById(R.id.resultView);
        formula = "";
        result = "";
        deleteLastBtn = findViewById(R.id.deleteLastBtn);
        deleteLastBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clearFormulaField(v);
                return true;
            }
        });
        fac = new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {
            @Override
            public double apply(double... args) {
                final int arg = (int) args[0];
                if ((double) arg != args[0]) {
                    throw new IllegalArgumentException("Operand for factorial has to be an integer");
                }
                if (arg < 0) {
                    throw new IllegalArgumentException("The operand of the factorial can not be less than zero");
                }
                double result = 1;
                for (int i = 1; i <= arg; i++) {
                    result *= i;
                }
                return result;
            }
        };
    }

    public void initNavView() {
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                setSize(id);
                return true;
            }
        });
    }

    public void setFormula(View v) {
        Button btn = (Button) v;
        if (btn.getText().toString().equals("sin")) {
            formula = formula + "sin(";
        } else if (btn.getText().toString().equals("cos")) {
            formula = formula + "cos(";
        } else if (btn.getText().toString().equals("tan")) {
            formula = formula + "tan(";
        } else if (btn.getText().toString().equals("log")) {
            formula = formula + "log(";
        } else if (btn.getText().toString().equals("–")) {
            formula = formula + "-";
        } else if (btn.getText().toString().equals("1/x")) {
            formula = formula + "^(-1)";
        } else if (btn.getText().toString().equals("√")) {
            formula = formula + "sqrt(";
        } else if (btn.getText().toString().equals("x")) {
            formula = formula + "*";
        } else if (btn.getText().toString().equals("x^2")) {
            formula = formula + "^2";
        } else if (btn.getText().toString().equals("x!")) {
            formula = formula + "!";
        } else {
            formula = formula + btn.getText().toString();
        }
        updateFormulaTxt();
    }

    public void clearFormulaField(View v) {
        formula = "";
        result = "";
        formulaTxt.setText(formula);
        resultTxt.setText(result);

    }

    public void deleteLastChar(View v) {
        if (formula.length() > 0) {
            formula = formula.substring(0, formula.length() - 1);
            updateFormulaTxt();
        }
    }

    public void calculateToNewValue(View v) {
        if (result.equals("")) {
            result = "Error ";
            updateResultTxt();
        } else if (result.equals("Error ")) {
            // do nothing
        } else {
            formula = result;
            updateFormulaTxt();
        }

    }

    public void calculate() throws RuntimeException {
        try {
            Expression e = new ExpressionBuilder(formula.toString()).variables("π").operator(fac).build().setVariable("π", Math.PI);
            ValidationResult res = e.validate();
            if (res.isValid()) {
                result = "" + e.evaluate();
                Character last = result.charAt(result.length() - 1);
                Character secondLast = result.charAt(result.length() - 2);
                if (last.equals('0') && secondLast.equals('.')) {
                    result = result.substring(0, result.length() - 2);
                }
                updateResultTxt();
            } else {
                result = "";
            }

        } catch (RuntimeException eR) {
            result = "";
        } finally {


            updateResultTxt();
        }
    }

    public void updateFormulaTxt() {
        formulaTxt.setText(formula);
        calculate();
    }

    public void updateResultTxt() {
        resultTxt.setText(result);
    }

    public void setSize(int id) {
        switch (id) {
            case (R.id.nav_small):
                formulaTxt.setTextSize(35);
                break;
            case (R.id.nav_medium):
                formulaTxt.setTextSize(50);
                break;
            case (R.id.nav_large):
                formulaTxt.setTextSize(70);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("formulaStr", formula);
        savedInstanceState.putString("resultStr", result);

        super.onSaveInstanceState(savedInstanceState);
    }


}
