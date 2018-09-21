/**
 *  c = Celsius F = Fahrenheit K = Kelvin R = Rankine N = Newton De = Delisle Re = Reaumur Ro = Romer
 *  */
package net.digitalbd.smarttemperatureconverter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends Activity {
    Temperature converter;
    private double tF,tC,tR,tK,tRe,tRo,tN,tDe;
    public EditText temp_input;
    public TextView displayF,displayC,displayR,displayK,displayRe,displayRo,displayN,displayDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.converter = new Temperature();
        this.setAllTemperature();
        this.temp_input = (EditText) findViewById(R.id.temp_input);
        this.displayF = (TextView) findViewById(R.id.outputF);
        this.displayC = (TextView) findViewById(R.id.outputC);
        this.displayR = (TextView) findViewById(R.id.outputR);
        this.displayK = (TextView) findViewById(R.id.outputK);
        this.displayRe = (TextView) findViewById(R.id.outputRe);
        this.displayRo = (TextView) findViewById(R.id.outputRo);
        this.displayDe = (TextView) findViewById(R.id.outputDe);
        this.displayN = (TextView) findViewById(R.id.outputN);
        this.displayTemperature();
        Button btn = (Button) findViewById(R.id.btnConvert);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                calculateTemp();
                displayTemperature();
            }
        });

    }
    public void calculateTemp(){
        double temUser = this.getTempFromUser();
        RadioGroup inputTypeFromUser = (RadioGroup) findViewById(R.id.input_type_group);
        RadioButton radioBtn = (RadioButton) findViewById(inputTypeFromUser.getCheckedRadioButtonId());
        String inpTpFu = (String) radioBtn.getText();
        switch(inpTpFu.toUpperCase()){
            case "C":
                this.converter.setFromC(temUser);
                break;
            case "DE":
                this.converter.setFromDe(temUser);
                break;
            case "RE":
                this.converter.setFromRe(temUser);
                break;
            case "RO":
                this.converter.setFromRo(temUser);
                break;
            case "N":
                this.converter.setFromN(temUser);
                break;
            case "F":
                this.converter.setFromF(temUser);
                break;
            case "R":
                this.converter.setFromR(temUser);
                break;
            case "K":
                this.converter.setFromK(temUser);
                break;
            default:
                this.converter.setFromC(temUser);
        }
        /*
        if( == "C"){


        }
        */
        setAllTemperature();

    }
    public void displayTemperature(){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(4);
        this.displayF.setText(nf.format(this.tF));
        this.displayK.setText(nf.format(this.tK));
        this.displayR.setText(nf.format(this.tR));
        this.displayC.setText(nf.format(this.tC));
        this.displayRe.setText(nf.format(this.tRe));
        this.displayRo.setText(nf.format(this.tRo));
        this.displayDe.setText(nf.format(this.tDe));
        this.displayN.setText(nf.format(this.tN));
    }
    protected void setAllTemperature(){
        this.tC = this.converter.getC();
        this.tF = this.converter.getF();
        this.tR = this.converter.getR();
        this.tK = this.converter.getK();
        this.tRe = this.converter.getRe();
        this.tRo = this.converter.getRo();
        this.tN = this.converter.getN();
        this.tDe = this.converter.getDe();
    }
    public double getTempFromUser(){
        String str = String.valueOf(this.temp_input.getText());
        if(str.trim().length() == 0){
            str = "0";
        }
        double temFrom = Double.parseDouble(str);
        return temFrom;
    }

}
