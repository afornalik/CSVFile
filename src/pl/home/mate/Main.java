package pl.home.mate;

import pl.home.mate.fileIntefraceImplementation.fileInterfaceImplementationSuperClass.AllFunctionCSVFile;
import pl.home.mate.fileUtilities.FileInfoExtends;
import pl.home.mate.textClass.checkText.CheckedText;
import pl.home.mate.textClass.service.TextSplit;
import pl.home.mate.textClass.textIntefraces.CheckDataFormat;
import pl.home.mate.textFormatPatterns.TextPatternItemsExtend;
import pl.home.mate.textFormatPatterns.preparedPatterns.TextPatternItemsNameSurNameAddress;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternDelimiter;

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
        TextPatternDelimiter textPatternDelimiter = new TextPatternItemsNameSurNameAddress();


        functionCSVFile.isCSVFileExist();
        System.out.println(functionCSVFile.isCSVFileExist());
        System.out.println(functionCSVFile.loadOneLineFromCSVFile());


        textSplit.splitText(textPatternDelimiter).forEach(s -> System.out.println(s));
        textSplit.splitText(textPatternDelimiter)
                .stream()
                .filter(s -> s.contains("am"))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s.toUpperCase()));

        List<String> splitedOneLine = textSplit.splitText(textPatternDelimiter);

        TextPatternDelimiter textPatternDelimiter1 = new TextPatternItemsNameSurNameAddress();

        System.out.println("________________________________________");

        CheckDataFormat checkDataFormat = new CheckedText(textSplit.splitText(textPatternDelimiter), ((TextPatternItemsNameSurNameAddress) textPatternDelimiter).receiveListOfAttribute());

        System.out.println(checkDataFormat.checkFormat());
        String t ="";
    }
}
