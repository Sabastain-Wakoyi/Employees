//package filesummaryservice;
//
//import bean.callSummary;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FileSummaryServiceImpl implements IFileSummaryService{
//
//
//    @Override
//    public List<callSummary> getCallSummary(String filePath) {
//
//        List<callSummary> callSummaryList= new ArrayList<>();
//
//        try{
//            List<String> lines = Files.readAllLines(Paths.get(filePath));
//            lines.forEach(x->{
//                if (isValid(x)) {
//                    String[] col = x.split("\\s+");
//                    callSummary callSummary = new callSummary();
//                    if (col.length == 8) {
//                        callSummary.setSrNo(col[0]);
//                        callSummary.setExt(col[1]);
//                        callSummary.setJun(col[2]);
//                        callSummary.setDirectoryNo(col[3]);
//                        callSummary.setDate(col[4]);
//                        callSummary.setTime(col[5]);
//                        callSummary.setDuration(col[6]);
//                        callSummary.setBillAmt(col[7]);
//                        callSummaryList.add(callSummary);
//
//
//            });
//
//        }
//
//        return null;
//
//
//
//    private boolean isValid(String line)  {
//        try {
//            Integer.parseInt(line.split("\\s+")[0]);
//            return true;
//        }
//        catch (Exception e) {
//            return false;
//        }
//
//    }
//
//}
//
//    private boolean isValid(String x) {
//    }
//
//        }

package filesummaryservice;


import bean.callSummary;
import util.ReadUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSummaryServiceImpl implements IFileSummaryService{

    ReadUtil readUtil;

    public FileSummaryServiceImpl(){
        readUtil = new ReadUtil();
    }


    @Override
    public List<callSummary> getCallSummary(String filePath) throws IOException {

        List<callSummary> callSummaryList = new ArrayList<>();
        List<String> filteredLines = new ArrayList<>();
        List<String> allLines = Files.readAllLines(Paths.get(path.getAbsolutePath()), Charset.defaultCharset());
        allLines.forEach(x->{
            callSummaryList summary = buildCallSummary(x);
            if(summary!=null){
                callSummaryList.add(callSummary);
            }
        });
        return callSummaryList;
    }
}