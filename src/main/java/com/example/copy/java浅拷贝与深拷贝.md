直接复制，类如Car a=b; 只是复制了这个对象的引用，改变a，b任意一个，都是对同一份数据进行操作

浅拷贝 实现Cloneable接口   Car a=（Car）b.clone()  a对基本数据类型的改变，不会作用于 b，但对其中引用的改变，会作用于b
其中引用类型的属性本质上还是同一块

对象实现的接口Cloneable的clone()方法存在一个缺陷，它并不会将对象的所有属性全部拷贝过来，而是有选择性的拷贝，即浅拷贝！基本规则如下：

1、 基本类型

如果变量是基本很类型，则拷贝其值，比如int、float等。

2、 对象

如果变量是一个实例对象，则拷贝其地址引用，也就是说此时新对象与原来对象是公用该实例变量。

3、 String字符串

若变量为String字符串，则拷贝其地址引用。但是在修改时，它会从字符串池中重新生成一个新的字符串，原有字符串对象保持不变。

所以：浅拷贝只是Java提供的一种简单的拷贝机制，不便于直接使用。


深拷贝
1.层层引用类型的属性，都实现Cloneable接口，这样就开辟出了一块独立空间

2.字节流序列化与反序列化