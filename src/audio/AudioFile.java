package audio;

import java.io.File;

/**
 * Created by Tomov on 1.7.2018 г..
 */
public interface AudioFile {
    AudioFile getFromTo(double from, double to);
    void saveFile(File directory, String name, String fileExtension)throws Exception;
    static String getFileExtension(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        int i = name.lastIndexOf('.');
        String ext = i > 0 ? name.substring(i + 1) : "";
        return ext;
    }
}
