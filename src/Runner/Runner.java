package Runner;

import filesummaryui.FileSummaryService;
import filesummaryui.IfFileSummarise;
import util.ReadUtil;

import java.io.IOException;
import java.util.List;

public class Runner {
    private ReadUtil m_readUtils;
    private IfFileSummarise m_ifFileSummarise;

    public Runner() throws IOException {
        m_readUtils = new ReadUtil();
        m_ifFileSummarise = new FileSummaryService();

        UserOptions();

        }

    private  void UserOptions() throws IOException {
        int choice = 0;

        do {
            displayMainMenu();
            choice = m_readUtils.readInt("Input Your Option", "Option Valid");
            switch (choice) {
                case 1:  {m_ifFileSummarise.processFile();
                    break;
                }
                case 2: {

                }

                case 3: {

                }

                case 4: {

                }

                default: {
                    break;
                }



            }
        }while ( choice != 1);
    }

    private void displayMainMenu() {
        System.out.println("Menu");
        System.out.println("......");
        System.out.println("1. Add an Employee");

    }

}

