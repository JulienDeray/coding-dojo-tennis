

object TennisScoreCalculator {
  case class Player(name: String)

  private val intToString = Map(
    0 -> "love",
    1 -> "fifteen",
    2 -> "thirty",
    3 -> "forty",
  )

  def display(player1Score: Int, player2Score: Int): String = {
    findWhoWon(player1Score, player2Score)
      .map(_.name + " won!")
      .getOrElse(
        (player1Score, player2Score) match {
          case (x, y) if x < 3 && y < 3 && x != y      => nominalCase(x, y)
          case (x, y) if x < 3 && y < 3 && x == y      => equalCase(x)
          case (x, y) if x == y && x > 2               => "deuce"
          case (x, y) if x > 2 && Math.abs(x - y) == 1 => s"advantage ${advantageCase(x, y).name}"
          case _                                       => "invalid score"
        }
    )
  }

  private def advantageCase(x: Int, y: Int): Player =
    if (x > y) Player("player 1")
    else       Player("player 2")

  private def nominalCase(x: Int, y: Int): String =
    Seq(x, y)
      .map(intToString(_))
      .mkString(" ")

  private def equalCase(x: Int): String =
    intToString(x) + " all"

  private def findWhoWon(player1Score: Int, player2Score: Int): Option[Player] = (player1Score, player2Score) match {
    case (x, y) if x < 3 && y > 3 => Some(Player("player 2"))
    case (x, y) if x > 3 && y < 3 => Some(Player("player 1"))
    case _                        => None
  }
}
