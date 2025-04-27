package Undergraduate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Database.dbconnection;
import Undergraduate.components.*;

import Login.Login;

public class Undergraduate extends JFrame implements ActionListener {

    private JPanel leftPanel, rightPanel;
    private CardLayout cardLayout;

    private JButton courseBtn, attendanceBtn, medicalBtn, gradeBtn, timeTableBtn, noticeBtn, profileBtn, logOutBtn;

    private String userId;
    private dbconnection dbConnector;

    public Undergraduate(String userId) {
        this.userId = userId;
        this.dbConnector = new dbconnection();

        
        setTitle("Undergraduate Portal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        Font buttonFont = new Font("Roboto", Font.BOLD, 13);

        // Left navigation panel
        leftPanel = new JPanel(null);
        leftPanel.setBounds(0, 0, 200, 600);
        leftPanel.setBackground(new Color(153,187,187));

        courseBtn = createNavButton("COURSES", 100, buttonFont);
        attendanceBtn = createNavButton("ATTENDANCE", 150, buttonFont);
        medicalBtn = createNavButton("MEDICAL", 200, buttonFont);
        gradeBtn = createNavButton("GRADES", 250, buttonFont);
        timeTableBtn = createNavButton("TIME TABLE", 300, buttonFont);
        noticeBtn = createNavButton("NOTICES", 350, buttonFont);
        profileBtn = createNavButton("MY PROFILE", 400, buttonFont);
        logOutBtn = createNavButton("Log Out", 500, buttonFont);
        logOutBtn.setForeground(Color.red);

        leftPanel.add(courseBtn);
        leftPanel.add(attendanceBtn);
        leftPanel.add(medicalBtn);
        leftPanel.add(gradeBtn);
        leftPanel.add(timeTableBtn);
        leftPanel.add(noticeBtn);
        leftPanel.add(profileBtn);
        leftPanel.add(logOutBtn);

        // Right content panel with CardLayout
        cardLayout = new CardLayout();
        rightPanel = new JPanel(cardLayout);
        rightPanel.setBounds(200, 0, 800, 600);

        rightPanel.add(new CoursePanel(), "COURSES");
        rightPanel.add(new AttendancePanel(userId, dbConnector), "ATTENDANCE");
        rightPanel.add(new MedicalPanel(userId, dbConnector), "MEDICAL");
        rightPanel.add(new GradePanel(userId), "GRADES");
        rightPanel.add(new TimeTablePanel(dbConnector), "TIME TABLE");
        rightPanel.add(new NoticePanel(userId), "NOTICES");
        rightPanel.add(new ProfilePanel(userId), "MY PROFILE");

        add(leftPanel);
        add(rightPanel);

        // Set default panel
        cardLayout.show(rightPanel, "COURSES");
        courseBtn.setEnabled(false);
        courseBtn.setForeground(Color.WHITE);
    }

    private JButton createNavButton(String text, int y, Font font) {
        JButton btn = new JButton(text);
        btn.setBounds(0, y, 200, 50);
        btn.setForeground(Color.BLACK);
        btn.setBackground(new Color(153,187,187));
        btn.setFont(font);
        btn.setFocusable(false);
        btn.setBorderPainted(false);
        btn.addActionListener(this);
        return btn;
    }

    private void resetButtons() {
        JButton[] buttons = {
            courseBtn, attendanceBtn, medicalBtn, gradeBtn, timeTableBtn, noticeBtn, profileBtn
        };
        for (JButton btn : buttons) {
            btn.setEnabled(true);
            btn.setForeground(Color.BLACK);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resetButtons();

        Object source = e.getSource();

        if (source == courseBtn) {
            cardLayout.show(rightPanel, "COURSES");
            courseBtn.setEnabled(false);
            courseBtn.setForeground(Color.WHITE);
        } else if (source == attendanceBtn) {
            cardLayout.show(rightPanel, "ATTENDANCE");
            attendanceBtn.setEnabled(false);
            attendanceBtn.setForeground(Color.WHITE);
        } else if (source == medicalBtn) {
            cardLayout.show(rightPanel, "MEDICAL");
            medicalBtn.setEnabled(false);
            medicalBtn.setForeground(Color.WHITE);
        } else if (source == gradeBtn) {
            cardLayout.show(rightPanel, "GRADES");
            gradeBtn.setEnabled(false);
            gradeBtn.setForeground(Color.WHITE);
        } else if (source == timeTableBtn) {
            cardLayout.show(rightPanel, "TIME TABLE");
            timeTableBtn.setEnabled(false);
            timeTableBtn.setForeground(Color.WHITE);
        } else if (source == noticeBtn) {
            cardLayout.show(rightPanel, "NOTICES");
            noticeBtn.setEnabled(false);
            noticeBtn.setForeground(Color.WHITE);
        } else if (source == profileBtn) {
            cardLayout.show(rightPanel, "MY PROFILE");
            profileBtn.setEnabled(false);
            profileBtn.setForeground(Color.WHITE);
        } else if (source == logOutBtn) {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to log out?",
                    "Confirm Logout",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                profileBtn.setEnabled(false);
                profileBtn.setForeground(Color.WHITE);
                
                this.dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        }

    }
}
