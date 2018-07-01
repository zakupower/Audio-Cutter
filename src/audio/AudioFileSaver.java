package audio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomov on 28.6.2018 г..
 */
public class AudioFileSaver {
    private List<AudioFile> cutFiles;
    private ArrayList<Cut> cuts;
    private File directory;
    private String fileExtention;
    // fileExtention ["wav","mp3"]; TODO create a class to abstract the extension
    //TODO only work with wav for now
    public AudioFileSaver(List<AudioFile> cutFiles, ArrayList<Cut> cuts, File directory, String fileExtention) {
        this.cutFiles = cutFiles;
        this.cuts = cuts;
        this.directory = directory;
        this.fileExtention = fileExtention;
    }

    public void tryToSaveCutFilesTo(){
        try {
            saveCutFiles();
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    private void saveCutFiles(){
        try {
            for (int i = 0; i < cutFiles.size(); i++) {
                cutFiles.get(i).saveFile(directory,cuts.get(i).getName(),fileExtention);
            }
        } catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
