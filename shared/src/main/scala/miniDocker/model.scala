package miniDocker
enum Command{
  case Build(build: miniDocker.Build)
  case Run(hash:Hash)
}
case class Build(
                base:Build.Base,// could either be a tag or a hash or a keyword
                commands:List[Build.Command]
                )

object Build{
  enum Base {
    case EmptyImage
    case ImageReference  (hash: miniDocker.Hash)
  }

  enum Command {
    case Upsert(key: String, value: String)
    case Delete(key: String)
  }
}

case class Hash(
               value:String
               )

