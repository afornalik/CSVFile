package pl.home.mate.textClass.textIntefraces;

import pl.home.mate.textException.SplitTextException;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternDelimiter;

import java.util.List;

public interface TextSplit {

    List<String> splitText(TextPatternDelimiter textPatternItemsExtend) throws SplitTextException;
}
