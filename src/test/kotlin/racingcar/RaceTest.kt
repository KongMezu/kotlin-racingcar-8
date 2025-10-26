package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Race 클래스 테스트")
class RaceTest {

    @Test
    @DisplayName("Race 생성 시 자동차가 이름 수만큼 생성된다")
    fun raceInitialization_createsCarsCorrectly() {
        val race = Race(listOf("pobi", "woni", "jun"))
        assertThat(race.cars).hasSize(3)
        assertThat(race.cars.all { it.position == 0 }).isTrue()
    }

    @Test
    @DisplayName("playRound 실행 시 모든 자동차가 이동 시도를 한다")
    fun playRound_shouldCallMoveForEachCar() {
        val race = Race(listOf("pobi", "woni"))
        val before = race.cars.map { it.position }

        race.playRound()

        val after = race.cars.map { it.position }
        assertThat(after).hasSameSizeAs(before)
    }

    @Test
    @DisplayName("findWinners는 가장 많이 이동한 자동차 이름을 반환한다")
    fun findWinners_shouldReturnMaxPositionCars() {
        val race = Race(listOf("pobi", "woni", "jun"))
        race.cars[0].apply { repeat(3) { position++ } }
        race.cars[1].apply { repeat(1) { position++ } }
        race.cars[2].apply { repeat(3) { position++ } }

        val winners = race.findWinners()

        assertThat(winners)
            .containsExactlyInAnyOrder("pobi", "jun")
            .doesNotContain("woni")
    }
}
