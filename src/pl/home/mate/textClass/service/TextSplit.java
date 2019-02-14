package pl.home.mate.textClass.service;

import pl.home.mate.ErrorMessage.ErrorMessage;
import pl.home.mate.textClass.UncheckedText;
import pl.home.mate.textException.SplitTextException;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternDelimiter;


import java.util.Arrays;
import java.util.List;

public class TextSplit extends UncheckedText implements pl.home.mate.textClass.textFormatIntefraces.TextSplit{



    private ErrorMessage errorMessage = new ErrorMessage();
    private String oneLine;
    private TextPatternDelimiter textPatternItemsExtend;

    public TextSplit(String textToCheck) {
        super(textToCheck);
    }

    @Override
    public List<String> splitText(TextPatternDelimiter textPatternItemsExtend) throws SplitTextException {
        this.textPatternItemsExtend = textPatternItemsExtend;
        oneLine = super.getTextToCheck();
        this.splitTextTry(oneLine);
        return Arrays.asList(oneLine.split(","));
    }

    private void splitTextTry(String oneLine) throws SplitTextException {
        int expectedNumberOfItemsInLine = Arrays.asList(oneLine.split(",")).size();
            if (expectedNumberOfItemsInLine==0){
               this.throwSplitTextException("Line is empty");
            } else if  (expectedNumberOfItemsInLine!=this.textPatternItemsExtend.countDelimiter()) {
                this.throwSplitTextException("To Many items or delimiters in line  : "+oneLine+" , expect  : "
                        + this.textPatternItemsExtend.countDelimiter()+" delimiters (\",\")");
            }
        }

    private void throwSplitTextException(String errorMessageInfo) throws SplitTextException {
        errorMessage.setError(true);
        errorMessage.setErrorMessage(errorMessageInfo);
        throw new SplitTextException();
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
