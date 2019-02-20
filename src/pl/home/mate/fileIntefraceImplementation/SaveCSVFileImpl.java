package pl.home.mate.fileIntefraceImplementation;

import pl.home.mate.fileInterfaces.SaveCSVFile;
import pl.home.mate.fileUtilities.FileInfoExtends;
import pl.home.mate.textClass.checkText.CheckedText;

public class SaveCSVFileImpl implements SaveCSVFile {

    private CheckedText checkedText;
    private FileInfoExtends fileInfoExtends;

    public SaveCSVFileImpl(FileInfoExtends fileInfoExtends) {
        this.fileInfoExtends = fileInfoExtends;
    }

    @Override
    public void saveTextToCSVFile(String stringToSave) {

    }


}
