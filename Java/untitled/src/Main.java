import java.util.Scanner;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    class Main {
        public static void main(String[] args) {
            String person = "\uD83E\uDDD9";
            String monster = "\uD83E\uDDDF";

            int personLive = 3;
            int sizeBoard = 5;
            int personX;
            int personY;
            int step = 0;

            personX = 1 + sizeBoard / 2;
            personY = 1 + sizeBoard / 2;
            // \n, \t - спец символ
            String gamingField = "+ —— + —— + —— + —— + —— +\n"
                    + "|    |    |    |    |    |\n"
                    + "+ —— + —— + —— + —— + —— +\n"
                    + "|    |    |    |    |    |\n"
                    + "+ —— + —— + —— + —— + —— +\n"
                    + "|    |    | " + monster + " |    |    |\n"
                    + "+ —— + —— + —— + —— + —— +\n"
                    + "|    |    |    |    |    |\n"
                    + "+ —— + —— + —— + —— + —— +\n"
                    + "| " + person + " |    |    |    |    |\n"
                    + "+ —— + —— + —— + —— + —— +";

            System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            System.out.println("Ваш ответ:\t" + answer);
        }
    }
    switch (answer) {
        case "ДА":
            System.out.println("Выбери сложность игры (от 1 до 5):");
            int difficultGame = scanner.nextInt();
            System.out.println("Выбранная сложность:\t" + difficultGame);

            System.out.println(gamingField);
            System.out.println("Количество жизней:\t" + personLive + "\n");
            System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)" +
                    "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + ")");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(x + ", " + y);

            if (x != personX && y != personY) {
                System.out.println("Некорректный ход");
            } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                personX = x;
                personY = y;
                step+=1;
                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                        "\nХод номер: " + step);
            } else {
                System.out.println("Координаты не изменены");
            }
            break;

        case "НЕТ":
            System.out.println("Жаль, приходи еще!");
            break;

        default:
            System.out.println("Данные введены некорректно");
    }
    int personLive = 3;
    int sizeBoard = 5;
    int personX;
    int personY;
    int step = 0;

    personX = 1;
    personY = sizeBoard;

    Random random = new Random();
    int castleX = 1 + random.nextInt(sizeBoard);
    int castleY = 1;

    String leftBlock = " | ";
    String rightBlock = " |";
    String wall = " + —— + —— + —— + —— + —— + ";

    String[][] board = new String[sizeBoard][sizeBoard];

        for (int y = 1; y <= sizeBoard; y++) {
        for (int x = 1; x <= sizeBoard; x++) {
            board[y - 1][x - 1] = "  ";
        }
    }

    int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;

        for (int i = 0; i < countMonster; i++) {
        board[random.nextInt(sizeBoard - 1)]
                [random.nextInt(sizeBoard)] = monster;
    }

    board[castleY - 1][castleX - 1] = castle;

        System.out.println(
                "Привет! Ты готов начать играть в игру? "
                + "(Напиши: ДА или НЕТ)"
                );

    Scanner scanner = new Scanner(System.in);
    String answer = scanner.nextLine();

        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
        case "ДА":
            System.out.println("Выбери сложность игры (от 1 до 5):");
            int difficultGame = scanner.nextInt();
            System.out.println("Выбранная сложность:\t" + difficultGame);

            while (true) {
                board[personY - 1][personX - 1] = person;

                for (String[] row : board) {
                    System.out.println(wall);

                    for (String cell : row) {
                        System.out.print(leftBlock);
                        System.out.print(cell);
                    }

                    System.out.println(rightBlock);
                }

                System.out.println(wall);

                System.out.println("Количество жизней:\t"+ personLive + "\n");

                System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)" +
                        "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + ")");

                int x = scanner.nextInt();
                int y = scanner.nextInt();

                System.out.println(x + ", " + y);

                if (x != personX && y != personY) {
                    System.out.println("Некорректный ход");
                } else if (
                        Math.abs(x - personX) == 1
                                || Math.abs(y - personY) == 1
                ) {
                    if (board[y - 1][x - 1].equals("  ")) {
                        board[personY - 1][personX - 1] = "  ";

                        personX = x;
                        personY = y;
                        step++;

                        System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY + "\nХод номер: " + step);

                    } else if (
                            board[y - 1][x - 1].equals(castle)
                    ) {
                        System.out.println("Вы прошли игру!");
                        break;
                    } else {
                        System.out.println("Решите задачу.");
                    }
                } else {
                    System.out.println("Координаты не изменены");
                }

                if (personLive <= 0) {
                    break;
                }
            }

            if (personLive <= 0) {
                System.out.println(
                        "Закончились жизни. Итог: ..."
                );
            }
            break;

        case "НЕТ":
            System.out.println("Жаль, приходи ещё!");
            break;

        default:
            System.out.println("Данные введены некорректно");
            break;
    }
        int personLive = 3;
        int sizeBoard = 5;
        int personX;
        int personY;
        int step = 0;

        String monster = "\uD83E\uDDDF\u200D";
        String castle = "\uD83C\uDFF0";
        int sizeBoard = 3;
        int personX = 1;
        int personY = sizeBoard;
        personX = 1;
        personY = sizeBoard;

        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        int castleY = 1;

        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";

        int step = 0;
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— +";

        String gamingField = "+ —— + —— + —— +\n"
                + "|    |    | \uD83C\uDFE0 |\n"
                + "+ —— + —— + —— +\n"
                + "|    | " + monster + " |    |\n"
                + "+ —— + —— + —— +\n"
                + "| " + person + " |    |    |\n"
                + "+ —— + —— + —— +";
        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";

                for (int y = 1; y <= sizeBoard; y++) {
                    for (int x = 1; x <= sizeBoard; x++) {
                        board[y - 1][x - 1] = "  ";
                    }
                }


                int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
                Random r = new Random();
                for (int i = 0; i <= countMonster; i++) {
                    board[r.nextInt(sizeBoard - 1)][r.nextInt(sizeBoard)] = monster;
                }

                int castleX = r.nextInt(sizeBoard);
                int castleY = 0;

                for (int i = 0; i < countMonster; i++) {
                    board[random.nextInt(sizeBoard - 1)]
                            [random.nextInt(sizeBoard)] = monster;
                }

                board[castleY][castleX] = castle;
                board[castleY - 1][castleX - 1] = castle;

                System.out.println(
                        "Привет! Ты готов начать играть в игру? "
                                + "(Напиши: ДА или НЕТ)"
                );

                System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();

                Scanner sc = new Scanner(System.in);
                String answer = sc.nextLine();
                System.out.println("Ваш ответ:\t" + answer);


                switch (answer) {
                    case "ДА" -> {

                        System.out.println("Выбери сложность игры(от 1 до 5):");
                        int difficultGame = sc.nextInt();
                        case "ДА":
                            System.out.println("Выбери сложность игры (от 1 до 5):");
                            int difficultGame = scanner.nextInt();
                            System.out.println("Выбранная сложность:\t" + difficultGame);

                            int maxStep = 2;

                            while (true) {
                                board[personY - 1][personX - 1] = person;

                                for (String[] raw : board) {
                                    for (String[] row : board) {
                                        System.out.println(wall);
                                        for (String col : raw) {
                                            System.out.print(leftBlock + col + " ");

                                            for (String cell : row) {
                                                System.out.print(leftBlock);
                                                System.out.print(cell);
                                            }

                                            System.out.println(rightBlock);
                                        }
                                        System.out.println(wall);

                                        System.out.println(wall);

                                        System.out.println("Количество жизней:\t" + personLive + "\n");
                                        System.out.println("Количество жизней:\t"+ personLive + "\n");

                                        System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)" +
                                                "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + "))");
                                        int x = sc.nextInt();
                                        int y = sc.nextInt();
                                        "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + ")");

                                        int x = scanner.nextInt();
                                        int y = scanner.nextInt();

                                        System.out.println(x + ", " + y);

                                        // проверка
                                        if (x != personX && y != personY) {
                                            System.out.println("Неккоректный ход");
                                        } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                                            System.out.println("Некорректный ход");
                                        } else if (
                                                Math.abs(x - personX) == 1
                                                        || Math.abs(y - personY) == 1
                                        ) {
                                            if (board[y - 1][x - 1].equals("  ")) {
                                                board[personY - 1][personX - 1] = "  ";

                                                personX = x;
                                                personY = y;
                                                step++;
                                                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                                                        "\nХод номер: " + step);
                                            }else if (board[y - 1][x - 1].equals(castle)) {

                                                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY + "\nХод номер: " + step);

                                            } else if (
                                                    board[y - 1][x - 1].equals(castle)
                                            ) {
                                                System.out.println("Вы прошли игру!");
                                                break;
                                            } else {
                                                @@ -110,11 +115,20 @@ public static void main(String[] args) {
                                                }
                                            }

                                            System.out.println("Закончились жизни. Итог: ...");
                                        }
                                        case "НЕТ" -> System.out.println("Жаль, приходи еще!");
                                        default -> System.out.println("Данные введены неккоректно");
                                    }
                                    if (personLive <= 0) {
                                        System.out.println(
                                                "Закончились жизни. Итог: ..."
                                        );
                                    }
                                    break;

                                    case "НЕТ":
                                        System.out.println("Жаль, приходи ещё!");
                                        break;

                                    default:
                                        System.out.println("Данные введены некорректно");
                                        break;
                                }
                                static boolean taskMonster(int difficultGame) {
                                    @@ -107,37 +114,38 @@ static boolean taskMonster(int difficultGame) {
                                        int a = random.nextInt(100);
                                        int b = random.nextInt(100);
                                        int trueAnswer = a + b;

                                        System.out.println("Реши пример: " + a + " + " + b + " = ?");
                                        Scanner sc = new Scanner(System.in);
                                        int ans = sc.nextInt();

                                        if (trueAnswer == ans) {
                                            System.out.println("Верно! Ты победил монстра");
                                            return true;
                                        } else {
                                            System.out.println("Ты проиграл эту битву!");
                                            return false;
                                        }
                                        System.out.println("Ты проиграл эту битву!");
                                    } else {
                                        //допишем потом здесь еще игру, а пока пусть наш игрок проигрывает по умолчанию
                                        // какой-то код
                                        return false;
                                    }
                                    return false;
                                }


                                static void outputBoard(String[][] board, int live) {
                                    String leftBlock = "| ";
                                    String rightBlock = "|";
                                    String wall = "+ —— + —— + —— + —— + —— +";

                                    for (String[] raw : board) {
                                        for (String[] row : board) {
                                            System.out.println(wall);
                                            for (String col : raw) {
                                                for (String col : row) {
                                                    System.out.print(leftBlock + col + " ");
                                                }
                                                System.out.println(rightBlock);
                                            }
                                            System.out.println(wall);


                                            System.out.println("Количество жизней:\t" + live + "\n");
                                        }
                                    }