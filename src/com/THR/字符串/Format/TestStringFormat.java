package com.THR.�ַ���.Format;

import java.util.Date;
import java.util.Locale;

public class TestStringFormat {

    public static void main(String args[]){

        //doFormatStringAndNum();
        doFormatDate();
    }

    private static void doFormatDate() {
        Date date = new Date();
        //c��ʹ��
        System.out.printf("ȫ�����ں�ʱ����Ϣ��%tc%n",date);
        //f��ʹ��
        System.out.printf("��-��-�ո�ʽ��%tF%n",date);
        //d��ʹ��
        System.out.printf("��/��/���ʽ��%tD%n",date);
        //r��ʹ��
        System.out.printf("HH:MM:SS PM��ʽ��12ʱ�ƣ���%tr%n",date);
        //t��ʹ��
        System.out.printf("HH:MM:SS��ʽ��24ʱ�ƣ���%tT%n",date);
        //R��ʹ��
        System.out.printf("HH:MM��ʽ��24ʱ�ƣ���%tR",date);

        //b��ʹ�ã��·ݼ��
        String str=String.format(Locale.US,"Ӣ���·ݼ�ƣ�%tb",date);
        System.out.println(str);
        System.out.printf("�����·ݼ�ƣ�%tb%n",date);
        //B��ʹ�ã��·�ȫ��
        str=String.format(Locale.US,"Ӣ���·�ȫ�ƣ�%tB",date);
        System.out.println(str);
        System.out.printf("�����·�ȫ�ƣ�%tB%n",date);
        //a��ʹ�ã����ڼ��
        str=String.format(Locale.US,"Ӣ�����ڵļ�ƣ�%ta",date);
        System.out.println(str);
        //A��ʹ�ã�����ȫ��
        System.out.printf("�������ڵļ�ƣ�%tA%n",date);
        //C��ʹ�ã���ǰ��λ
        System.out.printf("���ǰ��λ���֣�������λǰ�油0����%tC%n",date);
        //y��ʹ�ã������λ
        System.out.printf("��ĺ���λ���֣�������λǰ�油0����%ty%n",date);
        //j��ʹ�ã�һ�������
        System.out.printf("һ���е�����������ĵڼ��죩��%tj%n",date);
        //m��ʹ�ã��·�
        System.out.printf("��λ���ֵ��·ݣ�������λǰ�油0����%tm%n",date);
        //d��ʹ�ã��գ���λ���������㣩
        System.out.printf("��λ���ֵ��գ�������λǰ�油0����%td%n",date);
        //e��ʹ�ã��գ�һλ�����㣩
        System.out.printf("�·ݵ��գ�ǰ�治��0����%te",date);

        //H��ʹ��
        System.out.printf("2λ����24ʱ�Ƶ�Сʱ������2λǰ�油0��:%tH%n", date);
        //I��ʹ��
        System.out.printf("2λ����12ʱ�Ƶ�Сʱ������2λǰ�油0��:%tI%n", date);
        //k��ʹ��
        System.out.printf("2λ����24ʱ�Ƶ�Сʱ��ǰ�治��0��:%tk%n", date);
        //l��ʹ��
        System.out.printf("2λ����12ʱ�Ƶ�Сʱ��ǰ�治��0��:%tl%n", date);
        //M��ʹ��
        System.out.printf("2λ���ֵķ��ӣ�����2λǰ�油0��:%tM%n", date);
        //S��ʹ��
        System.out.printf("2λ���ֵ��루����2λǰ�油0��:%tS%n", date);
        //L��ʹ��
        System.out.printf("3λ���ֵĺ��루����3λǰ�油0��:%tL%n", date);
        //N��ʹ��
        System.out.printf("9λ���ֵĺ�����������9λǰ�油0��:%tN%n", date);
        //p��ʹ��
        str = String.format(Locale.US, "Сд��ĸ�������������(Ӣ)��%tp", date);
        System.out.println(str);
        System.out.printf("Сд��ĸ������������ǣ��У���%tp%n", date);
        //z��ʹ��
        System.out.printf("�����GMT��RFC822ʱ����ƫ����:%tz%n", date);
        //Z��ʹ��
        System.out.printf("ʱ����д�ַ���:%tZ%n", date);
        //s��ʹ��
        System.out.printf("1970-1-1 00:00:00 ��������������������%ts%n", date);
        //Q��ʹ��
        System.out.printf("1970-1-1 00:00:00 �������������ĺ�������%tQ%n", date);
    }

    private static void doFormatStringAndNum() {
        System.out.printf("Hello, %s", "World!!!");
        System.out.printf("Hello, %c%n", 33);
        System.out.printf("Hello, %c%n", 'a');
        System.out.printf("Hello, %b%n", "rr".equals("rr"));
        System.out.printf("Hello, %d%n", 100);
        System.out.printf("Hello, %x%n", 100);
        System.out.printf("Hello, %o%n", 100);
        System.out.printf("Hello, %f%n", 100.888);
        System.out.printf("Hello, %a%n", 100.888);
        System.out.printf("Hello, %e%n", 100.888);
        System.out.printf("Hello, %g%n", 100.888);
        System.out.printf("Hello, %h%n", 'A');
        System.out.printf("Hello, %%%n", 99);

        System.out.println("------------------------");

        System.out.printf("Hello, %+d%n", 100);
        System.out.printf("Hello, %-5d%s%n", 100 , "haha");
        System.out.printf("Hello, %5d%s%n", 100 , "haha");
        System.out.printf("Hello, %05d%s%n", 100 , "haha");
        System.out.printf("Hello, %,d%n", 10000000);
        System.out.printf("Hello, %(d%n", -1000);
        System.out.printf("Hello, %#f%n", 99.99);
        System.out.printf("%f��%<6.4f%n", 99.45);
        System.out.printf("%f��%<7f%n", 99.45);
        System.out.printf("%d��%<6d%n", 99);
        System.out.printf("%s,%10.5f%n", "Hello", 99.99);
        System.out.printf("%s,%010.5f%n", "Hello", 99.99);
        System.out.printf("%s,%010f%n", "Hello", 99.99);
        System.out.printf("%2$s,%1$d", 100, "Hello");
    }


    /**
     * ����args������format�ַ����ĺϷ�����֤
     */
    private static void doTestNumAndFormat() {
        String URL_FORMAT_PATTERN = "http://%s:%s/%s";

        String str = String.format(URL_FORMAT_PATTERN, "a", "b", "c");
        //args[]������ƥ��ת����������ȣ�������������
        System.out.println("����args[],�����" + str);
        str = String.format(URL_FORMAT_PATTERN, "a", "b", "c", "d");
        //��args[]��������ƥ��ת�������������������������argsԪ�ز�������
        System.out.println("����args[],�����" + str);

        try {
            //��args[]��������ƥ��ת���������򱨴� java.util.MissingFormatArgumentException: Format specifier 's'
            str = String.format(URL_FORMAT_PATTERN, "a", "b");
            System.out.println("args[]��������,�����" + str);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //��format�ַ������淶�����򱨴� java.util.UnknownFormatConversionException: Conversion = 'j'
        URL_FORMAT_PATTERN = "http://%j:%s/%s";
        str = String.format(URL_FORMAT_PATTERN, "a", "b", "c");
        System.out.println("format�ַ�����ʽ����,�����" + str);
    }
}
