package miniDocker
case class Build(
                base:Build.Base,// could either be a tag or a hash or a keyword
                commands:List[Command]
                )

object Build{
  enum Base {
    case EmptyImage
    case ImageHash(hash: miniDocker.Hash)
  }
}
enum Command{
  case Upsert(key:String,value:String)
  case Delete(key:String)
}

case class Hash(
               value:String
               )

