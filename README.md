# FourGame

2人対戦型のボードゲーム。n×n マスのボードでフィールドの値を4にした数を競う Java Swing アプリ。

## ゲームルール

- ボードは n×n マスで構成され、各マスの初期値は 0
- プレイヤーは交互にマスを選択する（赤・青の2人）
- 選択したマスとその上下左右の隣接マスの値が +1 される（最大値は 4）
- 値が 4 になったマスは、そのとき操作したプレイヤーの色に染まる
- **スコア** = 自分が値を 4 にしたマスの数
- 全マスの値が 4 になった時点でゲーム終了、スコアが高い方の勝ち
- 引き分けあり（同点の場合）

## 技術スタック

| カテゴリ | 内容 |
|----------|------|
| 言語 | Java 21 |
| GUI フレームワーク | Java Swing |
| ビルドツール | Apache Ant (`build.xml`) |
| IDE | NetBeans |

## 動作環境

- Java 21 以上（Java SE）
- NetBeans IDE 推奨（`nbproject/` が含まれるため）
- OS: Windows / macOS / Linux（Swing が動く環境ならOK）

## 起動方法

### NetBeans の場合

1. リポジトリをクローン

   ```bash
   git clone https://github.com/joeokinaga/Four-game.git
   ```

2. `File > Open Project` でクローンしたフォルダを開く

3. `Run > Run Project`（F6）を押す

### コマンドラインの場合

```bash
javac -d out src/fourgame/*.java
java -cp out fourgame.FourGame
```

## 操作方法

1. 起動後、ボードサイズ（3×3 / 4×4 / 5×5）を選択する
2. 赤プレイヤーから開始 — クリックしたいマスを選ぶ
3. 交互にプレイ。全マスが埋まると勝者がダイアログで表示される
4. ダイアログを閉じると自動的に新しいゲームが始まる

## ファイル構成

```
src/fourgame/
├── FourGame.java   # エントリーポイント（main）
├── Game.java       # ゲームロジック（盤面・スコア・勝敗判定）
├── Player.java     # プレイヤーEnum（RED / BLUE / NONE）
├── MainWindow.java # メインウィンドウ（ボードサイズ選択）
├── Window.java     # ゲームウィンドウ
└── BaseWindow.java # 共通ウィンドウ処理
```

## 実装のポイント

- **盤面とロジックの分離**: `Game.java` はGUIに依存せず、盤面状態・スコア・勝敗判定をすべて管理
- **隣接マス処理**: 上下左右（斜め除く）の4方向を `incrementNeighbors()` で処理
- **プレイヤー切り替え**: `switchPlayer()` で RED ↔ BLUE を交互に管理
- **終了判定**: `isGameOver()` で全マスが4になったか毎ターン後にチェック

## 注意事項

- 3×3 / 4×4 / 5×5 のみ対応（任意サイズ変更は未対応）
- CPUプレイヤー（AI）は非搭載、2人が同じ画面でプレイする形式
- ウィンドウのリサイズには対応していない

## ライセンス

This project was created as a university assignment.
