package academy.learnprogramming.service;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    //fields
    private final MessageGenerator messageGenerator;
    private final Game game;

    //constructors
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
        this.game = game;
    }



    @Override
    public boolean isGameOver() {
       return game.isGameLost() || game.isGameWon();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }

    //init
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

}
