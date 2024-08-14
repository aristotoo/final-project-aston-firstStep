package UserInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
Класс, который будет обрабатывать запросы от пользователя, когда он начнет взаимодействие с консолью.
 */

public class RequestProcessing {
    Scanner input = new Scanner(System.in);
    List<Integer> answers = new ArrayList<>();

    public List<Integer> collectData() {
        int fillArray = input.nextInt();
        switch (fillArray) {
            case 0 -> System.exit(0);
            case 1, 2, 3 -> {
                answers.add(fillArray);
                int entity = input.nextInt();
                switch (entity) {
                    case 0 -> System.exit(0);
                    case 1, 2, 3 -> {
                        answers.add(entity);
                        int size = input.nextInt();
                        if (size > 0) {
                            answers.add(size);
                            int furtherAction = input.nextInt();
                            switch (furtherAction) {
                                case 0 -> System.exit(0);
                                case 1, 2, 3 -> {
                                    answers.add(furtherAction);
                                    int afterSorting = input.nextInt();
                                    switch (afterSorting) {
                                        case 0 -> System.exit(0);
                                        case 1, 2 -> {
                                            answers.add(afterSorting);
                                            int chooseField = input.nextInt();
                                            switch (chooseField) {
                                                case 0 -> System.exit(0);
                                                case 1, 2, 3 -> {
                                                    answers.add(chooseField);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return answers;
    }
}
