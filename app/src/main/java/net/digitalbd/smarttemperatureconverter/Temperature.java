package net.digitalbd.smarttemperatureconverter;

/**
 * Created by Rukon on 2/12/2017.
 * c = Celsius F = Fahrenheit K = Kelvin R = Rankine N = Newton De = Delisle Re = Reaumur Ro = Romer
 */

public class Temperature {
    private double tF,tR,tC,tK,tN,tRe,tRo,tDe;
    Temperature(){
        this.tF = 0;
        this.tR = 0;
        this.tC = 0;
        this.tK = 0;
        this.tDe = 0;
        this.tRe = 0;
        this.tRo = 0;
        this.tN = 0;
    }
    public void setFromF(double FromData){
        this.tF = FromData;
        this.tC = (((this.tF - 32) * 5) / 9);
        this.tK = ((this.tF + 459.67) * 5) / 9;
        this.tR = this.tF + 459.67;
        this.tN = ((this.tF - 32) * 11) / 60;
        this.tDe = ((212 - this.tF) * 5) / 6;
        this.tRe = ((this.tF - 32) * 4) / 9;
        this.tRo = (((this.tF - 32) * 7) / 24) + 7.5;
    }
    public void setFromC(double FromData){
        this.tC = FromData;
        this.tF = ((this.tC * 9) / 5) + 32;
        this.tK = this.tC + 273.15;
        this.tR = ((this.tC + 273.15) * 9) / 5;
        this.tN = (this.tC * 33) / 100;
        this.tDe = ((100 - this.tC) * 3) / 2;
        this.tRe = (this.tC *4) / 5;
        this.tRo = ((this.tC * 21) / 40) + 7.5;
    }
    public void setFromR(double FromData){
        this.tR = FromData;
        this.tC = ((this.tR * 5) / 9) - 273.15;
        this.tF = this.tR - 459.67;
        this.tK = (this.tR * 5) / 9;
        this.tN = ((this.tR - 491.67) * 11) / 60;
        this.tDe = ((671.67 - this.tR) * 5) / 6;
        this.tRe = ((((this.tR * 5) / 9) + 273.15) * 4) / 5;
        this.tRo = (((this.tR - 491.67) * 7) / 24) + 7.5;
    }
    public void setFromK(double FromData){
        this.tK = FromData;
        this.tC = this.tK - 273.15;
        this.tF = ((this.tK - 273.15) * 1.8000) + 32.00;
        this.tR = (this.tK * 9) / 5;
        this.tN = ((this.tK - 273.15) * 33) / 100;
        this.tDe = ((373.15 - this.tK) * 3) / 2;
        this.tRe = ((this.tK - 273.15) * 4) / 5;
        this.tRo = (((this.tK - 273.15) * 21) / 40)  + 7.5;
    }

    public void setFromRe(double FromData){
        this.tRe = FromData;
        this.tC  = (this.tRe * 5) / 4;
        this.tF = ((this.tRe * 9) / 4) + 32;
        this.tK = ((this.tRe * 4) / 4) + 273.15;
        this.tR = ((this.tRe * 9) /  4) + 491.67;
        this.tN = (this.tRe * 33) / 80;
        this.tDe = ((373.15 - this.tK) * 3) / 2;
        this.tRo = ((this.tRe * 21) / 32) + 7.5;
    }
    public void setFromDe(double FromData){
        this.tDe = FromData;
        this.tC = 100 - ((this.tDe * 2) / 3);
        this.tF = 212 - ((this.tDe * 6) / 5);
        this.tK = 373.15 - ((this.tDe * 2) / 3);
        this.tR = 671.67 - ((this.tDe * 6) / 5);
        this.tN = 33 - ((this.tDe * 11) / 50);
        this.tRe = 80 - ((this.tDe * 8) / 15);
        this.tRo = 60 - ((this.tDe * 7) / 20);
    }
    public void setFromRo(double FromData){
        this.tRo = FromData;
        this.tC = ((this.tRo - 7.5) * 40) / 21;
        this.tF = (((this.tRo - 7.5) * 24) / 7) + 32;
        this.tK = (((this.tRo - 7.5) * 40) /  21) + 273.15;
        this.tR = (((this.tRo - 7.5) * 24) / 7) +  491.67;
        this.tN =  ((this.tRo - 7.5) * 22) / 35;
        this.tDe = ((60 - this.tRo)  * 20) / 7;
        this.tRe =  ((this.tRo - 7.5) * 32) / 21;
    }
    public void setFromN(double FromData){
        this.tN = FromData;
        this.tC = (this.tN * 100) / 33;
        this.tF = ((this.tN * 60) / 11) + 32;
        this.tK = ((this.tN * 100) / 33) + 273.15;
        this.tR = ((this.tN * 60) / 11) + 491.67;
        this.tDe = ((33 - this.tN) * 50) / 11;
        this.tRe = (this.tN * 80) / 33;
        this.tRo = ((this.tN * 35) / 22) + 7.5;
    }
    public double getF() {
        return this.tF;
    }
    public double getC(){
        return this.tC;
    }
    public double getR(){
        return this.tR;
    }
    public double getK(){
        return this.tK;
    }
    public double getRe(){
        return this.tRe;
    }
    public double getDe(){
        return this.tDe;
    }
    public double getRo(){
        return this.tRo;
    }
    public double getN(){
        return this.tN;
    }
}
