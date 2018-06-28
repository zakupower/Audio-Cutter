package audio;





import jAudioFeatureExtractor.jAudioTools.AudioSamples;

import javax.sound.sampled.AudioFileFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomov on 25.6.2018 г..
 */
public class WavCutter implements AudioCutter {
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
        AudioFile as = new AudioFile(inputFile);
        for(Cut cut: cuts){
            AudioFile cutFile  = as.getFromTo(cut.getFrom(), cut.getTo());
            cutFiles.add(cutFile);
        }
    }
    public List<AudioFile> getCutFiles(){
        return cutFiles;
    }


}
