package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactBookApp extends JFrame {
    private DefaultListModel<String> contactListModel;
    private JList<String> contactList;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton searchButton;

    public ContactBookApp() {
        setTitle("通讯录");

        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        // 联系人列表
        contactListModel = new DefaultListModel<>();
        contactListModel.addElement("贾晓芸 17713534706");
        contactListModel.addElement("小红 12312312312");
        contactListModel.addElement("小芳 45645645");
        contactList = new JList<>(contactListModel);
        contactList.setBorder(BorderFactory.createEtchedBorder());
        panel.add(new JScrollPane(contactList), BorderLayout.CENTER);

        // 按钮面板
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("增加");
        deleteButton = new JButton("删除");
        editButton = new JButton("修改");
        searchButton = new JButton("查找");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(searchButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // 添加按钮事件处理
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("请输入联系人信息：");
                if (input != null && !input.trim().isEmpty()) {
                    contactListModel.addElement(input);
                }
            }
        });

        // 删除按钮事件处理
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = contactList.getSelectedIndex();
                if (selectedIndex != -1) {
                    contactListModel.remove(selectedIndex);
                }
            }
        });

        // 修改按钮事件处理
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = contactList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String input = JOptionPane.showInputDialog(
                            "请输入修改后的联系人信息：", contactListModel.get(selectedIndex));
                    if (input != null && !input.trim().isEmpty()) {
                        contactListModel.setElementAt(input, selectedIndex);
                    }
                }
            }
        });

        // 查找按钮事件处理
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("请输入要查找的联系人：");
                if (input != null && !input.trim().isEmpty()) {
                    boolean found = false;
                    for (int i = 0; i < contactListModel.size(); i++) {
                        if (contactListModel.elementAt(i).contains(input)) {
                            contactList.setSelectedIndex(i);
                            contactList.ensureIndexIsVisible(i);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "未找到该联系人。");
                    }
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ContactBookApp().setVisible(true);
            }
        });
    }
}