package racingcar.controller

class RacingCarontroller {
    fun run() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = readLine()?.split(",") ?: emptyList()
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readLine()?.toIntOrNull() ?: 0

        println("입력한 자동차: $carNames, 시도 횟수: $tryCount")
    }
}
