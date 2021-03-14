package java_project;

import java_project.data.CreateData;
import java_project.entity.Product;
import java_project.view.MainView;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CreateData.initData();
        MainView mainView = new MainView();
        mainView.openPrograming();
    }
}
