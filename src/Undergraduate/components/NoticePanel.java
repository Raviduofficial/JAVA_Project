package Undergraduate.components;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Database.dbconnection;

public class NoticePanel extends JPanel {
    private JTable noticeTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private TableRowSorter<DefaultTableModel> rowSorter;
    private dbconnection dbConnector;

    public NoticePanel(String userId) {
        dbConnector = new dbconnection();
        setLayout(new BorderLayout());
  


        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(153,187,187));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("Notices");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        titlePanel.add(titleLabel, BorderLayout.WEST);


        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        searchPanel.setBackground(new Color(245, 248, 255));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        searchField = new JTextField();
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchField.setPreferredSize(new Dimension(250, 30));

        searchPanel.add(searchLabel, BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.WHITE);
        topPanel.add(titlePanel);
        topPanel.add(searchPanel);

        add(topPanel, BorderLayout.NORTH);

        // table
        String[] columnNames = {"Notice Title", "Content", "Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        noticeTable = new JTable(tableModel);
        noticeTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        noticeTable.setRowHeight(28);
        noticeTable.setGridColor(new Color(220, 230, 240));
        noticeTable.setSelectionBackground(new Color(204, 229, 255));

        JTableHeader header = noticeTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setBackground(new Color(102, 153, 255));
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(noticeTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        add(scrollPane, BorderLayout.CENTER);

        //search bar
        rowSorter = new TableRowSorter<>(tableModel);
        noticeTable.setRowSorter(rowSorter);
        noticeTable.setDefaultEditor(Object.class, null);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filter(); }
            public void removeUpdate(DocumentEvent e) { filter(); }
            public void changedUpdate(DocumentEvent e) { filter(); }

            private void filter() {
                String text = searchField.getText();
                rowSorter.setRowFilter(text.trim().isEmpty() ? null : RowFilter.regexFilter("(?i)" + text));
            }
        });


        noticeTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = noticeTable.getSelectedRow();
                if (selectedRow >= 0) {
                    selectedRow = noticeTable.convertRowIndexToModel(selectedRow);
                    String title = (String) tableModel.getValueAt(selectedRow, 0);
                    String content = (String) tableModel.getValueAt(selectedRow, 1);
                    String date = tableModel.getValueAt(selectedRow, 2).toString();

                    JTextArea contentArea = new JTextArea(content);
                    contentArea.setEditable(false);
                    contentArea.setLineWrap(true);
                    contentArea.setWrapStyleWord(true);
                    contentArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    contentArea.setBackground(new Color(248, 248, 248));

                    JScrollPane scroll = new JScrollPane(contentArea);
                    scroll.setPreferredSize(new Dimension(400, 250));

                    JOptionPane.showMessageDialog(
                            NoticePanel.this,
                            scroll,
                            title + " (" + date + ")",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });


        loadNotices();
    }

    private void loadNotices() {
        String query = "SELECT notice_title, notice_content, notice_date FROM notice ORDER BY notice_date DESC";
        try (Connection conn = dbconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String title = rs.getString("notice_title");
                String content = rs.getString("notice_content");
                Date date = rs.getDate("notice_date");

                tableModel.addRow(new Object[]{title, content, date});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load notices", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
