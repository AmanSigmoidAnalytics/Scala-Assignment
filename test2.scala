case class PlayerStats(Year: Int, PlayerName: String, Country: String, Matches: Int, 
                       Runs: Int, Wickets: Int) 

object Main {
  def main(args: Array[String]): Unit = {
    val playerStatsList: List[PlayerStats] = List(
      PlayerStats(2021, "Sam", "India", 23, 2300, 3),
      PlayerStats(2021, "Ram", "India", 23, 300, 30),
      PlayerStats(2021, "Mano", "India", 23, 300, 13)
    )

    // 1. Player with the highest run scored.
    val playerWithHighestRuns = playerStatsList.maxBy(_.Runs)
    println(s"Player with the highest runs: $playerWithHighestRuns")

    // 2. Top 5 players by runs scored.
    val top5PlayersByRuns = playerStatsList.sortBy(_.Runs)(Ordering[Int].reverse).take(5)
    println("Top 5 players by runs:")
    top5PlayersByRuns.foreach(println)

    // 3. Top 5 players by wickets taken.
    val top5PlayersByWickets = playerStatsList.sortBy(_.Wickets)(Ordering[Int].reverse).take(5)
    println("Top 5 players by wickets:")
    top5PlayersByWickets.foreach(println)

    // 4. Rank players with overall performance giving weight 5x to wickets taken and (5/100)x to runs scored.
    val rankedPlayers = playerStatsList.map(player => {
      val overallPerformance = (5 * player.Wickets) + (0.05 * player.Runs)
      (player, overallPerformance)
    }).sortBy(_._2)(Ordering[Double].reverse)
    println("Ranked players by overall performance:")
    rankedPlayers.foreach(println)
  }
}
