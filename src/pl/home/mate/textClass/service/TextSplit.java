package pl.home.mate.textClass.service;

import pl.home.mate.textClass.UncheckedText;
import pl.home.mate.textException.SplitTextException;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternPool;


import java.util.Arrays;
import java.util.List;

public class TextSplit extends UncheckedText implements pl.home.mate.textClass.textIntefraces.TextSplit{




    private String oneLine;
    private TextPatternPool textPatternPool;

    public TextSplit(String textToCheck) {
        super(textToCheck);
    }

    @Override
    public List<String> splitText(TextPatternPool textPatternPool) {
        this.textPatternPool = textPatternPool;
        oneLine = super.getTextToCheck();
        this.splitTextTry(oneLine);
        return Arrays.asList(oneLine.split(","));
    }

    private void splitTextTry(String oneLine)  {
        try {
            if (checkNumbersOfPools() == 0) {
                throw new SplitTextException("Line is empty");
            } else if (checkNumbersOfPools() != this.textPatternPool.countPool()) {
                throw new SplitTextException("To Many items or Pools in line  : " + oneLine + " , expect  : "
                        + this.textPatternPool.countPool() + " Pools (\",\")");
            }
        }catch ( SplitTextException e){
            System.out.println(e.getMessage());
        }
    }


    private Integer checkNumbersOfPools(){
        return Arrays.asList(oneLine.split(",")).size();
    }
}
