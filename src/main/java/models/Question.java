package models;

public class Question {
    private int id_question;
    private String content;
    private String reponse1;
    private String reponse2;
    private String reponse3;
    private String reponse4;
    private int trueanswer;
    private int duration;
    private int score;

    public Question() {
    }

    public Question(int id_question, String content, String reponse1, String reponse2, String reponse3, String reponse4, int trueanswer, int duration, int score) {
        this.id_question = id_question;
        this.content = content;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponse4 = reponse4;
        this.trueanswer = trueanswer;
        this.duration = duration;
        this.score = score;
    }
    public Question( String content, String reponse1, String reponse2, String reponse3, String reponse4, int trueanswer, int duration, int score) {

        this.content = content;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponse4 = reponse4;
        this.trueanswer = trueanswer;
        this.duration = duration;
        this.score = score;
    }



    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public String getReponse4() {
        return reponse4;
    }

    public void setReponse4(String reponse4) {
        this.reponse4 = reponse4;
    }

    public int getTrueAnswer() {
        return trueanswer;
    }

    public void setTrueAnswer(int trueanswer) {
        this.trueanswer = trueanswer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }




}
