package pl.home.mate;

import pl.home.mate.fileIntefraceImplementation.fileInterfaceImplementationSuperClass.AllFunctionCSVFile;
import pl.home.mate.fileUtilities.FileInfoExtends;
import pl.home.mate.textClass.checkText.CheckedText;
import pl.home.mate.textClass.service.TextSplit;
import pl.home.mate.textClass.textIntefraces.CheckDataFormat;
import pl.home.mate.textFormatPatterns.preparedPatterns.TextPatternItems_SSI;
import pl.home.mate.textFormatPatterns.preparedPatterns.TextPatternItems_SSS;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternPool;


import java.util.List;
import java.util.stream.Collectors;

/**
 @Author Andrzej Fornalik
    Read data from CSV file
 @version 1.0
 @
 */

/*2. Napisz program, który wczytuje listę obywateli (imię, nazwisko, rok urodzenia) z pliku w formacie CSV, np. o treści
        ```Jan,Kowalski,1955
Adam,Iksiński,2017```*/


public class Main {

    public static void main(String[] args) throws Exception {

        FileInfoExtends text = new FileInfoExtends("text.csv");
        AllFunctionCSVFile functionCSVFile = new AllFunctionCSVFile(text);
        TextSplit textSplit = new TextSplit(functionCSVFile.loadOneLineFromCSVFile());
        TextPatternPool textPatternPool = new TextPatternItems_SSS();
        TextPatternPool textPatternPool2 = new TextPatternItems_SSI();


        functionCSVFile.isCSVFileExist();
        System.out.println(functionCSVFile.isCSVFileExist());
        System.out.println(functionCSVFile.loadOneLineFromCSVFile());


        textSplit.splitText(textPatternPool).forEach(s -> System.out.println(s));
        textSplit.splitText(textPatternPool)
                .stream()
                .filter(s -> s.contains("orna"))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s.toUpperCase()));

        List<String> splitedOneLine = textSplit.splitText(textPatternPool);

        TextPatternPool textPatternPool1 = new TextPatternItems_SSS();

        System.out.println("________________________________________");

        CheckDataFormat checkDataFormat = new CheckedText(textSplit.splitText(textPatternPool), ((TextPatternItems_SSS) textPatternPool).receiveListOfAttribute());
        CheckDataFormat checkDataFormat2 = new CheckedText(textSplit.splitText(textPatternPool), ((TextPatternItems_SSI) textPatternPool2).receiveListOfAttribute());


        System.out.println(checkDataFormat.checkFormat());
        System.out.println(checkDataFormat2.checkFormat());
        String t ="";
    }
}
