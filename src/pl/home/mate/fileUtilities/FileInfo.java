package pl.home.mate.fileUtilities;




public abstract class FileInfo {

    private String fileURL;

    public FileInfo(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }
}
