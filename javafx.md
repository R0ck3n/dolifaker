🧠 1️⃣ Équivalence Web → JavaFX

Si tu viens du web, pense comme ça :

Web	JavaFX

| Web                     | JavaFX             |
| ----------------------- | ------------------ |
| `<div>`                 | `Pane`             |
| Flexbox                 | `VBox` / `HBox`    |
| position absolute       | `StackPane`        |
| `<input type="number">` | `Spinner<Integer>` |
| `<label>`               | `Label`            |
| CSS                     | `-fx-*` styles     |
| DOM                     | Scene Graph        |


JavaFX fonctionne avec une Scene Graph (arbre de composants).

Un peu comme :

```txt
StackPane
 ├── VBox
 │     ├── Label
 │     └── Spinner
 └── Label (user name top right)

```
Chaque élément est un Node.
Chaque Node peut contenir d'autres Nodes (comme des div imbriquées).

🧠 2️⃣ Comment fonctionne ton createUI()