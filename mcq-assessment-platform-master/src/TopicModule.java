import java.util.*;

public class TopicModule {
    String title;
    List<Question> questions;

    public TopicModule(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void add(Question q) {
        questions.add(q);
    }

    public void resetAskedFlags() {
        for (Question q : questions) q.asked = false;
    }
}
