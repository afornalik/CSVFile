package pl.home.mate.textFormatPatterns.preparedPatterns;

import com.sun.istack.internal.NotNull;

import pl.home.mate.textFormatPatterns.TextPatternItems;
import pl.home.mate.textFormatPatterns.TextPatternItemsExtend;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternAcceptedAttributeList;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternDelimiter;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternReceivingItems;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternType.TextPatternAcceptedAttributeType;

import java.util.ArrayList;
import java.util.List;

public class TextPatternItemsNameSurNameAddress extends TextPatternItemsExtend implements TextPatternDelimiter, TextPatternReceivingItems, TextPatternAcceptedAttributeList {


    private TextPatternItems<String> name;
    private TextPatternItems<String> surName;
    private TextPatternItems<String> address;


    public TextPatternItemsNameSurNameAddress(@NotNull String name, @NotNull String surName, @NotNull String address) {
        super();
        this.name.setTextItem(name);
        this.surName.setTextItem(surName);
        this.address.setTextItem(address);

       }

    public TextPatternItemsNameSurNameAddress() {
       super();
    }


    @Override
    public TextPatternItems<String>[] receiveItems() {
        TextPatternItems<String>[] receiveItems = new TextPatternItems[3];
        receiveItems[0] = name;
        receiveItems[1] = surName;
        receiveItems[2] = address;
        return receiveItems;
    }

    @Override
    public int countDelimiter() {
        return 3;
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
        return "TextPatternItemsNameSurNameAddress{" +
                "name=" + name +
                ", surName=" + surName +
                ", address=" + address +
                '}';
    }



}
