package com.THR.ThinkingInJava.�쳣;

public class StormInning extends MyException.Inning implements MyException.Storm {

    /**
     * �����๹�����׳��쳣����ô�����๹����
     *     1.�����׳�����๹�����׳����쳣�������쳣�Ļ����쳣��
     *     2.�����׳������쳣�����쳣���Ժ͵������׳����쳣�޹�
     *     3.�������ֻ��һ�������������׳����쳣����ʹ�����๹�����ͻ��������ʽ��ͬ��Ҳ�����׳���Ӧ�쳣
     */
    public StormInning() throws MyException.RainOut, MyException.BaseballException {
    }
    //��ʹ����������ͬ��Ҳ��Ҫ�׳��쳣
    public StormInning(String s) throws MyException.BaseballException {
    }


    /**
     * ��������д����ʱ
     *      1.�ɽ��׳�����෽���׳��쳣��ĵ������쳣���������׳���С���쳣��
     *      2.���Բ��׳��쳣(��event()����)
     */
    @Override
    public void atBat() throws MyException.Strike, MyException.PopFoul {

    }

    /**
     * ����̳е���ͽӿ�����ͬ�����������׳��쳣��ͬ��
     *      1.������д�����쳣����ͬʱ�׳������������쳣������
     *      2.��õķ�ʽ(��һ��..)�ǲ��׳��쳣 [��Ц....]
     *      3.�����׳������쳣������[�ٴο�Ц...]
     */
    @Override
    public void event() {

    }

    @Override
    public void rainHard() throws MyException.RainOut {

    }

    public static void main(String args[]){

        //try {
        //    StormInning si = new StormInning();
        //    si.atBat();
        //} catch (MyException.Strike strike) {
        //    strike.printStackTrace();
        //} catch (MyException.Foul foul) {
        //    foul.printStackTrace();
        //} catch (MyException.BaseballException e) {
        //    e.printStackTrace();
        //}
    }

}
