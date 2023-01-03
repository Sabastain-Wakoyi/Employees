package runners;

import filesSummarise.IfFileSummarise;
import utils.readUtils;

public class Runners<List, Employees> {
    private readUtils m_readUtils;
    private IfFileSummarise m_ifFileSummarise;

    public Runners(){
        m_readUtils = new readUtils();
        m_ifFileSummarise = new IfFileSummarise(){};

        UserOptions();

        }

    private  void UserOptions() {
        int choice = 0;
        List employeesArrayList = new List();

    }

}

