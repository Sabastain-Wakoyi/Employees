package filesummaryui;

import util.ReadUtil;

public class FileSummaryService implements IfFileSummarise{
    private ReadUtil readUtil;
    private IfFileSummarise ifFileSummarise;

    public FileSummaryService(ReadUtil readUtil, IfFileSummarise ifFileSummarise) {
        this.readUtil = new ReadUtil() ;
        this.ifFileSummarise = new FileSummaryService();
    }

    @Override
    public void processFile() {


    }
}
