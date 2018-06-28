package audio;

import jAudioFeatureExtractor.jAudioTools.AudioSamples;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomov on 25.6.2018 г..
 */
public interface AudioCutter {
    void tryToCreateCutFiles(File inputFile, ArrayList<Cut> cuts);
    List<AudioFile> getCutFiles();
}
