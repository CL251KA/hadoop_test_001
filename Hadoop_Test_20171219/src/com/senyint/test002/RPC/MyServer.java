package com.senyint.test002.RPC;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;
import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * 
* @ClassName: MyServer 
* @Description: RPCԶ�̹��̵��õķ����
* @author Cai ShiJun 
* @date 2017��12��19�� ����7:34:10 
*
 */
public class MyServer {
	
	public static void main(String[] args) {
		
		try {
			
			//��������ip��ַ����������
			String hadoopIpAddress = "172.16.100.144";
			//�������Ķ˿ںš�
			int hadoopPort = 8080;
			
			/**
			 * ����һ��RPC��Server��
			 * @param	setProtocol()�еĲ���Myinterface���Լ����岢�̳���VersionedProtocol�ӿڵĽӿڡ�VersionedProtocol����ʹ��Hadoop RPCЭ��ĳ��ࡣ
			 * @param	instance ʵ���еķ����ᱻ�ͻ��˵��á�		setInstance()�еĲ�����ʵ����Myinterface���ࡣ	
			 * @param	bindAddress �󶨵������ַ���ڼ������ӵĵ�����	setBindAddress()�еĲ����Ƿ�������ip��ַ����������
			 * @param	port �󶨵�����˿����ڼ������ӵĵ�����	setPort()�����õķ������Ķ˿ںš�
			 * @param	setNumHandlers()��ʾ�������˴���������߳���Ŀ��
			 * 
			 * BindAddress���ɺ���setBindAddress���ã���Port���ɺ���setPort���ã�0��ʾ��ϵͳ���ѡ��һ���˿ںţ��ֱ��ʾ��������host�ͼ����˿ںţ���NnumHandlers���ɺ���setNumHandlers���ã���ʾ�������˴���������߳���Ŀ������Ϊֹ���������������״̬���ȴ��ͻ������󵽴
			 */
			//���һ��RPC�����Server����Serverʵ����һ��Э���ʵ��������ָ���Ķ˿ں͵�ַ��
			Server server = new RPC.Builder(new Configuration()).setProtocol(Myinterface.class)
						.setInstance(new MyinterfaceImpl()).setBindAddress(hadoopIpAddress).setPort(hadoopPort) 
						.setNumHandlers(5).build(); 
			
			server.start(); 
			
		} catch (Exception e) {

			e.printStackTrace();
		
		}

	}
	
}


/**
 * 
* @ClassName: Myinterface 
* @Description: setProtocol()�еĲ���Myinterface���Լ����岢�̳���VersionedProtocol�ӿڵĽӿڡ�
* @author Cai ShiJun 
* @date 2017��12��20�� ����9:15:50 
*
 */
interface Myinterface extends VersionedProtocol{
	
	public final static long versionID = 102312313L;
	
	public String sayHello();
	
};


/**
 * 
* @ClassName: MyinterfaceImpl 
* @Description: instance ʵ���еķ����ᱻ�ͻ��˵��á�setInstance()�еĲ�����ʵ����Myinterface���ࡣ
* @author Cai ShiJun 
* @date 2017��12��20�� ����9:15:53 
*
 */
class MyinterfaceImpl implements Myinterface{

	@Override
	public ProtocolSignature getProtocolSignature(String arg0, long arg1, int arg2) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getProtocolVersion(String arg0, long arg1) throws IOException {
		// TODO Auto-generated method stub
		return Myinterface.versionID;
	}
	
	public String sayHello(){
		
		System.out.println("�ұ��ڷ���˵����ˣ�~~");
		
		return "Hello!~";
	}
	
}

