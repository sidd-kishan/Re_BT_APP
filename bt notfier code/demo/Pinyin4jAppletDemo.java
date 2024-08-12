/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  demo.Pinyin4jAppletDemo$1
 *  demo.Pinyin4jAppletDemo$2
 *  demo.Pinyin4jAppletDemo$3
 */
package demo;

import demo.Pinyin4jAppletDemo;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.Serializable;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pinyin4jAppletDemo
extends JApplet {
    private static final Dimension APP_SIZE = new Dimension(600, 400);
    private static String appName = "pinyin4j-2.0.0 applet demo";
    private static final long serialVersionUID = -1934962385592030162L;
    private JPanel buttonPanel = null;
    String[] caseTypes = new String[]{"LOWERCASE", "UPPERCASE"};
    private JComboBox caseTypesComboBox = null;
    private JLabel charLabel = null;
    private JTextField charTextField = null;
    private JButton convertButton = null;
    private JPanel formattedCharPanel = null;
    private JTextArea formattedOutputField = null;
    private JPanel jContentPane = null;
    private JTabbedPane jTabbedPane = null;
    private JPanel optionPanel = null;
    private JLabel toneLabel = null;
    String[] toneTypes;
    private JComboBox toneTypesComboBox = null;
    private JPanel unformattedCharPanel = null;
    private JLabel unformattedGwoyeuRomatzyhLabel = null;
    private JPanel unformattedGwoyeuRomatzyhPanel = null;
    private JScrollPane unformattedGwoyeuRomatzyhScrollPane = null;
    private JTextArea unformattedGwoyeuRomatzyhTextArea = null;
    private JLabel unformattedHanyuPinyinLabel = null;
    private JPanel unformattedHanyuPinyinPanel = null;
    private JScrollPane unformattedHanyuPinyinScrollPane = null;
    private JTextArea unformattedHanyuPinyinTextArea = null;
    private JLabel unformattedMPS2PinyinLabel = null;
    private JPanel unformattedMPS2PinyinPanel = null;
    private JScrollPane unformattedMPS2PinyinScrollPane = null;
    private JTextArea unformattedMPS2PinyinTextArea = null;
    private JLabel unformattedTongyongPinyinLabel = null;
    private JPanel unformattedTongyongPinyinPanel = null;
    private JScrollPane unformattedTongyongPinyinScrollPane = null;
    private JTextArea unformattedTongyongPinyinTextArea = null;
    private JLabel unformattedWadePinyinLabel = null;
    private JPanel unformattedWadePinyinPanel = null;
    private JScrollPane unformattedWadePinyinScrollPane = null;
    private JTextArea unformattedWadePinyinTextArea = null;
    private JLabel unformattedYalePinyinLabel = null;
    private JPanel unformattedYalePinyinPanel = null;
    private JScrollPane unformattedYalePinyinScrollPane = null;
    private JTextArea unformattedYalePinyinTextArea = null;
    String[] vCharTypes = new String[]{"WITH_U_AND_COLON", "WITH_V", "WITH_U_UNICODE"};
    private JComboBox vCharTypesComboBox = null;

    public Pinyin4jAppletDemo() {
        this.toneTypes = new String[]{"WITH_TONE_NUMBER", "WITHOUT_TONE", "WITH_TONE_MARK"};
        this.init();
    }

    static /* synthetic */ String access$000(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.getChineseCharText();
    }

    static /* synthetic */ JComboBox access$100(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.toneTypesComboBox;
    }

    static /* synthetic */ JTextArea access$1000(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.formattedOutputField;
    }

    static /* synthetic */ JComboBox access$200(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.vCharTypesComboBox;
    }

    static /* synthetic */ JComboBox access$300(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.caseTypesComboBox;
    }

    static /* synthetic */ JTextArea access$400(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.unformattedHanyuPinyinTextArea;
    }

    static /* synthetic */ JTextArea access$500(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.unformattedTongyongPinyinTextArea;
    }

    static /* synthetic */ JTextArea access$600(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.unformattedWadePinyinTextArea;
    }

    static /* synthetic */ JTextArea access$700(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.unformattedMPS2PinyinTextArea;
    }

    static /* synthetic */ JTextArea access$800(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.unformattedYalePinyinTextArea;
    }

    static /* synthetic */ JTextArea access$900(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        return pinyin4jAppletDemo.unformattedGwoyeuRomatzyhTextArea;
    }

    private JPanel getButtonPanel() {
        JPanel jPanel;
        if (this.buttonPanel != null) return this.buttonPanel;
        this.buttonPanel = jPanel = new JPanel();
        jPanel.add((Component)this.getConvertButton(), null);
        return this.buttonPanel;
    }

    private JComboBox getCaseTypesComboBox() {
        if (this.caseTypesComboBox != null) return this.caseTypesComboBox;
        this.caseTypesComboBox = new JComboBox<String>(this.caseTypes);
        return this.caseTypesComboBox;
    }

    private JTextField getCharTextField() {
        JTextField jTextField;
        if (this.charTextField != null) return this.charTextField;
        this.charTextField = jTextField = new JTextField();
        jTextField.setFont(new Font("Dialog", 0, 12));
        this.charTextField.setText("\u548c");
        this.charTextField.setPreferredSize(new Dimension(26, 20));
        return this.charTextField;
    }

    private String getChineseCharText() {
        return this.charTextField.getText();
    }

    private JButton getConvertButton() {
        JButton jButton;
        if (this.convertButton != null) return this.convertButton;
        this.convertButton = jButton = new JButton();
        jButton.setText("Convert to Pinyin");
        this.convertButton.addActionListener((ActionListener)new 2(this));
        return this.convertButton;
    }

    private JPanel getFormattedCharPanel() {
        JPanel jPanel;
        if (this.formattedCharPanel != null) return this.formattedCharPanel;
        this.formattedCharPanel = jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        this.formattedCharPanel.add((Component)this.getFormattedOutputField(), "Center");
        return this.formattedCharPanel;
    }

    private JTextArea getFormattedOutputField() {
        JTextArea jTextArea;
        if (this.formattedOutputField != null) return this.formattedOutputField;
        this.formattedOutputField = jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        return this.formattedOutputField;
    }

    private JPanel getJContentPane() {
        JPanel jPanel;
        if (this.jContentPane != null) return this.jContentPane;
        this.jContentPane = jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        this.jContentPane.add((Component)this.getJTabbedPane(), "Center");
        this.jContentPane.add((Component)this.getOptionPanel(), "North");
        this.jContentPane.add((Component)this.getButtonPanel(), "South");
        return this.jContentPane;
    }

    private JTabbedPane getJTabbedPane() {
        JTabbedPane jTabbedPane;
        if (this.jTabbedPane != null) return this.jTabbedPane;
        this.jTabbedPane = jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Unformatted Chinese Romanization Systems", null, this.getUnformattedCharPanel(), null);
        this.jTabbedPane.addTab("Formatted Hanyu Pinyin", null, this.getFormattedCharPanel(), null);
        return this.jTabbedPane;
    }

    private JPanel getOptionPanel() {
        if (this.optionPanel != null) return this.optionPanel;
        JComponent jComponent = new JLabel();
        this.charLabel = jComponent;
        ((JLabel)jComponent).setText("Input Chinese:");
        jComponent = new JLabel();
        this.toneLabel = jComponent;
        ((JLabel)jComponent).setText(" Format:");
        jComponent = new JPanel();
        this.optionPanel = jComponent;
        jComponent.setPreferredSize(new Dimension(640, 34));
        this.optionPanel.add((Component)this.charLabel, null);
        this.optionPanel.add((Component)this.getCharTextField(), null);
        this.optionPanel.add((Component)this.toneLabel, null);
        this.optionPanel.add((Component)this.getToneTypesComboBox(), null);
        this.optionPanel.add((Component)this.getVCharTypesComboBox(), null);
        this.optionPanel.add((Component)this.getCaseTypesComboBox(), null);
        return this.optionPanel;
    }

    private JComboBox getToneTypesComboBox() {
        JComboBox<String> jComboBox;
        if (this.toneTypesComboBox != null) return this.toneTypesComboBox;
        this.toneTypesComboBox = jComboBox = new JComboBox<String>(this.toneTypes);
        jComboBox.addActionListener((ActionListener)new 3(this));
        return this.toneTypesComboBox;
    }

    private JPanel getUnformattedCharPanel() {
        JPanel jPanel;
        if (this.unformattedCharPanel != null) return this.unformattedCharPanel;
        Serializable serializable = new JLabel();
        this.unformattedHanyuPinyinLabel = serializable;
        ((JLabel)serializable).setText("Hanyu Pinyin");
        serializable = new GridLayout();
        ((GridLayout)serializable).setRows(2);
        ((GridLayout)serializable).setHgap(1);
        ((GridLayout)serializable).setVgap(1);
        ((GridLayout)serializable).setColumns(3);
        this.unformattedCharPanel = jPanel = new JPanel();
        jPanel.setLayout((LayoutManager)((Object)serializable));
        this.unformattedCharPanel.add((Component)this.getUnformattedHanyuPinyinPanel(), null);
        this.unformattedCharPanel.add((Component)this.getUnformattedTongyongPinyinPanel(), null);
        this.unformattedCharPanel.add((Component)this.getUnformattedWadePinyinPanel(), null);
        this.unformattedCharPanel.add((Component)this.getUnformattedMPS2PinyinPanel(), null);
        this.unformattedCharPanel.add((Component)this.getUnformattedYalePinyinPanel(), null);
        this.unformattedCharPanel.add((Component)this.getUnformattedGwoyeuRomatzyhPanel(), null);
        return this.unformattedCharPanel;
    }

    private JPanel getUnformattedGwoyeuRomatzyhPanel() {
        if (this.unformattedGwoyeuRomatzyhPanel != null) return this.unformattedGwoyeuRomatzyhPanel;
        JComponent jComponent = new JLabel();
        this.unformattedGwoyeuRomatzyhLabel = jComponent;
        ((JLabel)jComponent).setText("Gwoyeu Romatzyh");
        jComponent = new JPanel();
        this.unformattedGwoyeuRomatzyhPanel = jComponent;
        jComponent.setLayout(new BorderLayout());
        this.unformattedGwoyeuRomatzyhPanel.add((Component)this.unformattedGwoyeuRomatzyhLabel, "North");
        this.unformattedGwoyeuRomatzyhPanel.add((Component)this.getUnformattedGwoyeuRomatzyhScrollPane(), "Center");
        return this.unformattedGwoyeuRomatzyhPanel;
    }

    private JScrollPane getUnformattedGwoyeuRomatzyhScrollPane() {
        JScrollPane jScrollPane;
        if (this.unformattedGwoyeuRomatzyhScrollPane != null) return this.unformattedGwoyeuRomatzyhScrollPane;
        this.unformattedGwoyeuRomatzyhScrollPane = jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(this.getUnformattedGwoyeuRomatzyhTextArea());
        return this.unformattedGwoyeuRomatzyhScrollPane;
    }

    private JTextArea getUnformattedGwoyeuRomatzyhTextArea() {
        JTextArea jTextArea;
        if (this.unformattedGwoyeuRomatzyhTextArea != null) return this.unformattedGwoyeuRomatzyhTextArea;
        this.unformattedGwoyeuRomatzyhTextArea = jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        this.unformattedGwoyeuRomatzyhTextArea.setLineWrap(true);
        return this.unformattedGwoyeuRomatzyhTextArea;
    }

    private JPanel getUnformattedHanyuPinyinPanel() {
        JPanel jPanel;
        if (this.unformattedHanyuPinyinPanel != null) return this.unformattedHanyuPinyinPanel;
        this.unformattedHanyuPinyinPanel = jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        this.unformattedHanyuPinyinPanel.add((Component)this.unformattedHanyuPinyinLabel, "North");
        this.unformattedHanyuPinyinPanel.add((Component)this.getUnformattedHanyuPinyinScrollPane(), "Center");
        return this.unformattedHanyuPinyinPanel;
    }

    private JScrollPane getUnformattedHanyuPinyinScrollPane() {
        JScrollPane jScrollPane;
        if (this.unformattedHanyuPinyinScrollPane != null) return this.unformattedHanyuPinyinScrollPane;
        this.unformattedHanyuPinyinScrollPane = jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(this.getUnformattedHanyuPinyinTextArea());
        return this.unformattedHanyuPinyinScrollPane;
    }

    private JTextArea getUnformattedHanyuPinyinTextArea() {
        JTextArea jTextArea;
        if (this.unformattedHanyuPinyinTextArea != null) return this.unformattedHanyuPinyinTextArea;
        this.unformattedHanyuPinyinTextArea = jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        this.unformattedHanyuPinyinTextArea.setLineWrap(true);
        return this.unformattedHanyuPinyinTextArea;
    }

    private JPanel getUnformattedMPS2PinyinPanel() {
        if (this.unformattedMPS2PinyinPanel != null) return this.unformattedMPS2PinyinPanel;
        JComponent jComponent = new JLabel();
        this.unformattedMPS2PinyinLabel = jComponent;
        ((JLabel)jComponent).setText("MPSII Pinyin");
        jComponent = new JPanel();
        this.unformattedMPS2PinyinPanel = jComponent;
        jComponent.setLayout(new BorderLayout());
        this.unformattedMPS2PinyinPanel.add((Component)this.unformattedMPS2PinyinLabel, "North");
        this.unformattedMPS2PinyinPanel.add((Component)this.getUnformattedMPS2PinyinScrollPane(), "Center");
        return this.unformattedMPS2PinyinPanel;
    }

    private JScrollPane getUnformattedMPS2PinyinScrollPane() {
        JScrollPane jScrollPane;
        if (this.unformattedMPS2PinyinScrollPane != null) return this.unformattedMPS2PinyinScrollPane;
        this.unformattedMPS2PinyinScrollPane = jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(this.getUnformattedMPS2PinyinTextArea());
        return this.unformattedMPS2PinyinScrollPane;
    }

    private JTextArea getUnformattedMPS2PinyinTextArea() {
        JTextArea jTextArea;
        if (this.unformattedMPS2PinyinTextArea != null) return this.unformattedMPS2PinyinTextArea;
        this.unformattedMPS2PinyinTextArea = jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        this.unformattedMPS2PinyinTextArea.setLineWrap(true);
        return this.unformattedMPS2PinyinTextArea;
    }

    private JPanel getUnformattedTongyongPinyinPanel() {
        if (this.unformattedTongyongPinyinPanel != null) return this.unformattedTongyongPinyinPanel;
        JComponent jComponent = new JLabel();
        this.unformattedTongyongPinyinLabel = jComponent;
        ((JLabel)jComponent).setText("Tongyong Pinyin");
        jComponent = new JPanel();
        this.unformattedTongyongPinyinPanel = jComponent;
        jComponent.setLayout(new BorderLayout());
        this.unformattedTongyongPinyinPanel.add((Component)this.unformattedTongyongPinyinLabel, "North");
        this.unformattedTongyongPinyinPanel.add((Component)this.getUnformattedTongyongPinyinScrollPane(), "Center");
        return this.unformattedTongyongPinyinPanel;
    }

    private JScrollPane getUnformattedTongyongPinyinScrollPane() {
        JScrollPane jScrollPane;
        if (this.unformattedTongyongPinyinScrollPane != null) return this.unformattedTongyongPinyinScrollPane;
        this.unformattedTongyongPinyinScrollPane = jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(this.getUnformattedTongyongPinyinTextArea());
        return this.unformattedTongyongPinyinScrollPane;
    }

    private JTextArea getUnformattedTongyongPinyinTextArea() {
        JTextArea jTextArea;
        if (this.unformattedTongyongPinyinTextArea != null) return this.unformattedTongyongPinyinTextArea;
        this.unformattedTongyongPinyinTextArea = jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        this.unformattedTongyongPinyinTextArea.setLineWrap(true);
        return this.unformattedTongyongPinyinTextArea;
    }

    private JPanel getUnformattedWadePinyinPanel() {
        if (this.unformattedWadePinyinPanel != null) return this.unformattedWadePinyinPanel;
        JComponent jComponent = new JLabel();
        this.unformattedWadePinyinLabel = jComponent;
        ((JLabel)jComponent).setText("Wade-Giles  Pinyin");
        jComponent = new JPanel();
        this.unformattedWadePinyinPanel = jComponent;
        jComponent.setLayout(new BorderLayout());
        this.unformattedWadePinyinPanel.add((Component)this.unformattedWadePinyinLabel, "North");
        this.unformattedWadePinyinPanel.add((Component)this.getUnformattedWadePinyinScrollPane(), "Center");
        return this.unformattedWadePinyinPanel;
    }

    private JScrollPane getUnformattedWadePinyinScrollPane() {
        JScrollPane jScrollPane;
        if (this.unformattedWadePinyinScrollPane != null) return this.unformattedWadePinyinScrollPane;
        this.unformattedWadePinyinScrollPane = jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(this.getUnformattedWadePinyinTextArea());
        return this.unformattedWadePinyinScrollPane;
    }

    private JTextArea getUnformattedWadePinyinTextArea() {
        JTextArea jTextArea;
        if (this.unformattedWadePinyinTextArea != null) return this.unformattedWadePinyinTextArea;
        this.unformattedWadePinyinTextArea = jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        this.unformattedWadePinyinTextArea.setLineWrap(true);
        return this.unformattedWadePinyinTextArea;
    }

    private JPanel getUnformattedYalePinyinPanel() {
        if (this.unformattedYalePinyinPanel != null) return this.unformattedYalePinyinPanel;
        JComponent jComponent = new JLabel();
        this.unformattedYalePinyinLabel = jComponent;
        ((JLabel)jComponent).setText("Yale Pinyin");
        jComponent = new JPanel();
        this.unformattedYalePinyinPanel = jComponent;
        jComponent.setLayout(new BorderLayout());
        this.unformattedYalePinyinPanel.add((Component)this.unformattedYalePinyinLabel, "North");
        this.unformattedYalePinyinPanel.add((Component)this.getUnformattedYalePinyinScrollPane(), "Center");
        return this.unformattedYalePinyinPanel;
    }

    private JScrollPane getUnformattedYalePinyinScrollPane() {
        JScrollPane jScrollPane;
        if (this.unformattedYalePinyinScrollPane != null) return this.unformattedYalePinyinScrollPane;
        this.unformattedYalePinyinScrollPane = jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(this.getUnformattedYalePinyinTextArea());
        return this.unformattedYalePinyinScrollPane;
    }

    private JTextArea getUnformattedYalePinyinTextArea() {
        JTextArea jTextArea;
        if (this.unformattedYalePinyinTextArea != null) return this.unformattedYalePinyinTextArea;
        this.unformattedYalePinyinTextArea = jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        this.unformattedYalePinyinTextArea.setLineWrap(true);
        return this.unformattedYalePinyinTextArea;
    }

    private JComboBox getVCharTypesComboBox() {
        if (this.vCharTypesComboBox != null) return this.vCharTypesComboBox;
        this.vCharTypesComboBox = new JComboBox<String>(this.vCharTypes);
        return this.vCharTypesComboBox;
    }

    public static void main(String[] object) {
        object = new Pinyin4jAppletDemo();
        System.runFinalizersOnExit(true);
        JFrame jFrame = new JFrame(appName);
        jFrame.addWindowListener((WindowListener)new 1((Pinyin4jAppletDemo)object));
        jFrame.add("Center", (Component)object);
        ((Pinyin4jAppletDemo)object).init();
        ((Applet)object).start();
        jFrame.setSize(APP_SIZE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    @Override
    public void init() {
        this.setSize(APP_SIZE);
        this.setContentPane(this.getJContentPane());
        this.setName(appName);
    }
}
