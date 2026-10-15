import java.io.Serializable;

/**
 * The Riddle class represents a riddle with a question and an answer.
 */
public class Riddle implements Serializable {
    
    /**
     * The question of the riddle.
     */
    public static String question;
    
    /**
     * The answer to the riddle.
     */
    public static String answer;

    /**
     * Constructs a new Riddle object with the given question and answer.
     * @param q the question of the riddle
     * @param a the answer to the riddle
     */
    public Riddle(String q, String a) {
        question = q;
        answer = a;
    }

    /**
     * Returns the question of the riddle.
     * @return the question of the riddle
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the answer to the riddle.
     * @return the answer to the riddle
     */
    public String getAnswer() {
        return answer;
    }
}