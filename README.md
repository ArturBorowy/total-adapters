# **total-adapters**

[![](https://jitpack.io/v/ArturBorowy/total-adapters-sample.svg)](https://jitpack.io/#ArturBorowy/total-adapters-sample)

Library provides **base classes** to simplify creating `GridView`'s and `RecyclerView`'s adapters.

Feel free to add your suggestions, issues and pull requests!

## Getting started

Add **total-adapters** dependency to your module level **build.gradle**:

```
dependencies {
        implementation 'com.github.ArturBorowy:total-adapters:0.1.0'
}
```

Unless you already have, add **JitPack** repository to your project level **build.gradle**:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

## Adapter types:

- **base** ([BaseRecyclerAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/recyclerview/base/BaseRecyclerAdapter.kt)/[BaseGridViewAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/gridview/base/BaseGridViewAdapter.kt) and interface [UpdateItemsAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/common/UpdateItemsAdapter.kt))

  - `RecyclerView` example: [ExampleBaseRecyclerAdapter](/app/src/main/java/pl/arturborowy/examples/recyclerview/base/ExampleBaseRecyclerAdapter.kt)

  - `GridView` example: [ExampleBaseGridViewAdapter](app/src/main/java/pl/arturborowy/examples/gridview/base/ExampleBaseGridViewAdapter.kt)

- **clickable view** ([ClickableViewRecyclerAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/recyclerview/clickable/ClickableViewRecyclerAdapter.kt)/[ClickableViewGridViewAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/gridview/clickable/ClickableViewGridViewAdapter.kt) and interface [ClickableViewAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/common/interfaces/ClickableViewAdapter.kt))

  - `RecyclerView` example: [ExampleClickableViewRecyclerAdapter](app/src/main/java/pl/arturborowy/examples/recyclerview/clickable/ExampleClickableViewRecyclerAdapter.kt)

  - `GridView` example: [ExampleClickableViewGridViewAdapter](app/src/main/java/pl/arturborowy/examples/gridview/clickable/ExampleClickableViewGridViewAdapter.kt)

- **whole view clickable** ([WholeViewClickableRecyclerAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/recyclerview/clickable/WholeViewClickableRecyclerAdapter.kt)/[WholeViewClickableGridViewAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/gridview/clickable/WholeViewClickableGridViewAdapter.kt) and interface [ClickableViewAdapter](totaladapters/src/main/java/pl/arturborowy/adapters/common/interfaces/ClickableViewAdapter.kt))

  - `RecyclerView` example: [ExampleWholeViewClickableRecyclerAdapter](app/src/main/java/pl/arturborowy/examples/recyclerview/wholeviewclickable/ExampleWholeViewClickableRecyclerAdapter.kt)

  - `GridView` example: [ExampleWholeViewClickableGridViewAdapter](app/src/main/java/pl/arturborowy/examples/gridview/wholeviewclickable/ExampleWholeViewClickableGridViewAdapter.kt)
  
## License

**[LICENSE](LICENSE)**
  
## Authors
  
###### Writer: [Artur Borowy](https://github.com/ArturBorowy)
###### Editor: [Jakub Brzozowski](https://github.com/KubaB)
