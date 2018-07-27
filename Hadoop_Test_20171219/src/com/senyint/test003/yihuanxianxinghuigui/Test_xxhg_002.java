package com.senyint.test003.yihuanxianxinghuigui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

import org.apache.commons.math3.distribution.NormalDistribution;
/**
 * 
 * @(#)zheng01.java 
 * @Description:�����������ṩ����̬�ֲ��ľ�ֵ�ͱ�׼��õ���̬���ʵľ���ʵ�֡�
 * @Definitions:���壺�ڴ��������̬�ֲ������������ݣ�֪�����������ݵľ�ֵ�ͷ���Ϊ����������������ĳ����Χ�ĸ���Ϊ��P(X<x)���������֮Ϊ��̬���ʡ����ʽΪ��X~N(��,��^2)             
 * @Explanation:���Ž��ͣ���Ϊ�����������ݵľ�ֵ����Ϊ�����������ݵı�׼�
 * @Comments:��������һ�����������ݣ���֪�������ݵľ�ֵ�ͱ�׼�����������x����̬���ʡ���������������ڱ��㷨��
 * @�ŵ�:֪����̬�ֲ�����ľ�ֵ�ͱ�׼��������ô��㷨�������С���������X����̬���ʡ�
 * @ȱ��:�޷����ƹ�����ϼ��ηֲ������⣬�޷���ȷ�����ɢ���ݸ��ʣ�����û�и�����ֵ���߱�׼�����̬�ֲ��޷����㡣
 * @���ó���:���������ݻ���������ɢ��С�����ݻ���������̬�ֲ��ص㣬���߶Բ����ϵ����ݽ���ȡ��������������������ﵽ��̬�ֲ��ص㣬�о���ľ������������ͱ�׼���
 * @�����ó���:������ɢ��̫�����ݲ�������̬�ֲ��ص㣬ͨ�������ݽ���ȡ�������������������޷��ﵽ��̬�ֲ��ص㣬�޷��ó��������������ͱ�׼�
 * @����/������:�����巽��
 * @�쳣/���:
 *          �쳣���������ݲ��Ϸ����磺Ҫ������double���ݣ�������ĸ��
 *          ������С��λ����ɲ���ȷ
 *       �����
 *          �쳣:���벻�Ϸ�������ʾ��
 *          ������С����λ���Զ��屣����װ�����ݾ��徫�Ƚ������á�
 * @Create Date��  2015��8��6��16:39:25
 * @since   JDK1.6  s
 * @author Magicfairytail
 */
public class Test_xxhg_002 {

    public static void main(String[] args) {
        /**
         * ��ֵΪ �̱�׼��ҵ���̬�ֲ��ľ���ʵ��
         * @param �� double�ͱ�����λС������ʾ��̬�ֲ���ֵ
         * @param �� double�ͱ�����λС������ʾ��̬�ֲ���׼��
         * @return S1 double�ͱ�����λС������ʾp(X<x)����̬����
         */
        NormalDistribution normalDistributioin = new NormalDistribution(0,1);//�½�һ����׼��̬�ֲ�����
        Scanner in=new Scanner(System.in);
        do {
            System.out.println("�������:");
            double ��=in.nextDouble();
            //��=NumberFormat.ZeroFormat(��);//���������ݱ���4λС��
            System.out.println("�������:");
            double ��=in.nextDouble();
            //��=NumberFormat.ZeroFormat(��);    //���������ݱ���4λС��            

            System.out.println("������x:");
            double x=in.nextDouble();
            //x=NumberFormat.ZeroFormat(x);//���������ݱ���4λС��
            double z=(x-��)/��;
            z=ZeroFormat(z,4);//���������ݱ���4λС��
                try {
                    double S1 = normalDistributioin.cumulativeProbability(z);
                    S1=ZeroFormat(S1,4);//���������ݱ���4λС��
                    System.out.println("��̬�ֲ�����Ϊ��");
                    System.out.println(S1);
                    System.out.println();
                    System.out.println("��������Ҫ����������(1/0)");
                    
                } catch (Exception e) {
                    // ������쳣Ϊ���õĽ����С�����쳣��ֱ�ӽ�����Զ���0
                    System.out.println("��̬�ֲ�����Ϊ��");
                    System.out.println("0");
                    System.out.println();
                    System.out.println("��������Ҫ����������(1/0)");
                }
            
        } while (in.nextInt()==1);//whileѭ�����������ֵΪ1������Ϊ����ֵ����ֹ����
    }
    
    
    public static double ZeroFormat(double num,int n)
    {
        BigDecimal bigDecimal=new BigDecimal(num);
        //DecimalFormat ff = new DecimalFormat("#.0000");  //������λС��
        //double result = Double.valueOf(ff.format(num));
        //return result;
        return bigDecimal.setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
                //setscale(n,BigDecimal.ROUND_HALF_UP).doubleValue;
    }
}