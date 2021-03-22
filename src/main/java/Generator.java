import java.util.Random;

public class Generator {
    Random random = new Random();
    Alphabet alphabet = new Alphabet();

    //создаем слово из набора букв в массиве класса Alphabet
    public String wordCreate() {
        StringBuilder word = new StringBuilder();
        int countLetters = (random.nextInt(15));
        for (int i = 0; i <= countLetters; i++) {
            word.append(alphabet.getLetters(random.nextInt(26)));
        }
        return word.toString();
    }

    //собирает предложение, случайно выбирая слова из массива String
    private String createProposition(String[] words) {
        String[] prop = new String[random.nextInt(14) + 1];
        String temp;
        for (int i = 0; i < prop.length; i++) {
            temp = words[random.nextInt(words.length - 1)];
            if (random.nextInt(3) == 2 && i < prop.length - 1) {
                prop[i] = temp + alphabet.getSymbols(4);
            } else {
                prop[i] = temp;
            }
        }

        String result = String.join(" ", prop);

        return result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase()
                + alphabet.getSymbols(random.nextInt(2))
                + alphabet.getSymbols(3);
    }
    //собирает параграф из предложений, генерируемых методом createProposition
    public String createParagraph(String[] words) {
        String[] paragraph = new String[random.nextInt(20)];

        for (int i = 0; i < paragraph.length; i++) {
            paragraph[i] = createProposition(words);
            if ((i != 0) && (paragraph[i].length() >= 114 || paragraph[i - 1].length() + paragraph[i].length() >= 114)
                    & (i != paragraph.length - 1)) {
                paragraph[i] += '\n';
            }
        }

        return String.join("", paragraph);
    }

}
