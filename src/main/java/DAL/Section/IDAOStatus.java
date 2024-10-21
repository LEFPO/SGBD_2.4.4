package main.java.DAL.Section;

import java.util.ArrayList;

import main.java.BL.Section.*;

public interface IDAOStatus {
    boolean addStatus(String status);
    boolean updateStatus(int id, String status);
    boolean deleteStatus(int id);
    ArrayList<Status> getStatuses();
    int getIDStatus(String status);
}

