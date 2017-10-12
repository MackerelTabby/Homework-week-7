import java.nio.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class SelfAware implements Language
{
    final String content;
    final String startTag;
    final String endTag;

    public SelfAware(final String content, final String startTag, String endTag)
    {
        if(content == null || startTag == null || endTag == null)
            throw new IllegalArgumentException("");
        if(!startTag.equals(endTag))
        {
            if(startTag.contains(endTag) || endTag.contains(startTag))
                throw new IllegalArgumentException("");
        }
        this.content = content;
        this.startTag = startTag;
        this.endTag = endTag;
    }
    public SelfAware() { content = "";
    startTag = "";
    endTag = "";};

    public static String[] adds(final String[] a, final String s)
    {
        final String[] sa;
        if(a != null && 0 < a.length)
        {
            sa = new String[a.length + 1];
            System.arraycopy(a, 0, sa, 0, a.length);
            sa[a.length] = s;
        }
        else
        {
            sa = new String[]{s};
        }
        return sa;
    }

    public int occurrences(String sourceFile) throws IOException
    {
        String key = new String(Files.readAllBytes(Paths.get(sourceFile)));
        String[] word = key.split("\\W+");
            int reserved = 0;
           // while(reserved > "boolean") or for loop {
            for (int i = 0; i < word.length; i++) {
                System.out.println(word[i]);
            }

        return reserved;
    }
    public void append(String sourceFile, String message) throws IOException
    {
        String key = new String(Files.readAllBytes(Paths.get(sourceFile)));
        Files.write(Paths.get(sourceFile), message.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }
    public static void main(String [] args)throws Exception
    {
        final String code =  System.getProperty("user.dir") + File.separator + "src"
                + File.separator + "main" + File.separator + "java" + File.separator
                + SelfAware.class.getName().replace(".", File.separator) + ".java";
        SelfAware sa = new SelfAware();
        sa.append(code, "\n//Keyword occurences: " + sa.occurrences(code));

    }

}

//Keyword occurences: 1
//Keyword occurences: 0
//Keyword occurences: 0