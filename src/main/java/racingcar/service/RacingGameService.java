package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.RacingGameConstants;
import racingcar.model.RacingCar;

public class RacingGameService {

    private final List<RacingCar> racingCars;

    public RacingGameService(List<String> carNames) {
        this.racingCars = initializeCars(carNames);
    }

    private List<RacingCar> initializeCars(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void startRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceOnce();
        }
    }

    private void raceOnce() {
        for (RacingCar car : racingCars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= RacingGameConstants.MOVE_THRESHOLD.getValue()) {
                car.advance();
            }
        }
    }

    public List<RacingCar> findWinners() {
        int maxPosition = racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

}