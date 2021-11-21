package bar.simon.gw2.achievements

import bar.simon.gw2.achievements.categories.{AchievementCategory, AchievementCategoryId}
import bar.simon.gw2.achievements.daily.AchievementDailies
import bar.simon.gw2.achievements.groups.{AchievementGroup, AchievementGroupId}
import bar.simon.gw2.http.HttpClientConfig
import cats.effect.Sync
import io.circe.Decoder

final class AchievementHttpClient[F[_]: Sync](config: HttpClientConfig[F], lang: String) extends AchievementClient[F] {

  import AchievementCodecs._

  private val groups     = "groups"
  private val categories = "categories"
  private val daily      = "daily"

  def getAllAchievementIds: F[List[AchievementId]] =
    get[List[AchievementId]]("")

  def getAchievement(id: AchievementId): F[Achievement] =
    get[Achievement](id.value.toString)

  def getAchievements(ids: List[AchievementId]): F[List[Achievement]] =
    get[List[Achievement]]("", Map("ids" -> ids.map(_.value).mkString(",")))

  def getAllGroupIds: F[List[AchievementGroupId]] =
    get[List[AchievementGroupId]](groups)

  def getGroup(id: AchievementGroupId): F[AchievementGroup] =
    get[AchievementGroup](s"$groups/${id.value}")

  def getGroups(ids: List[AchievementGroupId]): F[List[AchievementGroup]] =
    get[List[AchievementGroup]](groups, Map("ids" -> ids.map(_.value).mkString(",")))

  def getAllCategoryIds: F[List[AchievementCategoryId]] =
    get[List[AchievementCategoryId]](categories)

  def getCategory(id: AchievementCategoryId): F[AchievementCategory] =
    get[AchievementCategory](s"$categories/${id.value.toString}")

  def getCategories(ids: List[AchievementCategoryId]): F[List[AchievementCategory]] =
    get[List[AchievementCategory]](categories, Map("ids" -> ids.map(_.value).mkString(",")))

  def getDailiesOfToday: F[AchievementDailies] =
    get[AchievementDailies](daily)

  def getDailiesOfTomorrow: F[AchievementDailies] =
    get[AchievementDailies](daily + "/tomorrow")

  private def get[T](path: String, query: Map[String, String] = Map.empty)(implicit decoder: Decoder[T]): F[T] =
    config.get[T](path, query + ("lang" -> lang))
}
