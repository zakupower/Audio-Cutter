package audio;

import jAudioFeatureExtractor.jAudioTools.AudioSamples;

import javax.sound.sampled.AudioFileFormat;

import java.io.File;

/**
 * Created by Tomov on 28.6.2018 г..
 */
public class WavFile implements AudioFile{
    private AudioSamples file;

    public WavFile(AudioSamples file){
        this.file = file;
    }
    public WavFile(File inputFile){
        try {
            file = new AudioSamples(inputFile, "", false);
        }catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    public WavFile getFromTo(double from, double to){
        try {
            return new WavFile(new AudioSamples(file.getSamplesChannelSegregated(from, to), file.getAudioFormat(),"", false));
        }catch(Exception exc) {
            exc.printStackTrace();
        }
        return null; // TODO no idea how to handle it without null
    }

    public void saveFile(File directory,String name,String fileExtension)throws Exception{
        AudioFileFormat.Type format = ("wav").equals(fileExtension)?AudioFileFormat.Type.WAVE:null;// for now i handle only WAV files
        file.saveAudio(new File(directory.getPath() +"\\"+ name + "." + fileExtension), true, format, false);
    }

}
