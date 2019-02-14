package pl.home.mate.fileIntefraceImplementation;


import pl.home.mate.ErrorMessage.ErrorMessage;
import pl.home.mate.fileInterfaces.CheckCSVFile;
import pl.home.mate.fileUtilities.FileInfoExtends;

import java.io.File;

public class CheckCSVFileImpl  implements CheckCSVFile {


    private FileInfoExtends fileInfoExtends;
    private ErrorMessage errorMessage = new ErrorMessage();


    public CheckCSVFileImpl(FileInfoExtends fileInfoExtends) {
        this.fileInfoExtends = fileInfoExtends;
    }

    private boolean isCSVFileExistExceptionCheck()  {
        try {
            return new File(fileInfoExtends.getFileURL()).isFile();
        }  catch (SecurityException securityException) {
            errorMessage.setError(true);
            errorMessage.setErrorMessage("You have no privilege to open file : " + fileInfoExtends.getFileURL());
        }
        return false;
    }

    @Override
    public boolean isCSVFileExist() throws Exception {

        if(isCSVFileExistExceptionCheck()){
            return true;
        }
        return false;
    }
}
