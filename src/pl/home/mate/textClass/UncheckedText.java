package pl.home.mate.textClass;

import pl.home.mate.textClass.textIntefraces.CheckDataFormat;


public class UncheckedText extends Text implements CheckDataFormat {



    public UncheckedText(String textToCheck) {
        super(textToCheck);
    }



    @Override
    public boolean checkFormat()  {

        return false;
    }
}
