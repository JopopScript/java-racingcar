package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private String name;
    private Motor motor;

    @BeforeEach
    void setup() {
        name = "belle";
        motor = new TesterMotor();
    }

    @DisplayName("car 생성자 테스트")
    @Test
    void car() {
        Car car = new Car(name, motor);
        assertThat(car).isEqualToComparingFieldByField(new Car(name, motor));
    }

    @DisplayName("move() 테스트 : position이 +1 증가하는지 확인")
    @Test
    void move() {
        Car car = new Car(name, motor); // postition 초기값은 0
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("run() 테스트 : 메소드 호출시 전진하는지 확인")
    @Test
    void run1(){
        // TesterMotor는 항상 true 반환
        Motor motor = new TesterMotor();

        Car car = new Car(name, motor); // postition 초기값은 0
        car.run();

        assertThat(car.getPosition()).isEqualTo(1);
    }


    @DisplayName("run() 테스트 : 메소드 호출시 전진하지 않는지 확인")
    @Test
    void run2() {
        // TesterImmobileMotor 항상 false 반환
        Motor motor = new TesterImmobileMotor();

        Car car = new Car(name, motor); // postition 초기값은 0
        car.run();

        assertThat(car.getPosition()).isZero();
    }
}