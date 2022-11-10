package classes;

public class checkfilename {
    public static boolean checkfileextension(String filename) {
        if(filename.charAt(filename.length() - 1) == 't' &&
                filename.charAt(filename.length() - 1) == 'x' &&
                filename.charAt(filename.length() - 1) == 't' &&
                filename.charAt(filename.length() - 1) == '.')
            return true;
        else
            return false;
    }
}
