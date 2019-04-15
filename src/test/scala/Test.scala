import org.scalatest.{Matchers, WordSpec}
import TennisScoreCalculator._

class Test extends WordSpec with Matchers {

  "display love all" in {
    display(0, 0) shouldBe "love all"
  }

  "display love fifteen" in {
    display(0, 1) shouldBe "love fifteen"
  }

  "display love thirty" in {
    display(0, 2) shouldBe "love thirty"
  }

  "display that player 2 won" in {
    display(2, 4) shouldBe "player 2 won!"
  }

  "display that player 1 won" in {
    display(4, 2) shouldBe "player 1 won!"
  }

  "have a 'deuce' if both players have the same score and greater than 2" in {
    display(3, 3) shouldBe "deuce"
  }

  "display 'advantage player 1'" in {
    display(5, 4) shouldBe "advantage player 1"
  }

  "display 'advantage player 2'" in {
    display(4, 5) shouldBe "advantage player 2"
  }

  "display 'invalid score'" in {
    display(10, 5) shouldBe "invalid score"
  }
}
