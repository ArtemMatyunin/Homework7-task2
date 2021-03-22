public class Alphabet{
private final char[]letters;
private final char[] symbols;

    public Alphabet() {
        symbols = new char[]{'!','?','.',' ',','};
        letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f'
                , 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    }

    public char getLetters(int i) {
        return letters[i];
    }

    public char getSymbols(int i) {
        return symbols[i];
    }


}

