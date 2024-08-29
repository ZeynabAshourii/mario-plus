package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class HighestResults extends JFrame implements ActionListener {
    private final String[] columnNames = {"Username" , "Max Score"};
    private final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    private JTable table;
    private User user;
    private JButton back;
    private LinkedList<User> sort;
    public HighestResults(User user){
        this.user = user;
        for(int i = 0; i < User.users.size(); i++){
            User.users.get(i).highestScore();
        }
        sort = User.sortResultUsers();

        this.setSize(1080 , 771);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        back = new JButton("back");
        this.add(back , BorderLayout.AFTER_LAST_LINE);
        back.setBounds(0,0,100, 50);
        back.setFocusable(false);
        back.addActionListener(this);

        table = new JTable(tableModel);
        table.setEnabled(false);
        JScrollPane p = new JScrollPane();
        p.setViewportView(table);
        retrieveData();


        this.add(p, BorderLayout.NORTH);

        this.setVisible(true);

    }

    private void retrieveData() {
        for (int i = 0; i < sort.size(); i++){
            Object[] rowData = new Object[columnNames.length];
            //
            rowData[0] = sort.get(i).username;
            rowData[1] = sort.get(i).maxScore;

            //
            tableModel.addRow(rowData);
        }
        for(int i = 0; i < 26; i ++){

            Object[] rowData = new Object[columnNames.length];
            rowData[0] = "";
            rowData[1] = "";
            tableModel.addRow(rowData);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(back)){
            dispose();
            Frame31 frame31 = new Frame31(user);
            frame31.setVisible(true);
        }
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        User user1 = new User("khar" , "456");
//        user1.maxScore = 100;
//        User user2 = new User("gav" , "456");
//        user2.maxScore = 80;
//        new HighestResults(new User("zeynab" , "1234"));
//    }
}
