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

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileSummaryServiceImpl<callSummaryList> implements IFileSummaryService {

    ReadUtil readUtil;

    public FileSummaryServiceImpl() {
        readUtil = new ReadUtil();
    }


    @Override
    public List<callSummary> getCallSummary(String filePath) throws IOException {

        List<callSummary> callSummaryList = new ArrayList<>();
        List<String> filteredLines = new ArrayList<>();
        File path = null;
        List<String> allLines = Files.readAllLines(Paths.get(path.getAbsolutePath()), Charset.defaultCharset());
        allLines.forEach(x -> {
            callSummaryList summary = buildCallSummary(x);
            if (summary != null) {
                callSummary callSummary = new callSummary();
                callSummaryList.add(callSummary);
            }
        });
        return callSummaryList;
    }


    @Override
    public String saveToFile(List<callSummary> processFile) {
        StringBuffer stringBuffer = new StringBuffer();
        String savePath = readUtil.readString("Please enter the path where you want to save ", "error");
        File file = new File(savePath);
        if (file.isDirectory()) {
            processFile.forEach(x -> {
                stringBuffer.append(x.toString());
            });

            try {
                Files.write(Paths.get(file.getAbsolutePath() + "\\" + LocalDate.now()), stringBuffer.toString().getBytes());
            } catch (Exception e) {
                return "The file was not saved due to " + e.getMessage();
            }
        }

        return "The output file is saved at " + file.getAbsolutePath();
    }
}





