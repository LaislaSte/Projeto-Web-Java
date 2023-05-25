package backenddm20231n.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataHelper {
    private GregorianCalendar gc;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public DataHelper(String data){
        try {
            this.gc = new GregorianCalendar();
            this.gc.setTime(formatter.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getDays(){
        return getCampo(Calendar.DAY_OF_MONTH);
    }
    public int getMonth(){
        return getCampo(Calendar.MONTH) + 1;
    }
    public int getYear(){
        return getCampo(Calendar.YEAR);
    }
    private int getCampo(int tipoCampo){
        return gc.get(tipoCampo);
    }
    public Date getTypeDate() {
    	return gc.getTime();
    }

    public String getDate(){
        return getDays()+"/"+getMonth()+"/"+getYear();
    }

}