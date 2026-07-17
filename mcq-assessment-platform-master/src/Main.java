import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main extends JFrame {

    private String username;
    private List<TopicModule> modules;
    private JLabel scoreLabel;

    public Main() {
        askUsername();
    }

    private void askUsername() {
        username = JOptionPane.showInputDialog(
                this,
                "Enter your username:",
                "CyberLearn Login",
                JOptionPane.PLAIN_MESSAGE
        );

        if (username == null || username.trim().isEmpty()) {
            System.exit(0);
            return;
        }

        username = username.trim();
        DatabaseManager.addUser(username);
        modules = QuestionsRepository.buildModules();
        initUI();
    }

    private void initUI() {
        setTitle("CyberLearn Dashboard");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel bg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(new GradientPaint(
                        0, 0, new Color(10, 14, 16),
                        getWidth(), getHeight(), new Color(3, 28, 40)
                ));
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(new BorderLayout());
        add(bg);

        JPanel glass = new JPanel();
        glass.setOpaque(false);
        glass.setLayout(new BoxLayout(glass, BoxLayout.Y_AXIS));
        glass.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        bg.add(glass, BorderLayout.CENTER);

        JLabel title = new JLabel("CYBERLEARN", SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Consolas", Font.BOLD, 42));
        title.setForeground(new Color(0, 247, 255));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0));
        glass.add(title);

        JLabel welcome = new JLabel("Welcome, " + username, SwingConstants.CENTER);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        welcome.setForeground(new Color(205, 245, 235));
        glass.add(welcome);

        scoreLabel = new JLabel();
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        scoreLabel.setForeground(new Color(155, 230, 215));
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 0));
        glass.add(scoreLabel);

        refreshUserScore();

        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        glass.add(btnPanel);

        JButton takeQuiz = cyberButton("Take Quiz");
        JButton highscores = cyberButton("Leaderboard");
        JButton exit = cyberButton("Exit");

        takeQuiz.addActionListener(e -> showTopicSelection());
        highscores.addActionListener(e -> showHighScores());
        exit.addActionListener(e -> System.exit(0));

        btnPanel.add(takeQuiz);
        btnPanel.add(highscores);
        btnPanel.add(exit);

        setVisible(true);
    }

    private JButton cyberButton(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b.setFocusPainted(false);
        b.setForeground(Color.black);
        b.setBackground(new Color(0, 247, 255));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 220, 240), 2),
                BorderFactory.createEmptyBorder(10, 22, 10, 22)
        ));

        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b.setBackground(new Color(50, 231, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                b.setBackground(new Color(0, 187, 255));
            }
        });

        return b;
    }

    private void showTopicSelection() {
        String[] topics = modules.stream().map(m -> m.title).toArray(String[]::new);
        if (topics.length == 0) return;

        String choice = (String) JOptionPane.showInputDialog(
                this,
                "Select Cyber Topic",
                "Quiz Menu",
                JOptionPane.PLAIN_MESSAGE,
                null,
                topics,
                topics[0]
        );

        if (choice == null) return;

        TopicModule selected = modules.stream()
                .filter(m -> m.title.equals(choice))
                .findFirst()
                .orElse(null);

        if (selected != null) startQuiz(selected);
    }

    private void startQuiz(TopicModule module) {
        module.resetAskedFlags();
        HybridAdaptiveQuiz quiz = new HybridAdaptiveQuiz(module, username);

        setVisible(false);
        new QuizFrame(quiz, username, this);
    }

    public void refreshUserScore() {
        int best = DatabaseManager.getUserScore(username);
        scoreLabel.setText(best >= 0 ?
                "Highscore: " + best + " pts" :
                "No highscore yet — Start learning!");
    }

    private void showHighScores() {
        String scores = DatabaseManager.getHighscores();
        JOptionPane.showMessageDialog(
                this,
                new JScrollPane(new JTextArea(
                        scores == null || scores.isEmpty() ? "No scores yet." : scores
                )),
                "Leaderboard",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
