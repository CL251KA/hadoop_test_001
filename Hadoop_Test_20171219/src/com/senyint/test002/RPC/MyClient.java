package com.senyint.test002.RPC;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * 
* @ClassName: MyClient 
* @Description: RPCԶ�̹��̵��õĿͻ���
* @author Cai ShiJun 
* @date 2017��12��19�� ����7:34:40 
*
 */
public class MyClient {
	
	public static void main(String[] args) {
		
		try {
			
			/**
			 * ����һ���ͻ��˵Ĵ����������������ʵ����һ��������Э�飬�ͷ���˽����Ի�ͨ�ŵģ�������������һ��ָ���ĵ�ַ�ϵġ�
			 * @param Class<T> protocol 
			 * 		ʵ����VersionedProtocol�ӿڵĶ���
			 * 		VersionedProtocol����ʹ��Hadoop RPCЭ��ĳ��ࡣ
			 * 		������һ���ӿڵ�.class��
			 * @param  long clientVersion
			 * 		long���͵����֡�
			 * @param InetSocketAddress addr
			 * 		new InetSocketAddress(��������ip��ַ��������,�������Ķ˿ں�)
			 * @param Configuration conf 
			 * 		���� ����ֱ��new Configuration()
			 */
			//RPC.getProxy(protocol, clientVersion, addr, conf);��RPC.waitForProxy(protocol, clientVersion, addr, conf);������ͬ��
			Myinterface myinterface = RPC.waitForProxy(Myinterface.class, Myinterface.versionID, new InetSocketAddress("172.16.100.144",8080), new Configuration());
			
			String result = myinterface.sayHello();
			
			System.out.println("�ͻ��˵��ý����"+result);
			
			//�رմ������
			RPC.stopProxy(myinterface);
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
	}
	
}
