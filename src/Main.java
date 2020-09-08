import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String path = null;
        FileReader reader = null;

            try {
                path = consoleReader.readLine();
            } catch (IOException e) {
                System.out.println("Файл не найден");
            }

            ArrayList<String> list = new ArrayList<>();
            StringBuilder string = new StringBuilder();
            ArrayList<String> maxWord = new ArrayList<>();
            int max = 1;
            try {
                reader = new FileReader(path);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }
            int c;
            while (true) {
                try {
                    if ((c = reader.read()) == -1) break;

                    if ((c > 63 & c < 91) | (c > 96 & c < 123) | (c >= 1040 & c <= 1103)) {
                        string.append((char) c);
                    } else {
                        if (string.length() > 0) {
                            list.add(string.toString());
                        }
                        string = new StringBuilder();
                    }
                } catch (IOException  | NullPointerException e) {
                    System.out.println("Файл не найден");
                    break;
                }
            }
            if (string.length() > 0) {
                list.add(string.toString());
            }

            Collections.sort(list);

            for (String s : list) {
                System.out.println(s);

            }

            System.out.println();

            Set<String> set = new HashSet<String>(list);

            for (String uniqueWord : set) {
                int count = Collections.frequency(list, uniqueWord);
                if (count >= max) {
                    if (count > max) {
                        max = count;
                        maxWord.clear();
                        maxWord.add(uniqueWord);
                    } else {
                        maxWord.add(uniqueWord);
                    }
                }
                if ((count % 10 == 2) | (count % 10 == 3) | (count % 10 == 4)) {
                    System.out.println(">" + uniqueWord + "<" + " - встречается в тексте " + count + " раза");
                } else {
                    System.out.println(">" + uniqueWord + "<" + " - встречается в тексте " + count + " раз");
                }
            }

            System.out.println();

            if (maxWord.size() == 1) {
                System.out.println("Максимально встречающееся слово в файле - >" + maxWord.get(0) + "<");
                System.out.print("оно встречается ");
                if ((max % 10 == 2) | (max % 10 == 3) | (max % 10 == 4)) {
                    System.out.println(max + " раза");
                } else {
                    System.out.println(max + " раз");
                }
            } else if (maxWord.size() > 1) {
                System.out.println("Максимально встречающиеся слова в файле - ");
                for (String maxW : maxWord) {
                    System.out.println(">" + maxW + "<");
                }

                System.out.print("они встречаются в файле по ");
                if ((max % 10 == 2) | (max % 10 == 3) | (max % 10 == 4)) {
                    System.out.println(max + " раза каждое");
                } else {
                    System.out.println(max + " раз каждое");
                }
            }


        }
    }

