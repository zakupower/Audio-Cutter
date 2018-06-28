package audio;

import jAudioFeatureExtractor.jAudioTools.AudioSamples;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import java.io.File;

/**
 * Created by Tomov on 28.6.2018 г..
 */
public class AudioFile {
    private AudioSamples file;

    public AudioFile(AudioSamples file){
        this.file = file;
    }
    public AudioFile(File inputFile){
        try {
            file = new AudioSamples(inputFile, "", false);
        }catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    public AudioFile getFromTo(double from, double to){
        try {
            return new AudioFile(new AudioSamples(file.getSamplesChannelSegregated(from, to), file.getAudioFormat(),"", false));
        }catch(Exception exc) {
            exc.printStackTrace();
        }
        return null; // TODO no idea how to handle it without null
    }

    public void saveFile(File directory,String name,String fileExtension)throws Exception{
        AudioFileFormat.Type format = fileExtension.equals("wav")?AudioFileFormat.Type.WAVE:null;// for now i handle only WAV files
        file.saveAudio(new File(directory.getPath() +"\\"+ name + "." + fileExtension), true, format, false);
    }

}
