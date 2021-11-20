package bar.simon.gw2

import bar.simon.gw2.achievements.AchievementClient

case class Gw2Client[F[_]](achievements: AchievementClient[F])
