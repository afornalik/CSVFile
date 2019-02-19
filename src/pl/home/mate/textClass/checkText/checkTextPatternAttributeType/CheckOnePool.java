package pl.home.mate.textClass.checkText.checkTextPatternAttributeType;

import pl.home.mate.textClass.textIntefraces.CheckAttributeType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckOnePool<T> implements CheckAttributeType {

    T newt ;

    public void setNewt(T newt) {
        this.newt = newt;
    }

    @Override
    public boolean checkAttributeType(String type) {
        if (newt instanceof  String){
           return true;

        }else if(newt instanceof Integer) {
            try {
                Integer checkInt = Integer.parseInt(type);
            }catch(NumberFormatException e) {
                return false;
            }
            return true;

        }else if(newt instanceof Date) {
            try {
                Date date = new SimpleDateFormat("dd.mm.yyyy").parse(type);
            } catch ( NullPointerException | IllegalArgumentException | ParseException e) {
                return false;
            }
            return true;

        }else {
            return false;
        }
    }
}
