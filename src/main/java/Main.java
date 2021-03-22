import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Generator generator = new Generator();
        String[] wordsArray = wordsArray(random, generator);

        System.out.println("Введите путь к файлу(можно оставит пустым)");
        String path;
        path = scanner.nextLine();

        System.out.println("Введите размер файла в байтах");
        int sizeFile;
        sizeFile = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите количество файлов");
        int countFiles;
        countFiles = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите вероятность (целое положительное число)");
        int probability;
        probability = scanner.nextInt();
        scanner.nextLine();

        while (probability <= 0) {
            System.out.println("\"Введите вероятность (целое положительное число)");
            probability = scanner.nextInt();
            scanner.nextLine();
        }
        getFiles(path, countFiles, sizeFile, wordsArray, probability, generator);
    }


    private static String[] wordsArray(Random random, Generator generator) {
        String[] words = new String[random.nextInt(1000)];
        for (int i = 0; i < words.length; i++) {
            words[i] = generator.wordCreate();
        }
        return words;
    }

    private static void getFiles(String path, int n, int size, String[] words, int probability, Generator generator) {

        int i = 0;
        String filePath;
        while (i < n) {
            filePath = getPathFile(path);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
                 FileInputStream fileInputStream = new FileInputStream(filePath)) {
                while (fileInputStream.available() < size) {
                    bufferedWriter.write('\t' + generator.createParagraph(words) + '\n');
                    bufferedWriter.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    private static String getPathFile(String path) {
        final String fileName = new Generator().wordCreate() + ".txt";
        return path + fileName;
    }
}