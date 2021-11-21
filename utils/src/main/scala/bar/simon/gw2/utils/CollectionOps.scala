package bar.simon.gw2.utils

import scala.util.Random

object CollectionOps {
  implicit class SeqOps[T](s: Seq[T]) {
    def getRandom(random: Random = Random): T =
      s(random.nextInt(s.size))
  }
}
