import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationPanel {
    private JFrame mainFrame;
    private JButton bellIcon;
    private JPopupMenu notificationPopup;
    private JPanel notificationsPanel;
    private int notificationCount = 0;

    public NotificationPanel() {
        createGUI();
    }

    private void createGUI() {

        mainFrame = new JFrame("Notification Panel Example");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new BorderLayout());


        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bellIcon = new JButton();


        updateNotificationBadge(0);
        bellIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        bellIcon.setBorderPainted(false);
        bellIcon.setContentAreaFilled(false);
        bellIcon.setFocusPainted(false);

        topPanel.add(bellIcon);
        mainFrame.add(topPanel, BorderLayout.NORTH);


        notificationPopup = new JPopupMenu();
        notificationsPanel = new JPanel();
        notificationsPanel.setLayout(new BoxLayout(notificationsPanel, BoxLayout.Y_AXIS));


        JScrollPane scrollPane = new JScrollPane(notificationsPanel);
        scrollPane.setPreferredSize(new Dimension(300, 200));


        notificationPopup.setPopupSize(320, 220);
        notificationPopup.add(scrollPane);


        bellIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificationPopup.show(bellIcon, 0, bellIcon.getHeight());
                notificationCount = 0;
                updateNotificationBadge(notificationCount);
            }
        });

        mainFrame.setVisible(true);
    }

    public void addNotification(String title, String message) {
        JPanel notificationItem = new JPanel();
        notificationItem.setLayout(new BorderLayout());
        notificationItem.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        notificationItem.setBackground(Color.WHITE);


        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel timeLabel = new JLabel(sdf.format(new Date()));
        timeLabel.setForeground(Color.GRAY);

        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(timeLabel, BorderLayout.EAST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));

        JTextArea messageArea = new JTextArea(message);
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

        notificationItem.add(topPanel, BorderLayout.NORTH);
        notificationItem.add(messageArea, BorderLayout.CENTER);


        if (notificationsPanel.getComponentCount() > 0) {
            notificationsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        notificationsPanel.add(notificationItem);
        notificationsPanel.revalidate();
        notificationsPanel.repaint();


        notificationCount++;
        updateNotificationBadge(notificationCount);
    }

    private void updateNotificationBadge(int count) {
        if (count > 0) {
            bellIcon.setText("\uD83D\uDD14 (" + count + ")");
        } else {
            bellIcon.setText("\uD83D\uDD14");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NotificationPanel panel = new NotificationPanel();


                panel.addNotification("System Update", "A new system update is available. Please update when convenient.");
                panel.addNotification("New Message", "You have received a new message from John Doe.");
                panel.addNotification("Reminder", "Don't forget about the meeting at 3 PM today.");
                panel.addNotification("Task Completed", "Your background task has finished successfully.");
                panel.addNotification("Warning", "Low disk space on drive C:");
            }
        });
    }
}