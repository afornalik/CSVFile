package pl.home.mate.fileIntefraceImplementation;



import pl.home.mate.errorMessage.ErrorMessage;
import pl.home.mate.fileInterfaces.LoadCSVFile;
import pl.home.mate.fileUtilities.FileInfoExtends;

import java.io.BufferedReader;
import java.io.IOException;

public class LoadCSVFileImpl implements LoadCSVFile {


    private OpenCSVFileImpl openCSVFile;
    private FileInfoExtends fileInfo;
    private StringBuilder oneLine = new StringBuilder();
    private ErrorMessage errorMessage = new ErrorMessage();
    private BufferedReader bufferedReader;


    public LoadCSVFileImpl(FileInfoExtends fileInfoExtends) {
        openCSVFile = new OpenCSVFileImpl(fileInfoExtends);
        this.fileInfo = fileInfoExtends;
    }

    @Override
    public String loadOneLineFromCSVFile() throws Exception {
        oneLine  = new StringBuilder();
        this.openReaderToCSVFile();
        this.bufferedReader = openCSVFile.getBufferedReader();
        this.loadOneLineFromCSVFileToString();
        return oneLine.toString();
    }

    private void openReaderToCSVFile() throws Exception {
        if(!openCSVFile.isError()){
            openCSVFile.createBufferedReader();
            this.bufferedReader = openCSVFile.getBufferedReader();
        }else {
            this.errorMessage.setErrorMessage(openCSVFile.getErrorMessage());
        }
    }


    private void loadOneLineFromCSVFileToString() {
        try {
            oneLine.append(bufferedReader.readLine());
        }catch(IOException e) {
            setErrorMessageLoadLine();
        }
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessageLoadLine() {
        this.errorMessage.setErrorMessage(("Can't load text from file : "+ fileInfo.getFileURL()));
    }
}
