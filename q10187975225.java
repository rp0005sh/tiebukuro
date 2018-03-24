■ 変更箇所１
void Trun() 関数にて

if (say == 1) {
  :
  :
}
の箇所を以下のように変更

if (say == 1) {
    cc.stop();
    // フェードアウトアニメの実行部分
    final Timer timer = new Timer(10, null);
    timer.addActionListener(new ActionListener() {
        /** アルファ値(透過具合の値)255が透過なし、0が完全透明 */
        public int alf = 0xFF;
        @Override public void actionPerformed(ActionEvent e) {
            // ボタンから画像を抜き取る
            Icon icon = label1.getIcon();
            ImageIcon imageicon = (ImageIcon)icon;
            Image image = imageicon.getImage();

            // アルファ値を下げて、画像を生成
            Image alphaImage = getAlphaImage(image, alf--);
            
            // ボタンに画像を再設定
            label1.setIcon(new ImageIcon(alphaImage));

            // アルファが0(完全に透明)になったらアニメ終了
            if (alf == 0) {
                timer.stop();
                p.remove(label1);
                p.add(label2);
                label2.add(labeltext3);
                repaint();
            }
        }
    });
    // フェードアウトのアニメ開始
    timer.start();

    // タイトル画面の文字消去、背景黒設定
    label1.remove(labeltext1);
    label1.remove(labeltext2);
    p.setBackground(Color.black);
}




■ 変更箇所２
最後（void TITLE()の下）に以下の関数を追加

/** 
 * 指定したのアルファ値で作った画像を生成する
 * @param img 画像
 * @param alpha 設定するアルファ値(0～255)の範囲で透過度を設定する
 * @return 指定したのアルファ値で作った画像
 */
static public Image getAlphaImage(Image img, int alpha) {
    if (img == null) return null;
    int width = img.getWidth(null);
    int height = img.getHeight(null);
    //ピクセル値取得
    int[] pixel = new int[width * height];
    PixelGrabber pg = new PixelGrabber(img, 0, 0, width, height, pixel, 0, width);
    try {
        pg.grabPixels();
    } catch (InterruptedException e) {
        return null;
    }
    // 透明化
    for (int i = 0; i < width * height; i++) {
        pixel[i] &= 0x00FFFFFF;// alphaのビットを落とす
        pixel[i] |= alpha << (8 * 3); // alphaのビットを設定
    }

    //イメージに戻す
    Image alphaImage = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(width, height, pixel, 0, width));
    return alphaImage;
}

