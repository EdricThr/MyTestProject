package com.THR.ThinkingInJava.持有对象;

import java.util.Arrays;
import java.util.List;

/**
 * 添加一组元素 p220
 *
 */
public class AsListIInference {
    //可见，都可以向上转型为Snow
    List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder(), new Light());
    //当数组对象只有二级导出类类型，则不能向上转型为其父类的父类（提示需要父类）
    //List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());

    //如果想向上转型为其父类的父类，则需要在Arrays.asList()中间插入一条线索，成为显式类型参数说明
    List<Snow> snow2 = Arrays.<Snow>asList(new Light(), new Heavy());

}

class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}