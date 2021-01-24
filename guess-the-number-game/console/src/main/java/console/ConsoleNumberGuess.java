package console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess  {



    //fields
    private final Game game;
    private final MessageGenerator messageGenerator;

    //constructors
    public ConsoleNumberGuess(@Autowired Game game, @Autowired MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //events
    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("start() -- Container ready for use.");
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again: Y/N?");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("Y")){
                    break;
                }
                game.reset();
            }
        }
    }
}
