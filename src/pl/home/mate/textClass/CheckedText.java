package pl.home.mate.textClass;

import pl.home.mate.textClass.textFormatIntefraces.CheckDataFormat;

public class CheckedText  implements CheckDataFormat {

    private CheckedText checkedText;
    private UncheckedText uncheckedText;



    @Override
    public boolean checkFormat() throws Exception {

        return false;
    }


}
