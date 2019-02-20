package pl.home.mate.fileIntefraceImplementation;

import pl.home.mate.errorMessage.ErrorMessage;
import pl.home.mate.fileInterfaces.OpenCSVFile;
import pl.home.mate.fileUtilities.FileInfoExtends;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OpenCSVFileImpl implements OpenCSVFile {

    private CheckCSVFileImpl checkCSVFile;
    private FileInfoExtends fileInfo;
    private ErrorMessage errorMessage = new ErrorMessage();
    private BufferedReader bufferedReader;

    public OpenCSVFileImpl(FileInfoExtends fileInfoExtends) {
        checkCSVFile = new CheckCSVFileImpl(fileInfoExtends);
        this.fileInfo = fileInfoExtends;
    }

    @Override
    public void createBufferedReader() throws Exception {
        try {
            if (checkCSVFile.isCSVFileExist()) {
                this.bufferedReader = new BufferedReader(new FileReader(fileInfo.getFileURL()));
            }else {
                this.errorMessage.setError(true);
                this.setErrorMessageFileNotFound();
            }
        }catch (FileNotFoundException fileNotFoundException){
            this.errorMessage.setErrorMessage(fileNotFoundException.getMessage());
            this.errorMessage.setError(true);
        }
    }


    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public String getErrorMessage() {
        return errorMessage.getErrorMessage();
    }

    public boolean isError() {
        return this.errorMessage.isError();
    }


    private void setErrorMessageFileNotFound() {
        this.errorMessage.setErrorMessage(("There is no File located on : "+ fileInfo.getFileURL()));
    }


}
