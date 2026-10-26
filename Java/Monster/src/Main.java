import java.util.Random;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
    public class Monster {
        private String image = "\uD83E\uDDDF";
        private final int x, y;

        Monster(int sizeBoard) {
            Random random = new Random();
            x = 1 + random.nextInt(sizeBoard);
            y = 1 + random.nextInt(sizeBoard - 1);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean conflictPerson(int personX, int personY) {
            return personX == x && personY == y;
        }

        public boolean taskMonster(int difficultGame) {
            System.out.println("Решите задачу:");

            if (difficultGame == 1) {
                Random random = new Random();
                int a = random.nextInt(100);
                int b = random.nextInt(100);
                int trueAnswer = a + b;

                System.out.println("Реши пример: " + a + " + " + b + " = ?");
                Scanner scanner = new Scanner(System.in);
                int answer = scanner.nextInt();

                if (trueAnswer == answer) {
                    System.out.println("Верно! Ты победил монстра");
                    return true;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    return false;
                }
            } else {
                // какой-то код
                return false;
            }
        }
    }
}