
public class SequenceSearchImpl extends SelfAware
{

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);

    }

//    @Override
    public String[] getAllTaggedSequences() {
        String[] sa = new String[0];
        int x0;
        int x1 = -endTag.length(); // we have already processed the sequence all the way to x1

        while (-1 != (x0 = content.indexOf(startTag, x1 + endTag.length()))) { // x0 : location of 1st letter of a startTag
            x1 = content.indexOf(endTag, x0 + startTag.length()); // x1 : location of 1st letter of an endTag
            sa = adds(sa, content.substring(x0 + startTag.length(), x1));
        }
        return sa;
    }

  // @Override
    public String getLongestTaggedSequence() {
        final String[] sa = getAllTaggedSequences();
        int k = 0;
        for (int i = 1; i < sa.length; i++) {
            if (sa[k].length() <= sa[i].length()) {
                k = i;
            }
        }
        return sa.length > 0 ? sa[k] : null;
    }

  // @Override
    public String displayStringArray() {
        String result = "";
        for (final String s : getAllTaggedSequences()) {
            result += String.format("%s : %d\n", s, s.length());
        }
        return result;
    }


    @Override
    public void append(String sourceFile, String message)
    {
    String[] sa;
    for(int i = 1; ; i++)
    {
    //sourceFile + message;
    }
    }
    /**
     * @return {@link String} the content string with the all tags removed.
     */
    @Override
    public String toString() {
        return content.replace(startTag, "").replace(endTag, "");
    }
}