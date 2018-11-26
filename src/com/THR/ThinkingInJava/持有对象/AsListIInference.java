package com.THR.ThinkingInJava.���ж���;

import java.util.Arrays;
import java.util.List;

/**
 * ���һ��Ԫ�� p220
 *
 */
public class AsListIInference {
    //�ɼ�������������ת��ΪSnow
    List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder(), new Light());
    //���������ֻ�ж������������ͣ���������ת��Ϊ�丸��ĸ��ࣨ��ʾ��Ҫ���ࣩ
    //List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());

    //���������ת��Ϊ�丸��ĸ��࣬����Ҫ��Arrays.asList()�м����һ����������Ϊ��ʽ���Ͳ���˵��
    List<Snow> snow2 = Arrays.<Snow>asList(new Light(), new Heavy());

}

class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}