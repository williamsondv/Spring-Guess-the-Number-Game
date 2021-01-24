package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {
    //fields
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();
    private final int maxNumber;
    private final int minNumber;

    //constructors
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //public methods
    @Override
    public int next() {
        return random.nextInt((maxNumber - minNumber) + minNumber);
    }



}
