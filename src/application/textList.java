package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class textList {
    private ObservableList<text> textList; // Use your actual class name Text

    public textList() {
        textList = FXCollections.observableArrayList();
    }

    public ObservableList<text> getTextList() {
        return textList;
    }

    public void addText(text newText) {
        textList.add(newText);
    }
    
    
}
