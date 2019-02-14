package pl.home.mate.textClass.textFormatIntefraces;

import pl.home.mate.textException.SplitTextException;
import pl.home.mate.textFormatPatterns.TextPatternItemsExtend;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternDelimiter;

import java.util.List;

public interface TextSplit {

    List<String> splitText(TextPatternDelimiter textPatternItemsExtend) throws SplitTextException;
}
