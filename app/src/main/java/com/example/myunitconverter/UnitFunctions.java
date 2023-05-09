package com.example.myunitconverter;

public class UnitFunctions {

    public static final int MASS = 0;
    public static final int LENGTH = 1;
    public static final int TEMP = 2;

    public static final int FROM_KG_TO_POUND=0;
    public static final int FROM_POUND_TO_KG=1;
    public static final int FROM_MILES_TO_KM=2;
    public static final int FROM_KM_TO_MILES=3;
    public static final int FROM_FAH_TO_CEL=4;
    public static final int FROM_CEL_TO_FAH=5;

    public  static double makeGenericConversion(int calculation, double value){

        switch (calculation){

            case FROM_CEL_TO_FAH:
                return convertCelciusToFah(value);
            case FROM_FAH_TO_CEL:
                return fahRoCelcius(value);
            case FROM_MILES_TO_KM:
                return milesToKm(value);
            case FROM_KM_TO_MILES:
                return kmToMiles(value);
            case FROM_KG_TO_POUND:
                return kgToPounds(value);
            case FROM_POUND_TO_KG:
                return poundsToKg(value);
            default:
                return 0;
        }
    }

    public static double convertCelciusToFah(double c){
        //T(°F) = T(°C) × 9/5 + 32
        //T(C) = (F-32) *5/9

        return (c * 9/5) + 32;
    }

    public static double fahRoCelcius(double fah){
        return (fah - 32)*5/9;
    }

    public static double kgToPounds(double kg){

        //m(lb) = m(kg) / 0.45359237

        return kg/0.45359237;

    }

    public static double poundsToKg(double pounds){

        //m(lb) = m(kg) / 0.45359237

        return pounds*0.45359237;

    }

    public static double kmToMiles(double km){
        //d(mi) = d(km) / 1.609344

        return km/1.609344;
    }

    public static double milesToKm(double miles){
        return miles*1.609344;
    }
// eend of conversion funcyions
    class SelectionOption{

        private String title;
        private int function;

        public SelectionOption(String title, int function) {
            this.title = title;
            this.function = function;
        }

        public String getTitle() {
            return title;
        }

        public int getFunction() {
            return function;
        }

        @Override
        public String toString() {
            return  title;
        }
    }
}
