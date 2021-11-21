package bar.simon.gw2

import bar.simon.gw2.achievements.AchievementClient
import bar.simon.gw2.commerce.CommerceClient

case class Gw2Client[F[_]](achievements: AchievementClient[F], commerce: CommerceClient[F])
