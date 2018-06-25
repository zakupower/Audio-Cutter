package audio;





import jAudioFeatureExtractor.jAudioTools.AudioSamples;

import javax.sound.sampled.AudioFileFormat;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Tomov on 25.6.2018 г..
 */
public class WavCutter implements AudioCutter {
    private File inputFile;
    private ArrayList<Cut> cuts;
    private ArrayList<AudioSamples> cutFiles = new ArrayList<>();


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
        AudioSamples as = new AudioSamples(inputFile,"",false);
        for(Cut cut: cuts){
            double[][] cutSamples = as.getSamplesChannelSegregated(cut.getFrom(), cut.getTo());
            AudioSamples cutFile = new AudioSamples(cutSamples,as.getAudioFormat(),"",false);
            cutFiles.add(cutFile);
        }
    }

    public void saveCutFilesTo(File file){
        try {
            for (int i = 0; i < cutFiles.size(); i++) {
                cutFiles.get(i).saveAudio(new File(file.getPath() +"\\"+ cuts.get(i).getName() + ".wav"), true, AudioFileFormat.Type.WAVE, false);
            }
        } catch(Exception exc){
            exc.printStackTrace();
        }
    }

}
