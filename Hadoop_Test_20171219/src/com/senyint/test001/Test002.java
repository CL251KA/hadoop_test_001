package com.senyint.test001;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

/**
 * 
* @ClassName: Test002 
* @Description:	ʹ��FileSystem
* @author Cai ShiJun 
* @date 2017��12��19�� ����1:23:08 
*
 */
public class Test002 {
	
	//hadoop�е��ļ�·��
	private static final String HDFS_PATH = "hdfs://172.16.100.147:9000/hello";
	
	//org.apache.hadoop.fs.FileSystem�ı���
	private static FileSystem fileSystem = null;
	
	static{
		
		try {
			
			Configuration conf = new Configuration();
			URI uri = new URI(HDFS_PATH);
			
			fileSystem = FileSystem.get(uri , conf);
		
		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}
	
	
	/**
	 * 
	* @Title: createFolder 
	* @Description: �����ļ���
	* @throws 
	* @author Cai ShiJun 
	* @date 2017��12��19�� ����5:07:32
	 */
	@Test
	public void createFolder(){
		
		try {
			
			final String DIR_PATH = "/d20171219165801";
			
			fileSystem.mkdirs(new Path(DIR_PATH));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	/**
	 * 
	* @Title: uploadFiles 
	* @Description: �ϴ��ļ�
	* @throws 
	* @author Cai ShiJun 
	* @date 2017��12��19�� ����5:37:30
	 */
	@Test
	public void uploadFile(){
		
		try {
			
			final String FILE_PATH = "/d20171219165801/f1000";
			
			final FSDataOutputStream out = fileSystem.create(new Path(FILE_PATH));
			
			final InputStream in = new FileInputStream("D:/hadoop_test.txt");
			
			/**
			 * @param in	������	
			 * @param out	�����
			 * @param buffSize	��������С	1024
			 * @param close	�Ƿ�ر��� boolean	true�����ر���
			 */
			IOUtils.copyBytes(in, out, 1024, true);
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	}
	
	
	/**
	 * 
	* @Title: downloadFiles 
	* @Description: �����ļ�
	* @throws 
	* @author Cai ShiJun 
	* @date 2017��12��19�� ����5:58:45
	 */
	@Test
	public void downloadFile(){
		
		try {
			
			final String FILE_PATH = "/d20171219165801/f1000";
			
			final FSDataInputStream in = fileSystem.open(new Path(FILE_PATH));
			
			/**
			 * @param in	������	
			 * @param out	�����	System.out���������̨
			 * @param buffSize	��������С	1024
			 * @param close	�Ƿ�ر��� boolean	true�����ر���
			 */
			IOUtils.copyBytes(in, System.out, 1024, true);
			
		} catch (Exception e) {

			e.printStackTrace();
		
		}
		
	}
	
	
	/**
	 * 
	* @Title: deleteFile 
	* @Description: ɾ���ļ�
	* @throws 
	* @author Cai ShiJun 
	* @date 2017��12��19�� ����6:07:21
	 */
	@Test
	public void deleteFile(){
		
		try {
			
			final String FILE_PATH = "/d20171219165801/f1000";
			
			/**
			 * @param recursive �ݹ�
			 */
			Boolean recursive = true;
			fileSystem.delete(new Path(FILE_PATH), recursive);
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	}
	
}
