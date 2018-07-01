package audio;

import java.io.File;

/**
 * Created by Tomov on 1.7.2018 г..
 */
public interface AudioFile {
    AudioFile getFromTo(double from, double to);
    void saveFile(File directory, String name, String fileExtension)throws Exception;
}
