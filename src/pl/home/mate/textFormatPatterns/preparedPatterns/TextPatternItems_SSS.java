package pl.home.mate.textFormatPatterns.preparedPatterns;

import com.sun.istack.internal.NotNull;

import pl.home.mate.textFormatPatterns.TextPatternItems;
import pl.home.mate.textFormatPatterns.TextPatternItemsExtend;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternAcceptedAttributeList;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternPool;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternReceivingItems;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternType.TextPatternAcceptedAttributeType;

import java.util.ArrayList;
import java.util.List;

public class TextPatternItems_SSS extends TextPatternItemsExtend implements TextPatternPool, TextPatternReceivingItems, TextPatternAcceptedAttributeList {

    private final int AMOUNT_OF_POOL= 3;

    private TextPatternItems<String>[] pool = new TextPatternItems[AMOUNT_OF_POOL];

    public TextPatternItems_SSS() {
       super();
    }

    @Override
    public TextPatternItems<String>[] receiveItems() {
        return pool;
    }

    @Override
    public int countPool() {
        return this.AMOUNT_OF_POOL;
    }


    @Override
    public List<TextPatternAcceptedAttributeType> receiveListOfAttribute() {
        List<TextPatternAcceptedAttributeType> listOfArgumentsType = new ArrayList<>();
        listOfArgumentsType.add(TextPatternAcceptedAttributeType.STRING);
        listOfArgumentsType.add(TextPatternAcceptedAttributeType.STRING);
        listOfArgumentsType.add(TextPatternAcceptedAttributeType.STRING);
        return listOfArgumentsType;
    }

    @Override
    public String toString() {
        return "TextPatternItems_SSS{" +
                "pool1 =" + this.pool[0] +
                ", pool2 =" + this.pool[1] +
                ", address=" + this.pool[2] +
                '}';
    }



}
