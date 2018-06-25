package audio;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Tomov on 25.6.2018 г..
 */
public interface AudioCutter {
    void tryToCreateCutFiles(File inputFile, ArrayList<Cut> cuts);
    void saveCutFilesTo(File file);
}
