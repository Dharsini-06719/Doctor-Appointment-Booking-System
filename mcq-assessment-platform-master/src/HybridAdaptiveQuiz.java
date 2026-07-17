import java.util.*;

public class HybridAdaptiveQuiz {

    private final TopicModule module;
    private final String username;

    private int currentDifficulty = 3;
    private final Set<Question> asked = new LinkedHashSet<>();
    private final Map<Question, Integer> userAnswers = new HashMap<>();

    public HybridAdaptiveQuiz(TopicModule module, String username) {
        this.module = module;
        this.username = username;
    }

    public int getTotalQuestions() {
        return module.questions == null ? 0 : module.questions.size();
    }

    public int getCurrentDifficulty() {
        return currentDifficulty;
    }

    public int getScore() {
        int s = 0;
        for (Map.Entry<Question, Integer> e : userAnswers.entrySet()) {
            Question q = e.getKey();
            Integer chosen = e.getValue();
            if (chosen != null && q != null) {
                int correct = getCorrectOptionIndex(q);
                if (correct == chosen.intValue()) s++;
            }
        }
        return s;
    }

    public void answerQuestion(Question q, int selectedIndex) {
        if (q == null) return;
        userAnswers.put(q, selectedIndex);

        int correct = getCorrectOptionIndex(q);

        if (selectedIndex == correct) {
            if (currentDifficulty < 5) currentDifficulty++;
        } else {
            if (currentDifficulty > 1) currentDifficulty--;
        }

        asked.add(q);
    }

    public Question getNextQuestion() {
        List<Question> pool = new ArrayList<>();
        if (module.questions != null) {
            for (Question q : module.questions) {
                if (q == null) continue;
                if (!asked.contains(q)) pool.add(q);
            }
        }

        if (pool.isEmpty()) return null;

        Question best = null;
        int bestDiff = Integer.MAX_VALUE;
        for (Question q : pool) {
            int qDiff = normalizeDifficulty(q);
            int diff = Math.abs(qDiff - currentDifficulty);
            if (diff < bestDiff) {
                bestDiff = diff;
                best = q;
            } else if (diff == bestDiff && best != null) {
                int bestQDiff = normalizeDifficulty(best);
                if (qDiff > bestQDiff && qDiff >= currentDifficulty && bestQDiff < currentDifficulty) {
                    best = q;
                }
            }
        }

        if (best != null) {
            asked.add(best);
            try {
                java.lang.reflect.Field f = best.getClass().getDeclaredField("asked");
                f.setAccessible(true);
                if (f.getType() == boolean.class || f.getType() == Boolean.class) {
                    f.setBoolean(best, true);
                }
            } catch (Exception ignored) {
            }
        }

        return best;
    }

    private int normalizeDifficulty(Question q) {
        try {
            java.lang.reflect.Field f = q.getClass().getDeclaredField("difficulty");
            f.setAccessible(true);
            Object val = f.get(q);
            if (val instanceof Number) {
                int v = ((Number) val).intValue();
                if (v < 1) v = 1;
                if (v > 5) v = 5;
                return v;
            }
        } catch (Exception ignored) {
        }
        return 3;
    }

    private int getCorrectOptionIndex(Question q) {
        try {
            java.lang.reflect.Field f = null;
            try { f = q.getClass().getDeclaredField("correctOption"); } catch (Exception e) { }
            if (f == null) {
                try { f = q.getClass().getDeclaredField("correctAnswer"); } catch (Exception e) { }
            }
            if (f != null) {
                f.setAccessible(true);
                Object val = f.get(q);
                if (val instanceof Number) return ((Number) val).intValue();
            }
        } catch (Exception ignored) {}
        return -1;
    }

    public String inferSkillLevel(int score, int total) {
        if (total <= 0) return "Unknown";
        double pct = (100.0 * score) / total;
        if (pct >= 80.0) return "Advanced";
        if (pct >= 50.0) return "Intermediate";
        return "Beginner";
    }
}
