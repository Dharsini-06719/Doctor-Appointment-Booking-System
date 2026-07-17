public class Question {
    String text;
    public String[] options;
    int correctOption;
    int difficulty;
    String topic;
    boolean asked = false;

    public Question(String text, String[] options, int correctOption, int difficulty, String topic) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
        this.difficulty = difficulty;
        this.topic = topic;
    }

    /*
    public void display(int qnum) {
        System.out.println("\nQ" + qnum + " [Difficulty " + difficulty + "] - " + topic);
        System.out.println(text);
        for (int i = 0; i < options.length; i++) {
            if (options[i] != null && !options[i].trim().isEmpty()) {
                System.out.println((i + 1) + ". " + options[i]);
            }
        }
    }
     */
}
