package audio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField fromField;
    @FXML
    private TextField toField;
    @FXML
    private VBox fieldsVBox;
    @FXML
    private TextField openField;
    @FXML
    private TextField saveField;
    @FXML
    private Label errorLabel;
    private ArrayList<Cut> cuts;
    private List<TextField> nameFieldsList = new ArrayList<>();
    private List<TextField> fromFieldsList = new ArrayList<>();
    private List<TextField> toFieldsList = new ArrayList<>();

    @FXML
    public void initialize() {
        nameFieldsList.add(nameField);
        fromFieldsList.add(fromField);
        toFieldsList.add(toField);
    }
    @FXML
    public void fileToCutPick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open mp3 file");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Audio Files","*.wav","*.mp3"),new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(nameField.getScene().getWindow());
        if (selectedFile != null) {
            openField.setText(selectedFile.getPath());
            openField.setStyle("");
        }
    }
    @FXML
    public void saveDirectoryPick(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Save mp3 cuts file");
        File selectedFile = directoryChooser.showDialog(nameField.getScene().getWindow());
        if (selectedFile != null) {
            saveField.setText(selectedFile.getPath());
            saveField.setStyle("");
        }
    }
    @FXML
    public void addCutFields(ActionEvent event) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        TextField tempNameField = new TextField(),
                tempFromField = new TextField(),
                tempToField = new TextField();
        tempNameField.setPrefWidth(200);
        tempFromField.setPrefWidth(50);
        tempToField.setPrefWidth(50);
        hBox.getChildren().addAll(new Label("Name:"),tempNameField,new Label("From:"),tempFromField,new Label("To:"),tempToField);
        fieldsVBox.getChildren().add(hBox);
        nameFieldsList.add(tempNameField);
        fromFieldsList.add(tempFromField);
        toFieldsList.add(tempToField);
    }

    @FXML
    public void saveCutFiles(ActionEvent event) {
        if(!isAudioFileSelected()){
            openField.setStyle("-fx-border-color: red");
            return;
        }
        if(!isSavePathSelected()){
            saveField.setStyle("-fx-border-color: red");
            return;
        }
        cuts = createCuts();
        if(!isThereAtLeastOneCut()){
            errorLabel.setText("At least one cut needed!");
            return;
        }
        System.out.println("Started cutting");
        errorLabel.setText("");
        File fileToCut = new File(openField.getText()),
            directoryToSave = new File(saveField.getText());

        AudioCutter cutter = new AudioCutter();
        cutter.tryToCreateCutFiles(fileToCut,cuts);
        AudioFileSaver saver = new AudioFileSaver(cutter.getCutFiles(),cuts,directoryToSave,getFileExtension(fileToCut));
        saver.tryToSaveCutFilesTo();
        System.out.println("Done cutting");

    }

    private String getFileExtension(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        int i = name.lastIndexOf('.');
        String ext = i > 0 ? name.substring(i + 1) : "";
        return ext;
    }
    private ArrayList<Cut> createCuts(){
        ArrayList<Cut> cuts = new ArrayList<>();
        for(int i = 0; i < nameFieldsList.size(); i++){
            if(!nameFieldsList.get(i).getText().isEmpty() && !fromFieldsList.get(i).getText().isEmpty() && !toFieldsList.get(i).getText().isEmpty()) {
                try {
                    cuts.add(new Cut(nameFieldsList.get(i).getText(), Double.parseDouble(fromFieldsList.get(i).getText()), Double.parseDouble(toFieldsList.get(i).getText())));
                }catch(NumberFormatException exc){
                   // to or from fields are not numbers
                }catch(InvalidCutException exc) {
                    //to or from fields are negative or from >= cut
                }
            } else {
                // one of fields is empty
            }
        }
        return cuts;
    }
    private boolean isThereAtLeastOneCut(){
        return !cuts.isEmpty();
    }
    private boolean isAudioFileSelected(){
        return !openField.getText().isEmpty();
    }
    private boolean isSavePathSelected(){
        return !saveField.getText().isEmpty();
    }

}
