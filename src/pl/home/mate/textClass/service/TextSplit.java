package pl.home.mate.textClass.service;

import pl.home.mate.textClass.UncheckedText;
import pl.home.mate.textException.EmptyLineException;
import pl.home.mate.textException.SplitTextException;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternDelimiter;


import java.util.Arrays;
import java.util.List;

public class TextSplit extends UncheckedText implements pl.home.mate.textClass.textIntefraces.TextSplit{




    private String oneLine;
    private TextPatternDelimiter textPatternDelimiter;

    public TextSplit(String textToCheck) {
        super(textToCheck);
    }

    @Override
    public List<String> splitText(TextPatternDelimiter textPatternDelimiter) {
        this.textPatternDelimiter = textPatternDelimiter;
        oneLine = super.getTextToCheck();
        this.splitTextTry(oneLine);
        return Arrays.asList(oneLine.split(","));
    }

    private void splitTextTry(String oneLine)  {
        try {
            if (checkNumbersOfDelimiters() == 0) {
                throw new EmptyLineException("Line is empty");
            } else if (checkNumbersOfDelimiters() != this.textPatternDelimiter.countDelimiter()) {
                throw new SplitTextException("To Many items or delimiters in line  : " + oneLine + " , expect  : "
                        + this.textPatternDelimiter.countDelimiter() + " delimiters (\",\")");
            }
        }catch (EmptyLineException | SplitTextException e){
            System.out.println(e.getMessage());
        }
    }


    private Integer checkNumbersOfDelimiters(){
        return Arrays.asList(oneLine.split(",")).size();
    }
}
