package bar.simon.gw2

import bar.simon.gw2.account.AccountClient
import bar.simon.gw2.achievements.AchievementClient
import bar.simon.gw2.commerce.CommerceClient

case class Gw2Client[F[_]](
    achievements: AchievementClient[F],
    account: AccountClient[F],
    commerce: CommerceClient[F]
)
