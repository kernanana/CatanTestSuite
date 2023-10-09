package presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LanguagePanel extends JPanel {
    private JLabel languageOptionsText;
    public LanguagePanel(JButton firstLanguage, JButton secondLanguage) {
       languageOptionsText  = new JLabel("Choose your language");
       add(languageOptionsText);
       add(firstLanguage);
       add(secondLanguage);
    }
}
