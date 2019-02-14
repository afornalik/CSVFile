package pl.home.mate.textClass;

import pl.home.mate.textClass.textFormatIntefraces.CheckDataFormat;


public class UncheckedText extends Text implements CheckDataFormat {



    public UncheckedText(String textToCheck) {
        super(textToCheck);
    }



    @Override
    public boolean checkFormat() throws Exception {

        return false;
    }
}
