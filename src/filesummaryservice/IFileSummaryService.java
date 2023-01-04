package filesummaryservice;

import bean.callSummary;

import java.util.List;

public interface IFileSummaryService {
    List<callSummary> getCallSummary(String filePath);
}
