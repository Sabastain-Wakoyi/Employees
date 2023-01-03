package Runner;

import filesummaryui.IfFileSummarise;
import util.ReadUtil;

public class Runner<List, Employees> {
    private ReadUtil m_readUtils;
    private IfFileSummarise m_ifFileSummarise;

    public Runner(){
        m_readUtils = new ReadUtil();
        m_ifFileSummarise = new IfFileSummarise(){};

        UserOptions();

        }

    private  void UserOptions() {
        int choice = 0;
        List employeesArrayList = new List();
        do
        {
            displayMainMenu();
            choice=m_readUtils.readInt("Input Your Option", "Option Valid");
            switch (choice)
            {
                case 1 :

                    m_Employees.AddNewEmployee();
            }
        }
    }

    private void displayMainMenu() {
    }

}

