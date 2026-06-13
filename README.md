# FourGame

2人対戦のボードゲームです。グリッド上のタイルをクリックしてスコアを競います。Java Swing で作られたデスクトップアプリです。

## ゲームルール

- プレイヤーは RED と BLUE の2人で交互にタイルをクリックします
- クリックしたタイル＋上下左右の隣接タイルの値が1ずつ増加します
- タイルの値が **4** に達すると、そのタイルはクリックしたプレイヤーの色になります
- すべてのタイルが値4になったらゲーム終了
- 色付きタイルが多いプレイヤーの勝ちです

## 使用技術

- **言語:** Java
- **GUI:** Java Swing
- **IDE:** NetBeans / IntelliJ IDEA

## セットアップ

### 前提条件

- Java 8 以上
- NetBeans IDE（推奨）または IntelliJ IDEA

### NetBeans で開く場合

1. リポジトリをクローン

   ```bash
   git clone https://github.com/joeokinaga/Four-game.git
   ```

2. NetBeans を起動 → `File` → `Open Project` → クローンしたフォルダを選択

3. `Run Project`（F6）で起動

### コマンドラインで実行する場合

```bash
cd Four-game/src
javac *.java
java FourGameGUI
```

## ディレクトリ構成

```
FourGame/
├── src/
│   ├── FourGameGUI.java   # メインウィンドウ（エントリポイント）
│   ├── PlayGame.java      # ゲームロジック・スコア管理
│   ├── GameBoard.java     # ボード状態・タイル更新
│   └── Tile.java          # タイル1マスの状態
├── build/                 # コンパイル済みクラス（自動生成）
├── build.xml              # Antビルドファイル
└── manifest.mf
```

## ライセンス

[MIT](LICENSE)
