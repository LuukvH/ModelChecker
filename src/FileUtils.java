import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by laj on 12-3-2016.
 */
public class FileUtils {
    public static File[] getFiles(String dirName, final String extension) {
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(extension);
            }
        });
    }
}
