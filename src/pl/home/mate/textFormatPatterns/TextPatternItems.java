package pl.home.mate.textFormatPatterns;

public abstract class TextPatternItems<T> {

    private T textItem;

    public T getTextItem() {
        return textItem;
    }

    public void setTextItem(T textItem) {
        this.textItem = textItem;
    }
}
