/**
 * 座標クラス
 */
static class Point {
  double x, y;
  Point(double x, double y) {this.x = x; this.y = y;};
  @Override public String toString() {return x + "," + y;}
}

/** 三角形OABの頂点座標 */
static final Point
O = new Point(100,  20),
A = new Point( 20, 180),
B = new Point(180, 180);

private Point
/** 三角形内部を動く点の座標 */
p = new Point(100, 100),
/** 三角形内部を動く点の速度ベクトル */
v = new Point(2f, 0.4f);

@Override
public void setup() {
  size(200, 200);
}


@Override
public void draw() {
  background(0);
  triangle((int)O.x, (int)O.y, (int)A.x, (int)A.y, (int)B.x, (int)B.y);
  ellipse((float)p.x, (float)p.y, 10, 10);
  update();
}

/**
 * 座標や速度ベクトルのアップデートを行う
 */
public void update() {
  // 次の座標
  Point next = new Point(p.x + v.x, p.y + v.y);

  // 点Oを基準の位置ベクトルに変換
  // 連立方程式より、ベクトルpをベクトルa,ベクトルbで表したときの、それぞれの係数s,tを求める
  Point a = new Point(A.x - O.x, A.y - O.y);
  Point b = new Point(B.x - O.x, B.y - O.y);
  Point p = new Point(next.x - O.x, next.y - O.y);

  double k = a.x * b.y - b.x * a.y;
  double s = (p.x * b.y - b.x * p.y) / k;
  double t = (a.x * p.y - p.x * a.y) / k;

  // 次の位置座標も三角形内部に入る場合
  if (0 < s && 0 < t && s + t < 1) {
    // 速度ベクトルは変更しない
  } else

  // 次の位置座標が三角形の右の辺を超過する場合
  if (s <= 0 && 0 < t) {
    double theta = Math.toRadians(-120);
    v = new Point(
      v.x * Math.cos(2 * theta) + v.y * Math.sin(2 * theta),
      v.x * Math.sin(2 * theta) - v.y * Math.cos(2 * theta));
  } else

  // 次の位置座標が三角形の左の辺を超過する場合
  if (t <= 0 && 0 < s) {
    double theta = Math.toRadians(-60);
    v = new Point(
      v.x * Math.cos(2 * theta) + v.y * Math.sin(2 * theta),
      v.x * Math.sin(2 * theta) - v.y * Math.cos(2 * theta));
  } else

  // 次の位置座標が三角形の底辺を超過する場合
  if(0 <= s && 0 <= t && 1 <= s + t)  {
    v.y *= -1;
  }

  // 点の位置座標を更新
  this.p.x += v.x; this.p.y += v.y;
}
