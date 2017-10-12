import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HowMany {
    private static char x = 'z';
    public static void main(String[] args) throws Exception {
        final String code = System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "main" + File.separator + "java" + File.separator +
                HowMany.class.getName().replace(".", File.separator) + ".java";

        System.out.println(code);

        HowMany hm = new HowMany();
        hm.append(code, String.format("\n//Character %s was found %d times", x, + hm.occurrences(code,x)));
    }


    public void append(final String sourceFile, final String message) throws IOException {
        Files.write(Paths.get(sourceFile), message.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }


    public int occurrences(final String sourceFile, final char x) throws Exception {
        final String s = new String(Files.readAllBytes(Paths.get(sourceFile)));
        System.out.println(s);
        String[] sa = s.split("\\b");
        for(String a : sa)
        {
            if(0 < a.trim().length())
            {
                System.out.println(a.trim());
            }
        }
        int n = 0; // occurrences counter
        int k = -1; // progressed through k
        while (-1 != (k = s.indexOf(x,k+1))) {
            n++;
        }
        return n;
    }
}

//Character z was found 1 times
//Character z was found 2 times