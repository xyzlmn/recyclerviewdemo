
    RecyclerView是一种新的视图组件，目标是为任何基于适配器的视图提供相似的渲染方式，RecyclerView可以作为ListView和GridView控件的继承者。这里用一个demo来实现像使用Listview一样使用RecyclerView。


像使用Listview一样使用RecyclerView需要到以下5个元素：
-------

RecyclerView.Adapter：新型适配器，和ListView的Adapter类似，但也稍有不同。
ViewHolder：用于绑定数据，显示子view。

LayoutManager：这个类决定视图被放在画面中哪个位置，但这只是它的众多职责之一，它还可以管理滚动和循环利用。

ItemDecoration：在item上绘制装饰，比如说是item间的分割线

ItemAnimator：会根据适配器上收到的通知动画显示视图组的修改。基本上，它会自动显示添加和移除条目动画。这也不是一个简单的类，但我们发现DefaultItemAnimator已经可以运行得很好了。
