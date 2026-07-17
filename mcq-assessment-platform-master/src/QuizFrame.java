import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class QuizFrame extends JFrame {

    private final HybridAdaptiveQuiz quiz;
    private final Main dashboardRef;
    private final String username;

    private JLabel headerLabel;
    private JLabel difficultyLabel;
    private JLabel progressLabel;
    private JProgressBar progressBar;
    private JLabel questionLabel;

    private JButton[] optionButtons = new JButton[4];

    private Question currentQuestion;
    private int progress = 0;

    private final Color BG = new Color(17, 24, 32);
    private final Color ACCENT = new Color(79, 163, 255);
    private final Color TEXT = new Color(235, 245, 250);
    private final Color CORRECT = new Color(76, 175, 80);
    private final Color WRONG = new Color(229, 57, 53);
    private final Color CARD_BG = new Color(25, 34, 44);

    private boolean acceptingClicks = true;

    public QuizFrame(HybridAdaptiveQuiz quiz, String username, Main dashboardRef) {
        this.quiz = quiz;
        this.username = username;
        this.dashboardRef = dashboardRef;

        setTitle("CyberLearn • Quiz");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(880, 560);
        setLocationRelativeTo(null);

        initUI();
        SwingUtilities.invokeLater(this::loadNextQuestion);
        setVisible(true);
    }

    private void initUI() {
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.setBorder(new EmptyBorder(16, 18, 16, 18));

        headerLabel = new JLabel("Adaptive Quiz", SwingConstants.LEFT);
        headerLabel.setForeground(ACCENT);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        top.add(headerLabel, BorderLayout.WEST);

        JPanel meta = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        meta.setOpaque(false);
        difficultyLabel = new JLabel("Difficulty: —");
        difficultyLabel.setForeground(TEXT);
        difficultyLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        meta.add(difficultyLabel);

        progressLabel = new JLabel("Progress: 0/0");
        progressLabel.setForeground(TEXT);
        progressLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        meta.add(progressLabel);

        top.add(meta, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);
        add(centerWrapper, BorderLayout.CENTER);

        JPanel card = new JPanel();
        card.setBackground(CARD_BG);
        card.setPreferredSize(new Dimension(760, 360));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(46, 61, 78), 1),
                new EmptyBorder(20, 20, 20, 20)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        centerWrapper.add(card);

        questionLabel = new JLabel("", SwingConstants.LEFT);
        questionLabel.setForeground(TEXT);
        questionLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        questionLabel.setBorder(new EmptyBorder(6, 6, 12, 6));
        card.add(questionLabel);

        JPanel optionsArea = new JPanel();
        optionsArea.setOpaque(false);
        optionsArea.setLayout(new BoxLayout(optionsArea, BoxLayout.Y_AXIS));
        optionsArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(optionsArea);

        for (int i = 0; i < optionButtons.length; i++) {
            JButton b = new JButton();
            b.setFocusPainted(false);
            b.setHorizontalAlignment(SwingConstants.LEFT);
            b.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            b.setForeground(new Color(220, 235, 245));
            b.setBackground(CARD_BG);
            b.setOpaque(true);
            b.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(40, 56, 70), 1),
                    new EmptyBorder(14, 12, 14, 12)
            ));
            b.setAlignmentX(Component.LEFT_ALIGNMENT);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            final int idx = i;
            b.addActionListener(e -> onOptionClicked(idx));

            b.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if (acceptingClicks && b.isEnabled())
                        b.setBackground(new Color(32, 46, 60));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if (b.isEnabled())
                        b.setBackground(CARD_BG);
                }
            });

            optionButtons[i] = b;
            optionsArea.add(b);
            optionsArea.add(Box.createVerticalStrut(10));
        }

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setOpaque(false);
        bottom.setBorder(new EmptyBorder(10, 18, 18, 18));

        progressBar = new JProgressBar(0, Math.max(1, quiz.getTotalQuestions()));
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setForeground(ACCENT);
        progressBar.setBackground(new Color(28, 36, 44));
        bottom.add(progressBar, BorderLayout.CENTER);

        JButton quitBtn = new JButton("Quit");
        quitBtn.setFocusPainted(false);
        quitBtn.setBackground(new Color(60, 70, 80));
        quitBtn.setForeground(TEXT);
        quitBtn.setBorder(BorderFactory.createLineBorder(new Color(64, 80, 96)));
        quitBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Exit quiz and return to dashboard?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
                if (dashboardRef != null) {
                    dashboardRef.setVisible(true);
                    try { dashboardRef.refreshUserScore(); } catch (Exception ignored) {}
                }
            }
        });
        bottom.add(quitBtn, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

    private void onOptionClicked(int idx) {
        if (!acceptingClicks) return;
        acceptingClicks = false;

        for (JButton b : optionButtons) b.setEnabled(false);

        int selectedIndex = idx + 1;

        quiz.answerQuestion(currentQuestion, selectedIndex);

        int correctIdx = getCorrectOptionIndex(currentQuestion) - 1;
        if (selectedIndex - 1 == correctIdx) {
            optionButtons[idx].setBackground(CORRECT);
            optionButtons[idx].setForeground(Color.white);
        } else {
            optionButtons[idx].setBackground(WRONG);
            optionButtons[idx].setForeground(Color.white);
            if (correctIdx >= 0 && correctIdx < optionButtons.length && optionButtons[correctIdx] != null) {
                optionButtons[correctIdx].setBackground(CORRECT);
                optionButtons[correctIdx].setForeground(Color.white);
            }
        }

        progress++;
        progressBar.setValue(progress);
        progressBar.setString(String.format("Progress: %d / %d", progress, quiz.getTotalQuestions()));
        progressLabel.setText(String.format("Progress: %d/%d", progress, quiz.getTotalQuestions()));

        Timer t = new Timer(850, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((Timer) e.getSource()).stop();
                for (JButton b : optionButtons) {
                    b.setEnabled(true);
                    b.setBackground(CARD_BG);
                    b.setForeground(new Color(220, 235, 245));
                    b.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(new Color(40, 56, 70), 1),
                            new EmptyBorder(14, 12, 14, 12)
                    ));
                }
                acceptingClicks = true;
                loadNextQuestion();
            }
        });
        t.setRepeats(false);
        t.start();
    }

    private void loadNextQuestion() {
        currentQuestion = quiz.getNextQuestion();

        if (currentQuestion == null) {
            finishQuiz();
            return;
        }

        int diff = quiz.getCurrentDifficulty();
        difficultyLabel.setText("Difficulty: " + convertDifficulty(diff));

        String safeText = currentQuestion.text == null ? "(no text)" : currentQuestion.text;
        questionLabel.setText("<html><div style='width:720px;'>" + escapeHtml(safeText) + "</div></html>");

        for (int i = 0; i < optionButtons.length; i++) {
            if (i < currentQuestion.options.length && currentQuestion.options[i] != null && !currentQuestion.options[i].trim().isEmpty()) {
                optionButtons[i].setVisible(true);
                optionButtons[i].setText("<html><div style='width:680px;'>" + escapeHtml((i + 1) + ". " + currentQuestion.options[i]) + "</div></html>");
                optionButtons[i].setEnabled(true);
                optionButtons[i].setBackground(CARD_BG);
                optionButtons[i].setForeground(new Color(220, 235, 245));
            } else {
                optionButtons[i].setVisible(false);
            }
        }

        progressLabel.setText(String.format("Progress: %d/%d", progress, quiz.getTotalQuestions()));
        progressBar.setMaximum(Math.max(1, quiz.getTotalQuestions()));
        progressBar.setValue(progress);
        progressBar.setString(String.format("Progress: %d / %d", progress, quiz.getTotalQuestions()));
    }

    private void finishQuiz() {
        int score = quiz.getScore();
        int total = quiz.getTotalQuestions();

        DatabaseManager.updateHighscore(username, score);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setBackground(new Color(14, 20, 26));
        area.setForeground(TEXT);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        String level = "Unknown";
        try { level = quiz.inferSkillLevel(score, total); } catch (Exception ignored) {}
        area.setText("Quiz Completed!\n\nScore: " + score + " / " + total + "\nSkill Level: " + level);

        JOptionPane.showMessageDialog(this, new JScrollPane(area), "Results", JOptionPane.INFORMATION_MESSAGE);

        dispose();
        if (dashboardRef != null) {
            dashboardRef.setVisible(true);
            try { dashboardRef.refreshUserScore(); } catch (Exception ignored) {}
        }
    }

    private int getCorrectOptionIndex(Question q) {
        if (q == null) return -1;
        try {
            try {
                java.lang.reflect.Field f = q.getClass().getDeclaredField("correctOption");
                f.setAccessible(true);
                Object val = f.get(q);
                if (val instanceof Number) return ((Number) val).intValue();
            } catch (NoSuchFieldException ignore) {}
            try {
                java.lang.reflect.Field f2 = q.getClass().getDeclaredField("correctAnswer");
                f2.setAccessible(true);
                Object val2 = f2.get(q);
                if (val2 instanceof Number) return ((Number) val2).intValue();
            } catch (NoSuchFieldException ignore) {}
        } catch (Exception ignored) {}
        return -1;
    }

    private String convertDifficulty(int d) {
        return switch (d) {
            case 1 -> "Very Easy";
            case 2 -> "Easy";
            case 3 -> "Medium";
            case 4 -> "Hard";
            case 5 -> "Very Hard";
            default -> "Unknown";
        };
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br/>");
    }
}
