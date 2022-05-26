public class Dia9  {

    public static void main(String[] args) {
        for (Gender gender : Gender.values()) {
            System.out.printf("O valor de %s é %s%n", gender, gender.getValue());
        }
    }

    public enum Gender {
        MULHER('m'),
        HOMEM('h');

        private final char value;

        Gender(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }
}
