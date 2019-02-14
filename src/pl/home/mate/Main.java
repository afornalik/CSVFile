package pl.home.mate;

import pl.home.mate.fileIntefraceImplementation.fileInterfaceImplementationSuperClass.AllFunctionCSVFile;
import pl.home.mate.fileUtilities.FileInfoExtends;
import pl.home.mate.textClass.service.TextSplit;
import pl.home.mate.textFormatPatterns.TextPatternItemsExtend;
import pl.home.mate.textFormatPatterns.preparedPatterns.TextPatternItemsNameSurNameAddress;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternDelimiter;

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
                .filter(s -> s.contains("orna"))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s.toUpperCase()));


        TextPatternDelimiter textPatternDelimiter1 = new TextPatternItemsNameSurNameAddress();

    }
}
