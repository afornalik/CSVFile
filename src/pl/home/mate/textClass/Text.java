package pl.home.mate.textClass;



public abstract class Text{



    private String TextToCheck;

    public Text(String textToCheck) {
        TextToCheck = textToCheck;
    }

    public String getTextToCheck() {
        return TextToCheck;
    }

    public void setTextToCheck(String textToCheck) {
        TextToCheck = textToCheck;
    }
}
