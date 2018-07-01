package audio;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomov on 25.6.2018 г..
 */
public class AudioCutter{
    private File inputFile;
    private List<Cut> cuts;
    private List<AudioFile> cutFiles = new ArrayList<>();


    public void tryToCreateCutFiles(File inputFile, ArrayList<Cut> cuts){
        this.inputFile = inputFile;
        this.cuts = cuts;
        try {
            createCutFiles();
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    private void createCutFiles() throws Exception{
        if(("wav").equals(AudioFile.getFileExtension(inputFile))){
            AudioFile as = new WavFile(inputFile);
            for(Cut cut: cuts){
                AudioFile cutFile  = as.getFromTo(cut.getFrom(), cut.getTo());
                cutFiles.add(cutFile);
            }
        } else {
            throw new InvalidAudioFormatException("Audio format not supported");
        }

    }
    public List<AudioFile> getCutFiles(){
        return cutFiles;
    }


}
