package models;

    public class TestQuestion {
        private int idtest_question;
        private int id_test;
        private int id_question;

        public TestQuestion(int idtest_question, int  id_test, int id_question) {
            this.idtest_question = idtest_question;
            this.id_test = id_test;
            this.id_question = id_question;
        }

        public TestQuestion(int id_test, int id_question) {
            this.id_test= id_test;
            this.id_question=id_question;

        }

        public int getIdtest_question() {
            return idtest_question;
        }

        public void setIdtest_question(int idtest_question) {
            this.idtest_question = idtest_question;
        }

        public int getId_test() {
            return id_test;
        }

        public void setId_test(int id_test) {
            this.id_test = id_test;
        }

        public int getId_question() {
            return id_question;
        }

        public void setId_question(int id_question) {
            this.id_question = id_question;
        }
    }


