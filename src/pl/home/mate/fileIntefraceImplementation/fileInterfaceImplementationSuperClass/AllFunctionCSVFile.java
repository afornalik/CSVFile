package pl.home.mate.fileIntefraceImplementation.fileInterfaceImplementationSuperClass;

import pl.home.mate.fileIntefraceImplementation.*;
import pl.home.mate.fileInterfaces.*;
import pl.home.mate.fileUtilities.FileInfoExtends;

public class AllFunctionCSVFile implements CheckCSVFile, LoadCSVFile, OpenCSVFile, SaveCSVFile {

    private CheckCSVFileImpl checkCSVFileImpl;
    private LoadCSVFileImpl loadCSVFileImpl;
    private OpenCSVFileImpl openCSVFileImpl;
    private SaveCSVFileImpl saveCSVFileImpl;
    private FileInfoExtends fileInfoExtends;

    public FileInfoExtends getFileInfoExtends() {
        return fileInfoExtends;
    }



    public AllFunctionCSVFile(FileInfoExtends fileInfoExtends) {
        this.fileInfoExtends = fileInfoExtends;
        checkCSVFileImpl = new CheckCSVFileImpl(fileInfoExtends);
        loadCSVFileImpl = new LoadCSVFileImpl(fileInfoExtends);
        openCSVFileImpl = new OpenCSVFileImpl(fileInfoExtends);
        saveCSVFileImpl = new SaveCSVFileImpl(fileInfoExtends);

    }

    @Override
    public boolean isCSVFileExist() throws  Exception {
        return checkCSVFileImpl.isCSVFileExist() ;
    }

    @Override
    public String loadOneLineFromCSVFile() throws Exception {
        return loadCSVFileImpl.loadOneLineFromCSVFile();
    }

    @Override
    public void createBufferedReader() throws Exception {
         openCSVFileImpl.createBufferedReader();
    }

    @Override
    public void saveTextToCSVFile(String stringToSave) {
        saveCSVFileImpl.saveTextToCSVFile(stringToSave);
    }


}
