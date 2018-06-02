public static String judgeGame(String handA, String handB) {
  String ret = "";
  switch (handA) {
    case "グー":
      switch (handB) {
        case "グー"  : ret = "引き分け";    break;
        case "チョキ": ret = "Aさんの勝ち"; break;
        case "パー"  : ret = "Bさんの勝ち"; break;
      }
      break;
    case "チョキ":
      switch (handB) {
        case "グー"  : ret = "Bさんの勝ち"; break;
        case "チョキ": ret = "引き分け";    break;
        case "パー"  : ret = "Aさんの勝ち"; break;
      }
      break;
    case "パー":
      switch (handB) {
        case "グー"  : ret = "Aさんの勝ち"; break;
        case "チョキ": ret = "Bさんの勝ち"; break;
        case "パー"  : ret = "引き分け";    break;
      }
      break;
  }

  if (ret.isEmpty()) throw new IllegalArgumentException("引数がおかしい(" + handA + "," + handB + ")");
  return ret;
}
